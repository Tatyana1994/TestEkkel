//: by.iba.ekkel.concurrency/Fat.java
// Objects creation of which takes much time
package by.iba.ekkel.concurrency;

public class Fat {
	
	private volatile double d; // prevents optimization
	private static int counter = 0;
	private final int id = counter++;
	public Fat() {
		// Cost-based, interruptable operation
		for(int i = 0; i < 10000; i++) {
			d += (Math.PI + Math.E) / (double)i;
		}
	}
	public void operation() {
		System.out.println(this);
	}
	public String toString() {
		return "Fat id: " + id;
	}

}
