//: operators/Bool.java
package by.iba.ekkel.operators;

import java.util.*;

public class Bool {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		
		int i = rand.nextInt(100);
		int j = rand.nextInt(100);
		
		System.out.println("i is " + i);
		System.out.println("j is " + j);
		System.out.println("i > j is " + (i > j));
		System.out.println("i < j is " + (i < j));
		System.out.println("i >= j is " + (i >= j));
		System.out.println("i <= j is " + (i <= j));
		System.out.println("i == j is " + (i == j));
		System.out.println("i != j is " + (i != j));
		
		//Целое число int не может интерпретироваться
		//как логический тип (boolean)
		//! print("i && j is " + (i && j));
		//! print("i || j is " + (i || j));
		//! print("!i is " + !i);
		System.out.println("(i < 10) && (j < 10) is "
		       + ((i < 10) && (j < 10)) );
		System.out.println("(i < 10) || (j < 10) is "
		       + ((i < 10) || (j < 10)) );
		  }
		
} /* Output
i is 49
j is 8
i > j is true
i < j is false
i >= j is true
i <= j is false
i == j is false
i != j is true
(i < 10) && (j < 10) is false
(i < 10) || (j < 10) is true
*///:~
