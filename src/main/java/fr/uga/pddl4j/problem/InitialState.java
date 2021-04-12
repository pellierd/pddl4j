/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */
/*
 * Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.problem.numeric.NumericVariable;
import fr.uga.pddl4j.problem.operator.AbstractFluentDescription;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements an initial syaye, i.e., the set of known positives and negative fluents.
 *
 * @author D. Pellier
 * @version 1.0 - 28.04.2020
 * @since 4.0
 */
public class InitialState extends AbstractFluentDescription {

    /**
     * The list numeric variables and their values.
     */
    private List<NumericVariable> numericVariables;

    /**
     * Creates a new initial state from a other initial state.
     *
     * @param other the other initiam state.
     */
    public InitialState(final InitialState other) {
        super(other);
        this.numericVariables = new ArrayList<>();
        this.numericVariables.addAll(other.getNumericVariables().stream().map(NumericVariable::new)
            .collect(Collectors.toList()));
    }

    /**
     * Creates a new empty initial state.
     */
    public InitialState() {
        super();
        this.numericVariables = new ArrayList<>();
    }

    /**
     * Returns the list of numeric variables of this initial state.
     *
     * @return the list of numeric variables of this initial state.
     */
    public final List<NumericVariable> getNumericVariables() {
        return this.numericVariables;
    }

    /**
     * Sets the numeric variables of the initial state.
     *
     * @param variables the numeric variables of the state.
     */
    public final void setNumericVariables(List<NumericVariable> variables) {
        this.numericVariables = variables;
    }

    /**
     * Adds a numeric variables to the initial state.
     *
     * @param variable the variable to add.
     */
    public void addNumericFluent(NumericVariable variable) {
        this.numericVariables.add(variable);
    }

}
