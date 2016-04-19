package org.elsys;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

	private final int capacity;
	private final Queue<Runnable> queue;

	public BlockingQueue(int capacity) {
		this.capacity = capacity;
		this.queue = new LinkedList<Runnable>();
	}

	private boolean isFull() {
		return queue.size() >= capacity;
	}

	private boolean isEmpty() {
		return queue.size() == 0;
	}

	public synchronized void put(Runnable task) throws InterruptedException {
		while (isFull()) {
			wait();
		}
		boolean wasEmpty = isEmpty();
		queue.add(task);
		if (wasEmpty) {
			notify();
		}
	}

	public synchronized Runnable take() throws InterruptedException {
		while (isEmpty()) {
			wait();
		}
		boolean wasFull = isFull();
		
		Runnable task = queue.poll();
		if (wasFull) {
			notify();
		}
		return task;
	}

}
