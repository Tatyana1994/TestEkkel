//: by.iba.ekkel.interfaces.filters/LowPass.java
package by.iba.ekkel.interfaces.filters;

public class LowPass extends Filter {
	
	double cutoff;
	
	public LowPass(double cutoff) {
		this.cutoff = cutoff;
	}
	
	public Waveform process(Waveform input) {
		return input; //Фиктивная обработка
	}

} /* Output
*///:~
