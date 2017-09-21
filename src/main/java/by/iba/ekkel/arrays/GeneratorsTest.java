//: by.iba.ekkel.arrays/GeneratorsTest.java
// Expected that tested class has a set of embedded Generator objects
// and each one has a default constructor
package by.iba.ekkel.arrays;

import by.iba.ekkel.mindview.util.*;

public class GeneratorsTest {
	
	public static int size = 10;
	public static void test(Class<?> surroundingClass) {
		//class.gerClasses gives information about all the embedded classes
		for(Class<?> type : surroundingClass.getClasses()) {
			System.out.print(type.getSimpleName() + ": ");
			try {
				Generator<?> g = (Generator<?>)type.newInstance();
				for(int i = 0; i < size; i++) {
					System.out.printf(g.next() + " ");
				}
				System.out.println();
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void main(String[] args) {
	
		test(CountingGenerator.class);
	
	}

} /* Output
Boolean: true false true false true false true false true false 
Byte: 0 1 2 3 4 5 6 7 8 9 
Character: a b c d e f g h i j 
Double: 0.0 1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 
Float: 0.0 1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 
Integer: 0 1 2 3 4 5 6 7 8 9 
Long: 0 1 2 3 4 5 6 7 8 9 
Short: 0 1 2 3 4 5 6 7 8 9 
String: abcdefg hijklmn opqrstu vwxyzAB CDEFGHI JKLMNOP QRSTUVW XYZabcd efghijk lmnopqr 
*///:~
