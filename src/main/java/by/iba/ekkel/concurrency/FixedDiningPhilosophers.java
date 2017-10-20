//: by.iba.ekkel.concurrency/FixedDiningPhilosophers.java
// Philosophers that have dinner without deadlocking
// {Args: 5 5 timeout}
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;

import sun.security.util.Length;

public class FixedDiningPhilosophers {
	
	public static void main(String[] args) throws Exception {
	
		int ponder = 5;
		if(args.length > 0) {
			ponder = Integer.parseInt(args[0]);
		}
		int size = 5;
		if(args.length > 1) {
			Integer.parseInt(args[1]);
		}
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[size];
		for(int i = 0; i < size; i++) {
			sticks[i] = new Chopstick();
		}
		for(int i = 0; i < size; i++) {
			if(i < (size - 1)) {
				exec.execute(new Philosopher(
						sticks[i], sticks[i+1], i, ponder));
			} else {
				exec.execute(new Philosopher(
						sticks[0], sticks[i], i, ponder));
			}
		}
		if(args.length == 3 && args[2].equals("timeout")) {
			TimeUnit.SECONDS.sleep(5);
		} else {
			System.out.println("Press 'Enter' to exit");
			System.in.read();
		}
		exec.shutdownNow();
	 
	}

} /* Output
*///:~