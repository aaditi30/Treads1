package ProducerConsumer;

import java.util.Scanner;

public class Processor {
	
	public void produce() throws InterruptedException{
		synchronized (this) {
			System.out.println("Producer thread running");
			wait();
			System.out.println("Resumed");
			
		}
		
	}
	public void consume(){
		try {
			Scanner scanner= new Scanner(System.in);
			Thread.sleep(3000);
			
			synchronized (this) {
				System.out.println("waiting for return key");
				scanner.nextLine();
				System.out.println("Return key pressed.");
				notify();
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
