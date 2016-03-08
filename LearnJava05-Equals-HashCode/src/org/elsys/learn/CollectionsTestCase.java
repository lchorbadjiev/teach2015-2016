package org.elsys.learn;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CollectionsTestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testColelctionIterator() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);

		assertEquals(2, list.size());

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int val = it.next();
			System.out.println(val);
		}

		for (int val : list) {
			System.out.println(val);
		}
	}

}