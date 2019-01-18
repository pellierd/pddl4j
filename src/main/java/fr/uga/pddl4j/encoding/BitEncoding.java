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

package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.exceptions.UnexpectedExpressionException;
import fr.uga.pddl4j.parser.Connective;
import fr.uga.pddl4j.util.BitExp;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.CondBitExp;
import fr.uga.pddl4j.util.IntExp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * This class contains methods to encode operators, goal and initial state into <code>BitSet</code>
 * representation.
 * </p>
 * <p>
 * Before encoding, every expression is normalized, i.e., put in disjunctive normal form (DNF) for
 * preconditions and put in conjunctive normal form (CNF) for effects. If an operator has disjunctive
 * preconditions, a new operator is created such all operators after normalization have only
 * conjunctive precondition.
 * </p>
 * <p>
 * <b>Notes:</b>
 * </p>
 * <ul>
 * <li> the problem of converting a well form formula of the first order-logic into DNF of CNF is
 * exponential. </li>
 * <li>The method does not compute the shorter DNF or CNF formula. If you want it have a look to
 * the Quine and McCluskey algorithm.</li>
 * </ul>
 *
 * @author D. Pellier
 * @version 1.0 - 10.06.2010
 */
final class BitEncoding implements Serializable {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The logger of the class.
     */
    private static final Logger LOGGER = LogManager.getLogger(BitEncoding.class);

    /**
     * The default constructor with a private access to prevent instance creation.
     */
    private BitEncoding() {
    }

    /**
     * Encode a list of specified operators into <code>BitSet</code> representation. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param operators the list of operators to encode.
     * @param map       the map that associates to a specified expression its index.
     * @return the list of operators encoded into bit set.
     */
    static List<BitOp> encodeOperators(final List<IntOp> operators, final Map<IntExp, Integer> map)
        throws UnexpectedExpressionException {

        // Normalize the operators
        BitEncoding.normalize(operators);

        final List<BitOp> ops = new ArrayList<>(operators.size());
        for (IntOp op : operators) {
            final int arity = op.getArity();
            final BitOp bOp = new BitOp(op.getName(), arity);
            bOp.setCost(op.getCost());

            // Initialize the parameters of the operator
            for (int i = 0; i < arity; i++) {
                bOp.setValueOfParameter(i, op.getValueOfParameter(i));
                bOp.setTypeOfParameter(i, op.getTypeOfParameters(i));
            }

            // Initialize the preconditions of the operator
            bOp.setPreconditions(BitEncoding.encode(op.getPreconditions(), map));

            // Initialize the effects of the operator
            final List<IntExp> effects = op.getEffects().getChildren();

            final CondBitExp unCondEffects = new CondBitExp();
            boolean hasUnConditionalEffects = false;
            for (IntExp ei : effects) {
                final Connective connective = ei.getConnective();
                final List<IntExp> children = ei.getChildren();
                if (connective.equals(Connective.WHEN)) {
                    final CondBitExp condBitExp = new CondBitExp();
                    condBitExp.setCondition(BitEncoding.encode(children.get(0), map));
                    condBitExp.setEffects(BitEncoding.encode(children.get(1), map));
                    bOp.getCondEffects().add(condBitExp);
                } else if (connective.equals(Connective.ATOM)) {
                    final Integer index = map.get(ei);
                    if (index != null) {
                        unCondEffects.getEffects().getPositive().set(index);
                        hasUnConditionalEffects = true;
                    }
                } else if (connective.equals(Connective.TRUE)) {
                    // do nothing
                } else if (connective.equals(Connective.NOT)) {
                    final Integer index = map.get(children.get(0));
                    if (index != null) {
                        unCondEffects.getEffects().getNegative().set(index);
                        hasUnConditionalEffects = true;
                    }
                } else {
                    throw new UnexpectedExpressionException(Encoder.toString(ei));
                }
            }
            if (hasUnConditionalEffects) {
                bOp.getCondEffects().add(unCondEffects);
            }
            ops.add(bOp);
        }
        return ops;
    }

    /**
     * Encode a specified goal in a disjunction of <code>BitExp</code>. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param goal the goal to encode.
     * @param map  the map that associates to a specified expression its index.
     * @return a list of <code>BitExp</code> that represents the goal as a disjunction of
     * <code>BitExp</code>.
     */
    static BitExp encodeGoal(IntExp goal, final Map<IntExp, Integer> map) throws UnexpectedExpressionException {
        if (goal.getConnective().equals(Connective.FALSE)) {
            return null;
        }

        BitExp newGoal;
        BitEncoding.toDNF(goal);
        Encoder.codedGoal = new ArrayList<>(goal.getChildren().size());
        for (IntExp exp : goal.getChildren()) {
            if (exp.getConnective().equals(Connective.ATOM)) {
                IntExp and = new IntExp(Connective.AND);
                and.getChildren().add(exp);
                Encoder.codedGoal.add(BitEncoding.encode(and, map));
            } else {
                Encoder.codedGoal.add(BitEncoding.encode(exp, map));
            }
        }
        if (Encoder.codedGoal.size() > 1) {
            // Create a new dummy fact to encode the goal
            final int dummyPredicateIndex = Encoder.tableOfPredicates.size();
            Encoder.tableOfPredicates.add(Constants.DUMMY_GOAL);
            Encoder.tableOfTypedPredicates.add(new ArrayList<>());
            IntExp dummyGoal = new IntExp(Connective.ATOM);
            dummyGoal.setPredicate(dummyPredicateIndex);
            dummyGoal.setArguments(new int[0]);
            final int dummyGoalIndex = Encoder.tableOfRelevantFacts.size();
            Encoder.tableOfRelevantFacts.add(dummyGoal);
            map.put(dummyGoal, dummyGoalIndex);
            newGoal = new BitExp();
            newGoal.getPositive().set(dummyGoalIndex);
            final CondBitExp condEffect = new CondBitExp(newGoal);
            // for each disjunction create a dummy action
            for (BitExp dis : Encoder.codedGoal) {
                final BitOp op = new BitOp(Constants.DUMMY_OPERATOR, 0);
                op.setDummy(true);
                op.setPreconditions(dis);
                op.getCondEffects().add(condEffect);
                Encoder.operators.add(op);
            }
        } else {
            newGoal = Encoder.codedGoal.get(0);
        }
        return newGoal;
    }

    /**
     * Encode a specified initial state in it <code>BitExp</code> representation. The specified
     * map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param init the initial state to encode.
     * @param map  the map that associates to a specified expression its index.
     * @return the <code>BitExp</code> that represents the initial encoded.
     */
    static BitExp encodeInit(final Set<IntExp> init, final Map<IntExp, Integer> map) {
        final BitExp bitInit = new BitExp();
        for (final IntExp fact : init) {
            if (fact.getConnective().equals(Connective.ATOM)) {
                final Integer i = map.get(fact);
                if (i != null) {
                    bitInit.getPositive().set(i);
                }
            } else {
                final Integer i = map.get(fact.getChildren().get(0));
                if (i != null) {
                    bitInit.getNegative().set(i);
                }
            }
        }
        return bitInit;
    }

    /**
     * Encode an specified <code>IntExp</code> in its <code>BitExp</code> representation.The
     * specified map is used to speed-up the search by mapping the an expression to this index.
     *
     * @param exp the <code>IntExp</code>.
     * @param map the map that associate to a specified expression its index.
     * @return the expression in bit set representation.
     */
    private static BitExp encode(final IntExp exp, final Map<IntExp, Integer> map)
        throws UnexpectedExpressionException {
        final BitExp bitExp = new BitExp();
        if (exp.getConnective().equals(Connective.ATOM)) {
            final Integer index = map.get(exp);
            if (index != null) {
                bitExp.getPositive().set(index);
            }
        } else if (exp.getConnective().equals(Connective.NOT)) {
            final Integer index = map.get(exp.getChildren().get(0));
            if (index != null) {
                bitExp.getNegative().set(index);
            }
        } else if (exp.getConnective().equals(Connective.AND)) {
            final List<IntExp> children = exp.getChildren();
            for (IntExp ei : children) {
                if (ei.getConnective().equals(Connective.ATOM)) {
                    final Integer index = map.get(ei);
                    if (index != null) {
                        bitExp.getPositive().set(index);
                    }
                } else if (ei.getConnective().equals(Connective.NOT)) {
                    final Integer index = map.get(ei.getChildren().get(0));
                    if (index != null) {
                        bitExp.getNegative().set(index);
                    }
                } else if (ei.getConnective().equals(Connective.TRUE)) {
                    // do nothing
                } else {
                    throw new UnexpectedExpressionException(Encoder.toString(exp));
                }
            }
        } else {
            LOGGER.error(Encoder.toString(exp));
            throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
        return bitExp;
    }

    /**
     * Normalize the operators, i.e, put in disjunctive normal form (DNF) for preconditions and put
     * in conjunctive normal form (CNF) for effects. If an operator has disjunctive preconditions, a
     * new operator is created such all operators after normalization have only conjunctive
     * precondition.
     *
     * @param operators the list of operators to normalize.
     */
    private static void normalize(final List<IntOp> operators) throws UnexpectedExpressionException {
        final List<IntOp> tmpOps = new ArrayList<>(operators.size() + 100);
        for (IntOp op : operators) {
            BitEncoding.toCNF(op.getEffects());
            BitEncoding.simplify(op.getEffects());
            final IntExp precond = op.getPreconditions();
            BitEncoding.toDNF(precond);
            for (final IntExp ei : precond.getChildren()) {
                final String name = op.getName();
                final int arity = op.getArity();
                final IntOp newOp = new IntOp(name, arity);
                newOp.setCost(op.getCost());
                for (int i = 0; i < arity; i++) {
                    newOp.setTypeOfParameter(i, op.getTypeOfParameters(i));
                }
                for (int i = 0; i < arity; i++) {
                    newOp.setValueOfParameter(i, op.getValueOfParameter(i));
                }
                newOp.setPreconditions(ei);

                newOp.setEffects(new IntExp(op.getEffects()));
                tmpOps.add(newOp);
            }

        }
        operators.clear();
        operators.addAll(tmpOps);
    }

    /**
     * Remove overlapped expression from a specified expression.
     *
     * @param exp the expression.
     */
    private static void simplify(IntExp exp) {
        boolean simplified;
        int i = 0;
        do {
            simplified = false;
            final List<IntExp> children = exp.getChildren();
            while (i < children.size()) {
                final IntExp ei = children.get(i);
                if (ei.getConnective().equals(Connective.AND)
                    || ei.getConnective().equals(Connective.OR)) {
                    simplified = true;
                    children.remove(i);
                    for (IntExp ej : ei.getChildren()) {
                        children.add(i, ej);
                        i++;
                    }
                } else {
                    i++;
                }
            }
        } while (simplified);
    }

    /**
     * Convert an expression in conjunctive normal form (CNF).
     *
     * @param exp the expression to transform in CNF.
     */
    private static void toCNF(final IntExp exp) throws UnexpectedExpressionException {
        switch (exp.getConnective()) {
            case WHEN:
                final IntExp antecedent = exp.getChildren().get(0);
                final IntExp consequence = exp.getChildren().get(1);
                BitEncoding.toDNF(antecedent);
                exp.setConnective(Connective.AND);
                exp.getChildren().clear();
                for (IntExp ei : antecedent.getChildren()) {
                    final IntExp newWhen = new IntExp(Connective.WHEN);
                    newWhen.getChildren().add(ei);
                    newWhen.getChildren().add(consequence);
                    exp.getChildren().add(newWhen);
                }
                break;
            case AND:
                final List<IntExp> children = exp.getChildren();
                int i = 0;
                while (i < children.size()) {
                    final IntExp ei = children.get(i);
                    BitEncoding.toCNF(ei);
                    exp.getChildren().remove(i);
                    for (IntExp ej : ei.getChildren()) {
                        exp.getChildren().add(i, ej);
                        i++;
                    }
                }
                break;
            case ATOM:
            case NOT:
            case TRUE:
                IntExp copy = new IntExp(exp);
                exp.setConnective(Connective.AND);
                exp.getChildren().clear();
                exp.getChildren().add(copy);
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
    }

    /**
     * Convert an expression in disjunctive normal form (DNF).
     *
     * @param exp the expression to transform in DNF.
     */
    private static void toDNF(final IntExp exp) throws UnexpectedExpressionException {
        switch (exp.getConnective()) {
            case OR:
                List<IntExp> children = exp.getChildren();
                int index = 0;
                while (index < children.size()) {
                    final IntExp ei = children.get(index);
                    BitEncoding.toDNF(ei);
                    if (ei.getConnective().equals(Connective.OR)) {
                        children.remove(index);
                        for (IntExp ej : ei.getChildren()) {
                            children.add(index, ej);
                            index++;
                        }
                    }
                }
                break;
            case AND:
                children = exp.getChildren();
                for (IntExp child : children) {
                    BitEncoding.toDNF(child);
                }
                IntExp dnf = exp.getChildren().get(0);
                for (int i = 1; i < exp.getChildren().size(); i++) {
                    final IntExp orExp = exp.getChildren().get(i);
                    final IntExp newOr = new IntExp(Connective.OR);
                    for (IntExp newAnd : dnf.getChildren()) {
                        for (IntExp ek : orExp.getChildren()) {
                            ek.getChildren().stream().filter(el -> !newAnd.getChildren().contains(el)).forEach(el -> {
                                if (el.getConnective().equals(Connective.OR)
                                    || el.getConnective().equals(Connective.AND)
                                    && el.getChildren().size() == 1) {
                                    newAnd.getChildren().add(el.getChildren().get(0));
                                } else {
                                    newAnd.getChildren().add(el);
                                }
                            });
                            boolean add = true;
                            for (IntExp el : newAnd.getChildren()) {
                                if (el.getConnective().equals(Connective.FALSE)) {
                                    add = false;
                                    break;
                                }
                            }
                            if (add) {
                                if (newAnd.getChildren().size() == 1) {
                                    newOr.getChildren().add(newAnd.getChildren().get(0));
                                } else {
                                    newOr.getChildren().add(newAnd);
                                }
                            }
                        }
                    }
                    dnf = newOr;
                }
                exp.affect(dnf);
                break;
            case ATOM:
            case NOT:
            case TRUE:
                IntExp and = new IntExp(Connective.AND);
                and.getChildren().add(new IntExp(exp));
                exp.setConnective(Connective.OR);
                exp.getChildren().clear();
                exp.getChildren().add(and);
                break;
            default:
                throw new UnexpectedExpressionException(Encoder.toString(exp));
        }
    }
}
