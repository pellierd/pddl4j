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

package pddl4j.util;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * This class implements memory agent enable to compute approximation of the size of java objects.
 * In order to start this agent you must add the following option to the command-line:
 * <pre>
 * -javaagent:pddl4j.jar
 * </pre>
 * Then, to know the size of an object just the class <code>MemoryAgent</code>. For instance:
 * <pre>
 * // Configuration
 * MemoryAgent.skipFinalField(false);
 * MemoryAgent.skipFlyweightObject(false);
 * MemoryAgent.skipStaticField(false);
 *	
 * // Calculate object size
 * MemoryAgent.deepSizeOf(objectToSize);
 * </pre>		 
 * 
 * @author D. Pellier
 * @version 1.0 - 14.06.2010
 * @see java.lang.instrument.Instrumentation
 */
public class MemoryAgent {

	/**
	 * Instance of <code>java.lang.instrument.Instrument</code> injected by the Java VM.
	 * 
	 * @see java.lang.instrument.Instrumentation
	 */
	private static Instrumentation instrumentation;

	/**
	 * The default value of the <code>SKIP_STATIC_FIELD</code> flag.
	 */
	public static boolean DEFAULT_SKIP_STATIC_FIELD = false;

	/**
	 * The flag used to indicate if static field must be skip during the computation process.
	 */
	private static boolean SKIP_STATIC_FIELD = MemoryAgent.DEFAULT_SKIP_STATIC_FIELD;

	/**
	 * The default value of the <code>SKIP_FINAL_FIELD</code> flag.
	 */
	public static boolean DEFAULT_SKIP_FINAL_FIELD = false;

	/**
	 * The flag used to indicate if final field must be skip during the computation process.
	 */
	private static boolean SKIP_FINAL_FIELD = MemoryAgent.DEFAULT_SKIP_FINAL_FIELD;

	/**
	 * The default value of the <code>SKIP_FLYWEIGHT_FIELD</code> flag.
	 */
	public static boolean DEFAULT_SKIP_FLYWEIGHT_FIELD = false;

	/**
	 * The flag used to indicate if flyweight field must be skip during the computation process.
	 */
	private static boolean SKIP_FLYWEIGHT_FIELD = MemoryAgent.DEFAULT_SKIP_FLYWEIGHT_FIELD;
	
	/**
	 * Creates a new <code>MemoryAgent</code>.
	 */
	public MemoryAgent() {
		super();
	}
	
	/**
	 * Call back method used by the Java VM to inject the
	 * <code>java.lang.instrument.Instrument</code> instance.
	 * 
	 * @param options the options of the agent.
	 * @param instrumentation the instrumentation object injected.
	 */
	public static void premain(String options, Instrumentation instrumentation) {
		MemoryAgent.instrumentation = instrumentation;
	}

	/**
	 * Allows to skip the final field while computing the deep size of an object. Default value is
	 * Default value is <code>MemoryAgent.DEFAULT_SKIP_FINAL_FIELD</code>.
	 * 
	 * @param flag <code>true</code> the final field must be skip; <code>false</code> otherwise.
	 */
	public static void skipFinalField(boolean flag) {
		MemoryAgent.SKIP_FINAL_FIELD = flag;
	}

	/**
	 * Allows to skip the static field while computing the deep size of an object. Default value is
	 * Default value is <code>MemoryAgent.DEFAULT_SKIP_FINAL_FIELD</code>.
	 * 
	 * @param flag <code>true</code> the static field must be skip; <code>false</code> otherwise.
	 */
	public static void skipStaticField(boolean flag) {
		MemoryAgent.SKIP_STATIC_FIELD = flag;
	}

	/**
	 * Allows to skip the flyweight object. If true flyweight objects has a size of 0. Default value
	 * is <code>MemoryAgent.DEFAULT_SKIP_FLYWEIGHT_FIELD</code>.
	 * 
	 * @param flag <code>true</code> the flyweight object must be skip; <code>false</code> otherwise.
	 */
	public static void skipFlyweightObject(boolean flag) {
		MemoryAgent.SKIP_FLYWEIGHT_FIELD = flag;
	}

	/**
	 * Returns an implementation-specific approximation of the amount of storage consumed by the
	 * specified object in bytes. The result may include some or all of the object's overhead, and
	 * thus is useful for comparison within an implementation but not between implementations. The
	 * estimate may change during a single invocation of the JVM. The method counts only the
	 * primitive contained in the specified object.
	 * 
	 * @param object the object to size
	 * @return an implementation-specific approximation of the amount of storage consumed by the
	 *         specified object in bytes.
	 * @see java.lang.instrument.Instrumentation#getObjectSize(Object)
	 */
	public static long sizeOf(Object object) {
		if (MemoryAgent.instrumentation == null)
			throw new IllegalStateException("Instrumentation environment not initialised.");
		if (MemoryAgent.SKIP_FLYWEIGHT_FIELD && MemoryAgent.isSharedFlyweight(object))
			return 0;
		return MemoryAgent.instrumentation.getObjectSize(object);
	}

	/**
	 * Compute an implementation-specific approximation of the amount of storage consumed by
	 * object and by all the objects reachable from it
	 * 
	 * @param object the object to size.
	 * @return an implementation-specific approximation of the amount of storage consumed by
	 *         objectToSize and by all the objects reachable from it
	 */
	public static long deepSizeOf(Object object) {
		final Map<Object, Object> doneObj = new IdentityHashMap<Object, Object>();
		return MemoryAgent.deepSizeOf(object, doneObj, 0);
	}

	/**
	 * Returns the deep size of an specified object in bytes.
	 * 
	 * @param obj the object to compute.
	 * @param doneObj the map of objects already computed.
	 * @param depth the depth of the computation.
	 * @return the deep size of an specified object.
	 */
	private static long deepSizeOf(Object obj, Map<Object, Object> doneObj, int depth) {
		if (obj == null) {
			return 0;
		}
		long size = 0;
		if (doneObj.containsKey(obj)) {
			return 0;
		}
		doneObj.put(obj, null);
		size = sizeOf(obj);
		if (obj instanceof Object[]) {
			for (Object o : (Object[]) obj) {
				size += deepSizeOf(o, doneObj, depth + 1);
			}
		} else {
			final Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				final Object o;
				try {
					o = field.get(obj);
				} catch (IllegalArgumentException e) {
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
				if (MemoryAgent.isComputable(field)) {
					size += MemoryAgent.deepSizeOf(o, doneObj, depth + 1);
				}
			}
		}
		return size;
	}

	/**
	 * Returns <code>true</code> if the specified class is a primitive type.
	 * 
	 * @param clazz the class.
	 * @return <code>true</code> if the specified class is a primitive type; <code>false</code>
	 *         otherwise.
	 */
	@SuppressWarnings("unchecked")
	private static boolean isPrimitiveType(final Class clazz) {
		return clazz == java.lang.Boolean.TYPE || clazz == java.lang.Character.TYPE
				|| clazz == java.lang.Byte.TYPE || clazz == java.lang.Short.TYPE
				|| clazz == java.lang.Integer.TYPE || clazz == java.lang.Long.TYPE
				|| clazz == java.lang.Float.TYPE || clazz == java.lang.Double.TYPE
				|| clazz == java.lang.Void.TYPE;
	}

	/**
	 * Returns <code>true</code> if the size of the specified field can be computed.
	 * 
	 * @param field the field.
	 * @return <code>true</code> if the size of the specified field can be computed;
	 *         <code>false</code>otherwise.
	 */
	private static boolean isComputable(final Field field) {
		final int modificatori = field.getModifiers();
		if (MemoryAgent.isPrimitiveType(field.getType())) {
			return false;
		} else if (MemoryAgent.SKIP_STATIC_FIELD && Modifier.isStatic(modificatori)) {
			return false;
		} else if (MemoryAgent.SKIP_FINAL_FIELD && Modifier.isFinal(modificatori)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns <code>true</code> if the specified object is a well-known shared flyweight. For
	 * example, interned Strings, Booleans and Number objects (see
	 * http://www.javaspecialists.co.za/archive/Issue142.html
	 * 
	 * @param obj the object.
	 * @return <code>true</code> if the specified object is a well-known shared flyweight;
	 *         <code>false</code> otherwise.
	 */
	private static boolean isSharedFlyweight(Object obj) {
		if (obj instanceof Comparable) {
			if (obj instanceof Enum) {
				return true;
			} else if (obj instanceof String) {
				return (obj == ((String) obj).intern());
			} else if (obj instanceof Boolean) {
				return (obj == Boolean.TRUE || obj == Boolean.FALSE);
			} else if (obj instanceof Integer) {
				return (obj == Integer.valueOf((Integer) obj));
			} else if (obj instanceof Short) {
				return (obj == Short.valueOf((Short) obj));
			} else if (obj instanceof Byte) {
				return (obj == Byte.valueOf((Byte) obj));
			} else if (obj instanceof Long) {
				return (obj == Long.valueOf((Long) obj));
			} else if (obj instanceof Character) {
				return (obj == Character.valueOf((Character) obj));
			}
		}
		return false;
	}
}
