package org.elsys.philosophers;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Philosopher extends Thread {

	private final int id;
	private final Fork left;
	private final Fork right;

	private final Random randomGenerator = new Random();

	private int foodCounter = 0;

	private final AtomicBoolean dining = new AtomicBoolean(true);

	public Philosopher(int id, Fork left, Fork right) {
		this.id = id;
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return "philosopher-" + id;
	}

	private void think() throws InterruptedException {
		System.out.println(this + " is thinking");
		Thread.sleep(randomGenerator.nextInt(200));
	}

	private void eat() throws InterruptedException {
		System.out.println(this + " is eating");
		foodCounter++;
		Thread.sleep(randomGenerator.nextInt(500));
	}

	public int getFoodCounter() {
		return foodCounter;
	}

	public void finishDinner() {
		dining.set(false);
	}

	@Override
	public void run() {
		try {
			while (dining.get()) {
				think();
				left.pickUp(this);
				right.pickUp(this);
				eat();
				left.putDown(this);
				right.putDown(this);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
