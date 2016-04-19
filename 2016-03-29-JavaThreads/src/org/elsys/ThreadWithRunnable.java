package org.elsys;

public class ThreadWithRunnable {
	
	public static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("Task: going into long running op");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Task: long running op done");
		}
		
	}
	
	public ThreadWithRunnable() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void main(String[] args) {
		Thread thread = new Thread(new Task(), "TaskThread");
		System.out.println("Thread created");
		
		thread.start();
		System.out.println("Thread started");
		
		System.out.println("can do something useful...");
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread joined");
		
		
		
		
	}
}
