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

package fr.uga.pddl4j.parser;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Implements the <tt>ParserTest</tt> of the PDD4L library. The parser accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 *
 * <p>
 * This class will test the parser on benchmark domain and problem from International planning contest.
 * The goal here is to test the PDDL4J 3.0 language coverage using all the file used in the competition.
 * </p>
 *
 * <p>
 * Note that IPC benchmark files are note delivered with the source code because of their 3GB size.
 * It suppose benchmark directory is a the root of your project.
 * If no test files are provided all test will pass the validation.
 * </p>
 *
 * @author C Gerard
 * @version 0.1 - 16.02.16
 */
public class ParserTest {

    /**
     * The path of the benchmarks files.
     */
    private static final String BENCH_DIR = "benchmarks" + File.separator;

    /**
     * PDDL files extension.
     */
    private static final String EXT = ".pddl";

    /**
     * The domain file name.
     */
    private static final String DOMAIN = "domain" + EXT;

    /**
     * Value the current competition use for test.
     */
    private String curIPC = "";

    /**
     * Method that executes benchmarks using IPC1 files on the parser to test if its coverage is OK.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testParserIPC1() throws Exception {

        curIPC = "ipc1" + File.separator;

        final HashMap<String, String[]> subFolders = new HashMap<>();

        subFolders.put("assembly", new String[]{"adl"});
        subFolders.put("grid", new String[]{"strips" + File.separator + "untyped"});
        subFolders.put("gripper", new String[]{"adl", "strips" + File.separator + "untyped"});
        subFolders.put("logistics", new String[]{"adl", "strips" + File.separator + "untyped"});
        subFolders.put("movie", new String[]{"adl", "strips" + File.separator + "untyped"});
        subFolders.put("mprime", new String[]{"adl", "strips" + File.separator + "untyped",
            "strips" + File.separator + "untyped" + File.separator + "additional"});
        subFolders.put("mystery", new String[]{"adl", "strips" + File.separator + "typed"});

        validate(subFolders);
    }

    /**
     * Method that executes benchmarks using IPC2 files on the parser to test if its coverage is OK.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testParserIPC2() throws Exception {

        curIPC = "ipc2" + File.separator;

        final HashMap<String, String[]> subFolders = new HashMap<>();

        subFolders.put("blocksworld", new String[]{
            "track1" + File.separator + "strips" + File.separator + "typed",
            "track1" + File.separator + "strips" + File.separator + "typed" + File.separator + "additional",
            "track1" + File.separator + "strips" + File.separator + "untyped",
            "track1" + File.separator + "strips" + File.separator + "untyped" + File.separator + "additional",
            "track2" + File.separator + "strips" + File.separator + "untyped",
            "track2" + File.separator + "strips" + File.separator + "untyped" + File.separator + "additional"
        });
        subFolders.put("elevator", new String[]{
            "adl" + File.separator + "full",
            "adl" + File.separator + "simple",
            "strips" + File.separator + "typed",
            "strips" + File.separator + "untyped"
        });
        subFolders.put("freecell", new String[]{
            "strips" + File.separator + "typed",
            "strips" + File.separator + "untyped"
        });
        subFolders.put("logistics", new String[]{
            "track1" + File.separator + "strips" + File.separator + "typed",
            "track1" + File.separator + "strips" + File.separator + "typed" + File.separator + "additional",
            "track1" + File.separator + "strips" + File.separator + "untyped",
            "track1" + File.separator + "strips" + File.separator + "untyped" + File.separator + "additional",
            "track2" + File.separator + "strips" + File.separator + "untyped",
            "track2" + File.separator + "strips" + File.separator + "untyped" + File.separator + "additional"
        });
        subFolders.put("schedule", new String[]{
            "adl" + File.separator + "typed",
            "adl" + File.separator + "untyped",
            "strips"
        });

        validate(subFolders);
    }

    /**
     * Method that executes benchmarks using IPC3 files on the parser to test if its coverage is OK.
     *
     * @throws Exception if something went wrong
     */
    @Test
    public void testParserIPC3() throws Exception {
        curIPC = "ipc3" + File.separator;

        final HashMap<String, String[]> subFolders = new HashMap<>();

        subFolders.put("depots", new String[]{
            "strips" + File.separator + "typed",
            "strips" + File.separator + "typed" + File.separator + "handcoded",
            "strips" + File.separator + "untyped",
            "strips" + File.separator + "untyped" + File.separator + "handcoded",
            "time" + File.separator + "typed",
            "time" + File.separator + "typed" + File.separator + "handcoded",
            "time" + File.separator + "untyped",
            "time" + File.separator + "untyped" + File.separator + "handcoded"
        });
        subFolders.put("driverlog", new String[]{
            "hard-numeric" + File.separator + "typed",
            "hard-numeric" + File.separator + "typed" + File.separator + "handcoded",
            "hard-numeric" + File.separator + "untyped",
            "hard-numeric" + File.separator + "untyped" + File.separator + "handcoded",
            "numeric" + File.separator + "typed",
            "numeric" + File.separator + "typed" + File.separator + "handcoded",
            "numeric" + File.separator + "untyped",
            "numeric" + File.separator + "untyped" + File.separator + "handcoded",
            "simple-time" + File.separator + "typed",
            "simple-time" + File.separator + "typed" + File.separator + "handcoded",
            "simple-time" + File.separator + "untyped",
            "simple-time" + File.separator + "untyped" + File.separator + "handcoded",
            "strips" + File.separator + "typed",
            "strips" + File.separator + "typed" + File.separator + "handcoded",
            "strips" + File.separator + "untyped",
            "strips" + File.separator + "untyped" + File.separator + "handcoded",
            "time" + File.separator + "typed",
            "time" + File.separator + "typed" + File.separator + "handcoded",
            "time" + File.separator + "untyped",
            "time" + File.separator + "untyped" + File.separator + "handcoded"
        });
        subFolders.put("freecell", new String[]{
            "strips" + File.separator + "typed",
            "strips" + File.separator + "untyped"
        });
        subFolders.put("rover", new String[]{
            "numeric" + File.separator + "typed",
            "numeric" + File.separator + "typed" + File.separator + "handcoded",
            "numeric" + File.separator + "untyped",
            "numeric" + File.separator + "untyped" + File.separator + "handcoded",
            "simple-time" + File.separator + "typed",
            "simple-time" + File.separator + "typed" + File.separator + "handcoded",
            "simple-time" + File.separator + "untyped",
            "simple-time" + File.separator + "untyped" + File.separator + "handcoded",
            "strips" + File.separator + "typed",
            "strips" + File.separator + "typed" + File.separator + "handcoded",
            "strips" + File.separator + "untyped",
            "strips" + File.separator + "untyped" + File.separator + "handcoded",
            "time" + File.separator + "typed",
            "time" + File.separator + "typed" + File.separator + "handcoded",
            "time" + File.separator + "untyped",
            "time" + File.separator + "untyped" + File.separator + "handcoded"
        });
        subFolders.put("satellite", new String[]{
            "complex" + File.separator + "adl" + File.separator + "typed",
            "complex" + File.separator + "adl" + File.separator + "typed" + File.separator + "handcoded",
            "complex" + File.separator + "adl" + File.separator + "untyped",
            "complex" + File.separator + "adl" + File.separator + "untyped" + File.separator + "handcoded",
            "complex" + File.separator + "strips" + File.separator + "fluents" + File.separator + "typed",
            "complex" + File.separator + "strips" + File.separator + "fluents" + File.separator + "typed"
                + File.separator + "handcoded",
            "hard-numeric" + File.separator + "adl" + File.separator + "typed",
            "hard-numeric" + File.separator + "adl" + File.separator + "untyped",
            "hard-numeric" + File.separator + "strips" + File.separator + "typed",
            "hard-numeric" + File.separator + "strips" + File.separator + "untyped",
            "numeric" + File.separator + "adl" + File.separator + "typed",
            "numeric" + File.separator + "adl" + File.separator + "typed" + File.separator + "handcoded",
            "numeric" + File.separator + "adl" + File.separator + "untyped",
            "numeric" + File.separator + "adl" + File.separator + "untyped" + File.separator + "handcoded",
            "numeric" + File.separator + "strips" + File.separator + "typed",
            "numeric" + File.separator + "strips" + File.separator + "typed" + File.separator + "handcoded",
            "numeric" + File.separator + "strips" + File.separator + "untyped",
            "numeric" + File.separator + "strips" + File.separator + "untyped" + File.separator + "handcoded",
            "propositional" + File.separator + "adl" + File.separator + "typed",
            "propositional" + File.separator + "adl" + File.separator + "typed" + File.separator + "handcoded",
            "propositional" + File.separator + "adl" + File.separator + "untyped",
            "propositional" + File.separator + "adl" + File.separator + "untyped" + File.separator + "handcoded",
            "propositional" + File.separator + "strips" + File.separator + "typed",
            "propositional" + File.separator + "strips" + File.separator + "typed" + File.separator + "handcoded",
            "propositional" + File.separator + "strips" + File.separator + "untyped",
            "propositional" + File.separator + "strips" + File.separator + "untyped" + File.separator + "handcoded",
            "simple-time" + File.separator + "adl" + File.separator + "typed",
            "simple-time" + File.separator + "adl" + File.separator + "typed" + File.separator + "handcoded",
            "simple-time" + File.separator + "adl" + File.separator + "untyped",
            "simple-time" + File.separator + "adl" + File.separator + "untyped" + File.separator + "handcoded",
            "simple-time" + File.separator + "strips" + File.separator + "typed",
            "simple-time" + File.separator + "strips" + File.separator + "typed" + File.separator + "handcoded",
            "simple-time" + File.separator + "strips" + File.separator + "untyped",
            "simple-time" + File.separator + "strips" + File.separator + "untyped" + File.separator + "handcoded",
            "time" + File.separator + "adl" + File.separator + "typed",
            "time" + File.separator + "adl" + File.separator + "typed" + File.separator + "handcoded",
            "time" + File.separator + "adl" + File.separator + "untyped",
            "time" + File.separator + "adl" + File.separator + "untyped" + File.separator + "handcoded",
            "time" + File.separator + "strips" + File.separator + "typed",
            "time" + File.separator + "strips" + File.separator + "typed" + File.separator + "handcoded",
            "time" + File.separator + "strips" + File.separator + "untyped",
            "time" + File.separator + "strips" + File.separator + "untyped" + File.separator + "handcoded",
        });
        subFolders.put("settlers", new String[]{
            "numeric" + File.separator + "strips" + File.separator + "typed",
            "numeric" + File.separator + "strips" + File.separator + "untyped"
        });
        subFolders.put("umt2", new String[]{
            "numeric" + File.separator + "adl"
        });
        subFolders.put("zenotravel", new String[]{
            "numeric" + File.separator + "strips" + File.separator + "typed",
            "numeric" + File.separator + "strips" + File.separator + "typed" + File.separator + "handcoded",
            "numeric" + File.separator + "strips" + File.separator + "untyped",
            "numeric" + File.separator + "strips" + File.separator + "untyped" + File.separator + "handcoded",
            "propositional" + File.separator + "strips" + File.separator + "typed",
            "propositional" + File.separator + "strips" + File.separator + "typed" + File.separator + "handcoded",
            "propositional" + File.separator + "strips" + File.separator + "untyped",
            "propositional" + File.separator + "strips" + File.separator + "untyped" + File.separator + "handcoded",
            "simple-time" + File.separator + "strips" + File.separator + "typed",
            "simple-time" + File.separator + "strips" + File.separator + "typed" + File.separator + "handcoded",
            "simple-time" + File.separator + "strips" + File.separator + "untyped",
            "simple-time" + File.separator + "strips" + File.separator + "untyped" + File.separator + "handcoded",
            "time" + File.separator + "strips" + File.separator + "typed",
            "time" + File.separator + "strips" + File.separator + "typed" + File.separator + "handcoded",
            "time" + File.separator + "strips" + File.separator + "untyped",
            "time" + File.separator + "strips" + File.separator + "untyped" + File.separator + "handcoded",
            "time" + File.separator + "strips" + File.separator + "untyped" + File.separator + "handcoded"
        });

        validate(subFolders);
    }

    /**
     * Validate parser over all PDDL files under subFolders directories.
     *
     * @param subFolders the map containing the sub tree where pddl files are located
     * @throws Exception if one test failed
     */
    private void validate(HashMap<String, String[]> subFolders) throws Exception {

        final Parser parser = new Parser();
        final ArrayList<String> errors = new ArrayList<>();

        // loop over categories
        subFolders.forEach((cat, list) -> {

            int nbTest = 0;
            String problemFile;
            String currentProblem;
            String localTestPath;
            String currentTestPath;
            String currentDomain;

            // loop around sub folder in a category
            for (String aList : list) {
                localTestPath = cat + File.separator + aList + File.separator;
                currentTestPath = BENCH_DIR + curIPC + localTestPath;
                currentDomain = currentTestPath + DOMAIN;

                nbTest = new File(currentTestPath).listFiles((dir, name) -> {
                    return name.startsWith("p");
                }).length;

                // Loop around problems in one category
                for (int j = 1; j < nbTest; j++) {
                    if (j < 10) {
                        problemFile = "p0" + j + EXT;
                    } else {
                        problemFile = "p" + j + EXT;
                    }

                    currentProblem = currentTestPath + problemFile;

                    try {
                        parser.parse(currentDomain, currentProblem);

                        ErrorManager errManager = parser.getErrorManager();

                        if (!parser.getErrorManager().isEmpty()) {
                            Set<Message> domainMessages = errManager.getMessages(new File(currentDomain));
                            Set<Message> problemMessages = errManager.getMessages(new File(currentProblem));

                            StringBuilder builder = new StringBuilder();

                            domainMessages.forEach(dMsg -> builder.append(dMsg.toString()));
                            problemMessages.forEach(pMsg -> builder.append(pMsg.toString()));

                            errors.add(builder.toString());

                        } else {
                            System.out.println("Parser test " + currentProblem + " successful");
                        }

                    } catch (FileNotFoundException fnfException) {
                        System.err.println("Test files not found !");
                        System.err.println("  -- " + currentDomain);
                        System.err.println("  -- " + currentProblem);
                        System.err.println("Parser test aborted !");
                    }
                }
            }
        });

        if (!errors.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append("Some parsing errors occurred !\n");
            errors.forEach(err -> {
                builder.append(err);
                builder.append("\n-------------------\n");
            });
            throw new Exception(builder.toString());
        }

    }

}
