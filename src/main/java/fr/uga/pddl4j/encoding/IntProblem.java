package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLSymbol;

import java.io.Serializable;
import java.util.*;

/**
 * Created by pellier on 03/11/2020.
 */
public class IntProblem implements Serializable {

    /**
     * The types of the problem.
     */
    private List<String> types;

    /**
     * The domain of values associated to the types.
     */
    private List<Set<Integer>> domains;

    /**
     * The constants.
     */
    private List<String> constants;

    /**
     * The predicates.
     */
    private List<String> predicates;

    /**
     * The types of the arguments of the predicates.
     */
    private List<List<Integer>> typeOfPredicateArguments;

    /**
     * The functions.
     */
    private List<String> functions;

    /**
     * The types of the arguments of the functions.
     */
    private List<List<Integer>> typeOfFunctionArguments;

    /**
     * The tasks.
     */
    private List<String> tasks;

    /**
     * The types of the arguments of the tasks.
     */
    private List<List<Integer>> typeOfTaskArguments;

    /**
     * The set primitive task symbols, i.e., the set of action symbol.
     */
    private Set<String> primitiveTaskSymbols;

    /**
     * The set compund task symbols, i.e., the set of task symbols used in methods.
     */
    private Set<String> compoundTaskSymbols;

    /**
     * The actions.
     */
    private List<IntAction> actions;

    /**
     * The methods.
     */
    private List<IntMethod> methods;

    /**
     * The initial state of the problem.
     */
    private Set<IntExpression> initialState;

    /**
     * The initial cost of the function declared in the problem.
     */
    private Map<IntExpression, Double> initialFunctionCosts;

    /**
     * The goal of the problem.
     */
    private IntExpression goal;

    /**
     * The initial task network of the problem.
     */
    private IntTaskNetwork initialTaskNetwork;

    /**
     * Creates a new empty planning problem.
     */
    public IntProblem() {
        this.types = new ArrayList<>();
        this.domains = new ArrayList<>();
        this.constants = new ArrayList<>();
        this.predicates = new ArrayList<>();
        this.typeOfPredicateArguments = new ArrayList<>();
        this.functions = new ArrayList<>();
        this.typeOfFunctionArguments = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.typeOfTaskArguments = new ArrayList<>();
        this.primitiveTaskSymbols = new LinkedHashSet<>();
        this.compoundTaskSymbols = new LinkedHashSet<>();
        this.actions = new ArrayList<>();
        this.methods = new ArrayList<>();
        this.initialState = new HashSet<>();
        this.initialFunctionCosts = new LinkedHashMap<>();
        this.goal = new IntExpression(PDDLConnective.AND);
        this.initialTaskNetwork = new IntTaskNetwork();
    }

    /**
     * Returns the types of the problem.
     *
     * @return the types of the problem.
     */
    public final List<String> getTypes() {
        return this.types;
    }

    /**
     * Sets the type symbols of the problem.
     *
     * @param types the types of the problem.
     */
    public final void setType(final List<String> types) {
        this.types = types;
    }

    /**
     * Returns the domains of values for each type of the problem. The problem at index i corresponds to the type at the
     * same index in the list of types of the problem.
     *
     * @return the domains of values for each type of the domain.
     */
    public final List<Set<Integer>> getDomains() {
        return this.domains;
    }

    /**
     * Returns the constants of the problem.
     *
     * @return the constants used of the problem.
     */
    public final List<String> getConstants() {
        return this.constants;
    }

    /**
     * Returns the predicates of the problem.
     *
     * @return the predicates of the problem.
     */
    public final List<String> getPredicates() {
        return this.predicates;
    }

    /**
     * Returns the types of the predicated arguments.
     *
     * @return the types of the predicated arguments.
     */
    public final List<List<Integer>> getTypeOfPredicateArguments() {
        return this.typeOfPredicateArguments;
    }

    /**
     * Returns the functions of the problem.
     *
     * @return the functions of the problem.
     */
    public final List<String> getFunctions() {
        return this.functions;
    }

    /**
     * Returns the types of the function arguments.
     *
     * @return the types of the function arguments.
     */
    public List<List<Integer>> getTypeOfFunctionArguments() {
        return this.typeOfFunctionArguments;
    }

    /**
     * Returns the tasks of the problem. The tasks of a problem is empty when the domain in not hierarchic.
     *
     * @return the tasks of the problem.
     */
    public final List<String> getTasks() {
        return this.tasks;
    }

    /**
     * Returns the types of the task arguments.
     *
     * @return the types of the task arguments.
     */
    public final List<List<Integer>> getTypeOfTaskArguments() {
        return this.typeOfTaskArguments;
    }

    /**
     * Returns the set primitive task symbols, i.e., the set of action symbol.
     *
     * @return the set primitive task symbols, i.e., the set of action symbol.
     */
    public final Set<String> getPrimitiveTaskSymbols() {
        return this.primitiveTaskSymbols;
    }

    /**
     * Returns the set compund task symbols, i.e., the set of task symbols used in methods.
     *
     * @return the set compund task symbols, i.e., the set of task symbols used in methods.
     */
    public Set<String> getCompoundTaskSymbols() {
        return this.compoundTaskSymbols;
    }

    /**
     * Returns the list of actions of the problem.
     *
     * @return the list of actions of the problem.
     */
    public final List<IntAction> getActions() {
        return this.actions;
    }

    /**
     * Returns the list of methods of the problem.
     *
     * @return the liste of methdos of the problem.
     */
    public final List<IntMethod> getMethods() {
        return this.methods;
    }

    /**
     * Returns the initial state of the problem.
     *
     * @return the initial state of the problem.
     */
    public final Set<IntExpression> getInitialState() {
        return this.initialState;
    }

    /**
     * Returns the initial cost of the function of the problem.
     *
     * @return the initial cost of the function of the problem.
     */
    public final Map<IntExpression, Double> getInitalFunctionCosts() {
        return this.initialFunctionCosts;
    }

    /**
     * Returns the goal of the problem.
     */
    public final IntExpression getGoal() {
        return this.goal;
    }

    /**
     * Returns the goal of the problem.
     *
     * @param goal the goal of the problem.
     */
    public final void setGoal(final IntExpression goal) {
        this.goal = goal;
    }

    /**
     * Returns the initial task network of the problem. The initial task network is only used to encode hierarchic
     * problem.
     *
     * @return the initial task network of the problem.
     */
    public final IntTaskNetwork getInitialTaskNetwork() {
        return this.initialTaskNetwork;
    }

    /**
     * Sets the initial task network of the problem. The initial task network is only used to encode hierarchic
     * problem.
     *
     * @param initialTaskNetwork the initial task network of the problem.
     */
    public final void setInitialTaskNetwork(final IntTaskNetwork initialTaskNetwork) {
        this.initialTaskNetwork = initialTaskNetwork;
    }

    /**
     * Returns a short string representation of the specified operator, i.e., its name and its
     * instantiated parameters.
     *
     * @param operator  the operator.
     * @return a string representation of the specified operator.
     */
    public String toShortString(final AbstractGroundOperator operator) {
        final StringBuilder str = new StringBuilder();
        str.append(operator.getName());
        for (int i = 0; i < operator.arity(); i++) {
            final int index = operator.getValueOfParameter(i);
            if (index == -1) {
                str.append(" ?");
            } else {
                str.append(" ").append(this.getConstants().get(index));
            }
        }
        return str.toString();
    }

    /**
     * Returns a string representation of the specified action.
     *
     * @param action the action.
     * @return a string representation of the specified acttion.
     */
    public String toString(final IntAction action) {
        final StringBuilder str = new StringBuilder();
        str.append("Action ").append(action.getName()).append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < action.arity(); i++) {
            final int index = action.getValueOfParameter(i);
            final String type = types.get(action.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(this.getConstants().get(index));
                str.append(" \n");
            }
        }
        str.append("Preconditions:\n");
        str.append(this.toString(action.getPreconditions()));
        str.append("\n");
        str.append("Effects:\n");
        str.append(this.toString(action.getEffects()));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a string representation of the specified method.
     *
     * @param method the method to print.
     * @return a string representation of the specified method.
     */
    public String toString(final IntMethod method) {
        final StringBuilder str = new StringBuilder();
        str.append("Method ").append(method.getName()).append("\n");
        str.append("Instantiations:\n");
        for (int i = 0; i < method.arity(); i++) {
            final int index = method.getValueOfParameter(i);
            final String type = types.get(method.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(constants.get(index));
                str.append(" \n");
            }
        }
        str.append("Task: ").append(toString(method.getTask()));
        str.append("\n");
        str.append("Preconditions:\n");
        str.append(this.toString(method.getPreconditions()));
        str.append("\n");
        str.append("Subtasks:\n");
        str.append(this.toString(method.getSubTasks()));
        str.append("\n");
        str.append("Ordering:\n");
        str.append(this.toString(method.getOrderingConstraints()));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a string representation of the specified task network.
     *
     * @param tn the task network to print.
     * @return a string representation of the specified method.
     */
    public String toString(final IntTaskNetwork tn) {
        final StringBuilder str = new StringBuilder();
        str.append("Parameters:\n");
        for (int i = 0; i < tn.arity(); i++) {
            final int index = tn.getValueOfParameter(i);
            final String type = this.getTypes().get(tn.getTypeOfParameters(i));
            if (index == -1) {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ? \n");
            } else {
                str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL).append(i);
                str.append(" - ");
                str.append(type);
                str.append(" : ");
                str.append(this.getConstants().get(index));
                str.append(" \n");
            }
        }
        str.append("Tasks:\n");
        str.append(this.toString(tn.getTasks()));
        str.append("\n");
        str.append("Ordering constraints:\n");
        str.append(this.toString(tn.getOrderingConstraints()));
        str.append("\n");
        return str.toString();
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp the expression.
     * @return a string representation of the specified expression.
     */
    public String toString(final IntExpression exp) {
        return this.toString(exp, " ");
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp the expression.
     * @param separator  the string separator between predicate symbol and arguments.
     * @return a string representation of the specified expression.
     */
    private String toString(final IntExpression exp, final String separator) {
        return this.toString(exp, "", separator);
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param exp        the expression
     * @param baseOffset the offset white space from the left used for indentation.
     * @param separator  the string separator between predicate symbol and arguments.
     * @return a string representation of the specified expression node.
     */
    private String toString(final IntExpression exp, final String baseOffset, final String separator) {
        final StringBuilder str = new StringBuilder();
        switch (exp.getConnective()) {
            case ATOM:
                str.append("(");
                str.append(this.getPredicates().get(exp.getPredicate()));
                int[] args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" ");
                        str.append(this.getConstants().get(index));
                    }
                }
                str.append(")");
                break;
            case FN_HEAD:
                str.append("(").append(this.getFunctions().get(exp.getPredicate()));
                args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" ");
                        str.append(this.getConstants().get(index));
                    }
                }
                str.append(")");
                break;
            case TASK:
                str.append("(");
                if (exp.getTaskID() != IntExpression.DEFAULT_TASK_ID) {
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                    str.append(exp.getTaskID());
                    str.append(" (");
                }
                str.append(tasks.get(exp.getPredicate()));
                args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" ");
                        str.append(this.getConstants().get(index));
                    }
                }
                if (exp.getTaskID() != IntExpression.DEFAULT_TASK_ID) {
                    str.append(")");
                }
                str.append(")");
                break;
            case EQUAL_ATOM:
                str.append("(").append("=");
                args = exp.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" ");
                        str.append(this.getConstants().get(index));
                    }
                }
                str.append(")");
                break;
            case AND:
            case OR:
                String offsetOr = baseOffset + "  ";
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                if (!exp.getChildren().isEmpty()) {
                    for (int i = 0; i < exp.getChildren().size() - 1; i++) {
                        str.append(this.toString(exp.getChildren().get(i), offsetOr)).append("\n").append(offsetOr);
                    }
                    str.append(toString(exp.getChildren().get(
                        exp.getChildren().size() - 1), offsetOr));
                }
                str.append(")");
                break;
            case FORALL:
            case EXISTS:
                str.append(" (").append(exp.getConnective().getImage());
                str.append(" (").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(-exp.getVariable() - 1);
                str.append(" - ");
                String offsetEx = baseOffset + baseOffset + "  ";
                str.append(types.get(exp.getType())).append(")\n").append(offsetEx);
                if (exp.getChildren().size() == 1) {
                    str.append(toString(exp.getChildren().get(0), offsetEx));
                }
                str.append(")");
                break;
            case NUMBER:
                str.append(exp.getValue());
                break;
            case F_EXP:
                str.append(toString(exp.getChildren().get(0), baseOffset));
                break;
            case F_EXP_T:
            case TRUE:
            case FALSE:
                str.append(exp.getConnective());
                break;
            case TIME_VAR:
                break;
            case FN_ATOM:
            case WHEN:
            case DURATION_ATOM:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                str.append(this.toString(exp.getChildren().get(0), baseOffset));
                str.append(" ");
                str.append(this.toString(exp.getChildren().get(1), baseOffset));
                str.append(")");
                break;
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case NOT:
            case ALWAYS:
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                str.append(this.toString(exp.getChildren().get(0), baseOffset));
                str.append(")");
                break;
            case IS_VIOLATED:
                str.append("(");
                str.append(exp.getConnective().getImage());
                str.append(")");
                break;
            case LESS_ORDERING_CONSTRAINT:
                str.append("(");
                str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(exp.getChildren().get(0).getTaskID());
                str.append(" ");
                str.append(exp.getConnective().getImage());
                str.append(" ");
                str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(exp.getChildren().get(1).getTaskID());
                str.append(")");
                break;
            default:
                str.append("DEFAULT");
                break;
        }
        return str.toString();
    }
}
