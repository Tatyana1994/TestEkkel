//: by.iba.ekkel.concurrency/EvenGenerator.java
// Threads conflict
package by.iba.ekkel.concurrency;

public class EvenGenerator extends IntGenerator {
	
	private int currentEvenValue = 5;
	public int next() {
		++currentEvenValue; //Dangerous point
		++currentEvenValue;
		return currentEvenValue;
	}
	
	public static void main(String[] args) {
	
		EvenChecker.test(new EvenGenerator());
	
	}

} /* Output
*///:~
