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

package pddl4j.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import pddl4j.parser.lexer.Lexer;

/**
 * Implements the <tt>Parser</tt> of the PDD4L library. The parser accepts only PDDL3.0 language.
 * See BNF Description of PDDL3.0 - Alfonso Gerevini and Derek Long for more details.
 * <p>
 * A simple example of how to use the parser:
 * 
 * <pre>
 * public static void main(String[] args) {
 * 
 * 	if (args.length == 2 &amp;&amp; args[0].equals(&quot;-p&quot;)) {
 * 		Parser parser = new Parser();
 * 		try {
 * 			parser.parse(args[1]);
 * 		} catch (FileNotFoundException e) {
 * 			System.out.println(e.getMessage());
 * 		}
 * 		if (!parser.getErrorManager().isEmpty()) {
 * 			parser.getErrorManager().printAll();
 * 		}
 * 	} else if (args.length == 4 &amp;&amp; args[0].equals(&quot;-o&quot;) &amp;&amp; args[2].equals(&quot;-f&quot;)) {
 * 		Parser parser = new Parser();
 * 		try {
 * 			parser.parse(args[1], args[3]);
 * 		} catch (FileNotFoundException e) {
 * 			System.out.println(e.getMessage());
 * 		}
 * 		if (!parser.getErrorManager().isEmpty()) {
 * 			parser.mgr.printAll();
 * 		}
 * 	} else {
 * 		System.out.println(&quot;\nusage of parser:\n&quot;);
 * 		System.out.println(&quot;OPTIONS   DESCRIPTIONS\n&quot;);
 * 		System.out.println(&quot;-p &lt;str&gt;    path for operator and fact file&quot;);
 * 		System.out.println(&quot;-o &lt;str&gt;    operator file name&quot;);
 * 		System.out.println(&quot;-f &lt;str&gt;    fact file name\n&quot;);
 * 	}
 * }
 * </pre>
 * 
 * </p>
 * 
 * @author D Pellier
 * @version 1.0 - 28.01.10
 */
public final class Parser {
    
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
     * 
     */
    public Parser() {
        super();
        this.mgr = new ErrorManager();
    }
    
    /**
	 * Parses a planning domain and a planning problem from the specified file.
	 * 
	 * @param problem the path of the file that contains the planning domains and problem.
	 * @throws FileNotFoundException if the specified problem file does not exist.
	 */
	public void parse(String problem) throws FileNotFoundException {
		this.parse(new File(problem));
	}
	
    /**
	 * Parses a planning domain and a planning problem from the specified file.
	 * 
	 * @param problem the file that contains the planning domains and problem.
	 * @throws FileNotFoundException if the specified problem file does not exist.
	 */
	public void parse(File problem) throws FileNotFoundException {
		if (!problem.exists()) {
			throw new FileNotFoundException("File  \"" + problem.getName() + "\" does not exist.");
		}
		try {
			this.lexer = new Lexer(new FileInputStream(problem));
			lexer.setErrorManager(this.mgr);
			lexer.setFile(problem);
			this.lexer.domain_and_problem();
			this.domain = this.lexer.getDomain();
			this.problem = this.lexer.getProblem();
			this.checkTypesDeclaration();
			this.checkConstantsDeclaration();
			this.checkPredicatesDeclaration();
			this.checkFunctionsDeclaration();
			this.checkOperatorsDeclaration();
			this.checkDerivedPredicatesDeclaration();
		} catch (Throwable e) {
			//System.out.println("\nUnexpected error:");
			//e.printStackTrace(System.out);
		}
	}
	
	/**
	 * Parses a planning domain from a specific files.
	 * 
	 * @param domain the file that contains the planning domains.
	 * @throws FileNotFoundException if the specified domain or problem file does not exist.
	 */
	public void parseDomain(String domain) throws FileNotFoundException {
		File d = new File(domain);
		if (!d.exists()) {
			throw new FileNotFoundException("File  \"" + d.getName() + "\" does not exist.");
		}
		try {
			// Parse and check the domain
			this.lexer = new Lexer(new FileInputStream(d));
			lexer.setErrorManager(this.mgr);
			lexer.setFile(d);
			this.lexer.domain();
			this.domain = this.lexer.getDomain();
			this.checkTypesDeclaration();
			this.checkConstantsDeclaration();
			this.checkPredicatesDeclaration();
			this.checkFunctionsDeclaration();
			this.checkDomainConstraints();
			this.checkOperatorsDeclaration();
			this.checkDerivedPredicatesDeclaration();
		} catch (Throwable e) {
			//System.out.println("\nUnexpected error:");
			//e.printStackTrace(System.out);
		}
	}
	
	/**
	 * Parses a planning problem from a specific file.
	 * 
	 * @param problem the file that contains the planning problem.
	 * @throws FileNotFoundException if the specified domain or problem file does not exist.
	 */
	public void parseProblem(File problem) throws FileNotFoundException {
		if (!problem.exists()) {
			throw new FileNotFoundException("File  \"" + problem.getName() + "\" does not exist.");
		}
		try {
			// Parse and check the domain
			this.lexer = new Lexer(new FileInputStream(problem));
			lexer.setErrorManager(this.mgr);
			this.lexer.setFile(problem);
			this.lexer.problem();
			this.problem = this.lexer.getProblem();
			this.checkDomainName();
			this.checkObjectsDeclaration();
			this.checkInitialFacts();
			this.checkGoal();
			this.checkProblemConstraints();
			this.checkMetric();
		} catch (Throwable e) {
			//System.out.println("\nUnexpected error:");
			//e.printStackTrace(System.out);
		}
	}
	
    /**
	 * Parses a planning domain and a planning problem from their respective files.
	 * 
	 * @param domain the path of the file that contains the planning domains.
	 * @param problem the path of the file that contains the planning problem.
	 * @throws FileNotFoundException if the specified domain or problem file does not exist.
	 */
	public void parse(String domain, String problem) throws FileNotFoundException {
		this.parse(new File(domain), new File(problem));
	}

	/**
	 * Parses a planning domain and a planning problem from their respective files.
	 * 
	 * @param domain the file that contains the planning domains.
	 * @param problem the file that contains the planning problem.
	 * @throws FileNotFoundException if the specified domain or problem file does not exist.
	 */
	private void parse(File domain, File problem) throws FileNotFoundException {
		if (!domain.exists()) {
			throw new FileNotFoundException("File  \"" + domain.getName() + "\" does not exist.");
		}
		if (!problem.exists()) {
			throw new FileNotFoundException("File  \"" + problem.getName() + "\" does not exist.");
		}
		try {
			// Parse and check the domain
			this.lexer = new Lexer(new FileInputStream(domain));
			lexer.setErrorManager(this.mgr);
			lexer.setFile(domain);
			this.lexer.domain();
			this.domain = this.lexer.getDomain();
			this.checkTypesDeclaration();
			this.checkConstantsDeclaration();
			this.checkPredicatesDeclaration();
			this.checkFunctionsDeclaration();
			this.checkDomainConstraints();
			this.checkOperatorsDeclaration();
			this.checkDerivedPredicatesDeclaration();
			// Parse and check the problem
			if (this.lexer == null) {
				this.lexer = new Lexer(new FileInputStream(problem));
			} else {
				this.lexer.ReInit(new FileInputStream(problem));
			}
			this.lexer.setFile(problem);
			this.lexer.problem();
			this.problem = this.lexer.getProblem();
			this.checkDomainName();
			this.checkObjectsDeclaration();
			this.checkInitialFacts();
			this.checkGoal();
			this.checkProblemConstraints();
			this.checkMetric();
		} catch (Throwable e) {
			//System.out.println("\nUnexpected error:");
			//e.printStackTrace(System.out);
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
	 *         <code>false<code> otherwise.
	 */
	private boolean checkMetric() {
		return (this.problem.getMetric() == null) ? true :
			this.checkParserNode(this.problem.getMetric(), new LinkedList<TypedSymbol>());
	}
	
	/**
	 * Check if the constraints declared in the domain are well formed.
	 * 
	 * @return <code>true</code> if the constraints declared in the domain are well formed;
	 *         <code>false<code> otherwise.
	 */
	private boolean checkDomainConstraints() {
		return (this.domain.getConstraints() == null) ? true : this.checkParserNode(this.domain
				.getConstraints(), new LinkedList<TypedSymbol>());
	}

	/**
	 * Check if the constraints declared in the domain are well formed.
	 * 
	 * @return <code>true</code> if the constraints declared in the domain are well formed;
	 *         <code>false<code> otherwise.
	 */
	private boolean checkProblemConstraints() {
		return (this.problem.getConstraints() == null) ? true : this
				.checkGroundedParserNode(this.problem.getConstraints());
	}

	/**
	 * Check if the goal is well formed.
	 * 
	 * @return <code>true</code> if the goal is well formed; <code>false<code> otherwise.
	 */
	private boolean checkGoal() {
		return this.checkGroundedParserNode(this.problem.getGoal());
	}
	
	/**
	 * Check if a specified ground PDDL expression is well formed.
	 * 
	 * @param exp The expression.
	 * @return <code>true</code> if a specified ground PDDL expression is well formed;
	 *         <code>false<code> otherwise.
	 */
	private boolean checkGroundedParserNode(Exp exp) {
		boolean checked = true;
		if (exp == null) return checked;
		LinkedList<Exp> stackGD = new LinkedList<Exp>();
		LinkedList<List<TypedSymbol>> stackCtx = new LinkedList<List<TypedSymbol>>();
		stackGD.add(exp);
		stackCtx.add(new LinkedList<TypedSymbol>());
		while (!stackGD.isEmpty()) {
			Exp gd = stackGD.poll();
			List<TypedSymbol> ctx = stackCtx.poll();
			List<TypedSymbol> newCtx = new LinkedList<TypedSymbol>(ctx);
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
					if (checked)
						newCtx.add(variable);
				}
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
	 * @return <code>true</code> if the initial facts are well formed; <code>false</code>
	 *         otherwise.
	 */
	private boolean checkInitialFacts() {
		boolean checked = true;
		LinkedList<Exp> stackGD = new LinkedList<Exp>();
		stackGD.addAll(this.problem.getInit());
		while (!stackGD.isEmpty()) {
			Exp gd = stackGD.poll();
			switch (gd.getConnective()) {
			case ATOM:
			case FN_ATOM:
				boolean error = false;
				List<Symbol> atom = gd.getAtom();
				if (atom == null) atom = gd.getChildren().get(0).getAtom();
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
	 * Check if the domain name specified in the problem is the same use in the domain.
	 * 
	 * @return <code>true</code> if the domain name specified in the problem is the same use in
	 *         the domain; <code>false</code> otherwise.
	 */
	private boolean checkDomainName() {
		boolean checked = true;
		if (this.domain.getName() != null && !this.problem.getDomain().equals(this.problem.getDomain())) {
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
	 * @return <code>true</code> if the types declaration is consistent; <code>false</code>
	 *         otherwise.
	 */
	private boolean checkTypesDeclaration() {

		List<TypedSymbol> types = this.domain.getTypes();
		boolean checked = true;

		if (types.isEmpty()) {
			checked = true;
		} else if (types.size() == 1 && types.get(0).equals(Parser.OBJECT)) {
			checked = true;
		} else {
			boolean typed_object_declared = false;
			Set<Symbol> set = new HashSet<Symbol>();
			Set<Symbol> typesToAdd = new HashSet<Symbol>();
			for (TypedSymbol type : types) {
				if (type.equals(Parser.OBJECT) && !type.getTypes().isEmpty()) {
					this.mgr.logParserError("type \"" + type.getImage()
							+ "\" cannot be used as subtype", this.lexer.getFile(), type
							.getBeginLine(), type.getBeginColumn());
				}
/*				if (type.equals(Parser.NUMBER) && !type.getTypes().isEmpty()) {
					this.mgr.logParserError("type \"" + type.getImage()
							+ "\" cannot be used as subtype", this.lexer.getFile(), type
							.getBeginLine(), type.getBeginColumn());
				}*/
				if (set.contains(type)) {
					checked = false;
					this.mgr.logParserError("type \"" + type.getImage()
							+ "\" already defined", this.lexer.getFile(), type
							.getBeginLine(), type.getBeginColumn());
				} else {
					set.add(type);
				}
				for (Symbol superType : type.getTypes()) {
					typed_object_declared |= superType.equals(Parser.OBJECT);
					if (!set.contains(superType) && !typesToAdd.contains(superType)) {
						if (typed_object_declared) {
							checked = false;
							this.mgr.logParserError("type \"" + superType.getImage() + "\" undefined",
								this.lexer.getFile(), superType.getBeginLine(), superType
										.getBeginColumn());
						} else {
							typesToAdd.add(superType);
						}
					}
				}
			}
			for (Symbol type: typesToAdd) {
				this.domain.getTypes().add(new TypedSymbol(type));
			}
		}
		return checked;
	}

	/**
	 * Checks the constants declaration. More precisely, checks if each constant is defined ones and
	 * if the domain is typed if the types of the constants was previously defined as types.
	 * 
	 * @return <code>true</code> if the constants declaration are well formed; <code>false</code>
	 *         otherwise.
	 */
	private boolean checkConstantsDeclaration() {
		List<TypedSymbol> constants = this.domain.getConstants();
		Set<Symbol> set = new HashSet<Symbol>();
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
	 * @return <code>true</code> if the predicates declaration are well formed; <code>false</code>
	 *         otherwise.
	 */
	private boolean checkPredicatesDeclaration() {
		List<NamedTypedList> predicates = this.domain.getPredicates();
		Set<String> set = new HashSet<String>();
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
			Symbol predicate_symbol = predicate.getName();
			String str = predicate_symbol.getImage() + "/" + predicate.getArguments().size();
			
			if (!set.add(str)) {
				this.mgr.logParserError("predicate \"" + str + "\" declared twice", this.lexer
						.getFile(), predicate_symbol.getBeginLine(), predicate_symbol
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
	 * @return <code>true</code> if the function declaration are well formed; <code>false</code>
	 *         otherwise.
	 */
	private boolean checkFunctionsDeclaration() {

		Set<String> predicates = new HashSet<String>();
		for (NamedTypedList predicate : this.domain.getPredicates()) {
			Symbol predicate_symbol = predicate.getName();
			String str = predicate_symbol.getImage() + "/" + predicate.getArguments().size();
			predicates.add(str);
		}

		List<NamedTypedList> functions = this.domain.getFunctions();
		Set<String> set = new HashSet<String>();
		boolean checked = true;
		for (NamedTypedList function : functions) {
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
			Symbol function_symbol = function.getName();
			String str = function_symbol.getImage() + "/" + function.getArguments().size();
			if (!set.add(str)) {
				this.mgr.logParserError("predicate \"" + str + "\" declared twice", this.lexer
						.getFile(), function_symbol.getBeginLine(), function_symbol
						.getBeginColumn());
				checked = false;
			}
			if (predicates.contains(str)) {
				this.mgr.logParserError("function \"" + str
						+ "\" is ambiguous with a predicate already declared",
						this.lexer.getFile(), function_symbol.getBeginLine(), function_symbol
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
	 *         <code>false</code> otherwise.
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
	 * Checks if the declared operators
	 * <ul>
	 * <li> have a unique name</li>
	 * <li> the type of the variables or constants used in their precondition, condition and effects
	 * are type previously declared.</li>
	 * <li> the variable used in their precondition, condition and effects are declared as
	 * parameters of the operators.</li>
	 * </ul>
	 * 
	 * @return <code>true</code> if the function declaration are well formed; <code>false</code>
	 *         otherwise.
	 */
	private boolean checkOperatorsDeclaration() {
		boolean checked = this.checkOperatorsUniqueness();
		for (Op op : this.domain.getOperators()) {
			if (this.checkOperatorsParameters(op)) {
				checked = this.checkParserNode(op.getPreconditions(), op.getParameters());
				checked = this.checkParserNode(op.getEffects(), op.getParameters());
				if (op.getDuration() != null) {
					checked = this.checkParserNode(op.getDuration(), op.getParameters());
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
	 * @param exp The PDDL expression.
	 * @param context The symbolEncoding.
	 * @return <code>true</code> if the expression is well formed; <code>false</code> otherwise.
	 */
	private boolean checkParserNode(Exp exp, List<TypedSymbol> context) {
		boolean checked = true;
		LinkedList<Exp> stackGD = new LinkedList<Exp>();
		LinkedList<List<TypedSymbol>> stackCtx = new LinkedList<List<TypedSymbol>>();
		stackGD.add(exp);
		stackCtx.add(context);
		while (!stackGD.isEmpty()) {
			Exp gd = stackGD.poll();
			List<TypedSymbol> ctx = stackCtx.poll();
			List<TypedSymbol> newCtx = new LinkedList<TypedSymbol>(ctx);
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
					if (checked) newCtx.add(variable);
				}
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
	 * @param gd The atom goal description.
	 * @param parameters The parameters that defined the global symbolEncoding, e.g., parameters of an
	 *            operator or the types variable of derived predicate.
	 * @param context The symbolEncoding, i.e., the quantified variables if any.
	 * @return <code>true</code> if an atom used in is well typed and if it was previously
	 *         declared in the predicates of the domain; <code>false</code> otherwise.
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
					for (Symbol type : param.getTypes()) {
						arg.addType(type);
					}
					atomSkeleton.add(arg);
				} 
			} else {
				TypedSymbol constant = this.domain.getConstant(s);
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
	 * @return <code>true</code> if this predicate was previously declared; <code>false</code>
	 *         otherwise.
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
	 * @return <code>true</code> if this function was previously declared; <code>false</code>
	 *         otherwise.
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
	 * @return <code>true</code> if the types of the first typed symbol can be viewed as a subtype
	 *         of the seconds. <code>false</code> otherwise.
	 */
	private boolean matchTypes(TypedSymbol s1, TypedSymbol s2) {
		List<Symbol> copy = new LinkedList<Symbol>(s1.getTypes());
		copy.retainAll(s2.getTypes());
		boolean isSubType = !copy.isEmpty();
		Iterator<Symbol> i = s1.getTypes().iterator();
		while (i.hasNext() && !isSubType) {
			TypedSymbol type = this.domain.getType(i.next());
			LinkedList<TypedSymbol> stack = new LinkedList<TypedSymbol>();
			stack.push(type);
			while (!stack.isEmpty() && !isSubType) {
				TypedSymbol t = stack.poll();
				copy = new LinkedList<Symbol>(t.getTypes());
				copy.retainAll(s2.getTypes());
				isSubType = !copy.isEmpty();
				for (Symbol s : t.getTypes()) {
					if (!s.equals(Parser.OBJECT)) {
						stack.push(this.domain.getType(s));
					}
				}
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
	 *         <code>false/<code> otherwise.
	 */
	private boolean checkOperatorsParameters(Op op) {
		boolean checked = true;
		Set<Symbol> set = new HashSet<Symbol>();
		for (TypedSymbol parameter : op.getParameters()) {
			Symbol s = parameter;
			if (!set.add(parameter)) {
				this.mgr.logParserError("parameter \"" + s + "\" is defined twice in the action \""
						+ op.getName() + "\"", this.lexer.getFile(), s.getBeginLine(), s
						.getBeginColumn());
				checked = false;
			}
			for (Symbol type : parameter.getTypes()) {
				if (!this.domain.isDeclaredType(type)) {
					this.mgr.logParserError("type \"" + type.getImage() + "\" of the parameter \""
							+ s + "\" in the action \"" + op.getName() + "\" is undefined",
							this.lexer.getFile(), s.getBeginLine(), s.getBeginColumn());
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
		Set<Symbol> set = new HashSet<Symbol>();
		for (Op op : this.domain.getOperators()) {
			if (!set.add(op.getName())) {
				Symbol op_name = op.getName();
				this.mgr.logParserError("action \"" + op_name + "\" declared twice", this.lexer
						.getFile(), op_name.getBeginLine(), op_name.getBeginColumn());
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
     * -p <str>    path for operator and fact file
     * -o <str>    operator file name
     * -f <str>    fact file name 
     * </pre>
	 * 
	 * @param args the arguments of the command line.
	 */
	public static void main(String[] args) {
		
		if (args.length == 2 && args[0].equals("-p")) {
			System.out.print("parse problem " + "\"" + args[1] + "\": ");
			Parser parser = new Parser();
			try {
				parser.parse(args[1]);
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			if (parser.mgr.isEmpty()) {
				System.out.println("ok");
			} else {
				System.out.println();
				parser.mgr.printAll();
			}
		} else if (args.length == 4 && args[0].equals("-o") && args[2].equals("-f")) {
			System.out.print("parse files " + "\"" + args[1] + "\" and " +  "\"" + args[3] + "\": ");
			Parser parser = new Parser();
			try {
				parser.parse(args[1], args[3]);
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			if (parser.mgr.isEmpty()) {
				System.out.println("ok");
			} else {
				System.out.println("no ok");
				parser.mgr.printAll();
			}
		} else {
			System.out.println("\nusage of parser:\n");
			System.out.println("OPTIONS   DESCRIPTIONS\n");
			System.out.println("-p <str>    path for operator and fact file");
			System.out.println("-o <str>    operator file name");
			System.out.println("-f <str>    fact file name\n");
		}
	}
}