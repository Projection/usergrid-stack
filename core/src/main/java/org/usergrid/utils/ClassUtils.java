/*******************************************************************************
 * Copyright 2012 Apigee Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.usergrid.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClassUtils extends org.apache.commons.lang.ClassUtils {

	@SuppressWarnings("unchecked")
	public static <A> Class<A> tryGetClass(Class<A> baseCls, String className) {

		try {
			Class<A> cls = (Class<A>) Class.forName(className);
			if (cls != null) {
				return cls;
			}
		} catch (ClassCastException e) {
			// logger.warn("Unable to convert to a typed entity (" + entityType
			// + "): " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// logger.warn("Unable to convert to a typed entity (" + entityType
			// + "): " + e.getMessage());
		}

		return null;

	}

	@SuppressWarnings("unchecked")
	public static <A, B> B cast(A a) {
		return (B) a;
	}

	@SuppressWarnings("unchecked")
	private static final Set<Class<?>> WRAPPER_TYPES = new HashSet<Class<?>>(
			Arrays.asList(Boolean.class, Byte.class, Character.class,
					Double.class, Float.class, Integer.class, Long.class,
					Short.class, Void.class));

	public static boolean isWrapperType(Class<?> clazz) {
		return WRAPPER_TYPES.contains(clazz);
	}

	public static boolean isWrapperType2(Class<?> clazz) {
		if (clazz == null) {
			return false;
		}
		return clazz.equals(Boolean.class) || clazz.equals(Integer.class)
				|| clazz.equals(Character.class) || clazz.equals(Byte.class)
				|| clazz.equals(Short.class) || clazz.equals(Double.class)
				|| clazz.equals(Long.class) || clazz.equals(Float.class);
	}

	public static boolean isPrimitiveType(Class<?> clazz) {
		if (clazz == null) {
			return false;
		}
		return clazz.isPrimitive() || isWrapperType(clazz);
	}

	public static boolean isBasicType(Class<?> clazz) {
		if (clazz == null) {
			return false;
		}
		return (String.class.isAssignableFrom(clazz)) || isPrimitiveType(clazz);
	}

}
