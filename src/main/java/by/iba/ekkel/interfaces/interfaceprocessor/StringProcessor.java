//: by.iba.ekkel.interfaces.interfaceprocessor/StringProcessor.java
package by.iba.ekkel.interfaces.interfaceprocessor;

import java.nio.charset.UnsupportedCharsetException;
import java.util.*;

public abstract class StringProcessor implements Processor {
	
	public String name() {
		return getClass().getSimpleName();
	}
	
	public abstract String process(Object input);
	
	public static String s = 
			"If she weighs the same as duck, she's made of wood";
	
	public static void main(String[] args) {
		
		Apply.process(new Upcase(), s);
		Apply.process(new Downcase(), s);
		Apply.process(new Splitter(), s);
		
	}

}

class Upcase extends StringProcessor {
	public String process(Object input) { // Ковариантный возвращаемый тип
		return ((String)input).toUpperCase();
	}
}

class Downcase extends StringProcessor {
	public String process(Object input) {
		return ((String)input).toLowerCase();
	}
}

class Splitter extends StringProcessor {
	public String process(Object input) {
		return Arrays.toString(((String)input).split(" "));
	}
} /* Output
Using processor Upcase
IF SHE WEIGHS THE SAME AS DUCK, SHE'S MADE OF WOOD
Using processor Downcase
if she weighs the same as duck, she's made of wood
Using processor Splitter
[If, she, weighs, the, same, as, duck,, she's, made, of, wood]
*///:~