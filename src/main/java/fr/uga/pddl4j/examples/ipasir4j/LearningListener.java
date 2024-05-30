package fr.uga.pddl4j.examples.ipasir4j;

/*-
 * #%L
 * Java binidngs for the IPASIR C interface
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2020 Live Ontologies Project
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 * A listener that can be notified about clauses learned by an
 * {@link IpasirSolver}.
 *
 * @author Yevgeny Kazakov
 *
 * @see IpasirSolver#setLearningListener(int, LearningListener)
 *
 */
public interface LearningListener {

	/**
	 * Notifies about a new clause learned by the solver. The literals of this
	 * clause can be read using the {@link ClauseReader} object provided in the
	 * argument of this method. This {@link ClauseReader} can be used only
	 * during the call of this method.
	 *
	 * @param reader
	 *            a {@link ClauseReader} using which the literals of the learned
	 *            clause can be read
	 */
	void clauseLearned(ClauseReader reader);

}
