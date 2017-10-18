//: by.iba.ekkel.concurrency/DeadlockingDiningPhilosophers.java
// Demonstration of deadlock concealed opportunity 
// {Args: 0 5 timeout}
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;

public class DeadlockingDiningPhilosophers {
	
	public static void main(String[] args) throws Exception {
	
		int ponder = 5;
		if(args.length > 0) {
			ponder = Integer.parseInt(args[0]);
		}
		int size = 5;
		if(args.length > 1) {
			size = Integer.parseInt(args[1]);
		}
		
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[size];
		for(int i = 0; i < size; i++) {
			sticks[i] = new Chopstick();
		}
		for(int i = 0; i < size; i++) {
			exec.execute(new Philosopher(
					sticks[i], sticks[(i + 1) % size], i, ponder));
		}
		if(args.length == 3 && args[2].equals("timeout")) {
			TimeUnit.SECONDS.sleep(5);
		} else {
			System.out.println("Preass 'Enter' to end the session");
			System.in.read();
		}
		exec.shutdownNow();
	
	}

} /* Output
Philosopher 0  is thinking
Philosopher 0  takes right stick
Philosopher 1  is thinking
Philosopher 1  takes right stick
Philosopher 1  takes left stick
Philosopher 4  is thinking
Philosopher 4  takes right stick
Philosopher 3  is thinking
Philosopher 2  is thinking
Philosopher 2  takes right stick
Philosopher 2  takes left stick
Philosopher 3  takes right stick
Philosopher 3  takes left stick
Philosopher 4  takes left stick
Philosopher 0  takes left stick
Philosopher 2  exit by the interruption
Philosopher 0  exit by the interruption
Philosopher 4  exit by the interruption
Philosopher 1  exit by the interruption
Philosopher 3  exit by the interruption
*///:~
