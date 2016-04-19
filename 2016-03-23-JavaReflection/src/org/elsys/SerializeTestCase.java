package org.elsys;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SerializeTestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckFields() {
		Class aClass = Bar.class;
		Field[] fields = aClass.getFields();
		System.out.println("how many fields: " + fields.length);
		
		fields = aClass.getDeclaredFields();
		System.out.println("how many fields: " + fields.length);
	}
	
	@Test
	public void testFieldsValues() {
		Bar bar = new Bar("ala", "bala");
		Class aClass = bar.getClass();
		Field[] fields = aClass.getDeclaredFields();
		for(Field f: fields) {
			System.out.println("name: " + f.getName());
			f.setAccessible(true);
			try {
				System.out.println("value:" + f.get(bar));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testSerializeInitial() throws IllegalArgumentException, IllegalAccessException {
		Bar bar = new Bar("ala", "bala");
		Class aClass = bar.getClass();
		Field[] fields = aClass.getDeclaredFields();
		List<String> result = new ArrayList<String>();
		for(Field f: fields) {
			StringBuffer buffer = new StringBuffer();
			f.setAccessible(true);
			buffer.append(f.getName());
			buffer.append(": ");
			Object val = f.get(bar);
			buffer.append("\"");
			buffer.append(val);
			buffer.append("\"");
			System.out.println(buffer);
			result.add(buffer.toString());
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("{");
		buffer.append(String.join(", ", result));
		buffer.append("}");
		System.out.println(buffer);
		
	}
	
	
	@Test
	public void testAnnotationIgnore() {
		Bar bar = new Bar("ala", "bala");
		Class aClass = bar.getClass();
		Field[] fields = aClass.getDeclaredFields();
		for(Field f: fields) {
			Annotation ignore = f.getAnnotation(Ignore.class);
			if(ignore != null) {
				System.out.println("name: " + f.getName() + " Ignore!!!!");
			} else {
				// dont ignore
			}
		}
	}
}
