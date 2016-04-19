package org.elsys;

public class ThreadWithRunnable {

	public static class Task implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public ThreadWithRunnable() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		Thread thread = new Thread(new Task(), "TaskThread");
		thread.start();
		
		System.out.println("thread started; going to wait it finishes...");
		System.out.println("we can do something else here...");
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread joined... going to finish...");
	}
}
