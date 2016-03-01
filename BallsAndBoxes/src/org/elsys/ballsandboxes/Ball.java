/**
 * This is part of the Problem Set 0: Introduction for 6.170 Fall 2005.
 */
package org.elsys.ballsandboxes;

/**
 * This is a simple object that has a capacity.
 */
public class Ball {

	private double capacity = 0;

	/**
	 * Constructor that creates a new ball object with the specified weight and
	 * capacity.
	 * 
	 * @param capacity
	 *            Capacity of the new object.
	 */
	public Ball(double capacity) {
		this.capacity = capacity;
	}

	/**
	 * Returns the capacity of the Ball.
	 * 
	 * @return the capacity of the Ball.
	 */
	public double getCapacity() {
		return capacity;
	}

}