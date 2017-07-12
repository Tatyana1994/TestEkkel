//: by.iba.ekkel.interfaces.interfaceprocessor/Apply.java
package by.iba.ekkel.interfaces.interfaceprocessor;

import static by.iba.ekkel.mindview.util.Print.*;

import java.util.Arrays;

public class Apply {
	
	public static void process(Processor p, Object s) {
		print("Using processor " + p.name());
		print(p.process(s));
	}

} /* Output
*///:~
