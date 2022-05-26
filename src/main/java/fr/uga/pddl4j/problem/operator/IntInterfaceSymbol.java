package fr.uga.pddl4j.problem.operator;
/*
 * Copyright (c) 2022 by Damien Pellier <Damien.Pellier@imag.fr>.
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

import java.io.Serializable;

/**
 * This interface defines the interface of the symbols.
 *
 * @author D. Pellier
 * @version 1.0 - 23.05.2022
 */
public interface IntInterfaceSymbol extends Cloneable, Serializable {

    /**
     * Returns a deep copy of the symbol.
     *
     * @return a deep copy of the symbol.
     */
    IntInterfaceSymbol clone();

    /**
     * Returns the image of the symbol.
     *
     * @return the image of the symbol.
     */
    String getImage();

}
