package org.elsys.ballsandboxes;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is part of the Problem Set 0: Introduction for 6.170 Fall 2005.
 */
/**
 * BoxTest is a glassbox test of the Box class.
 *
 * Recall that like a BallContainer, the Box is a container for Balls and you
 * can only put a Ball into a Box once. After you put the Ball into the Box,
 * further attempts to do so will fail, since the Ball is already in the Box!
 * Similarly, you cannot expect to remove a Ball from a Box if it is not inside
 * the Box.
 *
 * In addition, a Box differs from a ballcontainer because it only has a finite
 * volume. As Balls get put into a Box, it gets filled up. Once a Box is full,
 * further attempts to put Balls into the Box will also fail.
 *
 * @see ps0.Ball
 * @see ps0.BallContainer
 * @see ps0.Box
 */

public class BoxTest {

	private Box box = null;
	private int NUM_BALLS_TO_TEST = 5;
	private int BOX_CAPACITY = NUM_BALLS_TO_TEST - 1;
	private Ball[] b = null;
	private double BALL_UNIT_VOLUME = 10.0;
	private double JUNIT_DOUBLE_DELTA = 0.0001;
	private int TRIES_FOR_BALLS_TEST = 3;

	@Before
	public void setUp() throws Exception {
		assertTrue(NUM_BALLS_TO_TEST > 0);
		assertTrue(NUM_BALLS_TO_TEST > BOX_CAPACITY);

		double box_volume = 0;

		// Let's create the balls we need.
		b = new Ball[NUM_BALLS_TO_TEST];
		for (int i = 0; i < NUM_BALLS_TO_TEST; i++) {
			if (i < BOX_CAPACITY) {
				box_volume += (i + 1) * BALL_UNIT_VOLUME;
			}
			b[i] = new Ball((i + 1) * BALL_UNIT_VOLUME);
		}

		// Now, we create the box once we figure out how big a box we
		// need.
		box = new Box(box_volume);
	}

	/** Test to check that Box.add(Ball) is implemented correctly */
	@Test
	public void testAdd() {
		box.clear();
		for (int i = 0; i < BOX_CAPACITY; i++) {
			assertTrue(box.add(b[i]));
			assertFalse(box.add(b[i]));
			assertTrue(box.contains(b[i]));
		}
		for (int i = BOX_CAPACITY; i < NUM_BALLS_TO_TEST; i++) {
			assertFalse(box.add(b[i]));
		}
	}

	/**
	 * Test to check that Box.getBallsFromSmallest() is implemented correctly
	 */
	@Test
	public void testGetBalls() {
		Random rnd = new Random();

		for (int k = 0; k < TRIES_FOR_BALLS_TEST; k++) {

			box.clear();

			// Let's put all the balls into a list.
			LinkedList<Ball> list = new LinkedList<Ball>();
			for (int i = 0; i < BOX_CAPACITY; i++) {
				list.add(b[i]);
			}

			// First we add the balls to the box in some random order.
			for (int i = 0; i < BOX_CAPACITY; i++) {
				box.add(list.remove(rnd.nextInt(list.size())));
			}

			// Next we call the iterator and check that the balls come out in
			// the correct order.
			Iterator<Ball> it = box.getBallsFromSmallest();
			int count = 0;
			while (it.hasNext() && count < BOX_CAPACITY) {
				Ball ball = it.next();
				assertEquals(b[count], ball);
				if (b[count] != ball) {
					break;
				}
				count++;
			}
			assertEquals(BOX_CAPACITY, count);
		}
	}

	/**
	 * Test to check that Box.remove(Ball) is implemented correctly. Depending
	 * on how <code>getBallsFromSmallest()</code> is implemented, remove() might
	 * have to be overridden and this test helps ensure that remove() is not
	 * broken in the process.
	 */
	public void testRemove() {
		box.clear();
		assertFalse(box.remove(b[0]));
		for (int i = 0; i < BOX_CAPACITY; i++) {
			box.clear();
			for (int j = 0; j < i; j++) {
				box.add(b[j]);
			}
			for (int j = 0; j < i; j++) {
				assertTrue(box.remove(b[j]));
				assertFalse(box.contains(b[j]));
			}
			for (int j = i; j < NUM_BALLS_TO_TEST; j++) {
				assertFalse(box.remove(b[j]));
			}
		}
	}

}