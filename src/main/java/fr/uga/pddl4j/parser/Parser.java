/*
 * Copyright (c) 2010 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
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

import fr.uga.pddl4j.parser.lexer.Lexer;
import fr.uga.pddl4j.parser.lexer.ParseException;

import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.LogLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.LoggerConfig;
import picocli.CommandLine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

/**
 * Implements the <code>Parser</code> of the PDD4L library.
 *
 * <p>
 * A simple example of how to use the parser:
 * </p>
 * <pre>
 * public static void main(String[] args) {
 *
 *  if (args.length == 2 &amp;&amp; args[0].equals(&quot;-p&quot;)) {
 *      Parser parser = new Parser();
 *      try {
 *          parser.parse(args[1]);
 *        } catch (FileNotFoundException e) {
 *          System.out.println(e.getMessage());
 *        }
 *      if (!parser.getErrorManager().isEmpty()) {
 *          parser.getErrorManager().printAll();
 *      }
 *  } else if (args.length == 4 &amp;&amp; args[0].equals(&quot;-o&quot;) &amp;&amp; args[2].equals(&quot;-f&quot;)) {
 *    Parser parser = new Parser();
 *    try {
 *          parser.parse(args[1], args[3]);
 *        } catch (FileNotFoundException e) {
 *          System.out.println(e.getMessage());
 *        }
 *      if (!parser.getErrorManager().isEmpty()) {
 *          parser.mgr.printAll();
 *        }
 *    } else {
 *      System.out.println(&quot;\nusage of parser:\n&quot;);
 *      System.out.println(&quot;OPTIONS   DESCRIPTIONS\n&quot;);
 *      System.out.println(&quot;-p &lt;str&gt;    path for operator and fact file&quot;);
 *      System.out.println(&quot;-o &lt;str&gt;    operator file name&quot;);
 *      System.out.println(&quot;-f &lt;str&gt;    fact file name\n&quot;);
 *    }
 * }
 *
 * </pre>
 * To generate the PDDL BNF accepted by the parser use the commande line:
 *
 * <pre>
 *     ./gradlew jjdoc
 * </pre>
 * The BNF description is available in build/doc/PDD4J_BNF.
 *
 * @author D Pellier
 * @version 2.0 - 28.01.10
 */
@CommandLine.Command(name = "Parser",
    version = "Parser 1.0",
    description = "Parse PDDL domain and problem.",
    sortOptions = false,
    mixinStandardHelpOptions = true,
    headerHeading = "Usage:%n",
    synopsisHeading = "%n",
    descriptionHeading = "%nDescription:%n%n",
    parameterListHeading = "%nParameters:%n",
    optionListHeading = "%nOptions:%n")
public final class Parser implements Callable<Integer> {

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(AbstractPlanner.class.getName());

    /**
     * The specific symbol total-costs.
     */
    public static final Symbol<String> TOTAL_COST = new Symbol<String>(SymbolType.FUNCTOR, "total-cost");

    /**
     * The specific symbol total-costs.
     */
    public static final Symbol<String> TOTAL_TIME = new Symbol<String>(SymbolType.FUNCTOR, "total-time");

    /**
     * The error manager of the parser.
     */
    private ErrorManager mgr;

    /**
     * The lexer used.
     */
    private Lexer lexer;

    /**
     * The planning domain parsed.
     */
    private ParsedDomain domain;

    /**
     * The planning problem parsed.
     */
    private ParsedProblem problem;

    /**
     * The domain file.
     */
    private File domainFile;

    /**
     * The problem file.
     */
    private File problemFile;

    /**
     * Create a new <code>Parser</code>.
     */
    public Parser() {
        super();
        this.mgr = new ErrorManager();
    }

    /**
     * Sets the domain file to parse.
     *
     * @param domain the domain file to parse.
     */
    @CommandLine.Parameters(index = "0", description = "The domain file.")
    public final void setDomainFile(final File domain) {
        this.domainFile = domain;
    }

    /**
     * Returns the domain file to parse.
     *
     * @return the domain file to parse.
     */
    public final File getDomainFile() {
        return this.domainFile;
    }

    /**
     * Sets the problem file to parse.
     *
     * @param problem the problem file to parse.
     */
    @CommandLine.Parameters(index = "1", description = "The problem file.")
    public final void setProblemFile(final File problem) {
        this.problemFile = problem;
    }

    /**
     * Returns the problem file to parse.
     *
     * @return the problem file to parse.
     */
    public final File getProblemFile() {
        return this.problemFile;
    }

    /**
     * Sets the log level of the planner.
     *
     * @param log the log of the planner.
     * @see java.util.logging.Level
     */
    @CommandLine.Option(names = { "-l", "--log" }, defaultValue = "INFO", converter = LogLevel.class,
        description = "Set the level of trace of the planner: ALL, DEBUG, INFO, ERROR, FATAL, OFF, TRACE "
            + "(preset INFO).")
    public final void setLogLevel(final LogLevel log) {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        org.apache.logging.log4j.core.config.Configuration config = context.getConfiguration();
        LoggerConfig loggerConfig = config.getRootLogger();
        loggerConfig.setLevel(log.getLevel());
        context.updateLoggers();

    }

    /**
     * Returns the log of the planner.
     *
     * @return the trace level declared of the planner.
     * @see java.util.logging.Level
     */
    public final LogLevel getLogLevel() {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        org.apache.logging.log4j.core.config.Configuration config = context.getConfiguration();
        LoggerConfig loggerConfig = config.getRootLogger();
        return new LogLevel(loggerConfig.getLevel());
    }

    /**
     * Parses a planning domain from a specific file path.
     *
     * @param domain the path to the domain file.
     * @return a the pddl domain parsed or null if a lexical error or parser error occurred.
     * @throws FileNotFoundException if the specified domain does not exist.
     */
    public ParsedDomain parseDomain(String domain) throws FileNotFoundException {
        this.domainFile = new File(domain);
        return this.parseDomain(new File(domain));
    }

    /**
     * Parses a planning domain from a specific file.
     *
     * @param domain the file that contains the planning domain.
     * @return a the pddl domain parsed or null if a lexical error or parser error occurred.
     * @throws FileNotFoundException if the specified domain file does not exist.
     */
    public ParsedDomain parseDomain(File domain) throws FileNotFoundException {
        this.domainFile = domain;
        return this.parseDomain();
    }

    /**
     * Parses a planning domain from a specific file.
     *
     * @return the pddl domain parsed or null if a lexical error or parser error occurred.
     * @throws FileNotFoundException if the specified domain file does not exist.
     */
    public ParsedDomain parseDomain() throws FileNotFoundException {
        if (!this.getDomainFile().exists()) {
            throw new FileNotFoundException("File  \"" + this.getDomainFile().getName() + "\" does not exist.\n");
        }

        // Parse and check the domain
        FileInputStream inputStream = new FileInputStream(this.getDomainFile());
        if (this.lexer == null) {
            this.lexer = new Lexer(inputStream);
        } else {
            this.lexer.ReInit(inputStream);
        }
        lexer.setErrorManager(this.mgr);
        lexer.setFile(this.getDomainFile());
        try {
            this.domain = this.lexer.domain();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        if (this.domain == null) {
            return null;
        }
        this.checkRequirements();
        this.checkTypesDeclaration();
        this.checkConstantsDeclaration();
        this.checkPredicatesDeclaration();
        this.checkFunctionsDeclaration();
        this.checkDomainConstraints();
        this.checkTaskDeclaration();
        this.checkActionDeclaration();
        this.checkMethodDeclaration();
        this.checkDerivedPredicateDeclaration();
        return (this.getErrorManager().getMessages(Message.Type.LEXICAL_ERROR).isEmpty()
            && this.getErrorManager().getMessages(Message.Type.PARSER_ERROR).isEmpty()) ? this.domain : null;
    }

    /**
     * Parses a planning problem from a specific file path.
     *
     * @param problem the path to the planning problem.
     * @return a the pddl problem parsed or null if a lexical error or parser error occurred.
     * @throws FileNotFoundException if the specified problem file does not exist.
     */
    public ParsedProblem parseProblem(String problem) throws FileNotFoundException {
        this.problemFile = new File(problem);
        return this.parseProblem();
    }

    /**
     * Parses a planning problem from a specific file.
     *
     * @param problem the file that contains the planning problem.
     * @return a the pddl problem parsed or null if a lexical error or parser error occurred.
     * @throws FileNotFoundException if the specified problem file does not exist.
     */
    public ParsedProblem parseProblem(File problem) throws FileNotFoundException {
        this.problemFile = problem;
        return this.parseProblem();
    }

    /**
     * Parses a planning problem from a specific file.
     *
     * @return the pddl problem parsed or null if a lexical error or parser error occurred.
     * @throws FileNotFoundException if the specified problem file does not exist.
     */
    public ParsedProblem parseProblem() throws FileNotFoundException {
        if (!this.getProblemFile().exists()) {
            throw new FileNotFoundException("File  \"" + this.getProblemFile().getName() + "\" does not exist.\n");
        }

        // Parse and check the problem
        FileInputStream inputStream = new FileInputStream(this.getProblemFile());
        if (this.lexer == null) {
            this.lexer = new Lexer(inputStream);
        } else {
            this.lexer.ReInit(inputStream);
        }
        this.lexer.setFile(this.getProblemFile());
        try {
            this.problem = this.lexer.problem();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        if (this.problem == null) {
            return null;
        }
        this.checkDomainName();
        this.checkRequirements();
        this.checkObjectsDeclaration();
        this.checkInitialTaskNetwork();
        this.checkInitialState();
        this.checkGoal();
        this.checkProblemConstraints();
        this.checkMetric();
        return (this.getErrorManager().getMessages(Message.Type.LEXICAL_ERROR).isEmpty()
            && this.getErrorManager().getMessages(Message.Type.PARSER_ERROR).isEmpty()) ? this.problem : null;
    }

    /**
     * Parses a planning domain and a planning problem from the specified file path.
     *
     * @param domainAndProblem the path to the file that contains the planning domain and problem.
     * @return the problem parsed.
     * @throws FileNotFoundException if the specified file does not exist.
     */
    public DefaultParsedProblem parseDomainAndProblem(String domainAndProblem) throws FileNotFoundException {
        return this.parseDomainAndProblem(new File(domainAndProblem));
    }

    /**
     * Parses a planning domain and a planning problem from the specified file.
     *
     * @param domainAndProblem the file that contains the planning domain and problem.
     * @return the problem parsed.
     * @throws FileNotFoundException if the specified file does not exist.
     */
    public DefaultParsedProblem parseDomainAndProblem(File domainAndProblem) throws FileNotFoundException {
        if (!domainAndProblem.exists()) {
            throw new FileNotFoundException("File  \"" + domainAndProblem.getName() + "\" does not exist.\n");
        }
        this.lexer = new Lexer(new FileInputStream(domainAndProblem));
        lexer.setErrorManager(this.mgr);
        lexer.setFile(domainAndProblem);
        try {
            this.lexer.domain_and_problem();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        if (this.domain == null || this.problem == null) {
            return null;
        }
        this.domain = this.lexer.getDomain();
        this.problem = this.lexer.getProblem();
        this.checkRequirements();
        this.checkTypesDeclaration();
        this.checkConstantsDeclaration();
        this.checkPredicatesDeclaration();
        this.checkFunctionsDeclaration();
        this.checkTaskDeclaration();
        this.checkActionDeclaration();
        this.checkMethodDeclaration();
        this.checkDerivedPredicateDeclaration();
        this.checkDomainName();
        this.checkObjectsDeclaration();
        this.checkInitialTaskNetwork();
        this.checkInitialState();
        this.checkGoal();
        this.checkProblemConstraints();
        this.checkMetric();
        return new DefaultParsedProblem(this.getDomain(), this.getProblem());
    }

    /**
     * Parses a planning domain and a planning problem from their respective string description.
     *
     * @param domainString  the string that contains the planning domains.
     * @param problemString the string that contains the planning problem.
     * @throws IOException if an error occurs while parsing.
     */
    public void parseFromString(String domainString, String problemString) throws IOException {
        // Create temp files for domain and problem
        File domainTempFile = File.createTempFile("domain", ".pddl");
        File problemTempFile = File.createTempFile("problem", ".pddl");

        // Fill files with string content
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(domainTempFile), "UTF-8"))) {
            writer.write(domainString);
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(problemTempFile), "UTF-8"))) {
            writer.write(problemString);
        }

        // Parse and check the domain
        parseDomain(domainTempFile);
        // Parse and check the problem
        parseProblem(problemTempFile);
    }

    /**
     * Parses a planning domain and a planning problem from their respective string description.
     *
     * @param domainAndProblemString the string that contains the domain and planning problem.
     * @throws IOException if an error occurs while parsing.
     */
    public void parseFromString(String domainAndProblemString) throws IOException {
        // Create temp files for domain and problem
        File domainAndProblemTempFile = File.createTempFile("domainAndProblemString", ".pddl");

        // Fill files with string content
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(domainAndProblemTempFile), "UTF-8"))) {
            writer.write(domainAndProblemString);
        }

        // Parse and check the domain and problem
        parse(domainAndProblemTempFile);
    }

    /**
     * Parses a planning domain and a planning problem from an input stream.
     *
     * @param inputDomainAndProblem the stream that contains the domain and planning problem.
     * @throws IOException if an error occurs while parsing.
     */
    public void parseFromStream(InputStream inputDomainAndProblem) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputDomainAndProblem, "UTF-8"));
        parseFromString(buffer.lines().collect(Collectors.joining("\n")));
    }

    /**
     * Parses a planning domain and a planning problem from two input streams.
     *
     * @param inputDomain  the stream that contains the domain.
     * @param inputProblem the stream that contains the planning problem.
     * @throws IOException if an error occurs while parsing.
     */
    public void parseFromStream(InputStream inputDomain, InputStream inputProblem) throws IOException {
        BufferedReader bufferDomain = new BufferedReader(new InputStreamReader(inputDomain, "UTF-8"));
        BufferedReader bufferProblem = new BufferedReader(new InputStreamReader(inputProblem, "UTF-8"));
        parseFromString(bufferDomain.lines().collect(Collectors.joining("\n")),
            bufferProblem.lines().collect(Collectors.joining("\n")));
    }

    /**
     * Parses a planning domain and a planning problem from a file path.
     *
     * @param domainAndProblem the path of the file that contains the planning domain an problem.
     * @throws FileNotFoundException if the specified domain or problem file does not exist.
     */
    public void parse(String domainAndProblem) throws FileNotFoundException {
        this.parseDomainAndProblem(new File(domainAndProblem));
    }

    /**
     * Parses a planning domain and a planning problem from a file.
     *
     * @param domainAndProblem the file that contains the planning domain an problem.
     * @throws FileNotFoundException if the specified domain or problem file does not exist.
     */
    public void parse(File domainAndProblem) throws FileNotFoundException {
        this.parseDomainAndProblem(domainAndProblem);
    }

    /**
     * Parses a planning domain and a planning problem from their respective files.
     *
     * @param domain  the path of the file that contains the planning domains.
     * @param problem the path of the file that contains the planning problem.
     * @return the problem parsed.
     * @throws FileNotFoundException if the specified domain or problem file does not exist.
     */
    public DefaultParsedProblem parse(String domain, String problem) throws FileNotFoundException {
        return this.parse(new File(domain), new File(problem));
    }

    /**
     * Parses a planning domain and a planning problem from their respective files.
     *
     * @param domain  the file that contains the planning domains.
     * @param problem the file that contains the planning problem.
     * @return the problem parsed or null if an error occurred while parsing domain or problem.
     * @throws FileNotFoundException if the specified domain or problem file does not exist.
     */
    public DefaultParsedProblem parse(File domain, File problem) throws FileNotFoundException {
        if (!domain.exists()) {
            throw new FileNotFoundException("File  \"" + domain.getName() + "\" does not exist.\n");
        }
        if (!problem.exists()) {
            throw new FileNotFoundException("File  \"" + problem.getName() + "\" does not exist.\n");
        }
        // Parse and check the domain
        ParsedDomain pddlDomain = this.parseDomain(domain);
        // Parse and check the problem
        ParsedProblem pddlProblem = this.parseProblem(problem);
        return (pddlDomain != null && pddlProblem != null) ? new DefaultParsedProblem(pddlDomain, pddlProblem) : null;
    }

    /**
     * Returns the domain parsed.
     *
     * @return the domain parsed.
     */
    private final ParsedDomain getDomain() {
        return this.domain;
    }

    /**
     * Returns the problem parsed.
     *
     * @return the problem parsed.
     */
    private final ParsedProblem getProblem() {
        return this.problem;
    }

    /**
     * Check if the requirements declared in the domain are consistent. Requirements are consistent iff:
     *  <ul>
     *      <li>they do not contain both :partial-ordered-htn and :total-ordered-htn;</li>
     *      <li>they do not contain :htn-method-precondition with on the total or partial ordered requitrement.</li>
     *  </ul>
     *
     * @return <code>true</code> if the requirements declared in the domain are consistent.
     * <code>false</code> otherwise.
     */
    private boolean checkRequirements() {
        return (this.getDomain().getRequirements().contains(RequireKey.METHOD_PRECONDITIONS)
            && !this.getDomain().getRequirements().contains(RequireKey.HIERARCHY));
    }

    /**
     * Check if the metric declared in the domain is well formed.
     *
     * @return <code>true</code> if the metric declared in the domain is well formed;
     * <code>false</code> otherwise.
     */
    private boolean checkMetric() {
        return (this.problem.getMetric() == null) || this.checkParserNode(this.problem.getMetric(), new LinkedList<>());
    }

    /**
     * Check if the constraints declared in the domain are well formed.
     *
     * @return <code>true</code> if the constraints declared in the domain are well formed;
     * <code>false</code> otherwise.
     */
    private boolean checkDomainConstraints() {
        return (this.domain.getConstraints() == null)
            || this.checkParserNode(this.domain.getConstraints(), new LinkedList<>());
    }

    /**
     * Check if the constraints declared in the domain are well formed.
     *
     * @return <code>true</code> if the constraints declared in the domain are well formed;
     * <code>false</code> otherwise.
     */
    private boolean checkProblemConstraints() {
        return (this.problem.getConstraints() == null) || this.checkGroundedParserNode(this.problem.getConstraints());
    }

    /**
     * Check if the goal is well formed.
     *
     * @return <code>true</code> if the goal is well formed; <code>false</code> otherwise.
     */
    private boolean checkGoal() {
        return this.checkGroundedParserNode(this.problem.getGoal());
    }

    /**
     * Check if a specified ground PDDL expression is well formed.
     *
     * @param exp The expression.
     * @return <code>true</code> if a specified ground PDDL expression is well formed; <code>false</code> otherwise.
     */
    private boolean checkGroundedParserNode(Expression<String> exp) {
        boolean checked = true;
        if (exp == null) {
            return true;
        }
        LinkedList<Expression<String>> stackGD = new LinkedList<>();
        LinkedList<List<TypedSymbol<String>>> stackCtx = new LinkedList<>();
        stackGD.add(exp);
        stackCtx.add(new LinkedList<>());
        while (!stackGD.isEmpty()) {
            Expression<String> gd = stackGD.poll();
            List<TypedSymbol<String>> ctx = stackCtx.poll();
            List<TypedSymbol<String>> newCtx = new LinkedList<>(ctx);
            switch (gd.getConnector()) {
                case ATOM:
                case FN_HEAD:
                case EQUAL_ATOM:
                    boolean error = false;
                    final List<Symbol<String>> arguments = gd.getArguments();
                    final NamedTypedList atomSkeleton = new NamedTypedList(gd.getSymbol());
                    for (int i = 0; i < arguments.size(); i++) {
                        Symbol<String> symbol = arguments.get(i);
                        Iterator<TypedSymbol<String>> j = ctx.iterator();
                        TypedSymbol<String> qvar = null;
                        while (j.hasNext() && qvar == null) {
                            TypedSymbol<String> vj = j.next();
                            if (vj.equals(symbol)) {
                                qvar = vj;
                            }
                        }
                        if (symbol.getType().equals(SymbolType.VARIABLE) && qvar == null) {
                            this.mgr.logParserError("variable \"" + symbol + "\" is undefined",
                                this.lexer.getFile(), symbol.getLocation().getBeginLine(), symbol
                                    .getLocation().getBeginColumn());
                            error = true;
                        } else {
                            TypedSymbol<String> object = null;
                            if (qvar != null) {
                                object = qvar;
                            }
                            if (object == null) {
                                object = this.problem.getObject(symbol);
                            }
                            if (object == null) {
                                object = this.domain.getConstant(symbol);
                            }
                            if (object == null) {
                                this.mgr.logParserError("object \"" + symbol + "\" is undefined",
                                    this.lexer.getFile(), symbol.getLocation().getBeginLine(), symbol
                                        .getLocation().getBeginColumn());
                                error = true;
                            } else {
                                for (Symbol<String> type : object.getTypes()) {
                                    if (!this.domain.isDeclaredType(type)) {
                                        this.mgr.logParserError("type \"" + type.getValue()
                                            + "\" of the object \"" + object.getValue()
                                            + "\" is undefined", this.lexer.getFile(), type
                                            .getLocation().getBeginLine(), type.getLocation().getBeginColumn());
                                        error = true;
                                    }
                                }
                                atomSkeleton.add(object);
                            }
                        }
                        checked = !error;
                    }
                    if (checked && gd.getConnector().equals(Connector.ATOM)
                        && !this.isDeclaredPredicate(atomSkeleton)) {
                        this.mgr.logParserError("predicate \"" + atomSkeleton.getName() + "/"
                            + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                            .getFile(), atomSkeleton.getName().getLocation().getBeginLine(), atomSkeleton
                            .getName().getLocation().getBeginColumn());
                        checked = false;
                    } else if (checked && gd.getConnector().equals(Connector.FN_HEAD)
                        && !this.isDeclaredFunction(atomSkeleton)) {
                        this.mgr.logParserError("function \"" + atomSkeleton.getName() + "/"
                            + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                            .getFile(), atomSkeleton.getName().getLocation().getBeginLine(), atomSkeleton
                            .getName().getLocation().getBeginColumn());
                        checked = false;
                    }
                    break;
                case EXISTS:
                case FORALL:
                    for (TypedSymbol<String> variable : gd.getQuantifiedVariables()) {
                        error = false;
                        for (Symbol<String> type : variable.getTypes()) {
                            if (!this.domain.isDeclaredType(type)) {
                                this.mgr.logParserError("type \"" + type.getValue()
                                    + "\" used in quantified expression is undefined", this.lexer
                                    .getFile(), type.getLocation().getBeginLine(), type.getLocation().getBeginColumn());
                                error = true;
                            }
                        }
                        checked = !error;
                        if (checked) {
                            newCtx.add(variable);
                        }
                    }
                    break;
                default:
                    // do nothing
            }
            for (int i = 0; i < gd.getChildren().size(); i++) {
                stackCtx.add(newCtx);
                stackGD.add(gd.getChildren().get(i));
            }
        }
        return checked;
    }

    /**
     * Check the initial facts of the problem.
     *
     * @return <code>true</code> if the initial facts are well formed; <code>false</code> otherwise.
     */
    private boolean checkInitialState() {
        boolean checked = true;
        LinkedList<Expression<String>> stackGD = new LinkedList<>();
        stackGD.addAll(this.problem.getInit());
        while (!stackGD.isEmpty()) {
            Expression<String> gd = stackGD.poll();
            switch (gd.getConnector()) {
                case ATOM:
                case FN_ATOM:
                    boolean error = false;
                    Expression<String> fluent = null;
                    if (gd.getConnector().equals(Connector.ATOM)) {
                        fluent = gd;
                    } else {
                        fluent = gd.getChildren().get(0);
                    }
                    List<Symbol<String>> arguments = fluent.getArguments();
                    final NamedTypedList atomSkeleton = new NamedTypedList(fluent.getSymbol());
                    for (int i = 0; i < arguments.size(); i++) {
                        Symbol<String> symbol = arguments.get(i);
                        TypedSymbol<String> object = this.problem.getObject(symbol);
                        if (object == null) {
                            object = this.domain.getConstant(symbol);
                        }
                        if (object == null) {
                            this.mgr.logParserError("object \"" + arguments.get(i) + "\" is undefined",
                                this.lexer.getFile(), symbol.getLocation().getBeginLine(), symbol
                                    .getLocation().getBeginColumn());
                            error = true;
                        } else {
                            for (Symbol<String> type : object.getTypes()) {
                                if (!this.domain.isDeclaredType(type)) {
                                    this.mgr.logParserError("type \"" + type.getValue()
                                        + "\" of the object \"" + object.getValue()
                                        + "\" is undefined", this.lexer.getFile(), type
                                        .getLocation().getBeginLine(), type.getLocation().getBeginColumn());
                                    error = true;
                                }
                            }
                            atomSkeleton.add(object);
                        }
                    }
                    checked = !error;
                    if (checked && gd.getConnector().equals(Connector.ATOM)
                        && !this.isDeclaredPredicate(atomSkeleton)) {
                        this.mgr.logParserError("predicate \"" + atomSkeleton.getName() + "/"
                            + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                            .getFile(), atomSkeleton.getName().getLocation().getBeginLine(), atomSkeleton
                            .getName().getLocation().getBeginColumn());
                        checked = false;
                    } else if (checked && gd.getConnector().equals(Connector.FN_ATOM)
                        && !this.isDeclaredFunction(atomSkeleton)) {
                        this.mgr.logParserError("function \"" + atomSkeleton.getName() + "/"
                            + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                            .getFile(), atomSkeleton.getName().getLocation().getBeginLine(), atomSkeleton
                            .getName().getLocation().getBeginColumn());
                        checked = false;
                    }
                    break;
                case TIMED_LITERAL:
                    stackGD.add(gd.getChildren().get(1));
                    break;
                case NOT:
                    stackGD.add(gd.getChildren().get(0));
                    break;
                default:
                    // do nothing
            }
        }

        return checked;
    }

    /**
     * Check the objects' declaration.
     *
     * @return <code>true</code> if the objects are well declared; <code>false</code> otherwise.
     */
    private boolean checkObjectsDeclaration() {
        boolean checked = true;
        List<TypedSymbol<String>> objects = this.problem.getObjects();
        // Check that the type of the objects exists
        for (TypedSymbol<String> object : objects) {
            for (Symbol<String> type : object.getTypes()) {
                if (!this.domain.isDeclaredType(type)) {
                    this.mgr.logParserError("type \"" + type.getValue() + "\" of the object \""
                        + object.getValue() + "\" is undefined", this.lexer
                        .getFile(), type.getLocation().getBeginLine(), type.getLocation().getBeginColumn());
                    checked = false;
                }
            }
        }
        // Check that two objects with the same name has not two different types and are not declared twice
        for (int i = 0; i < objects.size(); i++) {
            final TypedSymbol oi = objects.get(i);
            for (int j = i + 1; j < objects.size(); j++) {
                TypedSymbol oj = objects.get(j);
                if (oi.getImage().equals(oj.getImage())) {
                    if (oi.getTypes().equals(oj.getTypes())) {
                        this.mgr.logParserError("object \"" + oj.getValue() + "\" already declared",
                            this.lexer.getFile(), oj.getLocation().getBeginLine(), oj.getLocation().getBeginColumn());
                        checked = false;
                    } else {
                        this.mgr.logParserError("objects \"" + oj + "\" and \"" + oi + "\" declared with "
                                + "different types", this.lexer.getFile(), oj.getLocation().getBeginLine(),
                            oj.getLocation().getBeginColumn());
                        checked = false;
                    }
                }
            }
        }
        // Check that an object and a constant with the same name has not two different types
        if (this.domain != null) {
            List<TypedSymbol<String>> constants = this.domain.getConstants();
            for (int i = 0; i < objects.size(); i++) {
                final TypedSymbol o = objects.get(i);
                for (int j = 0; j < constants.size(); j++) {
                    TypedSymbol c = constants.get(j);
                    if (o.getImage().equals(c.getImage())) {
                        if (!o.getTypes().equals(c.getTypes())) {
                            this.mgr.logParserError("object \"" + o.getValue() + "\" already declared as a "
                                    + "constant with an other type in the domain", this.lexer.getFile(),
                                o.getLocation().getBeginLine(), o.getLocation().getBeginColumn());
                            checked = false;
                        }
                    }
                }
            }
        }
        return checked;
    }

    /**
     * Check if the domain name specified in the problem is the same used in the domain.
     *
     * @return <code>true</code> if the domain name is the same, <code>false</code> otherwise.
     */
    private boolean checkDomainName() {
        boolean checked = true;
        if (this.domain.getDomainName() != null
            && this.problem.getProblemName() != null
            && !this.domain.getDomainName().equals(this.problem.getDomainName())) {
            this.mgr.logParserWarning("domain name \"" + this.problem.getDomainName()
                + "\" used in problem doest not match.", this.lexer.getFile(),
                this.problem.getDomainName().getLocation().getBeginLine(),
                this.problem.getDomainName().getLocation().getBeginColumn());
            checked = false;
        }
        return checked;
    }

    /**
     * Checks the types declaration. The types are well formed if the hierarchy is consistent
     * (multiple heritage is allowed).
     *
     * @return <code>true</code> if the types declaration is consistent; <code>false</code> otherwise.
     */
    private boolean checkTypesDeclaration() {

        List<TypedSymbol<String>> types = this.domain.getTypes();

        // Gathering types declaration
        final Map<String, TypedSymbol<String>> map = new HashMap<>();
        map.put(Symbol.OBJECT_TYPE.getValue(), new TypedSymbol<String>(Symbol.OBJECT_TYPE));

        for (TypedSymbol<String> type : types) {
            // Special cas for the type object
            if ((type.equals(Symbol.OBJECT_TYPE) || type.equals(Symbol.NUMBER_TYPE)) && !type.getTypes().isEmpty()) {
                this.mgr.logParserError("type \"" + type.getValue() + "\" cannot be used as derived type",
                    this.lexer.getFile(), type.getLocation().getBeginLine(), type.getLocation().getBeginColumn());
            } else { // General case
                // check if all super types are defined otherwise create a new type inherited from object
                type.getTypes().stream().filter(superType -> !types.contains(superType)).forEach(superType -> {
                    TypedSymbol<String> st = new TypedSymbol<String>(superType);
                    map.put(superType.getValue(), st);
                });
                // If the type was already encountered, it means that there is multiple inheritance
                // thus the super types are gathered
                TypedSymbol<String> t = map.get(type.getValue());
                if (t == null) {
                    map.put(type.getValue(), type);
                } else {
                    Set<Symbol<String>> set = new HashSet<>();
                    set.addAll(t.getTypes());
                    set.addAll(type.getTypes());
                    t.getTypes().clear();
                    t.getTypes().addAll(set);
                }
            }
        }


        // Check the consistency of the types declaration, i.e., if there is no loop in the types declaration
        boolean consistent = true;
        Iterator<TypedSymbol<String>> iterator = map.values().iterator();
        while (iterator.hasNext() && consistent) {
            final TypedSymbol<String> type = iterator.next();
            final LinkedList<TypedSymbol<String>> open = new LinkedList<>();
            open.add(type);
            while (!open.isEmpty() && consistent) {
                final TypedSymbol<String> current = open.poll();
                for (Symbol<String> st : current.getTypes()) {
                    final TypedSymbol<String> c = map.get(st.getValue());
                    consistent = !c.equals(type);
                    open.add(c);
                }
            }
            if (!consistent) {
                this.mgr.logParserError("Inconsistent types declaration for type \"" + type.getValue()
                    + "\"", this.lexer.getFile(), type.getLocation().getBeginLine(),
                    type.getLocation().getBeginColumn());
            }
        }

        // Add a copy of the types to the planning domain.
        this.domain.getTypes().clear();
        for (TypedSymbol<String> type : map.values()) {
            this.domain.getTypes().add(new TypedSymbol<String>(type));
        }
        return consistent;
    }

    /**
     * Checks the constants declaration. More precisely, checks if each constant is defined ones and
     * if the domain is typed if the types of the constants was previously defined as types.
     *
     * @return <code>true</code> if the constants declaration are well formed; <code>false</code> otherwise.
     */
    private boolean checkConstantsDeclaration() {
        List<TypedSymbol<String>> constants = this.domain.getConstants();
        Set<Symbol<String>> set = new HashSet<>();
        boolean checked = true;
        for (TypedSymbol<String> constant : constants) {
            if (!set.add(constant)) {
                this.mgr.logParserError("constant \"" + constant.getValue()
                        + "\" already defined", this.lexer.getFile(), constant.getLocation().getBeginLine(),
                    constant.getLocation().getBeginColumn());
                checked = false;
            }
            for (Symbol<String> type : constant.getTypes()) {
                if (!this.domain.isDeclaredType(type)) {
                    this.mgr.logParserError("type \"" + type.getValue() + "\" of the constant \""
                        + constant.getValue() + "\" is undefined", this.lexer
                        .getFile(), constant.getLocation().getBeginLine(), constant
                        .getLocation().getBeginColumn());
                }
                checked = false;
            }
        }
        return checked;
    }

    /**
     * Checks the predicates declaration. More precisely, this method checks, if the domain is
     * typed, if each types of the variables used in the predicates declaration are defined and if
     * there is no duplicated predicate.
     *
     * @return <code>true</code> if the predicates declaration are well formed; <code>false</code> otherwise.
     */
    private boolean checkPredicatesDeclaration() {
        List<NamedTypedList> predicates = this.domain.getPredicates();
        Set<String> set = new HashSet<>();
        boolean checked = true;
        for (NamedTypedList predicate : predicates) {
            for (TypedSymbol<String> variable : predicate.getArguments()) {
                for (Symbol<String> type : variable.getTypes()) {
                    if (!this.domain.isDeclaredType(type)) {
                        this.mgr.logParserError("type \"" + type.getValue()
                            + "\" of the variable \"" + variable.getValue()
                            + "\" is undefined in predicate declaration \"" + predicate.getName() + "\"",
                            this.lexer.getFile(), variable.getLocation().getBeginLine(),
                            variable.getLocation().getBeginColumn());
                        checked = false;
                    }
                }
            }
            Symbol<String> predicateSymbol = predicate.getName();
            String str = predicateSymbol.getValue() + "/" + predicate.getArguments().size();

            if (!set.add(str)) {
                this.mgr.logParserError("predicate \"" + str + "\" declared twice", this.lexer.getFile(),
                    predicateSymbol.getLocation().getBeginLine(), predicateSymbol.getLocation().getBeginColumn());
                checked = false;
            }
        }
        return checked;
    }

    /**
     * Checks the task declaration. More precisely, this method checks, if the domain is
     * typed, if each types of the variables used in the parameters of the tasks are well defined and if
     * there is no duplicated tasks.
     *
     * @return <code>true</code> if the predicates declaration are well formed; <code>false</code> otherwise.
     */
    private boolean checkTaskDeclaration() {
        List<NamedTypedList> tasks = this.domain.getTasks();
        Set<String> taskSet = new HashSet<>();

        boolean checked = true;
        for (NamedTypedList task : tasks) {
            for (TypedSymbol<String> variable : task.getArguments()) {
                for (Symbol<String> type : variable.getTypes()) {
                    if (!this.domain.isDeclaredType(type)) {
                        this.mgr.logParserError("type \"" + type.getValue()
                            + "\" of the variable \"" + variable.getValue()
                            + "\" is undefined in task declaration \"" + task.getName() + "\"", this.lexer.getFile(),
                            variable.getLocation().getBeginLine(), variable.getLocation().getBeginColumn());
                        checked = false;
                    }
                }
            }
            Symbol<String> symbol = task.getName();
            String taskSymbol = symbol.getValue() + "/" + task.getArguments().size();

            if (!taskSet.add(taskSymbol)) {
                this.mgr.logParserError("task \"" + taskSymbol + "\" declared twice", this.lexer
                    .getFile(), symbol.getLocation().getBeginLine(), symbol
                    .getLocation().getBeginColumn());
                checked = false;
            }
        }
        return checked;
    }

    /**
     * Checks the functions declaration. More precisely, this method checks, if the domain is typed,
     * if each types of the variables used in the function declaration are defined, if there is no
     * duplicated functions and conflict with predicates already defined.
     *
     * @return <code>true</code> if the function declaration are well formed; <code>false</code> otherwise.
     */
    private boolean checkFunctionsDeclaration() {

        Set<String> predicates = new HashSet<>();
        for (NamedTypedList predicate : this.domain.getPredicates()) {
            Symbol<String> predicateSymbol = predicate.getName();
            String str = predicateSymbol.getValue() + "/" + predicate.getArguments().size();
            predicates.add(str);
        }

        List<NamedTypedList> functions = this.domain.getFunctions();
        Set<String> set = new HashSet<>();
        boolean checked = true;
        for (NamedTypedList function : functions) {
            Symbol<String> functionSymbol = function.getName();
            for (TypedSymbol<String> variable : function.getArguments()) {
                for (Symbol<String> type : variable.getTypes()) {
                    if (!this.domain.isDeclaredType(type)) {
                        this.mgr.logParserError("type \"" + type.getValue()
                            + "\" of the variable \"" + variable.getValue()
                            + "\" is undefined", this.lexer.getFile(), variable
                            .getLocation().getBeginLine(), variable.getLocation().getBeginColumn());
                        checked = false;
                    }
                }
            }

            String str = functionSymbol.getValue() + "/" + function.getArguments().size();
            if (!set.add(str)) {
                this.mgr.logParserError("predicate \"" + str + "\" declared twice", this.lexer
                    .getFile(), functionSymbol.getLocation().getBeginLine(), functionSymbol
                    .getLocation().getBeginColumn());
                checked = false;
            }
            if (predicates.contains(str)) {
                this.mgr.logParserError("function \"" + str
                        + "\" is ambiguous with a predicate already declared",
                    this.lexer.getFile(), functionSymbol.getLocation().getBeginLine(), functionSymbol
                        .getLocation().getBeginColumn());
                checked = false;
            }
        }
        return checked;
    }

    /**
     * Checks if the declared derived predicates are well formed.
     *
     * @return <code>true</code> if the declared derived predicates are well formed;
     * <code>false</code> otherwise.
     */
    private boolean checkDerivedPredicateDeclaration() {
        boolean checked = true;
        for (ParsedDerivedPredicate axiom : this.domain.getDerivesPredicates()) {
            NamedTypedList head = axiom.getHead();
            for (TypedSymbol<String> argument : head.getArguments()) {
                for (Symbol<String> type : argument.getTypes()) {
                    if (!this.domain.isDeclaredType(type)) {
                        this.mgr.logParserError("type \"" + type.getValue()
                            + "\" used in derived predicate", this.lexer.getFile(), type
                            .getLocation().getBeginLine(), type.getLocation().getBeginColumn());
                        checked = false;
                    }
                }
            }
            if (checked && !this.isDeclaredPredicate(head)) {
                this.mgr.logParserError("predicate \"" + head.getName() + "/"
                        + head.getArguments().size() + "\" is undefined", this.lexer.getFile(),
                    head.getName().getLocation().getBeginLine(), head.getName().getLocation().getBeginColumn());
                checked = false;
            }
            if (checked) {
                checked = this.checkParserNode(axiom.getBody(), head.getArguments());
            }
        }
        return checked;
    }

    /**
     * Checks if the declared actions are well-formed.
     * <ul>
     * <li> actions must have a unique name.</li>
     * <li> The type of the variables or constants used in their precondition, condition and effects
     * are type previously declared.</li>
     * <li> The variable used in their precondition, condition and effects are declared as
     * parameters of the actions.</li>
     * </ul>
     *
     * @return <code>true</code> if the function declaration are well-formed; <code>false</code> otherwise.
     */
    private boolean checkActionDeclaration() {
        boolean checked = this.checkActionsUniqueness();
        for (ParsedAction action : this.domain.getActions()) {
            if (this.checkActionParameters(action)) {
                checked &= this.checkParserNode(action.getPreconditions(), action.getParameters());
                checked &= this.checkParserNode(action.getEffects(), action.getParameters());
                final Expression<String> effects = new Expression<String>(action.getEffects());
                if (action.getDuration() != null) {
                    checked &= this.checkParserNode(action.getDuration(), action.getParameters());
                }
            }
            this.checkActionSemantic(new ParsedAction(action));
        }
        return checked;
    }

    /**
     * Checks if the declared methods are well-formed.
     * <ul>
     * <li> Methods must have a unique name.</li>
     * <li> The type of the variables or constants used in their precondition, task and subtasks previously declared.
     * </li>
     * <li> The variable used in their precondition, condition and effects are declared as
     * parameters of the methods.</li>
     * <li> The task id used in subtasks declaration are unique.</li>
     * <li> The task id used in ordering constraints are all defined.</li>
     * </ul>
     *
     * @return <code>true</code> if the function declaration are well formed; <code>false</code> otherwise.
     */
    private boolean checkMethodDeclaration() {
        Set<String> actionSet = this.domain.getActions().stream().map(
            action -> action.getName().getValue()).collect(Collectors.toSet());
        boolean checked = this.checkMethodsUniqueness();
        for (ParsedMethod meth : this.domain.getMethods()) {
            if (this.checkMethodParameters(meth)) {
                checked &= this.checkParserNode(meth.getPreconditions(), meth.getParameters());
                checked &= this.checkParserNode(meth.getTask(), meth.getParameters());
                Symbol<String> taskSymbol = meth.getTask().getSymbol();
                if (actionSet.contains(taskSymbol.getValue())) {
                    this.mgr.logParserError("task symbol \"" + taskSymbol.getValue()
                        + "\" already used as action name",
                        this.lexer.getFile(), taskSymbol.getLocation().getBeginLine(),
                        taskSymbol.getLocation().getBeginColumn());
                    checked &= false;
                }
                checked &= this.checkParserNode(meth.getSubTasks(), meth.getParameters());
                checked &= this.checkParserNode(meth.getConstraints(), meth.getParameters());
            }
            if (this.checkTaskIDsUniqueness(meth)) {
                final Set<Symbol<String>> taskIds = Expression.getTaskIDs(meth.getSubTasks());
                if (meth.isDurative()) {
                    final Set<Symbol<String>> durativeIds = Expression.getTaskIDs(meth.getDuration());
                    for (Symbol<String> id : durativeIds) {
                        if (!taskIds.contains(id)) {
                            this.mgr.logParserError("task id \"" + id + "\" in the durative constraints of the "
                                + "method " + "\"" + meth.getName() + "\" is undefined", this.lexer.getFile(),
                                id.getLocation().getBeginLine(), id.getLocation().getBeginColumn());
                            checked = false;
                        }
                    }
                }
                final Set<Symbol<String>> orderingIds = Expression.getTaskIDs(meth.getOrdering());
                for (Symbol<String> id : orderingIds) {
                    if (!taskIds.contains(id)) {
                        this.mgr.logParserError("task id \"" + id + "\" in the ordering constraints of the"
                            + " method \"" + meth.getName() + "\" is undefined",
                            this.lexer.getFile(), id.getLocation().getBeginLine(), id.getLocation().getBeginColumn());
                        checked = false;
                    }
                }
                final Set<Symbol<String>> constIds = Expression.getTaskIDs(meth.getConstraints());
                for (Symbol<String> id : constIds) {
                    if (!taskIds.contains(id)) {
                        this.mgr.logParserError("task id \"" + id + "\" in the constraints of the "
                            + "method " + "\"" + meth.getName() + "\" is undefined",
                            this.lexer.getFile(), id.getLocation().getBeginLine(), id.getLocation().getBeginColumn());
                        checked = false;
                    }
                }
                // The verification is done only for non durative method
                if (!meth.isDurative()) {
                    checked = this.checkOrderingConstraintAcyclicness(meth.getOrdering());
                }
            } else {
                checked = false;
            }
            this.checkMethodSemantic(new ParsedMethod(meth));
        }
        return checked;
    }

    /**
     * Checks that the orderings constraints are acyclic. It wor
     *
     * @param constraints the ordering constraints expression. We make the assumption that the constraints are described
     *      by an AND expression.
     *
     * @return true if a set of ordering constraints are acyclic, false otherwise.
     */
    private boolean checkOrderingConstraintAcyclicness(final Expression<String> constraints) {
        Map<Symbol<String>, Set<Symbol<String>>> ordering = new LinkedHashMap<Symbol<String>, Set<Symbol<String>>>();
        for (Expression<String> constraint : constraints.getChildren()) {
            Symbol<String> keyTask = constraint.getChildren().get(0).getTaskID();
            Set<Symbol<String>> tasks = ordering.get(keyTask);
            if (tasks == null) {
                tasks = new HashSet<Symbol<String>>();
                ordering.put(keyTask, tasks);
            }
            tasks.add(constraint.getChildren().get(1).getTaskID());
        }
        Boolean closure = false;
        while (!closure) {
            closure = true;
            for (Map.Entry<Symbol<String>, Set<Symbol<String>>> entry : ordering.entrySet()) {
                Set<Symbol<String>> acc = new HashSet<Symbol<String>>();
                for (Symbol<String> task : entry.getValue()) {
                    Set<Symbol<String>> sacc = ordering.get(task);
                    if (sacc != null) {
                        acc.addAll(sacc);
                    }
                }
                closure &= !entry.getValue().addAll(acc);
            }
        }
        boolean check = true;
        Iterator<Map.Entry<Symbol<String>, Set<Symbol<String>>>> i = ordering.entrySet().iterator();
        while (i.hasNext() && check) {
            Map.Entry<Symbol<String>, Set<Symbol<String>>> entry = i.next();
            Symbol<String> task = entry.getKey();
            if (entry.getValue().contains(task)) {
                this.mgr.logParserError("cyclical constraint involving the task \"" + task.getValue()
                    + "\" in method declaration", this.lexer.getFile(), task.getLocation().getBeginLine(),
                    task.getLocation().getBeginColumn());
                check = false;
            }
        }
        return check;
    }

    /**
     * Checks if the declared initiak task network are well formed.
     * <ul>
     * <li> The task IDs used in subtasks declaration are unique.</li>
     * <li> The task ID used in ordering constraints are all defined.</li>
     * <li> The ordering constraints are acyclic.</li>
     * </ul>
     *
     * @return <code>true</code> if the initial task network is well formed; <code>false</code> otherwise.
     */
    private boolean checkInitialTaskNetwork() {
        boolean checked = true;
        if (problem.getInitialTaskNetwork() != null) {
            final ParsedTaskNetwork tn = this.problem.getInitialTaskNetwork();
            checked = this.checkParserNode(tn.getTasks(), tn.getParameters());
            if (this.checkTaskIDsUniquenessFromInitialTaskNetwork(tn.getTasks(), new HashSet<Symbol<String>>())) {
                final Set<Symbol<String>> taskIds = Expression.getTaskIDs(tn.getTasks());
                final Set<Symbol<String>> orderingIds = Expression.getTaskIDs(tn.getOrdering());
                for (Symbol<String> id : orderingIds) {
                    if (!taskIds.contains(id)) {
                        this.mgr.logParserError("task id \"" + id + "\" in the ordering constrains of the "
                            + "initial task network is undefined", this.lexer.getFile(),
                            id.getLocation().getBeginLine(),
                            id.getLocation().getBeginColumn());
                        checked = false;
                    }
                }
                final Set<Symbol<String>> constIds = Expression.getTaskIDs(tn.getConstraints());
                for (Symbol<String> id : constIds) {
                    if (!taskIds.contains(id)) {
                        this.mgr.logParserError("task id \"" + id + "\" in the constrains of the "
                            +  "initial task network is undefined", this.lexer.getFile(),
                            id.getLocation().getBeginLine(),
                            id.getLocation().getBeginColumn());
                        checked = false;
                    }
                }
                // The verification must be done but not implemented yet due to temporal aspects that make it more
                // complicated
                //checked = this.checkOrderingConstraintAcyclicness(tn.getOrdering());
            } else {
                checked = false;
            }
            //checked &= this.checkOrderingConstraintAcyclicness(problem.getConstraints());
        }
        return checked;
    }

    /**
     * Checks if the tasks ID used in an expression are unique.
     *
     * @param exp the expression.
     * @param taskIDs the set of task IDs already encountered.
     * @return true if the all the task ids used in the expression are unique; false otherwise.
     */
    private boolean checkTaskIDsUniquenessFromInitialTaskNetwork(Expression<String> exp, Set<Symbol<String>> taskIDs) {
        boolean unique = true;
        if (exp.getConnector().equals(Connector.TASK) && exp.getTaskID() != null) {
            if (!taskIDs.add(exp.getTaskID())) {
                this.mgr.logParserError("task id \"" + exp.getTaskID() + "\" in initial task network "
                    + "is already defined", this.lexer.getFile(),
                    exp.getTaskID().getLocation().getBeginLine(),
                    exp.getTaskID().getLocation().getBeginColumn());
                unique = false;
            }
        } else {
            for (int i = 0; i < exp.getChildren().size(); i++) {
                Expression<String> c = exp.getChildren().get(i);
                this.checkTaskIDsUniquenessFromInitialTaskNetwork(c, taskIDs);
            }
        }
        return unique;
    }

    /**
     * Checks if the tasks ID used in the tasks declaration of the method in parameter are unique.
     *
     * @param meth the methode to be tested.
     * @return true if the all the task ids used in a method declaration are unique; false otherwise.
     */
    private boolean checkTaskIDsUniqueness(ParsedMethod meth) {
        return this.checkTaskIDsUniqueness(meth, meth.getSubTasks(), new HashSet<Symbol<String>>());
    }

    /**
     * Checks if the tasks ID used in an expression are unique.
     *
     * @param meth the method to be tested.
     * @param exp the expression.
     * @return true if the all the task ids used in the expression are unique; false otherwise.
     */
    private boolean checkTaskIDsUniqueness(ParsedMethod meth, Expression<String> exp, Set<Symbol<String>> taskIds) {
        boolean unique = true;
        if (exp.getConnector().equals(Connector.TASK) && exp.getTaskID() != null) {
            if (!taskIds.add(exp.getTaskID())) {
                this.mgr.logParserError("task id \"" + exp.getTaskID() + "\" in method "
                    + "\"" + meth.getName() + "\" is already defined", this.lexer.getFile(),
                    exp.getTaskID().getLocation().getBeginLine(),
                    exp.getTaskID().getLocation().getBeginColumn());
                unique = false;
            }
        } else {
            for (int i = 0; i < exp.getChildren().size(); i++) {
                Expression<String> c = exp.getChildren().get(i);
                this.checkTaskIDsUniqueness(meth, c, taskIds);
            }
        }
        return unique;
    }

    /**
     * Checks if a PDDL expression such as the preconditions, the effects and the duration of an
     * action is well-formed. More precisely, check if all variables are well typed and are valid
     * parameters of the action or quantified variable and finally, if all atoms match a predicate
     * previously declared.
     *
     * @param exp     The PDDL expression.
     * @param context The symbolEncoding.
     * @return <code>true</code> if the expression is well-formed; <code>false</code> otherwise.
     */
    private boolean checkParserNode(Expression<String> exp, List<TypedSymbol<String>> context) {
        boolean checked = true;
        LinkedList<Expression<String>> stackGD = new LinkedList<>();
        LinkedList<List<TypedSymbol<String>>> stackCtx = new LinkedList<>();
        stackGD.add(exp);
        stackCtx.add(context);
        Set<Expression<String>> atoms = new HashSet<>();
        while (!stackGD.isEmpty()) {
            Expression<String> gd = stackGD.poll();
            List<TypedSymbol<String>> ctx = stackCtx.poll();
            List<TypedSymbol<String>> newCtx = new LinkedList<>(ctx);
            switch (gd.getConnector()) {
                case ATOM:
                case FN_HEAD:
                case TASK:
                    checked = this.checkAtom(gd, newCtx);
                    break;
                case EXISTS:
                case FORALL:
                    for (TypedSymbol<String> variable : gd.getQuantifiedVariables()) {
                        boolean error = false;
                        for (Symbol<String> type : variable.getTypes()) {
                            if (!this.domain.isDeclaredType(type)) {
                                this.mgr.logParserError("type \"" + type.getValue()
                                    + "\" used in quantified expression is undefined", this.lexer.getFile(),
                                    type.getLocation().getBeginLine(), type.getLocation().getBeginColumn());
                                error |= true;
                            }
                        }
                        checked = !error;
                        if (checked) {
                            newCtx.add(variable);
                        }
                    }
                    break;
                case EQUAL_ATOM:
                    for (Symbol<String> term : gd.getArguments()) {
                        checked = this.checkTerm(term, newCtx);
                    }
                    break;
                default:
                    // do nothing
            }
            for (int i = 0; i < gd.getChildren().size(); i++) {
                stackCtx.add(0, newCtx);
                stackGD.add(0, gd.getChildren().get(i));
            }
        }
        return checked;
    }

    /**
     * Check if an atom used is well typed and if it was previously declared in the predicates of
     * the domain.
     *
     * @param gd      The atom goal description.
     * @param context The symbolEncoding, i.e., the quantified variables if any.
     * @return <code>true</code> if an atom used is well typed and declared, <code>false</code> otherwise.
     */
    private boolean checkAtom(Expression<String> gd, List<TypedSymbol<String>> context) {
        boolean checked = true;
        List<Symbol<String>> arguments = gd.getArguments();
        final NamedTypedList atomSkeleton = new NamedTypedList(gd.getSymbol());
        for (int i = 0; i < arguments.size(); i++) {
            final Symbol<String> s = arguments.get(i);
            if (s.getType().equals(SymbolType.VARIABLE)) {
                TypedSymbol<String> param = null;
                Iterator<TypedSymbol<String>> itr = context.iterator();
                while (itr.hasNext() && param == null) {
                    TypedSymbol<String> pi = itr.next();
                    if (pi.equals(s)) {
                        param = pi;
                    }
                }
                if (param == null) {
                    this.mgr.logParserError("variable \"" + s.getValue() + "\" is undefined",
                        this.lexer.getFile(), s.getLocation().getBeginLine(), s.getLocation().getBeginColumn());
                    checked = false;
                } else {
                    final TypedSymbol<String> arg = new TypedSymbol<String>(s);
                    param.getTypes().forEach(arg::addType);
                    atomSkeleton.add(arg);
                }
            } else {
                TypedSymbol<String> constant = this.domain.getConstant(s);
                if (constant == null) {
                    if (this.problem != null) {
                        constant = this.problem.getObject(s);
                    }
                }
                if (constant == null) {
                    this.mgr.logParserError("constant \"" + s.getValue() + "\" is undefined",
                        this.lexer.getFile(), s.getLocation().getBeginLine(), s.getLocation().getBeginColumn());
                    checked = false;
                } else {
                    atomSkeleton.add(constant);
                }

            }
        }
        if (checked && gd.getConnector().equals(Connector.ATOM)
            && !this.isDeclaredPredicate(atomSkeleton)) {
            this.mgr.logParserError("predicate \"" + atomSkeleton.getName() + "/"
                + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                .getFile(), atomSkeleton.getName().getLocation().getBeginLine(), atomSkeleton
                .getName().getLocation().getBeginColumn());
            checked = false;
        } else if (checked && gd.getConnector().equals(Connector.FN_ATOM)
            && !this.isDeclaredFunction(atomSkeleton)) {
            this.mgr.logParserError("function \"" + atomSkeleton.getName() + "/"
                + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                .getFile(), atomSkeleton.getName().getLocation().getBeginLine(), atomSkeleton
                .getName().getLocation().getBeginColumn());
            checked = false;
        } else if (checked && gd.getConnector().equals(Connector.TASK)
            && !this.isDeclaredTask(atomSkeleton)) {
            this.mgr.logParserError("task \"" + atomSkeleton.getName() + "/"
                + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                .getFile(), atomSkeleton.getName().getLocation().getBeginLine(), atomSkeleton
                .getName().getLocation().getBeginColumn());
            checked = false;
        }
        return checked;
    }


    /**
     * Checks is a term is well defined in a specific context.
     *
     * @param term the term.
     * @param context the context.
     * @return <code>true</code> if the term is well defined; <code>false</code> otherwise.
     */
    private boolean checkTerm(Symbol<String> term, List<TypedSymbol<String>> context) {
        boolean checked = true;
        if (term.getType().equals(SymbolType.VARIABLE)) {
            TypedSymbol<String> param = null;
            Iterator<TypedSymbol<String>> itr = context.iterator();
            while (itr.hasNext() && param == null) {
                TypedSymbol<String> pi = itr.next();
                if (pi.equals(term)) {
                    param = pi;
                }
            }
            if (param == null) {
                this.mgr.logParserError("variable \"" + term.getValue() + "\" is undefined",
                    this.lexer.getFile(), term.getLocation().getBeginLine(), term.getLocation().getBeginColumn());
                checked = false;
            }
        } else {
            TypedSymbol<String> constant = this.domain.getConstant(term);
            if (constant == null) {
                if (this.problem != null) {
                    constant = this.problem.getObject(term);
                }
            }
            if (constant == null) {
                this.mgr.logParserError("constant \"" + term.getValue() + "\" is undefined",
                    this.lexer.getFile(), term.getLocation().getBeginLine(), term.getLocation().getBeginColumn());
                checked = false;
            }
        }
        return checked;
    }

    /**
     * Returns if task in parameter was previously declared.
     *
     * @param task the task.
     * @return <code>true</code> if this task was previously declared; <code>false</code> otherwise.
     */
    private boolean isDeclaredTask(NamedTypedList task) {
        boolean checked = false;
        int i = 0;
        while (i < this.domain.getTasks().size() && !checked) {
            NamedTypedList t = this.domain.getTasks().get(i);
            if (task.getName().equals(t.getName())
                && task.getArguments().size() == t.getArguments().size()) {
                int j = 0;
                checked = true;
                while (j < task.getArguments().size() && checked) {
                    TypedSymbol<String> arg1 = task.getArguments().get(j);
                    TypedSymbol<String> arg2 = t.getArguments().get(j);
                    checked = this.matchTypes(arg1, arg2);
                    j++;
                }
            }
            i++;
        }
        return checked;
    }

    /**
     * Returns if this predicate was previously declared.
     *
     * @param predicate the predicate.
     * @return <code>true</code> if this predicate was previously declared; <code>false</code> otherwise.
     */
    private boolean isDeclaredPredicate(NamedTypedList predicate) {
        boolean checked = false;
        int i = 0;
        while (i < this.domain.getPredicates().size() && !checked) {
            NamedTypedList p = this.domain.getPredicates().get(i);
            if (predicate.getName().equals(p.getName())
                && predicate.getArguments().size() == p.getArguments().size()) {
                int j = 0;
                checked = true;
                while (j < predicate.getArguments().size() && checked) {
                    TypedSymbol<String> arg1 = predicate.getArguments().get(j);
                    TypedSymbol<String> arg2 = p.getArguments().get(j);
                    checked = this.matchTypes(arg1, arg2);
                    j++;
                }
            }
            i++;
        }
        return checked;
    }

    /**
     * Returns if this function was previously declared.
     *
     * @param function the function.
     * @return <code>true</code> if this function was previously declared; <code>false</code> otherwise.
     */
    private boolean isDeclaredFunction(NamedTypedList function) {
        boolean checked = false;
        int i = 0;
        while (i < this.domain.getFunctions().size() && !checked) {
            NamedTypedList p = this.domain.getFunctions().get(i);
            if (function.getName().equals(p.getName())
                && function.getArguments().size() == p.getArguments().size()) {
                int j = 0;
                checked = true;
                while (j < function.getArguments().size() && checked) {
                    TypedSymbol<String> arg1 = function.getArguments().get(j);
                    TypedSymbol<String> arg2 = p.getArguments().get(j);
                    checked = this.matchTypes(arg1, arg2);
                    j++;
                }
            }
            i++;
        }
        return checked;
    }

    /**
     * Returns if the types of two typed symbol matched, i.e., if the types of the first typed
     * symbol can be viewed as a subtype of the second.
     *
     * @param s1 the first typed symbol.
     * @param s2 the second typed symbol.
     * @return <code>true</code> if the types can be viewed as a subtype, <code>false</code> otherwise.
     */
    private boolean matchTypes(TypedSymbol<String> s1, TypedSymbol<String> s2) {
        List<Symbol<String>> copy = new LinkedList<>(s1.getTypes());
        copy.retainAll(s2.getTypes());
        boolean isSubType = !copy.isEmpty();
        Iterator<Symbol<String>> i = s1.getTypes().iterator();
        while (i.hasNext() && !isSubType) {
            TypedSymbol<String> type = this.domain.getType(i.next());
            LinkedList<TypedSymbol<String>> stack = new LinkedList<>();
            stack.push(type);
            while (!stack.isEmpty() && !isSubType) {
                TypedSymbol<String> t = stack.poll();
                copy = new LinkedList<>(t.getTypes());
                copy.retainAll(s2.getTypes());
                isSubType = !copy.isEmpty();
                t.getTypes().stream().filter(s -> !s.equals(Symbol.OBJECT_TYPE)).forEach(s ->
                    stack.push(this.domain.getType(s)));
            }
        }
        return isSubType;
    }

    /**
     * Checks the parameters of an action, i.e., if each parameter is single and its type was previously
     * declared.
     *
     * @param action the action to check.
     * @return <code>true</code> if the parameters of the specified action are well formed;
     * <code>false</code> otherwise.
     */
    private boolean checkActionParameters(ParsedAction action) {
        boolean checked = true;
        Set<Symbol<String>> set = new HashSet<>();
        for (TypedSymbol<String> parameter : action.getParameters()) {
            if (!set.add(parameter)) {
                this.mgr.logParserError("parameter \"" + parameter + "\" is defined twice in the action \""
                    + action.getName() + "\"", this.lexer.getFile(), parameter.getLocation().getBeginLine(), parameter
                    .getLocation().getBeginColumn());
                checked = false;
            }
            for (Symbol<String> type : parameter.getTypes()) {
                if (!this.domain.isDeclaredType(type)) {
                    this.mgr.logParserError("type \"" + type.getValue() + "\" of the parameter \""
                        + parameter + "\" in the action \"" + action.getName() + "\" is undefined",
                        this.lexer.getFile(),
                        parameter.getLocation().getBeginLine(),
                        parameter.getLocation().getBeginColumn());
                    checked = false;
                }
            }
        }
        return checked;
    }

    /**
     * Checks the method parameters, i.e., if each parameter is single and its type was previously
     * declared.
     *
     * @param method the method to check.
     * @return <code>true</code> if the parameters of the specified method are well formed;
     * <code>false</code> otherwise.
     */
    private boolean checkMethodParameters(ParsedMethod method) {
        boolean checked = true;
        Set<Symbol<String>> set = new HashSet<>();
        for (TypedSymbol<String> parameter : method.getParameters()) {
            if (!set.add(parameter)) {
                this.mgr.logParserError("parameter \"" + parameter + "\" is defined twice in method \""
                    + method.getName() + "\"", this.lexer.getFile(), parameter.getLocation().getBeginLine(), parameter
                    .getLocation().getBeginColumn());
                checked = false;
            }
            for (Symbol<String> type : parameter.getTypes()) {
                if (!this.domain.isDeclaredType(type)) {
                    this.mgr.logParserError("type \"" + type.getValue() + "\" of the parameter \""
                        + parameter + "\" in method \"" + method.getName() + "\" is undefined",
                        this.lexer.getFile(),
                        parameter.getLocation().getBeginLine(),
                        parameter.getLocation().getBeginColumn());
                    checked = false;
                }
            }
        }
        return checked;
    }

    /**
     * Checks the uniqueness of the name of the action declared.
     *
     * @return <code>true</code> if all the actions are single; <code>false</code> otherwise.
     */
    private boolean checkActionsUniqueness() {
        boolean checked = true;
        Set<Symbol<String>> set = new HashSet<>();
        for (ParsedAction op : this.domain.getActions()) {
            if (!set.add(op.getName())) {
                Symbol<String> name = op.getName();
                this.mgr.logParserError("action \"" + name + "\" declared twice", this.lexer
                    .getFile(), name.getLocation().getBeginLine(), name.getLocation().getBeginColumn());
                checked = false;
            }
        }
        return checked;
    }

    /**
     * Checks the uniqueness of the name of the methods declared.
     *
     * @return <code>true</code> if all the methods are single; <code>false</code> otherwise.
     */
    private boolean checkMethodsUniqueness() {
        boolean checked = true;
        Set<Symbol<String>> set = new HashSet<>();
        for (ParsedMethod meth : this.domain.getMethods()) {
            if (!set.add(meth.getName())) {
                Symbol<String> name = meth.getName();
                this.mgr.logParserError("method \"" + name + "\" declared twice", this.lexer
                    .getFile(), name.getLocation().getBeginLine(), name.getLocation().getBeginColumn());
                checked = false;
            }
        }
        return checked;
    }

    /**
     * Check the semantic of an action. The action in parameter is modified during the method call.
     *
     * @param action the action to check.
     * @return <code>true</code> if the action succeeds the test; <code>false</code> otherwise.
     */
    private boolean checkActionSemantic(ParsedAction action) {
        boolean check = true;
        int i = 0;
        // Check preconditions
        final Expression<String> preconditions = action.getPreconditions();
        //Expression.renameVariables(preconditions, context);
        check &= this.checkExpressionSemantic(preconditions);
        if (preconditions.getConnector().equals(Connector.TRUE)) {
            this.mgr.logParserWarning("Action " + action.getName() + " is always applicable: "
                    + "action preconditions can be simplified to TRUE.", this.lexer.getFile(),
                action.getName().getLocation().getBeginLine(), action.getName().getLocation().getBeginColumn());
            check = false;
        } else if (preconditions.getConnector().equals(Connector.FALSE)) {
            this.mgr.logParserWarning("Action " + action.getName() + " is never applicable: "
                    + "action preconditions can be simplified to FALSE.", this.lexer.getFile(),
                action.getName().getLocation().getBeginLine(), action.getName().getLocation().getBeginColumn());
            check = false;
        }
        // Check effects
        final Expression<String> effects = action.getPreconditions();
        check &= this.checkExpressionSemantic(effects);
        if (effects.getConnector().equals(Connector.TRUE)) {
            this.mgr.logParserWarning("Action " + action.getName() + " is produced no effects: "
                    + "action effects can be simplified to TRUE.", this.lexer.getFile(),
                action.getName().getLocation().getBeginLine(), action.getName().getLocation().getBeginColumn());
            check = false;
        } else if (effects.getConnector().equals(Connector.FALSE)) {
            this.mgr.logParserWarning("Action " + action.getName() + " is produced invalid effects: "
                    + "action effects can be simplified to FALSE.", this.lexer.getFile(),
                action.getName().getLocation().getBeginLine(), action.getName().getLocation().getBeginColumn());
            check = false;
        }
        return check;
    }

    /**
     * Check the semantic of a method. The method in parameter is modified during the method call.
     *
     * @param method the method to check.
     * @return <code>true</code> if the method succeeds the test; <code>false</code> otherwise.
     */
    private boolean checkMethodSemantic(ParsedMethod method) {
        boolean check = true;
        int i = 0;
        // Check the method preconditions
        final Expression<String> preconditions = method.getPreconditions();
        check &= this.checkExpressionSemantic(preconditions);
        if (preconditions.getConnector().equals(Connector.TRUE)) {
            this.mgr.logParserWarning("Method " + method.getName() + " is always applicable: "
                    + "method preconditions can be simplified to TRUE.", this.lexer.getFile(),
                method.getName().getLocation().getBeginLine(), method.getName().getLocation().getBeginColumn());
            check = false;
        } else if (preconditions.getConnector().equals(Connector.FALSE)) {
            this.mgr.logParserWarning("Method " + method.getName() + " is never applicable: "
                    + "method preconditions can be simplified to FALSE.", this.lexer.getFile(),
                method.getName().getLocation().getBeginLine(), method.getName().getLocation().getBeginColumn());
            check = false;
        }
        return check;
    }

    /**
     * Check the semantic of an PDDL expression. This method checks:
     * <ul>
     *     <li>double negation</li>
     *     <li>unnecessary inner conjunctions or disjunctions</li>
     *     <li>equality always true</li>
     *     <li>disjunction or conjunction containing a and not a </li>
     *     <li>unnecessary conditional effect</li>
     *     <li>duplicated expression</li>
     * </ul>
     *
     * @param exp the expression to check.
     * @return <code>true</code> if the expression succeeds the test; <code>false</code> otherwise.
     * @throws UnexpectedExpressionException if the expression is not composed of expressions that are not FORALL,
     *      EXISTS, AND, OR, IMPLY, NOT, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL, EQUAL, ATOM or EQUAL_ATOM,
     *      WHEN, TRUE and FALSE.
     */
    private boolean checkExpressionSemantic(final Expression<String> exp) {
        // Expression cannot be evaluated due to lexical failure
        if (exp.getLocation() == null) {
            return false;
        }

        int line = exp.getLocation().getBeginLine();
        int column = exp.getLocation().getBeginColumn();

        boolean check = true;
        switch (exp.getConnector()) {
            case FORALL:
            case EXISTS:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case AT_END_CONSTRAINT:
            case ALWAYS_CONSTRAINT:
            case AT_MOST_ONCE_CONSTRAINT:
            case SOMETIME_CONSTRAINT:
            case HOLD_AFTER_METHOD_CONSTRAINT:
            case HOLD_BEFORE_METHOD_CONSTRAINT:
            case AT_END_METHOD_CONSTRAINT:
            case AT_START_METHOD_CONSTRAINT:
            case ALWAYS_METHOD_CONSTRAINT:
            case AT_MOST_ONCE_METHOD_CONSTRAINT:
            case SOMETIME_METHOD_CONSTRAINT:
            case SOMETIME_BEFORE_METHOD_CONSTRAINT:
            case SOMETIME_AFTER_METHOD_CONSTRAINT:
            case HOLD_BETWEEN_METHOD_CONSTRAINT:
            case HOLD_DURING_METHOD_CONSTRAINT:
                Expression<String> child = exp.getChildren().get(0);
                check &= this.checkExpressionSemantic(child);
                if (child.getConnector().equals(Connector.TRUE)
                    || child.getConnector().equals(Connector.FALSE)) {
                    exp.setConnector(child.getConnector());
                    this.mgr.logParserWarning(exp.getConnector() + " expression is always " + exp.getConnector()
                            + ".", this.lexer.getFile(), line, column);
                    check = false;
                }
                break;
            case IMPLY:
                final Expression<String> cause = exp.getChildren().get(0);
                final Expression<String> consequence = exp.getChildren().get(1);
                check &= this.checkExpressionSemantic(cause);
                if (cause.getConnector().equals(Connector.TRUE)) {
                    check &= this.checkExpressionSemantic(consequence);
                    exp.assign(consequence);
                    this.mgr.logParserWarning("IMPLY expression cause always TRUE.", this.lexer.getFile(),
                        line, column);
                    check = false;
                } else if (cause.getConnector().equals(Connector.FALSE)) {
                    exp.setConnector(Connector.TRUE);
                    this.mgr.logParserWarning("IMPLY expression cause always FALSE.", this.lexer.getFile(),
                        line, column);
                    check = false;
                } else {
                    check &= this.checkExpressionSemantic(consequence);
                    if (consequence.getConnector().equals(Connector.TRUE)) {
                        exp.setConnector(Connector.TRUE);
                        this.mgr.logParserWarning("IMPLY expression consequence always TRUE.",
                            this.lexer.getFile(), line, column);
                        check = false;
                    } else if (consequence.getConnector().equals(Connector.FALSE)) {
                        exp.setConnector(Connector.NOT);
                        exp.getChildren().remove(1);
                        this.mgr.logParserWarning("IMPLY expression consequence always FALSE.",
                            this.lexer.getFile(), line, column);
                        check = false;
                    }
                }
                break;
            case AND:
                check &= this.checkDuplicateChild(exp);
                check &= this.checkTautology(exp);
                if (exp.getChildren().isEmpty()) {
                    exp.setConnector(Connector.TRUE);
                    this.mgr.logParserWarning("AND expression is empty.", this.lexer.getFile(), line, column);
                    check = false;
                } else if (exp.getChildren().size() == 1) {
                    exp.assign(exp.getChildren().get(0));
                    check &= this.checkExpressionSemantic(exp);
                } else {
                    int i = 0;
                    while (i < exp.getChildren().size()
                        && !exp.getConnector().equals(Connector.TRUE)
                        && !exp.getConnector().equals(Connector.FALSE)) {
                        child = exp.getChildren().get(i);
                        int childLine = child.getLocation().getBeginLine();
                        int childColumn = child.getLocation().getBeginColumn();
                        check &= this.checkExpressionSemantic(child);
                        if (child.getConnector().equals(Connector.FALSE)) {
                            exp.setConnector(Connector.FALSE);
                            this.mgr.logParserWarning("AND expression contains a sub-expression (line "
                                    + childLine + ", column " + childColumn + ") always FALSE.",
                                this.lexer.getFile(), line, column);
                            check = false;
                        } else if (child.getConnector().equals(Connector.TRUE)) {
                            exp.getChildren().remove(i);
                            this.mgr.logParserWarning("AND expression contains a sub-expression (line "
                                    + childLine + ", column " + childColumn + ") always TRUE.",
                                this.lexer.getFile(), line, column);
                            check = false;
                        } else if (child.getConnector().equals(Connector.AND)) {
                            exp.getChildren().remove(i);
                            exp.getChildren().addAll(i, child.getChildren());
                            i += child.getChildren().size();
                            this.mgr.logParserWarning("AND expression contains an inner conjunction that "
                                + "can be removed.", this.lexer.getFile(), line, column);
                            check = false;
                        } else {
                            i++;
                        }
                    }
                }
                break;
            case OR:
                check &= this.checkDuplicateChild(exp);
                check &= this.checkTautology(exp);
                if (exp.getChildren().isEmpty()) {
                    exp.setConnector(Connector.TRUE);
                    this.mgr.logParserWarning("OR expression is empty.",  this.lexer.getFile(), line, column);
                    check = false;
                } else if (exp.getChildren().size() == 1) {
                    exp.assign(exp.getChildren().get(0));
                    check &= this.checkExpressionSemantic(exp);
                } else {
                    int i = 0;
                    while (i < exp.getChildren().size()
                        && !exp.getConnector().equals(Connector.TRUE)
                        && !exp.getConnector().equals(Connector.FALSE)) {
                        child = exp.getChildren().get(i);
                        int childLine = child.getLocation().getBeginLine();
                        int childColumn = child.getLocation().getBeginColumn();
                        check &= this.checkExpressionSemantic(child);
                        if (child.getConnector().equals(Connector.TRUE)) {
                            exp.setConnector(Connector.TRUE);
                            this.mgr.logParserWarning("OR expression contains a sub-expression (line "
                                    + childLine + ", column " + childColumn + ") always TRUE.",
                                this.lexer.getFile(), line, column);
                            check = false;
                        } else if (child.getConnector().equals(Connector.FALSE)) {
                            exp.getChildren().remove(i);
                            this.mgr.logParserWarning("OR expression contains a sub-expression (line "
                                    + childLine + ", column " + childColumn + ") always FALSE. ",
                                this.lexer.getFile(), line, column);
                            check = false;
                        } else if (child.getConnector().equals(Connector.OR)) {
                            exp.getChildren().remove(i);
                            exp.getChildren().addAll(i, child.getChildren());
                            i += child.getChildren().size();
                            this.mgr.logParserWarning("OR expression contains an inner disjunction that "
                                + "can be removed.", this.lexer.getFile(), line, column);
                            check = false;
                        } else {
                            i++;
                        }
                    }
                }
                break;
            case NOT:
                child = exp.getChildren().get(0);
                check &= this.checkExpressionSemantic(child);
                if (child.getConnector().equals(Connector.NOT)) {
                    exp.assign(child.getChildren().get(0));
                    this.mgr.logParserWarning("NOT expression contains a double negation that "
                        + "can be removed.", this.lexer.getFile(), line, column);
                } else if (child.getConnector().equals(Connector.TRUE)) {
                    exp.setConnector(Connector.FALSE);
                } else if (child.getConnector().equals(Connector.FALSE)) {
                    exp.setConnector(Connector.TRUE);
                }
                break;
            case WHEN:
                Expression<String> condition = exp.getChildren().get(0);
                check &= this.checkExpressionSemantic(condition);
                Expression<String> effect =  exp.getChildren().get(1);
                check &= this.checkExpressionSemantic(effect);
                if (condition.getConnector().equals(Connector.TRUE)) {
                    exp.assign(effect);
                    this.mgr.logParserWarning("WHEN expression with condition always TRUE. "
                        + "Effect can be considered as unconditional.", this.lexer.getFile(), line, column);
                    check = false;
                } else if (condition.getConnector().equals(Connector.FALSE)) {
                    exp.setConnector(Connector.TRUE);
                    this.mgr.logParserWarning("WHEN expression with condition always FALSE. "
                        + "The whole conditional effect can be removed.", this.lexer.getFile(), line, column);
                    check = false;
                }
                break;
            case EQUAL_ATOM:
                if (exp.getArguments().get(0).equals(exp.getArguments().get(1))) {
                    exp.setConnector(Connector.TRUE);
                    this.mgr.logParserWarning("EQUAL expression always TRUE. "
                        + "The expression can be removed.", this.lexer.getFile(), line, column);
                    check = false;
                }
                break;
            case TIMED_LITERAL:
                if (exp.getChildren().get(0).getValue() < 0.0) {
                    this.mgr.logParserError("TIMED_LITERAL expression cannot use a time < 0.0. ",
                        this.lexer.getFile(), line, column);
                    check = false;
                }
                break;
            case WITHIN_CONSTRAINT:
            case HOLD_AFTER_CONSTRAINT:
                if (exp.getChildren().get(0).getValue() < 0.0) {
                    this.mgr.logParserError(exp.getConnector().toString()
                            + " expression cannot use a time < 0.0. ",  this.lexer.getFile(), line, column);
                    check = false;
                }
                check &= this.checkExpressionSemantic(exp.getChildren().get(1));
                break;
            case SOMETIME_AFTER_CONSTRAINT:
            case SOMETIME_BEFORE_CONSTRAINT:
                check &= this.checkExpressionSemantic(exp.getChildren().get(0));
                check &= this.checkExpressionSemantic(exp.getChildren().get(1));
                break;
            case ALWAYS_WITHIN_CONSTRAINT:
                if (exp.getChildren().get(0).getValue() < 0.0) {
                    this.mgr.logParserError(exp.getConnector().toString()
                        + " expression cannot use a time < 0.0. ",  this.lexer.getFile(), line, column);
                    check = false;
                }
                check &= this.checkExpressionSemantic(exp.getChildren().get(1));
                check &= this.checkExpressionSemantic(exp.getChildren().get(2));
                break;
            case HOLD_DURING_CONSTRAINT:
                if (exp.getChildren().get(0).getValue() > exp.getChildren().get(1).getValue()) {
                    exp.setConnector(Connector.FALSE);
                    this.mgr.logParserError("HOLD_DURING_CONSTRAINT expression with invalid interval",
                        this.lexer.getFile(), line, column);
                    check = false;
                } else {
                    check &= this.checkExpressionSemantic(exp.getChildren().get(0));
                    if (exp.getChildren().get(0).getConnector().equals(Connector.TRUE)
                        || exp.getChildren().get(0).getConnector().equals(Connector.FALSE)) {
                        exp.setConnector(exp.getChildren().get(0).getConnector());
                        check = false;
                    }
                }
                break;
            case EQUAL_COMPARISON:
            case GREATER_COMPARISON:
            case GREATER_OR_EQUAL_COMPARISON:
            case LESS_COMPARISON:
            case LESS_OR_EQUAL_COMPARISON:
            case ATOM:
            case TRUE:
            case FALSE:
                break;
            default:
                throw new UnexpectedExpressionException(exp.toString());
        }
        return check;
    }

    /**
     * Check and removed duplicated child in conjunction and disjunction expressions. The expression in parameter is
     * modified. If a duplicated subexpression is found, the duplicated expression is removed.
     *
     * @param exp the expression to test. The expression must be a conjunction of a disjunction.
     * @return <code>true</code> if the expression is well-formed; <code>false</code> otherwise.
     */
    private boolean checkDuplicateChild(Expression<String> exp) {
        assert exp.getConnector().equals(Connector.AND)
            || exp.getConnector().equals(Connector.OR);
        boolean check = true;
        for (int i = 0; i < exp.getChildren().size(); i++) {
            final Expression<String> ei = exp.getChildren().get(i);
            for (int j = i + 1; j < exp.getChildren().size(); j++) {
                final Expression<String> ej =  exp.getChildren().get(j);
                if (ei.equals(ej)) {
                    exp.getChildren().remove(j);
                    j--;
                    this.mgr.logParserWarning("Duplicated " + ei.getConnector() + " sub-expression in "
                            + exp.getConnector().getImage().toUpperCase(Locale.ROOT) + " expression. "
                            + "The duplicated sub-expression can be removed.", this.lexer.getFile(),
                            ej.getLocation().getBeginLine(), ej.getLocation().getBeginColumn());
                    check = false;
                }
            }
        }
        return check;
    }

    /**
     * Check and remove tautologies of the form (a and not a) in conjunctive and disjunctive expressions. The expression
     * in parameter is modified. If a tautology is detected, the subexpression of the tautology are removed and replaced
     * by a TRUE expression.
     *
     * @param exp the expression to test. The expression must be a conjunction of a disjunction.
     * @return <code>true</code> if the expression is well-formed; <code>false</code> otherwise.
     */
    private boolean checkTautology(Expression<String> exp) {
        assert exp.getConnector().equals(Connector.AND)
            || exp.getConnector().equals(Connector.OR);
        boolean check = true;
        for (int i = 0; i < exp.getChildren().size(); i++) {
            Expression<String> ei =  exp.getChildren().get(i);
            Expression<String> neg = new Expression<String>(Connector.NOT);
            neg.addChild(ei);
            for (int j = i + 1; j < exp.getChildren().size(); j++) {
                Expression<String> ej = exp.getChildren().get(j);
                if (ej.equals(neg)) {
                    ei.setConnector(Connector.TRUE);
                    exp.getChildren().remove(j);
                    j--;
                    this.mgr.logParserWarning("Tautology detected between sub-expressions in "
                            + exp.getConnector() + " expression.",
                        this.lexer.getFile(), exp.getLocation().getBeginLine(), exp.getLocation().getBeginColumn());
                    check = false;
                }
            }
        }
        return check;
    }

    /**
     * Returns the error manager of the parser.
     *
     * @return the error manager of the parser.
     */
    public ErrorManager getErrorManager() {
        return this.mgr;
    }

    /**
     * The main method of the <code>Parser</code> planner.
     *
     * @param args the arguments of the command line.
     */
    public static void main(String[] args) {
        try {
            final Parser parser = new Parser();
            CommandLine cmd = new CommandLine(parser);
            int exitCode = (int) cmd.execute(args);
            System.exit(exitCode);
        } catch (Throwable e) {
            LOGGER.fatal(e.getMessage());
        }
    }

    /**
     * This method contains the code called by the main method of the planner when planner are launched from
     * command line.
     *
     * @return the exit return value of the planner: O if every thing is ok; 1 otherwise.
     */
    @Override
    public Integer call() {
        try {
            this.parse(this.getDomainFile(), this.getProblemFile());
            final ErrorManager errorManager = this.getErrorManager();
            if (!errorManager.isEmpty()) {
                for (Message m : errorManager.getMessages()) {
                    if (LOGGER.isFatalEnabled()
                        && (m.getType().equals(Message.Type.LEXICAL_ERROR)
                        || m.getType().equals(Message.Type.PARSER_ERROR))) {
                        LOGGER.fatal(m.toString());
                    } else if (LOGGER.isWarnEnabled()
                        && m.getType().equals(Message.Type.PARSER_WARNING)) {
                        LOGGER.warn(m.toString());
                    }
                }
                if (!errorManager.getMessages(Message.Type.LEXICAL_ERROR).isEmpty()
                    || !errorManager.getMessages(Message.Type.PARSER_ERROR).isEmpty()) {
                    return null;
                }
            } else if (LOGGER.isInfoEnabled()) {
                StringBuilder strb = new StringBuilder();
                strb.append("\nparsing domain file \"");
                strb.append(this.getDomainFile().getName());
                strb.append("\" done successfully");
                strb.append("\nparsing problem file \"");
                strb.append(this.getProblemFile().getName());
                strb.append("\" done successfully");
                strb.append("\n");
                LOGGER.info(strb);
            }
        } catch (FileNotFoundException e) {
            LOGGER.fatal(e.getMessage());
            return 1;
        }
        return 0;
    }
}
