package org.elsys.postfix;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PostfixTestCase {

	private Postfix postfix;
	
	@Before
	public void setUp() throws Exception {
		postfix = new Postfix();
		postfix.addOperation(new Plus());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Scanner scanner = new Scanner("10 20 +");
		postfix.interpret(scanner);
		
		Stack<Double> context = postfix.getContext();
		
		assertEquals(1, context.size());
		assertEquals(30.0, context.pop(), 0.000001);
	}

}
