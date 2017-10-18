//: by.iba.ekkel.concurrency/Chopstick.java
// Sticks for the philosophers that have dinner
package by.iba.ekkel.concurrency;

public class Chopstick {
	
	private boolean taken = false;
	public synchronized 
		void take() throws InterruptedException {
			while(taken) {
				wait();
			}
			taken = true;
	}
	
	public synchronized void drop() {
		taken = false;
		notifyAll();
	}

} /* Output
*///:~
