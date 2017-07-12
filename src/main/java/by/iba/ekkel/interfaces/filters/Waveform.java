//: by.iba.ekkel.interfaces.filters/Waveform.java
package by.iba.ekkel.interfaces.filters;

public class Waveform {
	
	private static long counter;
	private final long id = counter++;
	
	public String toString() {
		return "Waveform " + id;
	}


} /* Output
*///:~

