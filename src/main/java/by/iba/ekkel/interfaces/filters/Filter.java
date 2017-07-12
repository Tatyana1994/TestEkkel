//: by.iba.ekkel.interfaces.filters/Filter.java
package by.iba.ekkel.interfaces.filters;

public class Filter {

	public String name() {
		return getClass().getSimpleName();
	}
	
	public Waveform process(Waveform input) {
		return input;
	}
	
} /* Output
*///:~
