package org.elsys.philosophers;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {

	private final int id;
	private final ReentrantLock lock = new ReentrantLock();

	private Random random = new Random();
	
	public Fork(int id) {
		this.id = id;
	}

	public String toString() {
		return "Fork-" + id;
	}

	public boolean pickUp(Philosopher who) {
		try {
			if (lock.tryLock(random.nextInt(100), TimeUnit.MILLISECONDS)) {
				System.out.println(who + " pick up " + this);
				return true;
			} else {
				return false;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void putDown(Philosopher who) {
		lock.unlock();
		System.out.println(who + " put down " + this);
	}
}
