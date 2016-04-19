package org.elsys;

public class CountingThreads {
	private static long counter = 0;
	private static Object lock = new Object();
	private static class CountingTask implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 100_000_000; i++) {
				synchronized (lock) {
					counter++;
				}
			}
		}

	}

	public CountingThreads() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new CountingTask(), "CountingTask" + i);
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		System.out.println("counting started");
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("counting finished...");
		System.out.println("result: " + counter);

	}
}
