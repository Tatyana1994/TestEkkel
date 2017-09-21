//: by.iba.ekkel.arrays/AlphabeticSearch.java
// Search with Comparator
package by.iba.ekkel.arrays;

import java.util.*;
import by.iba.ekkel.mindview.util.*;

public class AlphabeticSearch {
	
	public static void main(String[] args) {
	
		String[] sa = Generated.array(new String[15], 
						new RandomGenerator.String(5));
		Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(sa));
		int index = Arrays.binarySearch(sa, sa[10], 
				String.CASE_INSENSITIVE_ORDER);
		System.out.println("Index: " + index + "\n" + sa[index]);
	
	}

} /* Output
[bkIna, cQrGs, dLsmw, eGZMm, EqUCB, hKcxr, HLGEa, JMRoE, Mesbt, nyGcF, OneOE, OWZnT, suEcU, WHkjU, YNzbr]
Index: 10
OneOE
*///:~
