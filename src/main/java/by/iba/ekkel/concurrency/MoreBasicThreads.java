//: by.iba.ekkel.concurrency/MoreBasicThreads.java
// Add new threads
package by.iba.ekkel.concurrency;

public class MoreBasicThreads {
	
	public static void main(String[] args) {
	
		for(int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting for LiftOff");
	
	}

} /* Output
#0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #2(9), #1(9), #2(8), #0(3), 
#4(9), #3(9), Waiting for LiftOff
#3(8), #4(8), #0(2), #3(7), #4(7), #0(1), #3(6), #4(6), 
#0(LiftOff!), #2(7), #3(5), #2(6), #3(4), #2(5), #3(3), 
#2(4), #3(2), #3(1), #3(LiftOff!), #1(8), #2(3), #1(7), #2(2), 
#1(6), #2(1), #1(5), #2(LiftOff!), #1(4), #4(5), #4(4), #4(3), 
#1(3), #1(2), #1(1), #4(2), #1(LiftOff!), #4(1), #4(LiftOff!),
*///:~
