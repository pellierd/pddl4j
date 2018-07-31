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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implements the <tt>Parser</tt> of the PDD4L library. The parser accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
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
 *      parser.getErrorManager().printAll();
 *        }
 *    } else if (args.length == 4 &amp;&amp; args[0].equals(&quot;-o&quot;) &amp;&amp; args[2].equals(&quot;-f&quot;)) {
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
 * </pre>
 *
 * @author D Pellier
 * @version 1.0 - 28.01.10
 */
public final class Parser {

    /**
     * Logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(Parser.class);

    /**
     * The specific symbol object.
     */
    public static final Symbol OBJECT = new Symbol(Symbol.Kind.TYPE, "object");

    /**
     * The specific symbol number.
     */
    public static final Symbol NUMBER = new Symbol(Symbol.Kind.TYPE, "number");

    /**
     * The specific symbol total-costs.
     */
    public static final Symbol TOTAL_COST = new Symbol(Symbol.Kind.FUNCTOR, "total-cost");

    /**
     * The specific symbol total-costs.
     */
    public static final Symbol TOTAL_TIME = new Symbol(Symbol.Kind.FUNCTOR, "total-time");

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
    private Domain domain;

    /**
     * The planning problem parsed.
     */
    private Problem problem;

    /**
     * Create a new <tt>Parser</tt>.
     */
    public Parser() {
        super();
        this.mgr = new ErrorManager();
    }

    /**
     * Parses a planning domain from a specific file path.
     *
     * @param domain the path to the domain file.
     * @throws FileNotFoundException if the specified domain does not exist.
     */
    public void parseDomain(String domain) throws FileNotFoundException {
        this.parseDomain(new File(domain));
    }

    /**
     * Parses a planning domain from a specific file.
     *
     * @param domain the file that contains the planning domain.
     * @throws FileNotFoundException if the specified domain file does not exist.
     */
    public void parseDomain(File domain) throws FileNotFoundException {
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
            this.lexer.domain();
            this.domain = this.lexer.getDomain();
            try {
                this.checkTypesDeclaration();
                this.checkConstantsDeclaration();
                this.checkPredicatesDeclaration();
                this.checkFunctionsDeclaration();
                this.checkDomainConstraints();
                this.checkOperatorsDeclaration();
                this.checkDerivedPredicatesDeclaration();
            } catch (NullPointerException exception) {
                LOGGER.error("domain file is not valid\n");
                this.domain = new Domain(new Symbol(Symbol.Kind.DOMAIN, "domain"));
            } finally {
                inputStream.close();
            }
        } catch (IOException | RuntimeException exception) {
            LOGGER.fatal(UNEXP_ERROR_MESSAGE, exception);
        } catch (TokenMgrError | ParseException pe) {
            LOGGER.error("parse error in domain() call\n");
        }
    }

    /**
     * Parses a planning problem from a specific file path.
     *
     * @param problem the path to the planning problem.
     * @throws FileNotFoundException if the specified problem file does not exist.
     */
    public void parseProblem(String problem) throws FileNotFoundException {
        this.parseProblem(new File(problem));
    }

    /**
     * Parses a planning problem from a specific file.
     *
     * @param problem the file that contains the planning problem.
     * @throws FileNotFoundException if the specified problem file does not exist.
     */
    public void parseProblem(File problem) throws FileNotFoundException {
        if (!problem.exists()) {
            throw new FileNotFoundException("File  \"" + problem.getName() + "\" does not exist.");
        }
        try {
            // Parse and check the domain
            FileInputStream inputStream = new FileInputStream(problem);
            if (this.lexer == null) {
                this.lexer = new Lexer(inputStream);
            } else {
                this.lexer.ReInit(inputStream);
            }
            this.lexer.setFile(problem);
            this.lexer.problem();
            this.problem = this.lexer.getProblem();
            try {
                this.checkDomainName();
                this.checkObjectsDeclaration();
                this.checkInitialFacts();
                this.checkGoal();
                this.checkProblemConstraints();
                this.checkMetric();
            } catch (NullPointerException exception) {
                LOGGER.error("problem file is not valid\n");
            } finally {
                inputStream.close();
            }
        } catch (IOException | RuntimeException exception) {
            LOGGER.error(UNEXP_ERROR_MESSAGE, exception);
        } catch (TokenMgrError | ParseException pe) {
            LOGGER.error("parse error in problem() call\n");
        }
    }

    /**
     * Parses a planning domain and a planning problem from the specified file path.
     *
     * @param domainAndProblem the path to the file that contains the planning domain and problem.
     * @throws FileNotFoundException if the specified file does not exist.
     */
    public void parseDomainAndProblem(String domainAndProblem) throws FileNotFoundException {
        this.parseDomainAndProblem(new File(domainAndProblem));
    }

    /**
     * Parses a planning domain and a planning problem from the specified file.
     *
     * @param domainAndProblem the file that contains the planning domain and problem.
     * @throws FileNotFoundException if the specified file does not exist.
     */
    public void parseDomainAndProblem(File domainAndProblem) throws FileNotFoundException {
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
            this.checkTypesDeclaration();
            this.checkConstantsDeclaration();
            this.checkPredicatesDeclaration();
            this.checkFunctionsDeclaration();
            this.checkOperatorsDeclaration();
            this.checkDerivedPredicatesDeclaration();
            this.checkDomainName();
            this.checkObjectsDeclaration();
            this.checkInitialFacts();
            this.checkGoal();
            this.checkProblemConstraints();
            this.checkMetric();
        } catch (TokenMgrError | ParseException | RuntimeException exception) {
            LOGGER.error(UNEXP_ERROR_MESSAGE, exception);
        }
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
     * @throws FileNotFoundException if the specified domain or problem file does not exist.
     */
    public void parse(String domain, String problem) throws FileNotFoundException {
        this.parse(new File(domain), new File(problem));
    }

    /**
     * Parses a planning domain and a planning problem from their respective files.
     *
     * @param domain  the file that contains the planning domains.
     * @param problem the file that contains the planning problem.
     * @throws FileNotFoundException if the specified domain or problem file does not exist.
     */
    public void parse(File domain, File problem) throws FileNotFoundException {
        if (!domain.exists()) {
            throw new FileNotFoundException("File  \"" + domain.getName() + "\" does not exist.");
        }
        if (!problem.exists()) {
            throw new FileNotFoundException("File  \"" + problem.getName() + "\" does not exist.");
        }
        try {
            // Parse and check the domain
            parseDomain(domain);
            // Parse and check the problem
            parseProblem(problem);
        } catch (RuntimeException exception) {
            LOGGER.error(UNEXP_ERROR_MESSAGE, exception);
        }
    }

    /**
     * Returns the domain parsed.
     *
     * @return the domain parsed.
     */
    public final Domain getDomain() {
        return this.domain;
    }

    /**
     * Returns the problem parsed.
     *
     * @return the problem parsed.
     */
    public final Problem getProblem() {
        return this.problem;
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
    private boolean checkGroundedParserNode(Exp exp) {
        boolean checked = true;
        if (exp == null) {
            return true;
        }
        LinkedList<Exp> stackGD = new LinkedList<>();
        LinkedList<List<TypedSymbol>> stackCtx = new LinkedList<>();
        stackGD.add(exp);
        stackCtx.add(new LinkedList<>());
        while (!stackGD.isEmpty()) {
            Exp gd = stackGD.poll();
            List<TypedSymbol> ctx = stackCtx.poll();
            List<TypedSymbol> newCtx = new LinkedList<>(ctx);
            switch (gd.getConnective()) {
                case ATOM:
                case FN_HEAD:
                case EQUAL_ATOM:
                    boolean error = false;
                    final List<Symbol> atom = gd.getAtom();
                    final NamedTypedList atomSkeleton = new NamedTypedList(atom.get(0));
                    for (int i = 1; i < atom.size(); i++) {
                        Symbol symbol = atom.get(i);
                        Iterator<TypedSymbol> j = ctx.iterator();
                        TypedSymbol qvar = null;
                        while (j.hasNext() && qvar == null) {
                            TypedSymbol vj = j.next();
                            if (vj.equals(symbol)) {
                                qvar = vj;
                            }
                        }
                        if (symbol.getKind().equals(Symbol.Kind.VARIABLE) && qvar == null) {
                            this.mgr.logParserError("variable \"" + symbol + "\" is undefined",
                                this.lexer.getFile(), symbol.getBeginLine(), symbol
                                    .getBeginColumn());
                            error = true;
                        } else {
                            TypedSymbol object = null;
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
                                for (Symbol type : object.getTypes()) {
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
                    if (checked && gd.getConnective().equals(Connective.ATOM)
                        && !this.isDeclaredPredicate(atomSkeleton)) {
                        this.mgr.logParserError("predicate \"" + atomSkeleton.getName() + "/"
                            + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                            .getFile(), atomSkeleton.getName().getBeginLine(), atomSkeleton
                            .getName().getBeginColumn());
                        checked = false;
                    } else if (checked && gd.getConnective().equals(Connective.FN_HEAD)
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
                    for (TypedSymbol variable : gd.getVariables()) {
                        error = false;
                        for (Symbol type : variable.getTypes()) {
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
        LinkedList<Exp> stackGD = new LinkedList<>();
        stackGD.addAll(this.problem.getInit());
        while (!stackGD.isEmpty()) {
            Exp gd = stackGD.poll();
            switch (gd.getConnective()) {
                case ATOM:
                case FN_ATOM:
                    boolean error = false;
                    List<Symbol> atom = gd.getAtom();
                    if (atom == null) {
                        atom = gd.getChildren().get(0).getAtom();
                    }
                    final NamedTypedList atomSkeleton = new NamedTypedList(atom.get(0));
                    for (int i = 1; i < atom.size(); i++) {
                        Symbol symbol = atom.get(i);
                        TypedSymbol object = this.problem.getObject(symbol);
                        if (object == null) {
                            object = this.domain.getConstant(symbol);
                        }
                        if (object == null) {
                            this.mgr.logParserError("object \"" + atom.get(i) + "\" is undefined",
                                this.lexer.getFile(), symbol.getBeginLine(), symbol
                                    .getBeginColumn());
                            error = true;
                        } else {
                            for (Symbol type : object.getTypes()) {
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
                    if (checked && gd.getConnective().equals(Connective.ATOM)
                        && !this.isDeclaredPredicate(atomSkeleton)) {
                        this.mgr.logParserError("predicate \"" + atomSkeleton.getName() + "/"
                            + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                            .getFile(), atomSkeleton.getName().getBeginLine(), atomSkeleton
                            .getName().getBeginColumn());
                        checked = false;
                    } else if (checked && gd.getConnective().equals(Connective.FN_ATOM)
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
        List<TypedSymbol> objects = this.problem.getObjects();
        for (TypedSymbol object : objects) {
            for (Symbol type : object.getTypes()) {
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
        if (this.domain.getName() != null && !this.domain.getName().equals(this.problem.getDomain())) {
            this.mgr.logParserWarning("domain name \"" + this.problem.getDomain()
                + "\" used in problem doest not match.", this.lexer.getFile(), this.problem
                .getDomain().getBeginLine(), this.problem.getDomain().getBeginColumn());
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

        List<TypedSymbol> types = this.domain.getTypes();

        // Gathering types declaration
        final Map<String, TypedSymbol> map = new HashMap<>();
        map.put(Parser.OBJECT.getImage(), new TypedSymbol(Parser.OBJECT));

        for (TypedSymbol type : types) {
            // Special cas for the type object
            if ((type.equals(Parser.OBJECT) || type.equals(Parser.NUMBER)) && !type.getTypes().isEmpty()) {
                this.mgr.logParserError("type \"" + type.getImage() + "\" cannot be used as derived type",
                    this.lexer.getFile(), type.getBeginLine(), type.getBeginColumn());
            } else { // General case
                // check if all super types are defined otherwise create a new type inherited from object
                type.getTypes().stream().filter(superType -> !types.contains(superType)).forEach(superType -> {
                    TypedSymbol st = new TypedSymbol(superType);
                    map.put(superType.getImage(), st);
                });
                // If the type was already encountered, it means that there is multiple inheritance
                // thus the super types are gathered
                TypedSymbol t = map.get(type.getImage());
                if (t == null) {
                    map.put(type.getImage(), type);
                } else {
                    Set<Symbol> set = new HashSet<>();
                    set.addAll(t.getTypes());
                    set.addAll(type.getTypes());
                    t.getTypes().clear();
                    t.getTypes().addAll(set);
                }
            }
        }


        // Check the consistency of the types declaration, i.e., if there is no loop in the types declaration
        boolean consistent = true;
        Iterator<TypedSymbol> iterator = map.values().iterator();
        while (iterator.hasNext() && consistent) {
            final TypedSymbol type = iterator.next();
            final LinkedList<TypedSymbol> open = new LinkedList<>();
            open.add(type);
            while (!open.isEmpty() && consistent) {
                final TypedSymbol current = open.poll();
                for (Symbol st : current.getTypes()) {
                    final TypedSymbol c = map.get(st.getImage());
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
        for (TypedSymbol type : map.values()) {
            this.domain.getTypes().add(new TypedSymbol(type));
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
        List<TypedSymbol> constants = this.domain.getConstants();
        Set<Symbol> set = new HashSet<>();
        boolean checked = true;
        for (TypedSymbol constant : constants) {
            if (!set.add(constant)) {
                this.mgr.logParserError("constant \"" + constant.getImage()
                        + "\" already defined", this.lexer.getFile(), constant.getBeginLine(),
                    constant.getBeginColumn());
                checked = false;
            }
            for (Symbol type : constant.getTypes()) {
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
     * typed, if each types of the variables used in the predicates declaration are defined, if
     * there is no duplicated predicate.
     *
     * @return <code>true</code> if the predicates declaration are well formed; <code>false</code> otherwise.
     */
    private boolean checkPredicatesDeclaration() {
        List<NamedTypedList> predicates = this.domain.getPredicates();
        Set<String> set = new HashSet<>();
        boolean checked = true;
        for (NamedTypedList predicate : predicates) {
            for (TypedSymbol variable : predicate.getArguments()) {
                for (Symbol type : variable.getTypes()) {
                    if (!this.domain.isDeclaredType(type)) {
                        this.mgr.logParserError("type \"" + type.getImage()
                            + "\" of the variable \"" + variable.getImage()
                            + "\" is undefined", this.lexer.getFile(), variable
                            .getBeginLine(), variable.getBeginColumn());
                        checked = false;
                    }
                }
            }
            Symbol predicateSymbol = predicate.getName();
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
     * Checks the functions declaration. More precisely, this method checks, if the domain is typed,
     * if each types of the variables used in the function declaration are defined, if there is no
     * duplicated functions and conflict with predicates already defined.
     *
     * @return <code>true</code> if the function declaration are well formed; <code>false</code> otherwise.
     */
    private boolean checkFunctionsDeclaration() {

        Set<String> predicates = new HashSet<>();
        for (NamedTypedList predicate : this.domain.getPredicates()) {
            Symbol predicateSymbol = predicate.getName();
            String str = predicateSymbol.getImage() + "/" + predicate.getArguments().size();
            predicates.add(str);
        }

        List<NamedTypedList> functions = this.domain.getFunctions();
        Set<String> set = new HashSet<>();
        boolean checked = true;
        for (NamedTypedList function : functions) {
            Symbol functionSymbol = function.getName();
            for (TypedSymbol variable : function.getArguments()) {
                for (Symbol type : variable.getTypes()) {
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
    private boolean checkDerivedPredicatesDeclaration() {
        boolean checked = true;
        for (DerivedPredicate axiom : this.domain.getDerivesPredicates()) {
            NamedTypedList head = axiom.getHead();
            for (TypedSymbol argument : head.getArguments()) {
                for (Symbol type : argument.getTypes()) {
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
     * Checks if the declared operators are well formed.
     * <ul>
     * <li> Operators must have a unique name.</li>
     * <li> The type of the variables or constants used in their precondition, condition and effects
     * are type previously declared.</li>
     * <li> The variable used in their precondition, condition and effects are declared as
     * parameters of the operators.</li>
     * </ul>
     *
     * @return <code>true</code> if the function declaration are well formed; <code>false</code> otherwise.
     */
    private boolean checkOperatorsDeclaration() {
        boolean checked = this.checkOperatorsUniqueness();
        for (Op op : this.domain.getOperators()) {
            if (this.checkOperatorsParameters(op)) {
                checked &= this.checkParserNode(op.getPreconditions(), op.getParameters());
                checked &= this.checkParserNode(op.getEffects(), op.getParameters());
                if (op.getDuration() != null) {
                    checked &= this.checkParserNode(op.getDuration(), op.getParameters());
                }
            }
        }
        return checked;
    }

    /**
     * Checks if a PDDL expression such as the preconditions, the effects and the duration of an
     * operator is well formed. More precisely, check if all variables are well typed and are valid
     * parameters of the operator or quantified variable and finally, if all atoms match a predicate
     * previously declared.
     *
     * @param exp     The PDDL expression.
     * @param context The symbolEncoding.
     * @return <code>true</code> if the expression is well formed; <code>false</code> otherwise.
     */
    private boolean checkParserNode(Exp exp, List<TypedSymbol> context) {
        boolean checked = true;
        LinkedList<Exp> stackGD = new LinkedList<>();
        LinkedList<List<TypedSymbol>> stackCtx = new LinkedList<>();
        stackGD.add(exp);
        stackCtx.add(context);
        while (!stackGD.isEmpty()) {
            Exp gd = stackGD.poll();
            List<TypedSymbol> ctx = stackCtx.poll();
            List<TypedSymbol> newCtx = new LinkedList<>(ctx);
            switch (gd.getConnective()) {
                case ATOM:
                case FN_HEAD:
                    checked = this.checkAtom(gd, ctx);
                    break;
                case EXISTS:
                case FORALL:
                    for (TypedSymbol variable : gd.getVariables()) {
                        boolean error = false;
                        for (Symbol type : variable.getTypes()) {
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
    private boolean checkAtom(Exp gd, List<TypedSymbol> context) {
        boolean checked = true;
        List<Symbol> atom = gd.getAtom();
        final NamedTypedList atomSkeleton = new NamedTypedList(atom.get(0));
        for (int i = 1; i < atom.size(); i++) {
            final Symbol s = atom.get(i);
            if (s.getKind().equals(Symbol.Kind.VARIABLE)) {
                TypedSymbol param = null;
                Iterator<TypedSymbol> itr = context.iterator();
                while (itr.hasNext() && param == null) {
                    TypedSymbol pi = itr.next();
                    if (pi.equals(s)) {
                        param = pi;
                    }
                }
                if (param == null) {
                    this.mgr.logParserError("variable \"" + s.getImage() + "\" is undefined",
                        this.lexer.getFile(), s.getBeginLine(), s.getBeginColumn());
                    checked = false;
                } else {
                    final TypedSymbol arg = new TypedSymbol(s);
                    param.getTypes().forEach(arg::addType);
                    atomSkeleton.add(arg);
                }
            } else {
                TypedSymbol constant = this.domain.getConstant(s);
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
        if (checked && gd.getConnective().equals(Connective.ATOM)
            && !this.isDeclaredPredicate(atomSkeleton)) {
            this.mgr.logParserError("predicate \"" + atomSkeleton.getName() + "/"
                + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                .getFile(), atomSkeleton.getName().getBeginLine(), atomSkeleton
                .getName().getBeginColumn());
            checked = false;
        } else if (checked && gd.getConnective().equals(Connective.FN_ATOM)
            && !this.isDeclaredFunction(atomSkeleton)) {
            this.mgr.logParserError("function \"" + atomSkeleton.getName() + "/"
                + atomSkeleton.getArguments().size() + "\" is undefined", this.lexer
                .getFile(), atomSkeleton.getName().getBeginLine(), atomSkeleton
                .getName().getBeginColumn());
            checked = false;
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
                    TypedSymbol arg1 = predicate.getArguments().get(j);
                    TypedSymbol arg2 = p.getArguments().get(j);
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
                    TypedSymbol arg1 = function.getArguments().get(j);
                    TypedSymbol arg2 = p.getArguments().get(j);
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
    private boolean matchTypes(TypedSymbol s1, TypedSymbol s2) {
        List<Symbol> copy = new LinkedList<>(s1.getTypes());
        copy.retainAll(s2.getTypes());
        boolean isSubType = !copy.isEmpty();
        Iterator<Symbol> i = s1.getTypes().iterator();
        while (i.hasNext() && !isSubType) {
            TypedSymbol type = this.domain.getType(i.next());
            LinkedList<TypedSymbol> stack = new LinkedList<>();
            stack.push(type);
            while (!stack.isEmpty() && !isSubType) {
                TypedSymbol t = stack.poll();
                copy = new LinkedList<>(t.getTypes());
                copy.retainAll(s2.getTypes());
                isSubType = !copy.isEmpty();
                t.getTypes().stream().filter(s -> !s.equals(Parser.OBJECT)).forEach(s ->
                    stack.push(this.domain.getType(s)));
            }
        }
        return isSubType;
    }

    /**
     * Checks the operator parameters, i.e., if each parameter is single and its type was previously
     * declared.
     *
     * @param op the operator to check.
     * @return <code>true</code> if the parameters of the specified operator are well formed;
     * <code>false</code> otherwise.
     */
    private boolean checkOperatorsParameters(Op op) {
        boolean checked = true;
        Set<Symbol> set = new HashSet<>();
        for (TypedSymbol parameter : op.getParameters()) {
            if (!set.add(parameter)) {
                this.mgr.logParserError("parameter \"" + parameter + "\" is defined twice in the action \""
                    + op.getName() + "\"", this.lexer.getFile(), parameter.getBeginLine(), parameter
                    .getBeginColumn());
                checked = false;
            }
            for (Symbol type : parameter.getTypes()) {
                if (!this.domain.isDeclaredType(type)) {
                    this.mgr.logParserError("type \"" + type.getImage() + "\" of the parameter \""
                            + parameter + "\" in the action \"" + op.getName() + "\" is undefined",
                        this.lexer.getFile(), parameter.getBeginLine(), parameter.getBeginColumn());
                    checked = false;
                }
            }
        }
        return checked;
    }

    /**
     * Checks the uniqueness of the name of the operators declared.
     *
     * @return <code>true</code> if all the operators are single; <code>false</code> otherwise.
     */
    private boolean checkOperatorsUniqueness() {
        boolean checked = true;
        Set<Symbol> set = new HashSet<>();
        for (Op op : this.domain.getOperators()) {
            if (!set.add(op.getName())) {
                Symbol opName = op.getName();
                this.mgr.logParserError("action \"" + opName + "\" declared twice", this.lexer
                    .getFile(), opName.getBeginLine(), opName.getBeginColumn());
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
            Parser parser = new Parser();
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
            Parser parser = new Parser();
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
