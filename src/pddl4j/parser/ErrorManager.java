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
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class implements the error manager used by the parser and java PDDL compiler.
 * 
 * @author D. Pellier
 * @version 1.3 - 28.01.2010
 */
public class ErrorManager implements Serializable {

	/**
	 * The set used to store the messages.
	 */
	private SortedSet<Message> msg;

	/**
	 * Creates a new error manager.
	 */
	public ErrorManager() {
		this.msg = new TreeSet<Message>();
	}

	/**
	 * Print the messages log in the error manager.
	 * 
	 * @param type the type of message to print.
	 */
	public void print(Message.Type type) {
		this.print(this.getMessages(type), System.out);
	}

	/**
	 * Print the messages log in the error manager that concerns a specific file.
	 * 
	 * @param file The file.
	 */
	public void print(File file) {
		this.print(this.getMessages(file), System.out);
	}

	/**
	 * Print the messages log in the error manager of a specific and concerning a specific file.
	 * 
	 * @param type the type of message to print.
	 * @param file the file.
	 */
	public void print(Message.Type type, File file) {
		this.print(this.getMessages(type, file), System.out);
	}

	/**
	 * Print the message to the current output stream.
	 * 
	 * @param messages the list of messages to print.
	 * @param out the print stream where the message must be printed.
	 */
	private void print(Collection<Message> messages, PrintStream out) {
		if (messages != null) {
			for (Message msg : messages) {
				out.println(msg);
			}
		}
	}
	
	/**
	 * Print the all the message of the error manager.
	 */
	public void printAll() {
		this.print(this.msg, System.out);
	}
	
	/**
	 * Returns the list of messages that concerns a specific file.
	 * 
	 * @param file The file.
	 * @return The list of messages.
	 */
	public Set<Message> getMessages(File file) {
		Set<Message> messages = new LinkedHashSet<Message>();
		for (Message msg : this.msg) {
			if (msg.getFile().equals(file)) {
				messages.add(msg);
			}
		}
		return messages;
	}

	/**
	 * Returns the list of messages of a specific type concerning a specific file.
	 * 
	 * @param type The type of messages.
	 * @param file The file.
	 * @return The list of messages of a specific type concerning a specific file.
	 */
	public Set<Message> getMessages(Message.Type type, File file) {
		Set<Message> messages = new LinkedHashSet<Message>();
		for (Message msg : this.msg) {
			if (msg.getType().equals(type) && msg.getFile().equals(file)) {
				messages.add(msg);
			}
		}
		return messages;
	}

	/**
	 * Returns the list of messages of a specific type.
	 * 
	 * @param type The type of messages.
	 * @return The list of messages of a specific type
	 */
	public Set<Message> getMessages(Message.Type type) {
		Set<Message> messages = new LinkedHashSet<Message>();
		for (Message msg : this.msg) {
			if (msg.getType().equals(type)) {
				messages.add(msg);
			}
		}
		return messages;
	}
	
	/**
	 * Initialize the error manager.
	 */
	public void clear() {
		this.msg.clear();
	}

	/**
	 * Returns if the error manager is empty, i.e., contains no message of any
	 * type.
	 * 
	 * @return <code>true</code> if the error manager is empty;
	 *         <code>false</code> otherwise.
	 */
	public boolean isEmpty() {
		return this.msg.isEmpty();
	}

	/**
	 * Log an error message to the current print stream.
	 * 
	 * @param msg the error message.
	 * @param file the file where the warning was encoutered.
	 * @param line the line of the error.
	 * @param column the column of the error.
	 */
	public void logParserError(String msg, File file, int line, int column) {
		this.msg.add(new Message(Message.Type.PARSER_ERROR, line, column, file, msg));
	}

	/**
	 * Log an lexical error message.
	 * 
	 * @param msg the error message.
	 * @param file the file where the error was encoutered.
	 * @param line the line of the error.
	 * @param column the column of the error.
	 */
	public void logLexicalError(String msg, File file, int line, int column) {
		this.msg.add(new Message(Message.Type.LEXICAL_ERROR, line, column, file, msg));
	}

	/**
	 * Log a warning message to the current print stream.
	 * 
	 * @param msg the warning message.
	 * @param file the file where the warning was encoutered.
	 * @param line the line of the warning.
	 * @param column the column of the warning.
	 */
	public void logParserWarning(String msg, File file, int line, int column) {
		this.msg.add(new Message(Message.Type.PARSER_WARNING, line, column, file, msg));
	}

}
