package fr.uga.pddl4j.test;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Parser;
import fr.uga.pddl4j.planners.ProblemFactory;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Static class that contains all shared method for manipulate the benchmark
 * directory structure.
 *
 * @author Cédric Gerard
 * @version 0.1 - 23.06.16
 */
public abstract class Tools {

    /**
     * This enumeration defines the type of file: Domain or Problem.
     */
    public enum FileType {
        /**
         * The DOMAIN file.
         */
        DOMAIN_FILE,
        /**
         * The PROBLEM file.
         */
        PROBLEM_FILE,
    }

    /**
     * The path of the benchmarks files.
     */
    public static final String BENCH_DIR = "benchmarks" + File.separator;

    /**
     * PDDL files extension.
     */
    public static final String PDDL_EXT = ".pddl";

    /**
     * PDDL4J output plan extension for KCL validator format.
     */
    public static final String PLAN_EXT = ".val";

    /**
     * The domain file name.
     */
    public static final String DOMAIN = "domain" + PDDL_EXT;

    /**
     * The path to VAL.
     */
    public static final String VAL = "src/test/resources/validate";

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
     * @return a coded problem from the parsing file
     */
    public static CodedProblem generateCodedProblem(String domainFile, String problemFile) {
        try {
            final File domain = new File(domainFile);
            final File problem = new File(problemFile);
            final ProblemFactory factory = ProblemFactory.getInstance();
            final ErrorManager errorManager = factory.parse(domain, problem);
            if (errorManager.isEmpty()) {
                return factory.encode();
            }
        } catch (IOException ioExcepion) {
            System.err.println(ioExcepion + " test files not found !");
        }
        return null;
    }

    /**
     * Instantiate the Parser and parse domain file specified in the given path.
     *
     * @param path        the path to the pddl file to test
     * @param errorToTest the type of issue to test
     * @param fileType    the type of file to test (DOMAIN or PROBLEM)
     * @return an ErrorManager from the parsing file
     */
    public static ErrorManager generateErrorMessages(String path, String errorToTest, Tools.FileType fileType) {
        final Parser parser = new Parser();
        ErrorManager errManager = new ErrorManager();
        final File file = new File(path);
        try {
            if (fileType == Tools.FileType.DOMAIN_FILE) {
                parser.parseDomain(file);
                errManager = parser.getErrorManager();
            } else if (fileType == Tools.FileType.PROBLEM_FILE) {
                final File domain = new File("src/test/resources/encoding/domain.pddl");
                parser.parse(domain, file);
                errManager = parser.getErrorManager();
            }
        } catch (FileNotFoundException fnfExcepion) {
            System.err.println(errorToTest + " test file not found !");
            System.err.println("  -- " + file);
        }
        return errManager;
    }

    /**
     * Change the permissions for VAL file (add read, write and execute).
     */
    public static void changeVALPerm() {
        final File val = new File(Tools.VAL);
        if (val.exists() && (isUnix() || isMac())) {
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
     * @param outputVal the output of VAL
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
     * Read the content of a file.
     *
     * @param path     the path to the file
     * @param encoding encoding of the file
     * @return the content of the file encoded
     */
    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    /**
     * Validate output plans.
     *
     * @param currentTestPath the current sub dir to test
     */
    public static void validatePlans(String currentTestPath) {
        try {
            final String domain = currentTestPath + "domain.pddl";
            File dir = new File(currentTestPath);
            File[] files = dir.listFiles((dir1, name) -> name.endsWith(".val"));

            if (files != null) {
                final StringBuilder output = new StringBuilder();

                for (File valfile : files) {
                    final String problem = currentTestPath + Tools.removeExtension(valfile.getName()) + ".pddl";
                    String target;
                    if (isWindows()) {
                        target = Tools.VAL + ".exe " + domain + " " + problem + " " + valfile;
                    } else {
                        target = Tools.VAL + " " + domain + " " + problem + " " + valfile;
                    }

                    final Runtime rt = Runtime.getRuntime();
                    final Process proc = rt.exec(target);
                    proc.waitFor();

                    String line;
                    final InputStreamReader inputStreamReader = new InputStreamReader(proc.getInputStream(),
                        StandardCharsets.UTF_8);
                    final BufferedReader reader = new BufferedReader(inputStreamReader);
                    try {
                        while ((line = reader.readLine()) != null) {
                            output.append(line + "\n");
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    } finally {
                        reader.close();
                        inputStreamReader.close();
                        proc.getInputStream().close();
                    }
                }

                final int number = Tools.numberValidatedPlans(output.toString());
                System.out.println("-- VAL on " + currentTestPath);
                System.out.println("   Plans found: " + files.length);
                System.out.println("   Plans validated: " + number);
                System.out.println("--");
                Assert.assertEquals(files.length,number);
            }

            Tools.cleanValPlan(currentTestPath);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
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
