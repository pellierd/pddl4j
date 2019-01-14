/*
 * Copyright (c) 2016 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.  If not, see
 * <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.util;

import java.io.Serializable;
import java.util.EventListener;

/**
 * This class implements a solution listener listening solution event.
 *
 * @author E. Hermellin
 * @version 1.0 - 10.01.2019
 * @since 3.7.3
 */
public interface SolutionListener extends EventListener, Serializable {

    /**
     * Returns the solution node of the new SolutionEvent triggered by search strategy.
     *
     * @param e the triggered solution event.
     */
    void newSolutionFound(SolutionEvent e);
}
