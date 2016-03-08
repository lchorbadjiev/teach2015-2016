package org.elsys.learn;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EqualsAndHashCodeTestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringEquals() {
		String s1 = new String("hello");
		String s2 = new String("hello");

		assertTrue(s1.equals(s2));
	}

	@Test
	public void testNameEquals() {
		Name n1 = new Name("pesho", "peshev");
		Name n2 = new Name("pesho", "peshev");
		Name n3 = n1;
		assertTrue(n1.equals(n3));
		assertTrue(n1.equals(n2));

		assertFalse(n1.equals("ala bala"));

	}

	@Test
	public void testNameEqualsWithNull() {
		Name n1 = new Name("pesho", "peshev");
		assertFalse(n1.equals(null));

		assertFalse(null instanceof Name);
	}

	@Test
	public void testStringHashCode() {
		String s1 = "pesho";
		String s2 = "pesho";
		String s3 = "gosho";

		assertEquals(s1.hashCode(), s2.hashCode());
		assertNotEquals(s1.hashCode(), s3.hashCode());
	}

	@Test
	public void testNameHashCode() {
		Name n1 = new Name("pesho", "peshev");
		Name n2 = new Name("pesho", "peshev");
		Name n3 = n1;

		assertEquals(n1.hashCode(), n3.hashCode());
		assertEquals(n1.hashCode(), n2.hashCode());
	}
	
	@Test
	public void testStringHashCollection() {
		HashSet<String> set = new HashSet<String>();
		set.add("pesho");
		set.add("gosho");
		
		assertTrue(set.contains("pesho"));
		assertTrue(set.contains("gosho"));
	}
	
	@Test
	public void testNameHashCollection() {
		HashSet<Name> set = new HashSet<Name>();
		set.add(new Name("pesho", "peshev"));
		set.add(new Name("gosho", "peshev"));
		
		assertTrue(set.contains(new Name("pesho", "peshev")));
	}
	
	@Test
	public void testNameHashCollectionSwap() {
		Name n1 = new Name("a", "b");
		Name n2 = new Name("b", "a");
		
		assertNotEquals(n1.hashCode(), n2.hashCode());
	}
}
