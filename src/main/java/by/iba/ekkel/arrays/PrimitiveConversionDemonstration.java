//: by.iba.ekkel.arrays/PrimitiveConversionDemonstration.java
package by.iba.ekkel.arrays;

import java.util.*;
import by.iba.ekkel.mindview.util.*;

public class PrimitiveConversionDemonstration {
	
	public static void main(String[] args) {
	
		Integer[] a = Generated.array(Integer.class, 
				new CountingGenerator.Integer(), 15);
		int[] b = ConvertTo.primitive(a);
		System.out.println(Arrays.toString(a));
		boolean[] c = ConvertTo.primitive(
				Generated.array(Boolean.class, 
						new CountingGenerator.Boolean(), 7));
		System.out.println(Arrays.toString(c));
	
	}

} /* Output
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
[true, false, true, false, true, false, true]
*///:~
