//: by.iba.ekkel.concurrency/CachdThreadPool.java
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;

public class CachedThreadPool {
	
	public static void main(String[] args) {
	
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	
	}

} /* Output
#0(9), #3(9), #1(9), #4(9), #1(8), #2(9), #2(8), #2(7), #1(7), 
#1(6), #1(5), #4(8), #4(7), #3(8), #0(8), #4(6), #4(5), #3(7), 
#4(4), #0(7), #4(3), #0(6), #3(6), #4(2), #0(5), #4(1), #1(4), 
#2(6), #2(5), #1(3), #4(LiftOff!), #0(4), #3(5), #0(3), #0(2), 
#0(1), #0(LiftOff!), 
#1(2), #2(4), #3(4), #2(3), #1(1), #1(LiftOff!), #2(2), #2(1),
 #2(LiftOff!), #3(3), #3(2), #3(1), #3(LiftOff!),
*///:~
