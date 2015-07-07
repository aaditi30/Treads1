package Semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class App {
	
	public static void main(String args[]) throws InterruptedException{
		/*Semaphore sem= new Semaphore(1);
		
		sem.acquire();
		sem.release();
		
		System.out.println("Available permits:" +sem.availablePermits());*/
		
		
		ExecutorService executor= Executors.newCachedThreadPool();
		
		for(int i=0; i<200;i++){
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Connection.getInstance().connect();
					
					
				}
			});
		}
	}

}
