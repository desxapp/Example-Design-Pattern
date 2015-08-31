package designpattern.behavioral;

import designpattern.util.BasedPattern;
import java.util.*;

public class Observer_ implements BasedPattern {
	@Override
	public void TestPattern() {
		ClientQueue queue = new ClientQueue();
		queue.addClientListener(new ClientLogger());
		Client c1 = new Client("127.0.0.1", "caterpillar");
		Client c2 = new Client("192.168.0.2", "justin");
		queue.add(c1);
		queue.add(c2);
		queue.remove(c1);
		queue.remove(c2);
	}

	class ClientLogger implements ClientListener {
		public void clientAdded(ClientEvent event) {
			System.out.println(event.ip + " added...");
		}

		public void clientRemoved(ClientEvent event) {
			System.out.println(event.ip + " removed...");
		}
	}

	class Client {
		private String ip;
		private String name;

		public Client(String ip, String name) {
			this.ip = ip;
			this.name = name;
		}

		void setIp(String ip) {
			this.ip = ip;
		}

		void setName(String name) {
			this.name = name;
		}

		String getIp() {
			return ip;
		}

		String getName() {
			return name;
		}
	}

	class ClientEvent {
		final String ip;
		final String name;

		ClientEvent(Client client) {
			this.ip = client.getIp();
			this.name = client.getName();
		}
	}

	interface ClientListener {
		void clientAdded(ClientEvent event);

		void clientRemoved(ClientEvent event);
	}

	class ClientQueue {
		private List<Client> clients = new LinkedList<Client>();
		private List<ClientListener> listeners = new LinkedList<ClientListener>();

		void addClientListener(ClientListener listener) {
			listeners.add(listener);
		}

		void removeClientListener(ClientListener listener) {
			listeners.remove(listener);
		}

		void notifyAdded(Client client) {
			ClientEvent event = new ClientEvent(client);
			for (ClientListener listener : listeners) {
				listener.clientAdded(event);
			}
		}

		void notifyRemoved(Client client) {
			ClientEvent event = new ClientEvent(client);
			for (ClientListener listener : listeners) {
				listener.clientRemoved(event);
			}
		}

		void add(Client client) {
			clients.add(client);
			notifyAdded(client);
		}

		void remove(Client client) {
			clients.remove(client);
			notifyRemoved(client);
		}

	}
}
