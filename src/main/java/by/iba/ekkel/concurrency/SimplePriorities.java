//: by.iba.ekkel.concurrency/SimplePriorities.java
// Using of the priority threads
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;

public class SimplePriorities implements Runnable {
	
	private int countDown = 5;
	private volatile double d; //Without optimization
	private int priority;
	public SimplePriorities(int priority) {
		this.priority = priority;
	}
	
	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}
	
	public void run() {
		Thread.currentThread().setPriority(priority);
		while(true) {
			//High-cost, interrupted operation
			for(int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double)i;
				if(i % 1000 == 0) {
					Thread.yield();
				}
			}
			System.out.println(this);
			if(--countDown == 0) return;
		}
	}
	
	public static void main(String[] args) {
	
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		}
		exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		exec.shutdown();
	
	}

} /* Output
*///:~