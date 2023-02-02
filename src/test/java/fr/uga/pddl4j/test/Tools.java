package fr.uga.pddl4j.test;

import fr.uga.pddl4j.parser.DefaultParsedProblem;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.parser.Parser;
import fr.uga.pddl4j.parser.RequireKey;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.problem.DefaultProblem;
import fr.uga.pddl4j.problem.Problem;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Static class that contains all shared method for manipulate the benchmark
 * directory structure.
 *
 * @author C. Gerard
 * @author D. Pellier
 * @version 1.1 - 23.06.16
 */
@SuppressWarnings({"unchecked"})
public abstract class Tools {

    /**
     * The path of the pddl benchmarks files.
     */
    public static final String PDDL_BENCH_DIR = "src/test/resources/benchmarks/pddl" + File.separator;

    /**
     * The path of the HDDL benchmarks files.
     */
    public static final String HDDL_BENCH_DIR = "src/test/resources/benchmarks/hddl" + File.separator;

    /**
     * PDDL files extension.
     */
    public static final String PDDL_EXT = ".pddl";

    /**
     * PDDL files extension.
     */
    public static final String HDDL_EXT = ".hddl";

    /**
     * PDDL4J output plan extension for KCL validator format.
     */
    public static final String VAL_EXT = ".val";

    /**
     * The PDDL domain file name.
     */
    public static final String PDDL_DOMAIN = "domain" + Tools.PDDL_EXT;

    /**
     * The HDDL domain file name.
     */
    public static final String HDDL_DOMAIN = "domain" + Tools.HDDL_EXT;

    /**
     * The path to PDDL_VAL.
     */
    public static final String PDDL_VAL = "src/test/resources/validators/validate";

    /**
     * The path to HDDL_VAL.
     */
    public static final String HDDL_VAL = "src/test/resources/validators/pandaPIParser";

    /**
     * Check if benchmark are already here.
     *
     * @param path the benchmark directory path
     * @return true if the benchmark file exist
     */
    public static boolean isBenchmarkExist(String path) {
        return new File(path).exists();
    }

    /**
     * Clean all val formatted plan from the current directory and all its subdirectories.
     *
     * @param localTestPath the current path to clean up
     */
    public static void cleanValPlan(String localTestPath) {
        File dir = new File(localTestPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".val"));

        if (files != null) {
            for (File file : files) {
                try {
                    Files.deleteIfExists(FileSystems.getDefault().getPath(localTestPath, file.getName()));
                    System.out.println("Deleting " + localTestPath + file.getName());
                } catch (IOException ioEx) {
                    ioEx.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    /**
     * Parse domain and problem files and return the associated coded problem.
     *
     * @param domainFile  the domain file to be tested.
     * @param problemFile the file file to be tested.
     * @return a coded problem from the parsing file
     */
    public static Problem generateCodedProblem(String domainFile, String problemFile) {
        try {
            final File domain = new File(domainFile);
            final File problem = new File(problemFile);
            Parser parser = new Parser();
            DefaultParsedProblem parsedProblem = parser.parse(domain, problem);
            ErrorManager errorManager = parser.getErrorManager();
            if (errorManager.isEmpty()) {
                return new DefaultProblem(parsedProblem);
            }
        } catch (IOException ioExcepion) {
            System.err.println(ioExcepion + " test files not found !");
        }
        return null;
    }

    /**
     * Change the permissions for PDDL_VAL file (add read, write and execute).
     */
    public static void changeVALPerm() {
        final File val = new File(Tools.PDDL_VAL);
        if (val.exists() && (Tools.isUnix() || Tools.isMac())) {
            val.setReadable(true);
            val.setExecutable(true);
        }
    }

    /**
     * Remove the extension of a filename.
     *
     * @param fileName the name of the file
     * @return the filename of the file without extension
     */
    public static String removeExtension(String fileName) {
        final Pattern ext = Pattern.compile("(?<=.)\\.[^.]+$");
        return ext.matcher(fileName).replaceAll("");
    }

    /**
     * Count the number of validated plans.
     *
     * @param outputVal the output of PDDL_VAL
     * @return the number of validated plans
     */
    public static int numberValidatedPlans(String outputVal) {
        int i = 0;
        final Pattern p = Pattern.compile("Plan valid");
        final Matcher m = p.matcher(outputVal);
        while (m.find()) {
            i++;
        }
        return i;
    }


    /**
     * Solves all the problems in the specified directory with a specified planner configuration.
     *
     * @param path the current sub dir to test
     * @param extension the file extension .pddl ou .hddl
     * @param name the name of the planner to used.
     * @param config the planner configuration to use to solve problems.
     */
    public static void solve(String path, String extension, Planner.Name name, PlannerConfiguration config) {
        Tools.cleanValPlan(path);
        String currentDomain = path + "domain" + extension;
        boolean oneDomainPerProblem = false;
        String problemFile;
        String currentProblem;

        // Counting the number of problem files
        File[] pbFileList = new File(path)
            .listFiles((dir, pb) -> pb.startsWith("p") && pb.endsWith(extension) && !pb.contains("dom"));

        int nbTest = 0;
        if (pbFileList != null) {
            nbTest = pbFileList.length;
        }

        // Check if there is on domain per problem or a shared domain for all
        if (!new File(currentDomain).exists()) {
            oneDomainPerProblem = true;
        }

        System.out.println("Test " + name + " planner on " + path);
        // Loop around problems in one category
        int fillLength = Math.max(Integer.toString(nbTest).length(), 2);
        for (int i = 1; i < nbTest + 1; i++) {
            problemFile = String.format("p%0" + fillLength + "d" + extension, i);
            currentProblem = path + problemFile;

            if (oneDomainPerProblem) {
                currentDomain = path + problemFile.split(".p")[0] + "-" + "domain" + extension;
            }
            // Parses the PDDL domain and problem description
            try {

                config.setProperty(Planner.DOMAIN_SETTING, currentDomain);
                config.setProperty(Planner.PROBLEM_SETTING, currentProblem);
                Planner planner = Planner.getInstance(name, config);


                DefaultParsedProblem parsedProblem = planner.parse(currentDomain, currentProblem);
                ErrorManager errorManager = planner.getParserErrorManager();
                if (!errorManager.isEmpty()) {
                    errorManager.printAll();
                }
                Assert.assertTrue(errorManager.getMessages(Message.Type.LEXICAL_ERROR).isEmpty());
                Assert.assertTrue(errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty());

                Plan plan = null;
                // Encodes and instantiates the problem in a compact representation
                System.out.println("* Instantiation [" + currentProblem + "]" + "...");
                try {
                    Problem pb = planner.instantiate(parsedProblem);
                    if (pb.isSolvable()) {
                        // Searches for a solution plan
                        System.out.println("* Trying to solve [" + currentProblem + "]" + " in "
                            + config.getProperty(Planner.TIME_OUT_SETTING) + " seconds");
                        plan = planner.solve(pb);
                    } else {
                        System.err.println("* Problem [" + currentProblem + "]" + " not solvable.");
                    }
                    if (plan == null) { // no solution in TIMEOUT computation time
                        System.out.println("* No solution found in " + config.getProperty(Planner.TIME_OUT_SETTING)
                            + " seconds for " + currentProblem);
                        break;
                    } else if (plan.isEmpty()) { // Empty solution
                        System.out.println("* Empty solution for " + currentProblem);
                    } else { // Save output plan
                        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(currentProblem.substring(0,
                            currentProblem.length() - extension.length()) + Tools.VAL_EXT))) {
                            if (extension.equals(Tools.PDDL_EXT)) {
                                bw.write(pb.toString(plan));
                            } else {
                                bw.write(pb.toString(plan.getHierarchy()));
                            }
                        }
                        System.out.println("* Solution found for " + currentProblem);
                    }
                } catch (OutOfMemoryError err) {
                    System.err.println("ERR: " + err.getMessage() + " - test aborted");
                    return;
                }
            } catch (Exception ioe) {
                ioe.printStackTrace();
            }
            System.out.println();
        }
        try {
            Tools.checkPlanValidity(path, extension);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check plan validity.
     *
     * @param currentTestPath the current sub dir to test.
     * @param extension the file extention used .pddl or .hddl.
     * @throws Exception if something wrong.
     */
    public static void checkPlanValidity(String currentTestPath, String extension) throws Exception {
        final String domain = currentTestPath + "domain" + extension;
        File dir = new File(currentTestPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".val"));

        String validator;
        if (extension.equals(Tools.HDDL_EXT)) {
            validator = Tools.HDDL_VAL;
        } else {
            validator = Tools.PDDL_VAL;
        }

        if (files != null) {
            final StringBuilder output = new StringBuilder();
            int number = 0;
            for (File valfile : files) {
                final String problem = currentTestPath + Tools.removeExtension(valfile.getName()) + extension;
                String target;
                if (isWindows()) {
                    target = validator + "-win.exe -v " + domain + " " + problem + " " + valfile;
                } else if (isMac()) {
                    target = validator + "-osx -v " + domain + " " + problem + " " + valfile;
                } else {
                    target = validator + "-nux -v " + domain + " " + problem + " " + valfile;
                }
                final Runtime rt = Runtime.getRuntime();
                final Process proc = rt.exec(target);
                proc.waitFor();

                String line;
                final InputStreamReader inputStreamReader = new InputStreamReader(proc.getInputStream(),
                    StandardCharsets.UTF_8);
                final BufferedReader reader = new BufferedReader(inputStreamReader);


                try {
                    if (extension.equals(Tools.PDDL_EXT)) {
                        while ((line = reader.readLine()) != null) {
                            output.append(line + "\n");
                        }
                        number = Tools.numberValidatedPlans(output.toString());
                    } else { // Deal the HTN validator output
                        boolean validated = true;
                        while ((line = reader.readLine()) != null && validated) {
                            validated = line.indexOf("false") != 1;
                            output.append(line + "\n");
                        }
                        if (validated) {
                            number++;
                        }
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } finally {
                    reader.close();
                    inputStreamReader.close();
                    proc.getInputStream().close();
                }
            }

            System.out.println("\n-- Plan validator on " + currentTestPath);
            System.out.println("   Plans found: " + files.length);
            System.out.println("   Plans validated: " + number);
            System.out.println("--");
            Assert.assertEquals(files.length, number);
        }
        Tools.cleanValPlan(currentTestPath);
    }

    /**
     * Encode problems targeted in currentTestPath directory and check if they are solvable.
     *
     * @param currentTestPath the current directory to test.
     * @param extension the extension of the file.
     */
    public static void instantiate(String currentTestPath, String extension) {
        // Remove log
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        org.apache.logging.log4j.core.config.Configuration config = context.getConfiguration();
        LoggerConfig loggerConfig = config.getRootLogger();
        loggerConfig.setLevel(Level.OFF);
        context.updateLoggers();

        String currentDomain = currentTestPath + "domain" + extension;
        boolean oneDomainPerProblem = false;
        String problemFile;
        String currentProblem;

        // Counting the number of problem files
        File[] pbFileList = new File(currentTestPath)
            .listFiles((dir, name) -> name.startsWith("p") && name.endsWith(extension) && !name.contains("dom"));

        int nbTest = 0;
        if (pbFileList != null) {
            nbTest = pbFileList.length;
        }

        // Check if there is on domain per problem or a shared domain for all
        if (!new File(currentDomain).exists()) {
            oneDomainPerProblem = true;
        }

        System.out.println("Instantiation: Test on " + currentTestPath);
        int fillLength = Math.max(Integer.toString(nbTest).length(), 2);
        for (int i = 1; i < nbTest + 1; i++) {
            problemFile = String.format("p%0" + fillLength + "d" + extension, i);
            currentProblem = currentTestPath + problemFile;
            if (oneDomainPerProblem) {
                currentDomain = currentTestPath + problemFile.split(".p")[0] + "-" + "domain" + extension;
            }

            // Parses the PDDL domain and problem description
            try {
                Parser parser = new Parser();
                DefaultParsedProblem problemParsed = parser.parse(new File(currentDomain), new File(currentProblem));
                ErrorManager errorManager = parser.getErrorManager();
                if (!errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty()
                        || !errorManager.getMessages(Message.Type.LEXICAL_ERROR).isEmpty()) {
                    errorManager.printAll();
                }

                Assert.assertTrue(errorManager.getMessages(Message.Type.LEXICAL_ERROR).isEmpty()
                    && errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty());

                try {
                    // Encodes and instantiates the problem in a compact representation
                    System.out.println(" * Instantiation [" + currentProblem + "]" + "...");
                    Problem pb;
                    String typeOfProblem;
                    if (problemParsed.getRequirements().contains(RequireKey.HIERARCHY)) {
                        pb = new DefaultProblem(problemParsed);
                        typeOfProblem = "HTN";
                    } else if (problemParsed.getRequirements().contains(RequireKey.DURATIVE_ACTIONS)) {
                        pb = new DefaultProblem(problemParsed);
                        typeOfProblem = "Temporal";
                    } else if (!problemParsed.getRequirements().contains(RequireKey.DURATIVE_ACTIONS)
                            && problemParsed.getRequirements().contains(RequireKey.NUMERIC_FLUENTS)) {

                        pb = new DefaultProblem(problemParsed);
                        typeOfProblem = "Numeric";
                    } else {
                        pb = new DefaultProblem(problemParsed);
                        typeOfProblem = "ADL";
                    }
                    pb.instantiate();
                    Assert.assertTrue(pb != null);
                    System.out.print(" * "  + typeOfProblem + " problem instantiated (");
                    System.out.print(pb.getActions().size() + " actions, ");
                    System.out.print(pb.getDurativeActions().size() + " durative actions, ");
                    if (pb.getMethods() != null) {
                        System.out.print(pb.getMethods().size() + " methods, ");
                    } else {
                        System.out.print(0 + " methods, ");
                    }
                    if (pb.getDurativeMethods() != null) {
                        System.out.print(pb.getDurativeMethods().size() + " durative methods, ");
                    } else {
                        System.out.print(0 + " durative methods, ");
                    }
                    System.out.print(pb.getFluents().size() + " fluents) ");
                    if (pb.isSolvable()) {
                        System.out.println("is solvable.");
                    } else {
                        System.out.println("is not solvable.");
                    }
                } catch (OutOfMemoryError err) {
                    System.err.println("ERR: " + err.getMessage() + " - test aborted");
                    return;
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
        }
    }

    /**
     * Instantiate the Parser and parse all domains and problems in the specified test path.
     *
     * @param currentTestPath the path where try to find domain and problems pddl files
     * @param extension the file extension .pddl or .hddl
     * @return all issues report as a ArrayList of String
     * @throws Exception if something wrong.
     */
    public static List<String> parse(String currentTestPath, String extension) throws Exception {

        if (!Tools.isBenchmarkExist(currentTestPath)) {
            System.out.println("missing benchmark directory + \"" + currentTestPath + "\" test skipped !");
            return null;
        }

        final Parser parser = new Parser();
        final ArrayList<String> errors = new ArrayList<>();
        String currentDomain = currentTestPath + "domain" + extension;
        boolean oneDomainPerProblem = false;
        String problemFile;
        String currentProblem;

        // Counting the number of problem files
        File[] pbFileList = new File(currentTestPath)
            .listFiles((dir, name) -> name.startsWith("p") && name.endsWith(extension) && !name.contains("dom"));

        int nbTest = 0;
        if (pbFileList != null) {
            nbTest = pbFileList.length;
        }

        // Check if there is on domain per problem or a shared domain for all
        if (!new File(currentDomain).exists()) {
            oneDomainPerProblem = true;
        }

        System.out.println("\nParser test: Test parser on " + currentTestPath);
        // Loop around problems in one category
        int fillLength = Math.max(Integer.toString(nbTest).length(), 2);
        for (int i = 1; i < nbTest + 1; i++) {
            problemFile = String.format("p%0" + fillLength + "d" + extension, i);
            currentProblem = currentTestPath + problemFile;
            if (oneDomainPerProblem) {
                currentDomain = currentTestPath + problemFile.split(".p")[0] + "-domain" + extension;
            }
            try {
                parser.parse(currentDomain, currentProblem);
                ErrorManager errManager = parser.getErrorManager();
                if (!parser.getErrorManager().getMessages(Message.Type.PARSER_ERROR).isEmpty()
                        || !parser.getErrorManager().getMessages(Message.Type.LEXICAL_ERROR).isEmpty()) {
                    Set<Message> domainMessages = errManager.getMessages(new File(currentDomain));
                    Set<Message> problemMessages = errManager.getMessages(new File(currentProblem));
                    final StringBuilder builder = new StringBuilder();
                    domainMessages.forEach(dMsg -> builder.append(dMsg.toString()));
                    problemMessages.forEach(pMsg -> builder.append(pMsg.toString()));
                    System.out.println("Parser test: [FAILURE]");
                    System.out.println("   * " + currentProblem);
                    System.out.println("   * " + currentDomain);
                    System.out.println("   * Errors:");
                    System.out.println(builder.toString());
                    throw new Exception(builder.toString());
                } else {
                    System.out.println("Parser test: [PASSED]");
                    System.out.println("   * " + currentProblem);
                    System.out.println("   * " + currentDomain);
                    if (!parser.getErrorManager().getMessages(Message.Type.PARSER_WARNING).isEmpty()) {
                        Set<Message> domainMessages = errManager.getMessages(new File(currentDomain));
                        Set<Message> problemMessages = errManager.getMessages(new File(currentProblem));
                        final StringBuilder builder = new StringBuilder();
                        domainMessages.forEach(dMsg -> builder.append(dMsg.toString()));
                        problemMessages.forEach(pMsg -> builder.append(pMsg.toString()));
                        System.out.println("   * Warnings:");
                        System.out.println(builder.toString());
                    }
                }
            } catch (FileNotFoundException fnfException) {
                System.err.println("Test files not found !");
                System.err.println("  -- " + currentDomain);
                System.err.println("  -- " + currentProblem);
                System.err.println("Parser test aborted !");
            }
        }
        return errors;
    }

    /**
     * Check if the OS is Windows.
     *
     * @return true if the OS is Windows, false otherwise.
     */
    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase(new Locale("en", "EN")).contains("win");
    }

    /**
     * Check if the OS is Mac.
     *
     * @return true if the OS is Mac, false otherwise.
     */
    private static boolean isMac() {
        return System.getProperty("os.name").toLowerCase(new Locale("en", "EN")).contains("mac");
    }

    /**
     * Check if the OS is Linux.
     *
     * @return true if the OS is Linux, false otherwise.
     */
    private static boolean isUnix() {
        return System.getProperty("os.name").toLowerCase(new Locale("en", "EN")).contains("nux");
    }
}
