package Deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	private Account acc1= new Account();
	private Account acc2= new Account();
	
	private Lock lock1= new ReentrantLock();
	private Lock lock2= new ReentrantLock();
	
	private void acquireLock(Lock lock1, Lock lock2) throws InterruptedException{
		while(true){
			//Acquire the locks
			
			boolean gotLock1= false;
			boolean gotKock2=false;
			
			try{
				gotLock1=lock1.tryLock();
				gotKock2=lock2.tryLock();
			}
			finally{
				if(gotKock2 && gotLock1){
					return;
				}
				
				if(gotLock1){
					lock1.unlock();
				}
				
				if(gotKock2){
					lock2.unlock();
				}
			}
			
			//Locks not acquired
			Thread.sleep(1);
		}
	}
	
	public void firstThread() throws InterruptedException{
		Random random= new Random();
		for(int i=0; i<10000;i++){
			lock1.lock();
			lock2.lock();
			try{
			Account.transfer(acc1, acc2, random.nextInt(100));
			}
			finally{
				lock1.unlock();
				lock2.unlock();
			}
			
		}
		
	}
	
	public void secondThread() throws InterruptedException{
		Random random= new Random();
		for(int i=0; i<10000;i++){
			lock1.lock();
			lock2.lock();
			try{
			Account.transfer(acc2, acc1, random.nextInt(100));
			}
			finally{
				lock1.unlock();
				lock2.unlock();
			}
			
		}
		
	}
	
	public void finished(){
		
		System.out.println("Account1 balance :" + acc1.getBalance());
		System.out.println("Account2 balance :" + acc2.getBalance());
		System.out.println("Total balance :" + (acc1.getBalance()+acc2.getBalance()));
		
	}

}
