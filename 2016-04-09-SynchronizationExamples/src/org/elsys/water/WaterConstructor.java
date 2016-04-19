package org.elsys.water;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class WaterConstructor implements Runnable {

	private AtomicBoolean running = new AtomicBoolean(true);
	private ReentrantLock lock = new ReentrantLock();

	private int oxygenCounter = 0;
	private int hydrogenCounter = 0;

	private CyclicBarrier barrier = new CyclicBarrier(3);

	private Semaphore oxygenSemaphore = new Semaphore(0);
	private Semaphore hydrogenSemaphore = new Semaphore(0);

	public WaterConstructor() {

	}

	public void proceedOxygen(Oxygen oxygen) throws Exception {
		lock.lock();
		try {
			oxygenCounter += 1;
			if (hydrogenCounter >= 2) {
				hydrogenSemaphore.release();
				hydrogenSemaphore.release();

				oxygenSemaphore.release();
				oxygenCounter -= 1;
			}
		} finally {
			lock.unlock();
		}
		oxygenSemaphore.acquire();

		oxygen.bond();
		barrier.await();
	}

	public void proceedHydrogen(Hydrogen hydrogen) throws Exception {
		lock.lock();
		try {
			hydrogenCounter += 1;
			if (hydrogenCounter >= 2 && oxygenCounter >= 1) {
				hydrogenSemaphore.release();
				hydrogenSemaphore.release();
				hydrogenCounter -= 2;

				oxygenSemaphore.release();
				oxygenCounter -= 1;
			}
		} finally {
			lock.unlock();
		}
		
		hydrogenSemaphore.acquire();

		hydrogen.bond();
		barrier.await();

	}

	@Override
	public void run() {
		Random random = new Random();
		int oxygen = 0;
		int hydrogen = 0;

		while (running.get()) {
			if (random.nextInt(3) == 0) {
				Oxygen o = new Oxygen(++oxygen, this);
				o.start();
			} else {
				Hydrogen h = new Hydrogen(++hydrogen, this);
				h.start();
			}
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void close() {
		running.set(false);
	}
	
	public static void main(String[] args) {
		WaterConstructor constructor = new WaterConstructor();
		constructor.run();
	}
}
