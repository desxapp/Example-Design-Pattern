package designpattern.behavioral;

import designpattern.util.BasedPattern;

import java.io.*;
import java.net.*;

public class Strategy implements BasedPattern {
	@Override
	public void TestPattern() {
		Server server;
		try {
			server = new Server(9999, new EchoService());
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	interface Service {
		public abstract void doService(Socket client) throws IOException;
	}

	class Server {
		private ServerSocket server;
		private Service service;

		Server(int port, Service service) throws IOException {
			this.server = new ServerSocket(port);
			this.service = service;
		}

		void start() throws IOException {
			while (true) {
				Socket client = server.accept();
				service.doService(client);
			}
		}
	}

	class EchoService implements Service {
		@Override
		public void doService(Socket client) throws IOException {
			BufferedReader reader = null;
			PrintStream writer = null;
			try {
				reader = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				writer = new PrintStream(client.getOutputStream());
				String input = reader.readLine();
				writer.println(input);
			} finally {
				client.close();
			}
		}
	}

}
