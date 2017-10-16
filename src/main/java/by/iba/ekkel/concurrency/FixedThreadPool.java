//: by.iba.ekkel.concurrency/FixedThreadPool.java
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;

public class FixedThreadPool {
	
	public static void main(String[] args) {
	
		// The number of thread quantity passes through Constructor arguments
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	
	}

} /* Output
#1(9), #1(8), #1(7), #1(6), #1(5), #1(4), #1(3), #1(2), #1(1), 
#1(LiftOff!), #3(9), #3(8), #3(7), #3(6), #3(5), #3(4), #3(3), 
#3(2), #3(1), #3(LiftOff!), #2(9), #2(8), #2(7), #2(6), #2(5), 
#2(4), #2(3), #2(2), #2(1), #2(LiftOff!), #0(9), #4(9), #4(8), 
#0(8), #4(7), #0(7), #4(6), 
#0(6), #4(5), #0(5), #4(4), #0(4), #4(3), 
#0(3), #4(2), #0(2), #4(1), #0(1), #0(LiftOff!), #4(LiftOff!),
*///:~
