//: operators/AutoInc.java
//Изменяют свой операнд вместо простого использования его значения
package by.iba.ekkel.operators;

public class AutoInc {
	
	public static void main(String[] args) {
		int i = 1;
		System.out.println("i: " + i);
		
		//Префиксный инекремент
		System.out.println("++i: " + ++i);
		
		//Постфиксный инкремент
		System.out.println("i++: " + i++);
		System.out.println("i: " + i);
		
		//Префиксный декремент
		System.out.println("--i: " + --i);
		
		//Постфиксный декремент
		System.out.println("i--: " + i--);
		
		System.out.println("i: " + i);
	}

}/* Output
i: 1
++i: 2
i++: 2
i: 3
--i: 2
i--: 2
i: 1
*///:~

