package org.elsys.philosophers;

import java.util.ArrayList;

public class Application {

	public static final int COUNT = 2;
	public static final int DINING_TIME = 30_000;

	public static void main(String[] args) throws InterruptedException {

		ArrayList<Fork> forks = new ArrayList<>();
		ArrayList<Philosopher> philosopers = new ArrayList<>();

		for (int i = 0; i < COUNT; i++) {
			forks.add(new Fork(i));
		}
		for (int i = 0; i < COUNT; i++) {
			philosopers.add(new Philosopher(i, forks.get(i), forks.get((i + 1) % COUNT)));
		}

		for (Philosopher p : philosopers) {
			p.start();
		}

		Thread.sleep(DINING_TIME);

		for (Philosopher p : philosopers) {
			p.finishDinner();
		}

		for (Philosopher p : philosopers) {
			p.join();
			System.out.println(p + " finished diner");
		}

		for (Philosopher p : philosopers) {
			System.out.println(p + " eated " + p.getFoodCounter() + " times");
		}
	}

}
