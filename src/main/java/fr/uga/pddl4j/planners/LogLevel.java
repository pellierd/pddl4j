/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.planners;

import org.apache.logging.log4j.Level;
import picocli.CommandLine;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class implements the log level for the trace of the planners.
 *
 * @author D. Pellier
 * @version 1.0 - 19.11.2021
 * @since 4.0
 */
public class LogLevel implements Serializable, CommandLine.ITypeConverter<LogLevel> {

    /**
     * The highest possible rank and is intended to turn off logging.
     */
    public static final LogLevel OFF = new LogLevel(Level.OFF);

    /**
     * Designates very severe error events that will presumably lead the application to abort.
     */
    public static final LogLevel FATAL = new LogLevel(Level.FATAL);

    /**
     * Designates error events that might still allow the application to continue running.
     */
    public static final LogLevel ERROR = new LogLevel(Level.ERROR);

    /**
     * Designates potentially harmful situations.
     */
    public static final LogLevel WARM = new LogLevel(Level.WARN);

    /**
     * Designates informational messages that highlight the progress of the application at coarse-grained level.
     */
    public static final LogLevel INFO = new LogLevel(Level.INFO);

    /**
     * Designates fine-grained informational events that are most useful to debug an application.
     */
    public static final LogLevel DEBUG = new LogLevel(Level.DEBUG);

    /**
     * Designates finer-grained informational events than the DEBUG.
     */
    public static final LogLevel TRACE = new LogLevel(Level.TRACE);

    /**
     * All levels including custom levels.
     */
    public static final LogLevel ALL = new LogLevel(Level.ALL);

    /**
     * The default level of the log.
     */
    public static final Level DEFAULT_LEVEL = Level.INFO;

    /**
     * The level of the log.
     */
    private Level level;

    /**
     * Creates a log level with the default level.
     */
    public LogLevel() {
        this.level = Level.INFO;
    }

    /**
     * Creates a log level with a specified level.
     *
     * @param level the level.
     */
    public LogLevel(Level level) {
        this.level = level;
    }

    /**
     * Creates a log level with a specified level as a string.
     *
     * @param level the sting level.
     */
    public LogLevel(String level) {
        this.level = Level.toLevel(level);
    }

    /**
     * Sets the level.
     *
     * @param level the level.
     *
     */
    public final void setLevel(final Level level) {
        this.level = level;
    }

    /**
     * Returns the level.
     *
     * @return the level.
     */
    public final Level getLevel() {
        return this.level;
    }

    /**
     * Convert a string value into a log level. The string accepted are: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE,
     * WARN. The string value in parameter is not case-sensitive.
     *
     * @param value the string value to be converted.
     * @return the log corresponding.
     * @throws IllegalArgumentException if the value cannot be converted into a log l©evel.
     */
    public LogLevel convert(final String value) throws IllegalArgumentException {
        final String upper = value.toUpperCase();
        switch (upper) {
            case "ALL" : return LogLevel.ALL;
            case "DEBUG" : return LogLevel.DEBUG;
            case "ERROR" : return LogLevel.ERROR;
            case "FATAL" : return LogLevel.FATAL;
            case "INFO" : return LogLevel.INFO;
            case "OFF" : return LogLevel.OFF;
            case "TRACE" : return LogLevel.TRACE;
            case "WARN": return LogLevel.WARM;
            default:
                throw new IllegalArgumentException(upper + " is not a valid log level.");
        }
    }

    /**
     * Returns if this object is equals to another.
     *
     * @param obj the object to be compared
     * @return <code>true</code> if this object is equals to the object in parameter <code>false</code> otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        final LogLevel log = (LogLevel) obj;
        return Objects.equals(this.getLevel(), log.getLevel());
    }

    /**
     * Returns the hash code value of this object.
     *
     * @return the hash code value of this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getLevel());
    }

    /**
     * Returns a string representation of this log.
     *
     * @return a string representation of this log.
     */
    public String toString() {
        return this.getLevel().toString();
    }
}
