//: by.iba.ekkel.generics/ErasedTypeEquivalence.java
package by.iba.ekkel.generics;

import java.util.*;

public class ErasedTypeEquivalence {
	
	public static void main(String[] args) {
	
		Class c1 = new ArrayList<String>().getClass();
		Class c2 = new ArrayList<Integer>().getClass();
		System.out.println(c1 == c2);
		
	}

} /* Output
true
*///:~ 
