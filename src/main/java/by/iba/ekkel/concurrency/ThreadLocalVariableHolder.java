//: by.iba.ekkel.concurrency/ThreadLocalVariableHolder.java
// Automatic assignment of personal memory to each thread
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.*;

class Accessor implements Runnable {
	private final int id;
	public Accessor(int idn) {
		id = idn;
	}
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}
	public String toString() {
		return "#" + id + " " + 
				ThreadLocalVariableHolder.get();
	}
}

public class ThreadLocalVariableHolder {
	
	private static ThreadLocal<Integer> value = 
			new ThreadLocal<Integer>() {
				private Random rand = new Random(47);
				protected synchronized Integer initialValue() {
					return rand.nextInt(10000);
				}
	};
	
	public static void increment() {
		value.set(value.get() + 1);
	}
	
	public static int get() {
		return value.get();
	}
	
	public static void main(String[] args) throws Exception {
	
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			exec.execute(new Accessor(i));
		}
		TimeUnit.SECONDS.sleep(3);  // Small delay
		exec.shutdownNow(); // Exit all Accessor objects
	
	}

} /* Output
#2 116319
#2 116320
#2 116321
#2 116322
#2 116323
#2 116324
#2 116325
#2 116326
#2 116327
#2 116328
#2 116329
#2 116330
#2 116331
#2 116332
#2 116333
#2 116334
#2 116335
#2 116336
#2 116337
#0 67831
#0 67832
#0 67833
#0 67834
#0 67835
#0 67836
#0 67837
#0 67838
#0 67839
#0 67840
...
*///:~
