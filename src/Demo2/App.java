package Demo2;

class Runner implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for( int i=0; i<10;i++){
			System.out.println("hello" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
public class App {
	public static void main(String args[]){
		Thread thread1= new Thread(new Runner());
		Thread thread2= new Thread(new Runner());
		thread1.start();
		thread2.start();
	}

}
