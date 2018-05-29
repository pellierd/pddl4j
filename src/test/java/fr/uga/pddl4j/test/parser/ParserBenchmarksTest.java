/*
 * Copyright (c) 2016 by Cedric Gerard <cedric.gerard@yeastlab.fr>.
 *
 * This file is part of PDDL4J library tests.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.test.parser;

import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Message;
import fr.uga.pddl4j.parser.Parser;
import fr.uga.pddl4j.test.Tools;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implements the <tt>ParserTest</tt> of the PDD4L library. The parser accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 * <p>
 * This class will test the parser on benchmark domain and problem from International planning contest.
 * The goal here is to test the PDDL4J 3.0 language coverage using all the file used in the competition.
 * </p>
 * <p>
 * Note that IPC benchmark files are note delivered with the source code because of their 3GB size.
 * It suppose benchmark directory is a the root of your project.
 * If no test files are provided all test will pass the validation.
 * </p>
 *
 * @author C Gerard
 * @version 0.1 - 16.02.16
 */
public class ParserBenchmarksTest {

    /**
     * Method that executes benchmarks using IPC1 files on the parser to test if its coverage is OK.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testParserIPC1() throws Exception {

        final String localTestPath = Tools.BENCH_DIR + "ipc1" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC1 test skipped !");
            return;
        }

        final ArrayList<String> errors = executeTests(localTestPath).collect(Collectors.toCollection(ArrayList::new));

        if (!errors.isEmpty()) {
            final StringBuilder builder = new StringBuilder();
            builder.append("Some parsing errors occurred !\n");
            errors.forEach(err -> {
                builder.append(err);
                builder.append("\n-------------------\n");
            });
            throw new Exception(builder.toString());
        }
    }

    /**
     * Method that executes benchmarks using IPC2 files on the parser to test if its coverage is OK.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testParserIPC2() throws Exception {

        final String localTestPath = Tools.BENCH_DIR + "ipc2" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC2 test skipped !");
            return;
        }

        final ArrayList<String> errors = executeTests(localTestPath).collect(Collectors.toCollection(ArrayList::new));

        if (!errors.isEmpty()) {
            final StringBuilder builder = new StringBuilder();
            builder.append("Some parsing errors occurred !\n");
            errors.forEach(err -> {
                builder.append(err);
                builder.append("\n-------------------\n");
            });
            throw new Exception(builder.toString());
        }
    }

    /**
     * Method that executes benchmarks using IPC3 files on the parser to test if its coverage is OK.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testParserIPC3() throws Exception {

        final String localTestPath = Tools.BENCH_DIR + "ipc3" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC3 test skipped !");
            return;
        }

        final ArrayList<String> errors = executeTests(localTestPath).collect(Collectors.toCollection(ArrayList::new));

        if (!errors.isEmpty()) {
            final StringBuilder builder = new StringBuilder();
            builder.append("Some parsing errors occurred !\n");
            errors.forEach(err -> {
                builder.append(err);
                builder.append("\n-------------------\n");
            });
            throw new Exception(builder.toString());
        }
    }

    /**
     * Method that executes benchmarks using IPC4 files on the parser to test if its coverage is OK.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testParserIPC4() throws Exception {

        final String localTestPath = Tools.BENCH_DIR + "ipc4" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC4 test skipped !");
            return;
        }

        final ArrayList<String> errors = executeTests(localTestPath).collect(Collectors.toCollection(ArrayList::new));

        if (!errors.isEmpty()) {
            final StringBuilder builder = new StringBuilder();
            builder.append("Some parsing errors occurred !\n");
            errors.forEach(err -> {
                builder.append(err);
                builder.append("\n-------------------\n");
            });
            throw new Exception(builder.toString());
        }
    }

    /**
     * Method that executes benchmarks using IPC5 files on the parser to test if its coverage is OK.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testParserIPC5() throws Exception {

        final String localTestPath = Tools.BENCH_DIR + "ipc5" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC5 test skipped !");
            return;
        }

        final ArrayList<String> errors = executeTests(localTestPath).collect(Collectors.toCollection(ArrayList::new));

        if (!errors.isEmpty()) {
            final StringBuilder builder = new StringBuilder();
            builder.append("Some parsing errors occurred !\n");
            errors.forEach(err -> {
                builder.append(err);
                builder.append("\n-------------------\n");
            });
            throw new Exception(builder.toString());
        }
    }

    /**
     * Method that executes benchmarks using IPC6 files on the parser to test if its coverage is OK.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testParserIPC6() throws Exception {

        final String localTestPath = Tools.BENCH_DIR + "ipc6" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC6 test skipped !");
            return;
        }

        final ArrayList<String> errors = executeTests(localTestPath).collect(Collectors.toCollection(ArrayList::new));

        if (!errors.isEmpty()) {
            final StringBuilder builder = new StringBuilder();
            builder.append("Some parsing errors occurred !\n");
            errors.forEach(err -> {
                builder.append(err);
                builder.append("\n-------------------\n");
            });
            throw new Exception(builder.toString());
        }
    }

    /**
     * Method that executes benchmarks using IPC7 files on the parser to test if its coverage is OK.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testParserIPC7() throws Exception {

        final String localTestPath = Tools.BENCH_DIR + "ipc7" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC7 test skipped !");
            return;
        }

        final ArrayList<String> errors = executeTests(localTestPath).collect(Collectors.toCollection(ArrayList::new));

        if (!errors.isEmpty()) {
            final StringBuilder builder = new StringBuilder();
            builder.append("Some parsing errors occurred !\n");
            errors.forEach(err -> {
                builder.append(err);
                builder.append("\n-------------------\n");
            });
            throw new Exception(builder.toString());
        }
    }

    /**
     * Method that executes benchmarks using IPC8 files on the parser to test if its coverage is OK.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testParserIPC8() throws Exception {

        final String localTestPath = Tools.BENCH_DIR + "ipc8" + File.separator;

        if (!Tools.isBenchmarkExist(localTestPath)) {
            System.out.println("missing Benchmark directory: IPC8 test skipped !");
            return;
        }

        final ArrayList<String> errors = executeTests(localTestPath).collect(Collectors.toCollection(ArrayList::new));

        if (!errors.isEmpty()) {
            final StringBuilder builder = new StringBuilder();
            builder.append("Some parsing errors occurred !\n");
            errors.forEach(err -> {
                builder.append(err);
                builder.append("\n-------------------\n");
            });
            throw new Exception(builder.toString());
        }
    }

    /**
     * Search for all domain file (domain.pddl or xxx-domain.pddl) and parse all domain/problem couple
     * if any.
     *
     * @param localTestPath the path where to begin research
     * @return A String stream containing error reports if any
     */
    private Stream<String> executeTests(String localTestPath) {

        // Go into subdirectories
        Stream<String> results =
            Stream.of(new File(localTestPath).list((dir, name) -> new File(localTestPath + name).isDirectory()))
                .map((subDir) -> localTestPath + subDir + File.separator)
                .flatMap(this::executeTests);

        // Validate current tests if any and returns errors from all tests that failed
        return Stream.concat(validate(localTestPath).stream(), results);
    }

    /**
     * Instantiate the Parser and parse all domains and problems in the specified test path.
     *
     * @param currentTestPath the path where try to find domain and problems pddl files
     * @return all issues report as a ArrayList of String
     */
    private ArrayList<String> validate(String currentTestPath) {
        final Parser parser = new Parser();
        final ArrayList<String> errors = new ArrayList<>();
        String currentDomain = currentTestPath + Tools.DOMAIN;
        boolean oneDomainPerProblem = false;
        String problemFile;
        String currentProblem;

        // Counting the number of problem files
        File[] pbFileList = new File(currentTestPath)
            .listFiles((dir, name) -> name.startsWith("p") && name.endsWith(".pddl") && !name.contains("dom"));

        int nbTest = 0;
        if (pbFileList != null) {
            nbTest = pbFileList.length;
        }

        // Check if there is on domain per problem or a shared domain for all
        if (!new File(currentDomain).exists()) {
            oneDomainPerProblem = true;
        }

        System.out.println("ParserBenchmarksTest: Test parser on " + currentTestPath);
        // Loop around problems in one category
        for (int i = 1; i < nbTest + 1; i++) {
            if (i < 10) {
                problemFile = "p0" + i + Tools.PDDL_EXT;
            } else {
                problemFile = "p" + i + Tools.PDDL_EXT;
            }

            currentProblem = currentTestPath + problemFile;

            if (oneDomainPerProblem) {
                currentDomain = currentTestPath + problemFile.split(".p")[0] + "-" + Tools.DOMAIN;
            }

            try {
                parser.parse(currentDomain, currentProblem);

                ErrorManager errManager = parser.getErrorManager();

                if (!parser.getErrorManager().isEmpty()) {
                    Set<Message> domainMessages = errManager.getMessages(new File(currentDomain));
                    Set<Message> problemMessages = errManager.getMessages(new File(currentProblem));

                    final StringBuilder builder = new StringBuilder();

                    domainMessages.forEach(dMsg -> builder.append(dMsg.toString()));
                    problemMessages.forEach(pMsg -> builder.append(pMsg.toString()));

                    errors.add(builder.toString());

                } else {
                    System.out.println("Parser test successful: \n   --" + currentProblem + "\n   --" + currentDomain);
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
}
