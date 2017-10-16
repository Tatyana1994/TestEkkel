//: by.iba.ekkel.concurrency/LiftOff.java
// Implemenation of Runnable interface
package by.iba.ekkel.concurrency;

public class LiftOff implements Runnable {

	protected int countDown = 10; //Default value
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff() {
		
	}
	public LiftOff(int countDown) {
		this.countDown = countDown;
	}
	
	public String status() {
		return "#" + id + "(" +
				(countDown > 0 ? countDown : "LiftOff!") + "), ";
	}
	
	public void run() {
		while(countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}
	
} /* Output
*///:~
