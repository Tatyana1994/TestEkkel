//: reusing/Cartoon.java
// Вызовы конструкторов при проведении наследования
package by.iba.ekkel.reusing;

import static by.iba.ekkel.mindview.util.Print.*;

class Art {
	Art() {
		print("Конструктор Art");
	}
}

class Drawing extends Art {
	public Drawing() {
		print("Конструктор Drawing");
	}
}


public class Cartoon extends Drawing {
	
	public Cartoon() {
		print("Конструктор Cartoon");
	}
	
	public static void main(String[] args) {
		Cartoon x = new Cartoon();
	}

} /* Output
Конструктор Art
Конструктор Drawing
Конструктор Cartoon
*///:~
