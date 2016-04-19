package org.elsys.philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {

	private final int id;

	private Lock lock = new ReentrantLock();

	public Fork(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "fork-" + id;
	}

	public void pickUp(Philosopher who) {
		lock.lock();
		System.out.println(who + " pick up fork " + this);
	}

	public void putDown(Philosopher who) {
		lock.unlock();
		System.out.println(who + " put down fork " + this);
	}

}
