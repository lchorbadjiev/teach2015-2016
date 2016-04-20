package org.elsys.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolServer {

	private static ExecutorService executor;
	
	public ThreadPoolServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		executor = Executors.newFixedThreadPool(2);
		
		ServerSocket serverSocket = new ServerSocket(4444);
		while (true) {
			System.out.println("going to accept new connection");
			Socket socket = serverSocket.accept();
			System.out.println("connection accepted...");
			Runnable work = new ClientRunnable(socket);
			System.out.println("runnable created...");
			executor.execute(work);
			System.out.println("work scheduled...");
		}
	}

}
