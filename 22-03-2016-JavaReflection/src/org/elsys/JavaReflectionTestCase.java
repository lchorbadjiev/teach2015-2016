package org.elsys;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JavaReflectionTestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClassName() {
		Bar bar = new Bar("hello");
		Class aClass = bar.getClass();
		System.out.println("class name: " + aClass.getName());
	}

	@Test
	public void testClassClass() {
		Class aClass = Bar.class;
		System.out.println("class name: " + aClass.getName());
	}

	@Test
	public void testClassForName() throws ClassNotFoundException {
		Class aClass = Class.forName("org.elsys.Bar");
		System.out.println("class for name: " + aClass.getName());

	}

	@Test
	public void testClassModifiers() {
		Class aClass = Bar.class;
		int modifiers = aClass.getModifiers();

		System.out.println("isAbstract: " + Modifier.isAbstract(modifiers));
		System.out.println("isPublic: " + Modifier.isPublic(modifiers));
		System.out.println("isFinal: " + Modifier.isFinal(modifiers));
	}
	
	
	@Test
	public void testClassMethods() {
		Class aClass = Bar.class;
		Method[] methods = aClass.getMethods();

		for (Method m : methods) {
			System.out.println("method name: " + m.getName());
			Parameter[] parameters = m.getParameters();
			for(Parameter p: parameters) {
				System.out.println("  >> param: " + p.getType().getName());
			}
		}
	}
	
	@Test
	public void testClassConstructors() {
		Class aClass = Bar.class;
		Constructor[] constructors = aClass.getConstructors();
		for(Constructor c: constructors) {
			System.out.println("constructor: " + c.toString());
			Parameter[] parameters = c.getParameters();
			for(Parameter p: parameters) {
				System.out.println("  >> param: " + p.getType().getName());
			}
		}
	}
	
	@Test
	public void testSuperclass() {
		Class aClass = Bar.class;
		System.out.println("superclass: " + aClass.getSuperclass().getName());
	}
	
	@Test
	public void testInterfaces() {
		Class aClass = Bar.class;
		Class[] interfaces = aClass.getInterfaces();
		for(Class i: interfaces) {
			System.out.println("interface: " + i.getName());
		}
	}
	
	@Test
	public void testConstructorCreateInstance() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, Exception, Exception {
		Class aClass = Bar.class;
		Constructor constructor = aClass.getConstructor(String.class);
		assertNotNull(constructor);
		
		
		Bar bar = (Bar) constructor.newInstance("hello");
		assertNotNull(bar);
		assertEquals("hello", bar.getBar());
	}
	
	@Test
	public void testConstructorCreateInstance1() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, Exception, Exception {
		Class<Bar> aClass = Bar.class;
		Constructor<Bar> constructor = aClass.getConstructor(String.class);
		assertNotNull(constructor);
		
		
		Bar bar = constructor.newInstance("hello");
		assertNotNull(bar);
		assertEquals("hello", bar.getBar());
	}
	
	@Test
	public void testMethodInvoke() throws Exception {
		Class<Bar> aClass = Bar.class;
		
		Method method=aClass.getMethod("getBar");
		
		Bar bar = new Bar("rab");
		
		assertEquals("rab", method.invoke(bar));
	}
	
	
//	@Test
//	public void testThrowRuntimeException() {
//		throw new NullPointerException();
//	}
//	
//	@Test
//	public void testThrowException() throws ClassNotFoundException {
//		throw new ClassNotFoundException();
//	}


	@Test
	public void testFooAnnotation() {
		Class<Bar> aClass = Bar.class;
		
		Annotation[] annotations = aClass.getAnnotations();
		for(Annotation a: annotations) {
			System.out.println("annotation: " + a.toString());
		}
	}

	
	@Test
	public void testAnnotationMethods() {
		Class<Bar> aClass = Bar.class;

		Method[] methods = aClass.getMethods();
		for(Method m: methods) {
			Annotation[] annotations = m.getAnnotations();
			for(Annotation a: annotations) {
				System.out.println("method: " + m.getName() + "; " + a.toString());
			}
		}
	}



}

	
	
	
	
	
	
	
