//: access/IceCream.java
// Демонстрация ключевого слова private
package by.iba.ekkel.access;

import static by.iba.ekkel.mindview.util.Print.*;

class Sundae {
	
	private Sundae() {
		
	}
	
	static Sundae makeASundae() {
		print("Конструктор Sundae()");
		return new Sundae();
	}
	
}

public class IceCream {
	
	public static void main(String[] args) {
		//! Sundae x = new Sundae();
		Sundae x = Sundae.makeASundae();
		
	}

}/* Output

*///:~
