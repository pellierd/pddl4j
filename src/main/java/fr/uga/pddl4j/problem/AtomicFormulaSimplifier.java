package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.parser.Expression;

public interface AtomicFormulaSimplifier<T> {

    boolean simplify(Expression<T> expression);

    //boolean isSimplifiable(Expression<T> expression);
}
