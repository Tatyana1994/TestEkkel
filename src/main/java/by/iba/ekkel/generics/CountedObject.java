//: by.iba.ekkel.generics/CountedObject.java
package by.iba.ekkel.generics;

public class CountedObject {
	
	private static long counter = 0;
	private final long id = counter++;
	public long id() {
		return id;
	}
	public String toString() {
		return "CountedObject " + id;
	}

} /* Output
*///:~
