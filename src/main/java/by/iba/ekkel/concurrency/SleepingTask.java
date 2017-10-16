//: by.iba.ekkel.concurrency/SleepingTask.java
// Call the sleep method() to freeze the thread
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;

public class SleepingTask extends LiftOff {
	
	public void run() {
		
		try {
			while(countDown-- > 0) {
				System.out.print(status());
				//The old style
				//Thread.sleep(100);
				//Style of Java SE5/6
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch(InterruptedException e) {
			System.err.println("Interrupted");
		}
		
	}
	
	public static void main(String[] args) {
	
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			exec.execute(new SleepingTask());	
		}
		exec.shutdown();
	
	}

} /* Output
#0(9), #4(9), #2(9), #3(9), #1(9), #3(8), #0(8), #4(8), 
#2(8), #1(8), #0(7), #2(7), #1(7), #4(7), #3(7), #3(6), 
#1(6), #0(6), #2(6), #4(6), #1(5), #0(5), #3(5), #2(5), 
#4(5), #2(4), #4(4), #1(4), #0(4), #3(4), #4(3), #1(3), 
#0(3), #2(3), #3(3), #3(2), #2(2), #1(2), #4(2), #0(2), 
#0(1), #4(1), #3(1), #1(1), #2(1), #1(LiftOff!), #3(LiftOff!), 
#2(LiftOff!), #4(LiftOff!), #0(LiftOff!), 
*///:~
