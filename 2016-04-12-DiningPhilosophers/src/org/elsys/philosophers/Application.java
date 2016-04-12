package org.elsys.philosophers;

import java.util.ArrayList;

public class Application {

	public static final int COUNT = 5;
	public static final int DINING_TIME = 10_000;

	public static void main(String[] args) {
		ArrayList<Fork> forks = new ArrayList<>();
		for (int i = 0; i < COUNT; i++) {
			forks.add(new Fork(i));
		}

		ArrayList<Philosopher> philosophers = new ArrayList<>();
		for (int i = 0; i < COUNT; i++) {
			Philosopher p = new Philosopher(i, forks.get(i), forks.get((i + 1) % COUNT));
			philosophers.add(p);
		}

		for (Philosopher p : philosophers) {
			p.start();
		}

		try {
			Thread.sleep(DINING_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Philosopher p : philosophers) {
			p.finishDining();
		}

		for (Philosopher p : philosophers) {
			System.out.println(p + " food counter=" + p.getFoodCounter());
		}
	}
}
