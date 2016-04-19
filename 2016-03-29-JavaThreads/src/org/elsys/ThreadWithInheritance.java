package org.elsys;

public class ThreadWithInheritance extends Thread {

	public ThreadWithInheritance() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("going to start long running op");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("long running op done");
	}

	
	public static void main(String[] args) {
		Thread thread = new ThreadWithInheritance();
		System.out.println("thread created");
		thread.start();
		System.out.println("thread started");
		
		System.out.println("going to join");
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread joined...");
	}
}
