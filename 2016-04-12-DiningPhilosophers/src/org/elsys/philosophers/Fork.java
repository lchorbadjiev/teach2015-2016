package org.elsys.philosophers;

import java.util.concurrent.locks.ReentrantLock;

public class Fork {

	private final int id;
	private final ReentrantLock lock = new ReentrantLock();

	public Fork(int id) {
		this.id = id;
	}

	public String toString() {
		return "Fork-" + id;
	}

	public void pickUp(Philosopher who) {
		lock.lock();
		System.out.println(who + " pick up " + this);
	}

	public void putDown(Philosopher who) {
		lock.unlock();
		System.out.println(who + " put down " + this);
	}
}
