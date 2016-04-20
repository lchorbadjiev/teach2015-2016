package org.elsys.server;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public EchoServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(4444);
		while (true) {
			System.out.println("going to accept new connection");
			Socket socket = serverSocket.accept();
			new Thread(new ClientRunnable(socket)).start();
		}
	}

}
