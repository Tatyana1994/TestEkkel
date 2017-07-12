//: initialization/ArrayInit.java
// Инициализация массивов
package by.iba.ekkel.initialization;

import java.util.*;

public class ArrayInit {

	public static void main(String[] args) {
		
		//может использоваться только в точке определения массива
		Integer[] a = {
				new Integer(1),
				new Integer(2),
				3 //Autoboxing
		};
		
		//может использоваться везде, даже внутри вызова метода
		Integer[] b = new Integer[] {
				new Integer(1),
				new Integer(2),
				3 //Autoboxing
		};
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
	}
	
}/* Output
[1, 2, 3]
[1, 2, 3]
*///:~
