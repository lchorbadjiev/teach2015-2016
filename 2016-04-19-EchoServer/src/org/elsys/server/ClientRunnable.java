package org.elsys.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientRunnable implements Runnable {
	private final Socket socket;

	public ClientRunnable(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("new connection accepted... ");
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output);

			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println("line read: " + line);
				writer.println(line);
				writer.flush();
			}
			System.out.println("client finishes...");
			writer.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
