package Pooling;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

public class ConnectionPool {
	
	private class ConnectionWrapper implements Connection {
		
		private Connection connection;
		
		public ConnectionWrapper(Connection connection){
			this.connection = connection;
		}

		@Override
		public void execute() {
			this.connection.execute();
		}

		@Override
		public void close() {
			ConnectionPool.this.returnToPool(this);
		}
		
	}
	
	BlockingQueue<Connection> connections = new LinkedBlockingDeque<Connection>();
	
	public ConnectionPool(List<Connection> connections) {
		connections.stream()
		.map(c-> new ConnectionWrapper(c))
		.collect(Collectors.toCollection(()->this.connections));
	}
	
	public Connection getConnection() {
		return connections.poll();
	}
	
	private void returnToPool(Connection connection) {
		connections.offer(connection);
	}

}
