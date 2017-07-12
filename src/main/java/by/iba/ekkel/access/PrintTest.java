//: access/PrintTest.java
// Использование статических методов печати из Print.java
package by.iba.ekkel.access;

import static by.iba.ekkel.mindview.util.Print.*;

public class PrintTest {
	
	public static void main(String[] args) {
		
		print("Теперь это стало возможно!");
		print(100);
		print(100L);
		print(3.14159);
		
	}

} /* Output
Теперь это стало возможно!
100
100
3.14159
*///:~
