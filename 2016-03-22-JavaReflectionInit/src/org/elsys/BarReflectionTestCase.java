package org.elsys;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BarReflectionTestCase {

	@Before
	public void setUp() throws Exception {
		System.out.println("------------------------------------------------------------------------");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMethods() {
		Method[] methods = Bar.class.getMethods();
		for (Method method : methods) {
			System.out.println("method = " + method.getName());
		}
	}

	@Test
	public void testClassName() {
		// Bar bar = new Bar("aaaa");
		Class<?> aClass = Bar.class;
		// Class<?> aClass1 = bar.getClass();

		System.out.println("class name: " + aClass.getName());
		System.out.println("class cononical name: " + aClass.getCanonicalName());
	}

	@Test
	public void testClassModifiers() {
		Class<?> aClass = Bar.class;
		int modifiers = aClass.getModifiers();

		System.out.println("Bar isAbstract: " + Modifier.isAbstract(modifiers));
		System.out.println("Bar isPublic: " + Modifier.isPublic(modifiers));
	}

	@Test
	public void testClassGetPackage() {
		Class<?> aClass = Bar.class;
		Package aPackage = aClass.getPackage();
		System.out.println("package: " + aPackage.getName());
	}

	@Test
	public void testClassGetSuperclass() {
		Class<?> aClass = Bar.class;
		Class<?> superClass = aClass.getSuperclass();

		System.out.println("superclass is: " + superClass.getName());
	}

	@Test
	public void testClassGetInterfaces() {
		Class<?> aClass = Bar.class;
		Class<?>[] interfaces = aClass.getInterfaces();

		for (Class<?> c : interfaces) {
			System.out.println("interface: " + c.getName());
		}
	}

	@Test
	public void testClassGetFields() {
		Field[] fields = Bar.class.getFields();
		for (Field f : fields) {
			System.out.println("field: " + f.getName());
		}
	}

	@Test
	public void testClassConstructor() {
		Constructor<?>[] constructors = Bar.class.getConstructors();
		for (Constructor<?> c : constructors) {
			System.out.println("constructor: " + c.getName());
			for (Parameter p : c.getParameters()) {
				System.out.println("constructor parmater: " + p.getName() + "; " + p.getType().getName());
			}
		}
	}

	@Test
	public void testClassCreateInstance() throws Exception {
		Constructor<Bar> constructor = Bar.class.getConstructor(String.class);
		assertNotNull(constructor);
		Bar bar = constructor.newInstance("hello");
		assertEquals("hello", bar.getBar());
	}

	@Test
	public void testMethodCall() throws Exception {
		Method method = Bar.class.getMethod("getBar");
		assertNotNull(method);

		Bar bar = new Bar("bye");
		assertEquals("bye", method.invoke(bar));
	}

	@Test
	public void testFieldValues() throws Exception {
		Bar bar = new Bar("hello");

		Field[] fields = Bar.class.getDeclaredFields();

		System.out.println("fields len: " + fields.length);
		for (Field f : fields) {
			System.out.println("field name:" + f.getName());
			f.setAccessible(true);
			System.out.println("name: " + f.getName() + ", value: " + f.get(bar));
		}

	}

	@Test
	public void testFieldValuesWithIgnore() throws Exception {
		// Bar bar = new Bar("hello");

		Field[] fields = Bar.class.getDeclaredFields();

		System.out.println("fields len: " + fields.length);
		for (Field f : fields) {
			System.out.println("field name:" + f.getName());
			f.setAccessible(true);
			Annotation ignore = f.getAnnotation(Ignore.class);
			if (ignore != null) {
				System.out.println("Ignore");
			} else {
				System.out.println("Dont Ignore");
			}
		}

	}

}
