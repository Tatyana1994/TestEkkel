//: by.iba.ekkel.concurrency/SynchronizedEvenGenerator.java
// Simplify work with mutexes 
// by using 'synchronized' key word
// {RunByHand}
package by.iba.ekkel.concurrency;

public class SynchronizedEvenGenerator extends IntGenerator {

	private int currentEvenValue = 0;
	public synchronized int next() {
		++currentEvenValue;
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}
	
	public static void main(String[] args) {
	
		EvenChecker.test(new SynchronizedEvenGenerator());
	
	}
	
} /* Output
*///:~
