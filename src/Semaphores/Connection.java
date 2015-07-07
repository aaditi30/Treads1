package Semaphores;

public class Connection {
	
	private static Connection instance= new Connection();
	private int connections=0;
	private Connection(){
		 
	}
	
	public static Connection getInstance(){
		return instance;
	}
	
	public void connect(){
		synchronized (this) {
			connections++;
			System.out.println("Current connections:" +connections);
			
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (this) {
			connections++;
			
		}
		
	}
	

}
