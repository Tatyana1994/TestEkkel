//: by.iba.ekkel.interfaces.interfaceprocessor/FilterProcessor.java
package by.iba.ekkel.interfaces.interfaceprocessor;

import by.iba.ekkel.interfaces.filters.*;

class FilterAdapter implements Processor {
	
	Filter filter;
	
	public FilterAdapter(Filter filter) {
		this.filter = filter;
	}
	
	public String name() {
		return filter.name();
	}
	
	public Waveform process(Object input) {
		return filter.process((Waveform)input);
	}
	
}

public class FilterProcessor {
	
	public static void main(String[] args) {
		Waveform w = new Waveform();
		Apply.process(new FilterAdapter(new LowPass(1.0)), w);
		Apply.process(new FilterAdapter(new HighPass(2.0)), w);
		Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
	}

} /* Output
Using processor LowPass
Waveform 0
Using processor HighPass
Waveform 0
Using processor BandPass
Waveform 0
*///:~
