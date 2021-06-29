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
import fr.uga.pddl4j.parser.lexer.TokenMgrError;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implements the <code>PDDLParser</code> of the PDD4L library.
 *
 * <p>
 * A simple example of how to use the parser:
 * </p>
 * <pre>
 * public static void main(String[] args) {
 *
 *  if (args.length == 2 &amp;&amp; args[0].equals(&quot;-p&quot;)) {
 *      PDDLParser parser = new PDDLParser();
 *      try {
 *          parser.parse(args[1]);
 *        } catch (FileNotFoundException e) {
 *          System.out.println(e.getMessage());
 *        }
 *      if (!parser.getErrorManager().isEmpty()) {
 *          parser.getErrorManager().printAll();
 *      }
 *  } else if (args.length == 4 &amp;&amp; args[0].equals(&quot;-o&quot;) &amp;&amp; args[2].equals(&quot;-f&quot;)) {
 *    PDDLParser parser = new PDDLParser();
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
public final class PDDLParser {

    /**
     * Logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(PDDLParser.class);

    /**
     * The specific symbol object.
     */
    public static final PDDLSymbol OBJECT = new PDDLSymbol(PDDLSymbol.Kind.TYPE, "object");

    /**
     * The specific symbol number.
     */
    public static final PDDLSymbol NUMBER = new PDDLSymbol(PDDLSymbol.Kind.TYPE, "number");

    /**
     * The specific symbol total-costs.
     */
    public static final PDDLSymbol TOTAL_COST = new PDDLSymbol(PDDLSymbol.Kind.FUNCTOR, "total-cost");

    /**
     * The specific symbol total-costs.
     */
    public static final PDDLSymbol TOTAL_TIME = new PDDLSymbol(PDDLSymbol.Kind.FUNCTOR, "total-time");

    /**
     * Message for unhandled error.
     */
    private static final String UNEXP_ERROR_MESSAGE = "\nunexpected error";

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
    private PDDLDomain domain;

    /**
     * The planning problem parsed.
     */
    private PDDLProblem problem;

    /**
     * Create a new <code>PDDLParser</code>.
     */
    public PDDLParser() {
        super();
        this.mgr = new ErrorManager();
    }

    /**
     * Parses a planning domain from a specific file path.
     *
     * @param domain the path to the domain file.
     * @return a the pddl domain parsed or null if a lexical error or parser error occurred.
     * @throws FileNotFoundException if the specified domain does not exist.
     */
    public PDDLDomain parseDomain(String domain) throws FileNotFoundException {
        return this.parseDomain(new File(domain));
    }

    /**
     * Parses a planning domain from a specific file.
     *
     * @param domain the file that contains the planning domain.
     * @return a the pddl domain parsed or null if a lexical error or parser error occurred.
     * @throws FileNotFoundException if the specified domain file does not exist.
     */
    public PDDLDomain parseDomain(File domain) throws FileNotFoundException {
        if (!domain.exists()) {
            throw new FileNotFoundException("File  \"" + domain.getName() + "\" does not exist.");
        }
        try {
            // Parse and check the domain
            FileInputStream inputStream = new FileInputStream(domain);
            if (this.lexer == null) {
                this.lexer = new Lexer(inputStream);
            } else {
                this.lexer.ReInit(inputStream);
            }
            lexer.setErrorManager(this.mgr);
            lexer.setFile(domain);
            this.domain = this.lexer.domain();
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
        } catch (Throwable t) {
            LOGGER.error(UNEXP_ERROR_MESSAGE, t.getMessage());
            return null;
        }
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
    public PDDLProblem parseProblem(String problem) throws FileNotFoundException {
        return this.parseProblem(new File(problem));
    }

    /**
     * Parses a planning problem from a specific file.
     *
     * @param problem the file that contains the planning problem.
     * @return a the pddl problem parsed or null if a lexical error or parser error occurred.
     * @throws FileNotFoundException if the specified problem file does not exist.
     */
    public PDDLProblem parseProblem(File problem) throws FileNotFoundException {
        if (!problem.exists()) {
            throw new FileNotFoundException("File  \"" + problem.getName() + "\" does not exist.");
        }
        try {
            // Parse and check the problem
            FileInputStream inputStream = new FileInputStream(problem);
            if (this.lexer == null) {
                this.lexer = new Lexer(inputStream);
            } else {
                this.lexer.ReInit(inputStream);
            }
            this.lexer.setFile(problem);
            this.problem = this.lexer.problem();
            this.checkDomainName();
            this.checkRequirements();
            this.checkObjectsDeclaration();
            this.checkInitialTaskNetwork();
            this.checkInitialFacts();
            this.checkGoal();
            this.checkProblemConstraints();
            this.checkMetric();
        } catch (Throwable t) {
            LOGGER.error(UNEXP_ERROR_MESSAGE, t.getMessage());
        }
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
    public ParsedProblem parseDomainAndProblem(String domainAndProblem) throws FileNotFoundException {
        return this.parseDomainAndProblem(new File(domainAndProblem));
    }

    /**
     * Parses a planning domain and a planning problem from the specified file.
     *
     * @param domainAndProblem the file that contains the planning domain and problem.
     * @return the problem parsed.
     * @throws FileNotFoundException if the specified file does not exist.
     */
    public ParsedProblem parseDomainAndProblem(File domainAndProblem) throws FileNotFoundException {
        if (!domainAndProblem.exists()) {
            throw new FileNotFoundException("File  \"" + domainAndProblem.getName() + "\" does not exist.");
        }
        try {
            this.lexer = new Lexer(new FileInputStream(domainAndProblem));
            lexer.setErrorManager(this.mgr);
            lexer.setFile(domainAndProblem);
            this.lexer.domain_and_problem();
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
            this.checkInitialFacts();
            this.checkGoal();
            this.checkProblemConstraints();
            this.checkMetric();
        } catch (TokenMgrError | ParseException | RuntimeException exception) {
            exception.printStackTrace();
            LOGGER.error(UNEXP_ERROR_MESSAGE, exception);
        }
        return new ParsedProblem(this.getDomain(), this.getProblem());
    }

    /**
     * Parses a planning domain and a planning problem from their respective string description.
     *
     * @param domainString  the string that contains the planning domains.
     * @param problemString the string that contains the planning problem.
     */
    public void parseFromString(String domainString, String problemString) {
        try {
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
        } catch (RuntimeException | IOException exception) {
            LOGGER.error(UNEXP_ERROR_MESSAGE, exception);
        }
    }

    /**
     * Parses a planning domain and a planning problem from their respective string description.
     *
     * @param domainAndProblemString the string that contains the domain and planning problem.
     */
    public void parseFromString(String domainAndProblemString) {
        try {
            // Create temp files for domain and problem
            File domainAndProblemTempFile = File.createTempFile("domainAndProblemString", ".pddl");

            // Fill files with string content
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(domainAndProblemTempFile), "UTF-8"))) {
                writer.write(domainAndProblemString);
            }

            // Parse and check the domain and problem
            parse(domainAndProblemTempFile);
        } catch (RuntimeException | IOException exception) {
            LOGGER.error(UNEXP_ERROR_MESSAGE, exception);
        }
    }

    /**
     * Parses a planning domain and a planning problem from an input stream.
     *
     * @param inputDomainAndProblem the stream that contains the domain and planning problem.
     */
    public void parseFromStream(InputStream inputDomainAndProblem) {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputDomainAndProblem, "UTF-8"))) {
            parseFromString(buffer.lines().collect(Collectors.joining("\n")));
        } catch (RuntimeException | IOException exception) {
            LOGGER.error(UNEXP_ERROR_MESSAGE, exception);
            LOGGER.error(UNEXP_ERROR_MESSAGE, exception);
        }
    }

    /**
     * Parses a planning domain and a planning problem from two input streams.
     *
     * @param inputDomain  the stream that contains the domain.
     * @param inputProblem the stream that contains the planning problem.

     */
    public void parseFromStream(InputStream inputDomain, InputStream inputProblem) {
        try {
            BufferedReader bufferDomain = new BufferedReader(new InputStreamReader(inputDomain, "UTF-8"));
            BufferedReader bufferProblem = new BufferedReader(new InputStreamReader(inputProblem, "UTF-8"));
            parseFromString(bufferDomain.lines().collect(Collectors.joining("\n")),
                bufferProblem.lines().collect(Collectors.joining("\n")));
        } catch (RuntimeException | IOException exception) {
            LOGGER.error(UNEXP_ERROR_MESSAGE, exception);
        }
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
    public ParsedProblem parse(String domain, String problem) throws FileNotFoundException {
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
    public ParsedProblem parse(File domain, File problem) throws FileNotFoundException {
        if (!domain.exists()) {
            throw new FileNotFoundException("File  \"" + domain.getName() + "\" does not exist.");
        }
        if (!problem.exists()) {
            throw new FileNotFoundException("File  \"" + problem.getName() + "\" does not exist.");
        }
        try {
            // Parse and check the domain
            PDDLDomain pddlDomain = this.parseDomain(domain);
            // Parse and check the problem
            PDDLProblem pddlProblem = this.parseProblem(problem);
            return (pddlDomain != null && pddlProblem != null) ? new ParsedProblem(pddlDomain, pddlProblem) : null;
        } catch (Throwable t) {
            LOGGER.error(UNEXP_ERROR_MESSAGE, t);
        }
        return null;
    }

    /**
     * Returns the domain parsed.
     *
     * @return the domain parsed.
     */
    private final PDDLDomain getDomain() {
        return this.domain;
    }

    /**
     * Returns the problem parsed.
     *
     * @return the problem parsed.
     */
    private final PDDLProblem getProblem() {
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
        return (this.getDomain().getRequirements().contains(PDDLRequireKey.METHOD_PRECONDITIONS)
            && !this.getDomain().getRequirements().contains(PDDLRequireKey.HIERARCHY));
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
    private boolean checkGroundedParserNode(PDDLExpression exp) {
        boolean checked = true;
        if (exp == null) {
            return true;
        }
        LinkedList<PDDLExpression> stackGD = new LinkedList<>();
        LinkedList<List<PDDLTypedSymbol>> stackCtx = new LinkedList<>();
        stackGD.add(exp);
        stackCtx.add(new LinkedList<>());
        while (!stackGD.isEmpty()) {
            PDDLExpression gd = stackGD.poll();
            List<PDDLTypedSymbol> ctx = stackCtx.poll();
            List<PDDLTypedSymbol> newCtx = new LinkedList<>(ctx);
            switch (gd.getConnective()) {
                case ATOM:
                case FN_HEAD:
                case EQUAL_ATOM:
                    boolean error = false;
                    final List<PDDLSymbol> atom = gd.getAtom();
                    final PDDLNamedTypedList atomSkeleton = new PDDLNamedTypedList(atom.get(0));
                    for (int i = 1; i < atom.size(); i++) {
                        PDDLSymbol symbol = atom.get(i);
                        Iterator<PDDLTypedSymbol> j = ctx.iterator();
                        PDDLTypedSymbol qvar = null;
                        while (j.hasNext() && qvar == null) {
                            PDDLTypedSymbol vj = j.next();
                            if (vj.equals(symbol)) {
                                qvar = vj;
                            }
                        }
                        if (symbol.getKind().equals(PDDLSymbol.Kind.VARIABLE) && qvar == null) {
                            this.mgr.logParserError("variable \"" + symbol + "\" is undefined",
                                this.lexer.getFile(), symbol.getBeginLine(), symbol
                                    .getBeginColumn());
                            error = true;
                        } else {
                            PDDLTypedSymbol object = null;
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
                                    this.lexer.getFile(), symbol.getBeginLine(), symbol
                                        .getBeginColumn());
                                error = true;
                            } else {
                                for (PDDLSymbol type : object.getTypes()) {
                                    if (!this.domain.isDeclaredType(type)) {
                                        this.mgr.logParserError("type \"" + type.getImage()
                                            + "\" of the object \"" + object.getImage()
                                            + "\" is undefined", this.lexer.getFile(), type
                                            .getBeginLine(), type.getBeginColumn());
                                        error = true;
                                    }
                                }
                                atomSkeleton.add(object);
                            }
                        }
                        checked = !error;
                    }
                    if (checked && gd.getConnective().equals(PDDLConnective.ATOM)
                        && !this.isDeclaredPredicate(atomSkeleton)) {
                        this.mgr.logParserError("predicate \"" + atomSkeleton.getName() + "/"
                            + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                            .getFile(), atomSkeleton.getName().getBeginLine(), atomSkeleton
                            .getName().getBeginColumn());
                        checked = false;
                    } else if (checked && gd.getConnective().equals(PDDLConnective.FN_HEAD)
                        && !this.isDeclaredFunction(atomSkeleton)) {
                        this.mgr.logParserError("function \"" + atomSkeleton.getName() + "/"
                            + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                            .getFile(), atomSkeleton.getName().getBeginLine(), atomSkeleton
                            .getName().getBeginColumn());
                        checked = false;
                    }
                    break;
                case EXISTS:
                case FORALL:
                    for (PDDLTypedSymbol variable : gd.getVariables()) {
                        error = false;
                        for (PDDLSymbol type : variable.getTypes()) {
                            if (!this.domain.isDeclaredType(type)) {
                                this.mgr.logParserError("type \"" + type.getImage()
                                    + "\" used in quantified expression is undefined", this.lexer
                                    .getFile(), type.getBeginLine(), type.getBeginColumn());
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
    private boolean checkInitialFacts() {
        boolean checked = true;
        LinkedList<PDDLExpression> stackGD = new LinkedList<>();
        stackGD.addAll(this.problem.getInit());
        while (!stackGD.isEmpty()) {
            PDDLExpression gd = stackGD.poll();
            switch (gd.getConnective()) {
                case ATOM:
                case FN_ATOM:
                    boolean error = false;
                    List<PDDLSymbol> atom = gd.getAtom();
                    if (atom == null) {
                        atom = gd.getChildren().get(0).getAtom();
                    }
                    final PDDLNamedTypedList atomSkeleton = new PDDLNamedTypedList(atom.get(0));
                    for (int i = 1; i < atom.size(); i++) {
                        PDDLSymbol symbol = atom.get(i);
                        PDDLTypedSymbol object = this.problem.getObject(symbol);
                        if (object == null) {
                            object = this.domain.getConstant(symbol);
                        }
                        if (object == null) {
                            this.mgr.logParserError("object \"" + atom.get(i) + "\" is undefined",
                                this.lexer.getFile(), symbol.getBeginLine(), symbol
                                    .getBeginColumn());
                            error = true;
                        } else {
                            for (PDDLSymbol type : object.getTypes()) {
                                if (!this.domain.isDeclaredType(type)) {
                                    this.mgr.logParserError("type \"" + type.getImage()
                                        + "\" of the object \"" + object.getImage()
                                        + "\" is undefined", this.lexer.getFile(), type
                                        .getBeginLine(), type.getBeginColumn());
                                    error = true;
                                }
                            }
                            atomSkeleton.add(object);
                        }
                    }
                    checked = !error;
                    if (checked && gd.getConnective().equals(PDDLConnective.ATOM)
                        && !this.isDeclaredPredicate(atomSkeleton)) {
                        this.mgr.logParserError("predicate \"" + atomSkeleton.getName() + "/"
                            + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                            .getFile(), atomSkeleton.getName().getBeginLine(), atomSkeleton
                            .getName().getBeginColumn());
                        checked = false;
                    } else if (checked && gd.getConnective().equals(PDDLConnective.FN_ATOM)
                        && !this.isDeclaredFunction(atomSkeleton)) {
                        this.mgr.logParserError("function \"" + atomSkeleton.getName() + "/"
                            + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                            .getFile(), atomSkeleton.getName().getBeginLine(), atomSkeleton
                            .getName().getBeginColumn());
                        checked = false;
                    }
                    break;
                case DURATION_ATOM:
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
     * Check the objects declaration.
     *
     * @return <code>true</code> if the objects are well declared; <code>false</code> otherwise.
     */
    private boolean checkObjectsDeclaration() {
        boolean checked = true;
        List<PDDLTypedSymbol> objects = this.problem.getObjects();
        for (PDDLTypedSymbol object : objects) {
            for (PDDLSymbol type : object.getTypes()) {
                if (!this.domain.isDeclaredType(type)) {
                    this.mgr.logParserError("type \"" + type.getImage() + "\" of the object \""
                        + object.getImage() + "\" is undefined", this.lexer
                        .getFile(), type.getBeginLine(), type.getBeginColumn());
                    checked = false;
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
                + "\" used in problem doest not match.", this.lexer.getFile(), this.problem
                .getDomainName().getBeginLine(), this.problem.getDomainName().getBeginColumn());
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

        List<PDDLTypedSymbol> types = this.domain.getTypes();

        // Gathering types declaration
        final Map<String, PDDLTypedSymbol> map = new HashMap<>();
        map.put(PDDLParser.OBJECT.getImage(), new PDDLTypedSymbol(PDDLParser.OBJECT));

        for (PDDLTypedSymbol type : types) {
            // Special cas for the type object
            if ((type.equals(PDDLParser.OBJECT) || type.equals(PDDLParser.NUMBER)) && !type.getTypes().isEmpty()) {
                this.mgr.logParserError("type \"" + type.getImage() + "\" cannot be used as derived type",
                    this.lexer.getFile(), type.getBeginLine(), type.getBeginColumn());
            } else { // General case
                // check if all super types are defined otherwise create a new type inherited from object
                type.getTypes().stream().filter(superType -> !types.contains(superType)).forEach(superType -> {
                    PDDLTypedSymbol st = new PDDLTypedSymbol(superType);
                    map.put(superType.getImage(), st);
                });
                // If the type was already encountered, it means that there is multiple inheritance
                // thus the super types are gathered
                PDDLTypedSymbol t = map.get(type.getImage());
                if (t == null) {
                    map.put(type.getImage(), type);
                } else {
                    Set<PDDLSymbol> set = new HashSet<>();
                    set.addAll(t.getTypes());
                    set.addAll(type.getTypes());
                    t.getTypes().clear();
                    t.getTypes().addAll(set);
                }
            }
        }


        // Check the consistency of the types declaration, i.e., if there is no loop in the types declaration
        boolean consistent = true;
        Iterator<PDDLTypedSymbol> iterator = map.values().iterator();
        while (iterator.hasNext() && consistent) {
            final PDDLTypedSymbol type = iterator.next();
            final LinkedList<PDDLTypedSymbol> open = new LinkedList<>();
            open.add(type);
            while (!open.isEmpty() && consistent) {
                final PDDLTypedSymbol current = open.poll();
                for (PDDLSymbol st : current.getTypes()) {
                    final PDDLTypedSymbol c = map.get(st.getImage());
                    consistent = !c.equals(type);
                    open.add(c);
                }
            }
            if (!consistent) {
                this.mgr.logParserError("Inconsistent types declaration for type \"" + type.getImage()
                    + "\"", this.lexer.getFile(), type.getBeginLine(), type.getBeginColumn());
            }
        }

        // Add a copy of the types to the planning domain.
        this.domain.getTypes().clear();
        for (PDDLTypedSymbol type : map.values()) {
            this.domain.getTypes().add(new PDDLTypedSymbol(type));
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
        List<PDDLTypedSymbol> constants = this.domain.getConstants();
        Set<PDDLSymbol> set = new HashSet<>();
        boolean checked = true;
        for (PDDLTypedSymbol constant : constants) {
            if (!set.add(constant)) {
                this.mgr.logParserError("constant \"" + constant.getImage()
                        + "\" already defined", this.lexer.getFile(), constant.getBeginLine(),
                    constant.getBeginColumn());
                checked = false;
            }
            for (PDDLSymbol type : constant.getTypes()) {
                if (!this.domain.isDeclaredType(type)) {
                    this.mgr.logParserError("type \"" + type.getImage() + "\" of the constant \""
                        + constant.getImage() + "\" is undefined", this.lexer
                        .getFile(), constant.getBeginLine(), constant
                        .getBeginColumn());
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
        List<PDDLNamedTypedList> predicates = this.domain.getPredicates();
        Set<String> set = new HashSet<>();
        boolean checked = true;
        for (PDDLNamedTypedList predicate : predicates) {
            for (PDDLTypedSymbol variable : predicate.getArguments()) {
                for (PDDLSymbol type : variable.getTypes()) {
                    if (!this.domain.isDeclaredType(type)) {
                        this.mgr.logParserError("type \"" + type.getImage()
                            + "\" of the variable \"" + variable.getImage()
                            + "\" is undefined in predicate declaration \"" + predicate.getName() + "\"",
                            this.lexer.getFile(), variable.getBeginLine(), variable.getBeginColumn());
                        checked = false;
                    }
                }
            }
            PDDLSymbol predicateSymbol = predicate.getName();
            String str = predicateSymbol.getImage() + "/" + predicate.getArguments().size();

            if (!set.add(str)) {
                this.mgr.logParserError("predicate \"" + str + "\" declared twice", this.lexer
                    .getFile(), predicateSymbol.getBeginLine(), predicateSymbol
                    .getBeginColumn());
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
        List<PDDLNamedTypedList> tasks = this.domain.getTasks();
        Set<String> taskSet = new HashSet<>();

        boolean checked = true;
        for (PDDLNamedTypedList task : tasks) {
            for (PDDLTypedSymbol variable : task.getArguments()) {
                for (PDDLSymbol type : variable.getTypes()) {
                    if (!this.domain.isDeclaredType(type)) {
                        this.mgr.logParserError("type \"" + type.getImage()
                            + "\" of the variable \"" + variable.getImage()
                            + "\" is undefined in task declaration \"" + task.getName() + "\"", this.lexer.getFile(),
                            variable.getBeginLine(), variable.getBeginColumn());
                        checked = false;
                    }
                }
            }
            PDDLSymbol symbol = task.getName();
            String taskSymbol = symbol.getImage() + "/" + task.getArguments().size();

            if (!taskSet.add(taskSymbol)) {
                this.mgr.logParserError("task \"" + taskSymbol + "\" declared twice", this.lexer
                    .getFile(), symbol.getBeginLine(), symbol
                    .getBeginColumn());
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
        for (PDDLNamedTypedList predicate : this.domain.getPredicates()) {
            PDDLSymbol predicateSymbol = predicate.getName();
            String str = predicateSymbol.getImage() + "/" + predicate.getArguments().size();
            predicates.add(str);
        }

        List<PDDLNamedTypedList> functions = this.domain.getFunctions();
        Set<String> set = new HashSet<>();
        boolean checked = true;
        for (PDDLNamedTypedList function : functions) {
            PDDLSymbol functionSymbol = function.getName();
            for (PDDLTypedSymbol variable : function.getArguments()) {
                for (PDDLSymbol type : variable.getTypes()) {
                    if (!this.domain.isDeclaredType(type)) {
                        this.mgr.logParserError("type \"" + type.getImage()
                            + "\" of the variable \"" + variable.getImage()
                            + "\" is undefined", this.lexer.getFile(), variable
                            .getBeginLine(), variable.getBeginColumn());
                        checked = false;
                    }
                }
            }

            String str = functionSymbol.getImage() + "/" + function.getArguments().size();
            if (!set.add(str)) {
                this.mgr.logParserError("predicate \"" + str + "\" declared twice", this.lexer
                    .getFile(), functionSymbol.getBeginLine(), functionSymbol
                    .getBeginColumn());
                checked = false;
            }
            if (predicates.contains(str)) {
                this.mgr.logParserError("function \"" + str
                        + "\" is ambiguous with a predicate already declared",
                    this.lexer.getFile(), functionSymbol.getBeginLine(), functionSymbol
                        .getBeginColumn());
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
        for (PDDLDerivedPredicate axiom : this.domain.getDerivesPredicates()) {
            PDDLNamedTypedList head = axiom.getHead();
            for (PDDLTypedSymbol argument : head.getArguments()) {
                for (PDDLSymbol type : argument.getTypes()) {
                    if (!this.domain.isDeclaredType(type)) {
                        this.mgr.logParserError("type \"" + type.getImage()
                            + "\" used in derived predicate", this.lexer.getFile(), type
                            .getBeginLine(), type.getBeginColumn());
                        checked = false;
                    }
                }
            }
            if (checked && !this.isDeclaredPredicate(head)) {
                this.mgr.logParserError("predicate \"" + head.getName() + "/"
                        + head.getArguments().size() + "\" is undefined", this.lexer.getFile(),
                    head.getName().getBeginLine(), head.getName().getBeginColumn());
                checked = false;
            }
            if (checked) {
                checked = this.checkParserNode(axiom.getBody(), head.getArguments());
            }
        }
        return checked;
    }

    /**
     * Checks if the declared actions are well formed.
     * <ul>
     * <li> actions must have a unique name.</li>
     * <li> The type of the variables or constants used in their precondition, condition and effects
     * are type previously declared.</li>
     * <li> The variable used in their precondition, condition and effects are declared as
     * parameters of the actions.</li>
     * </ul>
     *
     * @return <code>true</code> if the function declaration are well formed; <code>false</code> otherwise.
     */
    private boolean checkActionDeclaration() {
        boolean checked = this.checkActionsUniqueness();
        for (PDDLAction action : this.domain.getActions()) {
            if (this.checkActionParameters(action)) {
                checked &= this.checkParserNode(action.getPreconditions(), action.getParameters());
                checked &= this.checkParserNode(action.getEffects(), action.getParameters());
                if (action.getDuration() != null) {
                    checked &= this.checkParserNode(action.getDuration(), action.getParameters());
                }
            }
        }
        return checked;
    }

    /**
     * Checks if the declared methods are well formed.
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
            action -> action.getName().getImage()).collect(Collectors.toSet());
        boolean checked = this.checkMethodsUniqueness();
        for (PDDLMethod meth : this.domain.getMethods()) {
            if (this.checkMethodParameters(meth)) {
                checked &= this.checkParserNode(meth.getPreconditions(), meth.getParameters());
                checked &= this.checkParserNode(meth.getTask(), meth.getParameters());
                PDDLSymbol taskSymbol = meth.getTask().getAtom().get(0);
                if (actionSet.contains(taskSymbol.getImage())) {
                    this.mgr.logParserError("task symbol \"" + taskSymbol.getImage() + "\" already used as action name",
                        this.lexer.getFile(), taskSymbol.getBeginLine(), taskSymbol.getBeginColumn());
                    checked &= false;
                }
                checked &= this.checkParserNode(meth.getSubTasks(), meth.getParameters());
                checked &= this.checkParserNode(meth.getLogicalConstraints(), meth.getParameters());
            }
            if (this.checkTaskIDsUniqueness(meth)) {
                final Set<PDDLSymbol> taskIds = this.getTaskIDs(meth.getSubTasks());
                final Set<PDDLSymbol> consIds = this.getTaskIDs(meth.getOrderingConstraints());
                for (PDDLSymbol id : consIds) {
                    if (!taskIds.contains(id)) {
                        this.mgr.logParserError("task alias \"" + id + "\" in method "
                            + "\"" + meth.getName() + "\" is undefined", this.lexer
                            .getFile(), id.getBeginLine(), id.getBeginColumn());
                        checked = false;
                    }
                }
                checked = this.checkOrderingConstraintAcyclicness(meth.getOrderingConstraints());
            } else {
                checked = false;
            }
        }
        return checked;
    }

    /**
     * Checks that the orderings constraints are acyclic.
     *
     * @param constraints the ordering constraints expression. We make the assumption that the constraints are described
     *                    by an AND PDDLExpression.
     *
     * @return true if a set of ordering constraints are acyclic, false otherwise.
     */
    private boolean checkOrderingConstraintAcyclicness(final PDDLExpression constraints) {
        Map<PDDLSymbol, Set<PDDLSymbol>> ordering = new LinkedHashMap<PDDLSymbol, Set<PDDLSymbol>>();
        for (PDDLExpression constraint : constraints.getChildren()) {
            PDDLSymbol keyTask = constraint.getAtom().get(0);
            Set<PDDLSymbol> tasks = ordering.get(keyTask);
            if (tasks == null) {
                tasks = new HashSet<PDDLSymbol>();
                ordering.put(keyTask, tasks);
            }
            tasks.add(constraint.getAtom().get(1));
        }
        Boolean closure = false;
        while (!closure) {
            closure = true;
            for (Map.Entry<PDDLSymbol, Set<PDDLSymbol>> entry : ordering.entrySet()) {
                Set<PDDLSymbol> acc = new HashSet<PDDLSymbol>();
                for (PDDLSymbol task : entry.getValue()) {
                    Set<PDDLSymbol> sacc = ordering.get(task);
                    if (sacc != null) {
                        acc.addAll(sacc);
                    }
                }
                closure &= !entry.getValue().addAll(acc);
            }
        }
        boolean check = true;
        Iterator<Map.Entry<PDDLSymbol, Set<PDDLSymbol>>> i = ordering.entrySet().iterator();
        while (i.hasNext() && check) {
            Map.Entry<PDDLSymbol, Set<PDDLSymbol>> entry = i.next();
            PDDLSymbol task = entry.getKey();
            if (entry.getValue().contains(task)) {
                this.mgr.logParserError("cyclical constraint involving the task \"" + task.getImage()
                    + "\" in method declaration", this.lexer.getFile(), task.getBeginLine(), task.getBeginColumn());
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
            final PDDLTaskNetwork tn = this.problem.getInitialTaskNetwork();
            checked = this.checkParserNode(tn.getTasks(), tn.getParameters());
            if (this.checkTaskIDsUniquenessFromInitialTaskNetwork(tn.getTasks(), new HashSet<PDDLSymbol>())) {
                final Set<PDDLSymbol> taskIds = this.getTaskIDs(tn.getTasks());
                final Set<PDDLSymbol> consIds = this.getTaskIDs(tn.getOrderingConstraints());
                for (PDDLSymbol id : consIds) {
                    if (!taskIds.contains(id)) {
                        this.mgr.logParserError("task alias \"" + id + "\" initial task network"
                            + " is undefined", this.lexer.getFile(), id.getBeginLine(), id.getBeginColumn());
                        checked = false;
                    }
                }
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
    private boolean checkTaskIDsUniquenessFromInitialTaskNetwork(PDDLExpression exp, Set<PDDLSymbol> taskIDs) {
        boolean unique = true;
        if (exp.getConnective().equals(PDDLConnective.TASK) && exp.getTaskID() != null) {
            if (!taskIDs.add(exp.getTaskID())) {
                this.mgr.logParserError("task alias \"" + exp.getTaskID() + "\" in initial task network "
                    + "is already defined", this.lexer
                    .getFile(), exp.getTaskID().getBeginLine(), exp.getTaskID().getBeginColumn());
                unique = false;
            }
        } else {
            for (PDDLExpression c : exp.getChildren()) {
                this.checkTaskIDsUniquenessFromInitialTaskNetwork(c, taskIDs);
            }
        }
        return unique;
    }

    /**
     * Returns the set of task IDs contains in an expression.
     *
     * @param exp the expression.
     * @return the set of task IDs contains in exp.
     */
    private Set<PDDLSymbol> getTaskIDs(PDDLExpression exp) {
        Set<PDDLSymbol> taskIDs  = new HashSet<PDDLSymbol>();
        switch (exp.getConnective()) {
            case TASK:
                taskIDs.add(exp.getTaskID());
                break;
            case LESS_ORDERING_CONSTRAINT:
                taskIDs.add(exp.getAtom().get(0));
                taskIDs.add(exp.getAtom().get(1));
                break;
            default:
                for (PDDLExpression c : exp.getChildren()) {
                    taskIDs.addAll(this.getTaskIDs(c));
                }
        }
        return taskIDs;
    }

    /**
     * Checks if the tasks ID used in the tasks declaration of the method in parameter are unique.
     *
     * @param meth the methode to be tested.
     * @return true if the all the task ids used in a method declaration are unique; false otherwise.
     */
    private boolean checkTaskIDsUniqueness(PDDLMethod meth) {
        return this.checkTaskIDsUniqueness(meth, meth.getSubTasks(), new HashSet<PDDLSymbol>());
    }

    /**
     * Checks if the tasks ID used in an expression are unique.
     *
     * @param meth the method to be tested.
     * @param exp the expression.
     * @return true if the all the task ids used in the expression are unique; false otherwise.
     */
    private boolean checkTaskIDsUniqueness(PDDLMethod meth, PDDLExpression exp, Set<PDDLSymbol> taskIds) {
        boolean unique = true;
        if (exp.getConnective().equals(PDDLConnective.TASK) && exp.getTaskID() != null) {
            if (!taskIds.add(exp.getTaskID())) {
                this.mgr.logParserError("task alias \"" + exp.getTaskID() + "\" in method "
                    + "\"" + meth.getName() + "\" is already defined", this.lexer
                    .getFile(), exp.getTaskID().getBeginLine(), exp.getTaskID().getBeginColumn());
                unique = false;
            }
        } else {
            for (PDDLExpression c : exp.getChildren()) {
                this.checkTaskIDsUniqueness(meth, c, taskIds);
            }
        }
        return unique;
    }

    /**
     * Checks if a PDDL expression such as the preconditions, the effects and the duration of an
     * action is well formed. More precisely, check if all variables are well typed and are valid
     * parameters of the action or quantified variable and finally, if all atoms match a predicate
     * previously declared.
     *
     * @param exp     The PDDL expression.
     * @param context The symbolEncoding.
     * @return <code>true</code> if the expression is well formed; <code>false</code> otherwise.
     */
    private boolean checkParserNode(PDDLExpression exp, List<PDDLTypedSymbol> context) {
        boolean checked = true;
        LinkedList<PDDLExpression> stackGD = new LinkedList<>();
        LinkedList<List<PDDLTypedSymbol>> stackCtx = new LinkedList<>();
        stackGD.add(exp);
        stackCtx.add(context);
        Set<PDDLExpression> atoms = new HashSet<>();
        while (!stackGD.isEmpty()) {
            PDDLExpression gd = stackGD.poll();
            List<PDDLTypedSymbol> ctx = stackCtx.poll();
            List<PDDLTypedSymbol> newCtx = new LinkedList<>(ctx);
            switch (gd.getConnective()) {
                case ATOM:
                case FN_HEAD:
                case TASK:
                    checked = this.checkAtom(gd, newCtx);
                    break;
                case EXISTS:
                case FORALL:
                    for (PDDLTypedSymbol variable : gd.getVariables()) {
                        boolean error = false;
                        for (PDDLSymbol type : variable.getTypes()) {
                            if (!this.domain.isDeclaredType(type)) {
                                this.mgr.logParserError("type \"" + type.getImage()
                                    + "\" used in quantified expression is undefined", this.lexer
                                    .getFile(), type.getBeginLine(), type.getBeginColumn());
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
                    for (PDDLSymbol term : gd.getAtom()) {
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
        this.checkPDDLExpressionConsistency(exp);
        return checked;
    }

    /**
     * Checks if a PDDL expression is consistent or not, i.e., contains the atomic formula and it negatation.
     * This method only produces warnings.
     *
     * @param exp  The PDDL expression.
     * @return <code>true</code> if the expression is consistent; <code>false</code> otherwise.
     */
    private boolean checkPDDLExpressionConsistency(final PDDLExpression exp) {
        exp.moveNegationInward();
        return this.checkPDDLExpressionConsistency(exp, new HashSet<>(), new HashSet<>());
    }

    /**
     * Checks if a PDDL expression is consistent or not, i.e., contains the atomic formula and it negatation.
     *
     * @param exp     The PDDL expression.
     * @param positive the set of positive atoms previously encoutered.
     * @param negative the set of negative atoms previously encoutered.
     * @return <code>true</code> if the expression is consistent; <code>false</code> otherwise.
     */
    private boolean checkPDDLExpressionConsistency(final PDDLExpression exp, Set<PDDLExpression> positive,
                                                   Set<PDDLExpression> negative) {
        boolean checked = true;
        switch (exp.getConnective()) {
            case ATOM:
                PDDLSymbol predicate = exp.getAtom().get(0);
                if (!positive.add(exp)) {
                    this.mgr.logParserWarning("atomic formula " + exp
                        + " is used twice in the same expression",
                        this.lexer.getFile(), predicate.getBeginLine(), predicate.getBeginColumn());
                    checked = false;
                }
                if (negative.contains(exp)) {
                    this.mgr.logParserWarning("atomic formula " + exp
                        + " and its negation is used in the same expression",
                        this.lexer.getFile(), predicate.getBeginLine(), predicate.getBeginColumn());
                    checked = false;
                }
                break;
            case NOT:
                if (exp.getChildren().get(0).getConnective().equals(PDDLConnective.ATOM)) {
                    final PDDLExpression notExp = exp.getChildren().get(0);
                    predicate = notExp.getAtom().get(0);
                    if (!negative.add(notExp)) {
                        this.mgr.logParserWarning("atomic formula " + notExp
                                + " is used twice in the same expression",
                                this.lexer.getFile(), predicate.getBeginLine(), predicate.getBeginColumn());
                        checked = false;
                    }
                    if (positive.contains(notExp)) {
                        this.mgr.logParserWarning("atomic formula " + notExp
                                + "  and its negation is used in the same expression",
                                this.lexer.getFile(), predicate.getBeginLine(), predicate.getBeginColumn());
                        checked = false;
                    }
                } else {
                    checked = this.checkPDDLExpressionConsistency(exp.getChildren().get(0), positive, negative);
                }
                break;
            default:
                for (int i = 0; i < exp.getChildren().size(); i++) {
                    checked &= this.checkPDDLExpressionConsistency(exp.getChildren().get(i), positive, negative);
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
    private boolean checkAtom(PDDLExpression gd, List<PDDLTypedSymbol> context) {
        boolean checked = true;
        List<PDDLSymbol> atom = gd.getAtom();
        final PDDLNamedTypedList atomSkeleton = new PDDLNamedTypedList(atom.get(0));
        for (int i = 1; i < atom.size(); i++) {
            final PDDLSymbol s = atom.get(i);
            if (s.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
                PDDLTypedSymbol param = null;
                Iterator<PDDLTypedSymbol> itr = context.iterator();
                while (itr.hasNext() && param == null) {
                    PDDLTypedSymbol pi = itr.next();
                    if (pi.equals(s)) {
                        param = pi;
                    }
                }
                if (param == null) {
                    this.mgr.logParserError("variable \"" + s.getImage() + "\" is undefined",
                        this.lexer.getFile(), s.getBeginLine(), s.getBeginColumn());
                    checked = false;
                } else {
                    final PDDLTypedSymbol arg = new PDDLTypedSymbol(s);
                    param.getTypes().forEach(arg::addType);
                    atomSkeleton.add(arg);
                }
            } else {
                PDDLTypedSymbol constant = this.domain.getConstant(s);
                if (constant == null) {
                    if (this.problem != null) {
                        constant = this.problem.getObject(s);
                    }
                }
                if (constant == null) {
                    this.mgr.logParserError("constant \"" + s.getImage() + "\" is undefined",
                        this.lexer.getFile(), s.getBeginLine(), s.getBeginColumn());
                    checked = false;
                } else {
                    atomSkeleton.add(constant);
                }

            }
        }
        if (checked && gd.getConnective().equals(PDDLConnective.ATOM)
            && !this.isDeclaredPredicate(atomSkeleton)) {
            this.mgr.logParserError("predicate \"" + atomSkeleton.getName() + "/"
                + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                .getFile(), atomSkeleton.getName().getBeginLine(), atomSkeleton
                .getName().getBeginColumn());
            checked = false;
        } else if (checked && gd.getConnective().equals(PDDLConnective.FN_ATOM)
            && !this.isDeclaredFunction(atomSkeleton)) {
            this.mgr.logParserError("function \"" + atomSkeleton.getName() + "/"
                + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                .getFile(), atomSkeleton.getName().getBeginLine(), atomSkeleton
                .getName().getBeginColumn());
            checked = false;
        } else if (checked && gd.getConnective().equals(PDDLConnective.TASK)
            && !this.isDeclaredTask(atomSkeleton)) {
            this.mgr.logParserError("task \"" + atomSkeleton.getName() + "/"
                + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                .getFile(), atomSkeleton.getName().getBeginLine(), atomSkeleton
                .getName().getBeginColumn());
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
    private boolean checkTerm(PDDLSymbol term, List<PDDLTypedSymbol> context) {
        boolean checked = true;
        if (term.getKind().equals(PDDLSymbol.Kind.VARIABLE)) {
            PDDLTypedSymbol param = null;
            Iterator<PDDLTypedSymbol> itr = context.iterator();
            while (itr.hasNext() && param == null) {
                PDDLTypedSymbol pi = itr.next();
                if (pi.equals(term)) {
                    param = pi;
                }
            }
            if (param == null) {
                this.mgr.logParserError("variable \"" + term.getImage() + "\" is undefined",
                    this.lexer.getFile(), term.getBeginLine(), term.getBeginColumn());
                checked = false;
            }
        } else {
            PDDLTypedSymbol constant = this.domain.getConstant(term);
            if (constant == null) {
                if (this.problem != null) {
                    constant = this.problem.getObject(term);
                }
            }
            if (constant == null) {
                this.mgr.logParserError("constant \"" + term.getImage() + "\" is undefined",
                    this.lexer.getFile(), term.getBeginLine(), term.getBeginColumn());
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
    private boolean isDeclaredTask(PDDLNamedTypedList task) {
        boolean checked = false;
        int i = 0;
        while (i < this.domain.getTasks().size() && !checked) {
            PDDLNamedTypedList t = this.domain.getTasks().get(i);
            if (task.getName().equals(t.getName())
                && task.getArguments().size() == t.getArguments().size()) {
                int j = 0;
                checked = true;
                while (j < task.getArguments().size() && checked) {
                    PDDLTypedSymbol arg1 = task.getArguments().get(j);
                    PDDLTypedSymbol arg2 = t.getArguments().get(j);
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
    private boolean isDeclaredPredicate(PDDLNamedTypedList predicate) {
        boolean checked = false;
        int i = 0;
        while (i < this.domain.getPredicates().size() && !checked) {
            PDDLNamedTypedList p = this.domain.getPredicates().get(i);
            if (predicate.getName().equals(p.getName())
                && predicate.getArguments().size() == p.getArguments().size()) {
                int j = 0;
                checked = true;
                while (j < predicate.getArguments().size() && checked) {
                    PDDLTypedSymbol arg1 = predicate.getArguments().get(j);
                    PDDLTypedSymbol arg2 = p.getArguments().get(j);
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
    private boolean isDeclaredFunction(PDDLNamedTypedList function) {
        boolean checked = false;
        int i = 0;
        while (i < this.domain.getFunctions().size() && !checked) {
            PDDLNamedTypedList p = this.domain.getFunctions().get(i);
            if (function.getName().equals(p.getName())
                && function.getArguments().size() == p.getArguments().size()) {
                int j = 0;
                checked = true;
                while (j < function.getArguments().size() && checked) {
                    PDDLTypedSymbol arg1 = function.getArguments().get(j);
                    PDDLTypedSymbol arg2 = p.getArguments().get(j);
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
    private boolean matchTypes(PDDLTypedSymbol s1, PDDLTypedSymbol s2) {
        List<PDDLSymbol> copy = new LinkedList<>(s1.getTypes());
        copy.retainAll(s2.getTypes());
        boolean isSubType = !copy.isEmpty();
        Iterator<PDDLSymbol> i = s1.getTypes().iterator();
        while (i.hasNext() && !isSubType) {
            PDDLTypedSymbol type = this.domain.getType(i.next());
            LinkedList<PDDLTypedSymbol> stack = new LinkedList<>();
            stack.push(type);
            while (!stack.isEmpty() && !isSubType) {
                PDDLTypedSymbol t = stack.poll();
                copy = new LinkedList<>(t.getTypes());
                copy.retainAll(s2.getTypes());
                isSubType = !copy.isEmpty();
                t.getTypes().stream().filter(s -> !s.equals(PDDLParser.OBJECT)).forEach(s ->
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
    private boolean checkActionParameters(PDDLAction action) {
        boolean checked = true;
        Set<PDDLSymbol> set = new HashSet<>();
        for (PDDLTypedSymbol parameter : action.getParameters()) {
            if (!set.add(parameter)) {
                this.mgr.logParserError("parameter \"" + parameter + "\" is defined twice in the action \""
                    + action.getName() + "\"", this.lexer.getFile(), parameter.getBeginLine(), parameter
                    .getBeginColumn());
                checked = false;
            }
            for (PDDLSymbol type : parameter.getTypes()) {
                if (!this.domain.isDeclaredType(type)) {
                    this.mgr.logParserError("type \"" + type.getImage() + "\" of the parameter \""
                            + parameter + "\" in the action \"" + action.getName() + "\" is undefined",
                        this.lexer.getFile(), parameter.getBeginLine(), parameter.getBeginColumn());
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
    private boolean checkMethodParameters(PDDLMethod method) {
        boolean checked = true;
        Set<PDDLSymbol> set = new HashSet<>();
        for (PDDLTypedSymbol parameter : method.getParameters()) {
            if (!set.add(parameter)) {
                this.mgr.logParserError("parameter \"" + parameter + "\" is defined twice in method \""
                    + method.getName() + "\"", this.lexer.getFile(), parameter.getBeginLine(), parameter
                    .getBeginColumn());
                checked = false;
            }
            for (PDDLSymbol type : parameter.getTypes()) {
                if (!this.domain.isDeclaredType(type)) {
                    this.mgr.logParserError("type \"" + type.getImage() + "\" of the parameter \""
                            + parameter + "\" in method \"" + method.getName() + "\" is undefined",
                        this.lexer.getFile(), parameter.getBeginLine(), parameter.getBeginColumn());
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
        Set<PDDLSymbol> set = new HashSet<>();
        for (PDDLAction op : this.domain.getActions()) {
            if (!set.add(op.getName())) {
                PDDLSymbol name = op.getName();
                this.mgr.logParserError("action \"" + name + "\" declared twice", this.lexer
                    .getFile(), name.getBeginLine(), name.getBeginColumn());
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
        Set<PDDLSymbol> set = new HashSet<>();
        for (PDDLMethod meth : this.domain.getMethods()) {
            if (!set.add(meth.getName())) {
                PDDLSymbol name = meth.getName();
                this.mgr.logParserError("method \"" + name + "\" declared twice", this.lexer
                    .getFile(), name.getBeginLine(), name.getBeginColumn());
                checked = false;
            }
        }
        return checked;
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
     * The main method of the parser example. The command line syntax is as follow:
     * <pre>
     * usage of parser:
     *
     * OPTIONS   DESCRIPTIONS
     *
     * -p   path for operator and fact file
     * -o   operator file name
     * -f   fact file name
     * </pre>
     *
     * @param args the arguments of the command line.
     */
    public static void main(String[] args) {

        final StringBuilder strb = new StringBuilder();

        if (args.length == 2 && "-p".equals(args[0])) {
            strb.append("parse problem ").append("\"").append(args[1]).append("\": ");
            PDDLParser parser = new PDDLParser();
            try {
                parser.parse(args[1]);
            } catch (FileNotFoundException fnfException) {
                LOGGER.error("parsing problem error", fnfException);
            }
            if (parser.mgr.isEmpty()) {
                strb.append("ok");
            } else {
                strb.append(System.lineSeparator());
                parser.mgr.printAll();
            }
        } else if (args.length == 4 && "-o".equals(args[0]) && "-f".equals(args[2])) {
            strb.append("Parsed files ").append("\"").append(args[1]).append("\" and ").append("\"").append(args[3])
                .append("\": ");
            PDDLParser parser = new PDDLParser();
            try {
                parser.parse(args[1], args[3]);
            } catch (FileNotFoundException fnfException) {
                LOGGER.error("domain or problem missing", fnfException);
            }
            if (parser.mgr.isEmpty()) {
                strb.append("ok");
            } else {
                strb.append("not ok");
                parser.mgr.printAll();
            }
        } else {
            strb.append("\nusage of parser:\n").append("OPTIONS   DESCRIPTIONS\n")
                .append("-p <str>    path for operator and fact file\n")
                .append("-o <str>    operator file name\n")
                .append("-f <str>    fact file name\n");
        }

        LOGGER.trace(strb);
    }
}
