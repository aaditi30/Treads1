package Video2;

import java.util.Scanner;

class Processor extends Thread{
	
	private volatile boolean running=true;
	private Object lock1= new Object();
	private Object lock2= new Object();
	public void run(){
		while(running){
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void shutdown(){
		running=false;
	}
}

public class App {
	
	public static void main(String args[]){
		Processor proc1= new Processor();
		proc1.start();
		
		Scanner scanner= new Scanner(System.in);
		scanner.nextLine();
		proc1.shutdown();
	}

}
