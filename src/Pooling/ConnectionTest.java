package Pooling;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionTest {

	public static void main(String[] args) {
		
		
		List<Connection> connections = new ArrayList<Connection>();
		for(int i=0;i <5; i++) {
			connections.add(new TestConnection(i));
		}
		
		ConnectionPool pool = new ConnectionPool(connections);
		
		int threads = 20;
		ExecutorService executor = Executors.newFixedThreadPool(threads);
		
		for(int i=0; i < threads; i++) {
			int id=i;
			executor.submit(() -> {
				Thread.currentThread().setName("Thread:" + id);
				Connection connection = pool.getConnection();
				connection.execute();
				connection.close();	
			});
		}
		
		executor.shutdown();
	}
	
	
	private static class TestConnection implements Connection {
		
		int id;
		
		public TestConnection(int id) {
			this.id = id;
		}

		@Override
		public void execute() {
			System.out.println(Thread.currentThread().getName()+ ":" + id + ": Executed");
			try {
				Thread.sleep((long)Math.random()*1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void close() {
			System.out.println(Thread.currentThread().getName()+ ":" + id + ": Closed");
			
		}
	}
}
