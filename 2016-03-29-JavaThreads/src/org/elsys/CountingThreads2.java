package org.elsys;

public class CountingThreads2 {

	public static class Counter {
		private long count;
		
		public Counter() {
			count = 0L;
		}
		
		public void incrementCount() {
			synchronized (this) {
				count = count + 1;
			}
		}
		
		public long getCount() {
			return count;
		}
	}
	
	public static class CountingTask implements Runnable {
		
		private Counter counter;

		public CountingTask(Counter counter) {
			this.counter = counter;
		}
		
		@Override
		public void run() {
			for(int i=0; i<10_000_000; i++) {
				counter.incrementCount();
			}
			
		}
		
	}
	
	public CountingThreads2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Counter counter = new Counter();
		
		Thread[] threads = new Thread[10];
		for(int i = 0; i<threads.length; ++i) {
			threads[i] = new Thread(
					new CountingTask(counter));
		}
		for(int i=0; i<threads.length; ++i) {
			threads[i].start();
		}
		
		
		System.err.println("couning...");
		for(int i=0; i<threads.length; ++i) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("result: " + counter.getCount());
	}
	
}
