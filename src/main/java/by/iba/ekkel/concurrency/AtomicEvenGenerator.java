//: by.iba.ekkel.concurrency/AtomicEvenGenerator.java
// Atomic classes are rarely used in the common code
// {RunByHand}
package by.iba.ekkel.concurrency;

import java.util.concurrent.atomic.*;

public class AtomicEvenGenerator extends IntGenerator {
	
	private AtomicInteger currentValue = 
			new AtomicInteger(0);
	public int next() {
		return currentValue.addAndGet(2);
	}
	
	public static void main(String[] args) {
	
		EvenChecker.test(new AtomicEvenGenerator());
		
	}
}
