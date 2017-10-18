//: by.iba.ekkel.concurrency.waxomatic/WaxOMatic.java
// The easiest interaction of the tasks
package by.iba.ekkel.concurrency.waxomatic;

import java.util.concurrent.*;

import static by.iba.ekkel.mindview.util.Print.*;

class Car {
	private boolean waxOn = false;
	public synchronized void waxed() {
		waxOn = true; //Is ready to process
		notifyAll();
	}
	
	public synchronized void buffed() {
		waxOn = false; //Is ready to cover with the other layer
		notifyAll();
	}
	
	public synchronized void waitForWaxing() 
		throws InterruptedException {
			while(waxOn == false) {
				wait();
			}
	}
	
	public synchronized void waitForBuffing() 
			throws InterruptedException {
					while(waxOn == true) {
						wait();
					}
		
	}
}

class WaxOn implements Runnable {
	private Car car;
	public WaxOn(Car c) {
		car = c;
	}
	public void run() {
		try {
			while(!Thread.interrupted()) {
				printb("WaxOn! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waitForBuffing();
			}
		} catch(InterruptedException e) {
			print("\nExiting via Interrupt");
		}
		print("Ending Wax On task");
		
	}
}

class WaxOff implements Runnable {
	private Car car;
	public WaxOff(Car c) {
		car = c;
	}
	public void run() {
		try {
			while(!Thread.interrupted()) {
				car.waitForWaxing();
				printb("WaxOff! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch(InterruptedException e) {
			print("\nExiting via Interrupt");
		}
		print("Ending Wax Off task");
		
	}
}

public class WaxOMatic {
	
	public static void main(String[] args) throws Exception {
	
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(5); //Small delay
		exec.shutdownNow(); //Interrupt all the tasks 
	
	}
} /* Output
WaxOn!WaxOn!WaxOn!WaxOn!WaxOn!WaxOn!WaxOn!
WaxOn!WaxOn!WaxOn!WaxOn!WaxOn!WaxOn!WaxOn!
WaxOn!WaxOn!WaxOn!WaxOn!WaxOn!WaxOn!WaxOn!
WaxOn!WaxOn!WaxOn!WaxOn!
Exiting via Interrupt
Exiting via Interrupt
Ending Wax Off task
Ending Wax On task
*///:~