package fr.uga.pddl4j.examples.ipasir4j;

import java.util.NoSuchElementException;

/*-
 * #%L
 * JNA interfaces for IPASIR
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

import com.sun.jna.Pointer;

/**
 * A {@link ClauseReader} for reading the content of a clause using its pointer.
 *
 * @author Yevgeny Kazakov
 *
 * @see JNALearnCallback
 */
public class JNAClauseReader implements ClauseReader {

	/**
	 * the pointer to the clause that is being read
	 */
	private final Pointer clause_;
	/**
	 * the offset for the part of the clause that has been already read
	 */
	private int offset_ = 0;

	/**
	 * {@code true} if all literals of the clause have been read
	 */
	private boolean endOfClause_ = false;

	public JNAClauseReader(Pointer clause) {
		this.clause_ = clause;
	}

	@Override
	public int getNextLiteralOrZero() {
		if (endOfClause_) {
			throw new NoSuchElementException("End of clause has been reached!");
		}
		int result = clause_.getInt(offset_);
		offset_ += 4;
		if (result == 0) {
			endOfClause_ = true;
		}
		return result;
	}

}
