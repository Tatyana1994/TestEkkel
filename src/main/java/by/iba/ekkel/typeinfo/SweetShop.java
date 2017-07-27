//: by.iba.ekkel.typeinfo/SweetShop.java
// Проверка процесса загрузки классов
package by.iba.ekkel.typeinfo;

import static by.iba.ekkel.mindview.util.Print.*;

class Candy {
	static {
		print("Загрузка класса Candy");
	}
}

class Gum {
	static {
		print("Загрузка класса Gum");
	}
}

class Cookie {
	static {
		print("Загрузка класса Cookie");
	}
}


public class SweetShop {
	
	public static void main(String[] args) {
	
		print("в методе main()");
		new Candy();
		print("После создания объекта Candy");
		try {
			Class.forName("by.iba.ekkel.typeinfo.Candy");
			print("Объект найден");
		} catch(ClassNotFoundException e) {
			print("Класс Gum не найден");
		}
		print("После вызова метода Class.forName(\"Gum\")");
		new Cookie();
		print("После создания объекта Cookie");
	 
	}

} /* Output
в методе main()
Загрузка класса Candy
После создания объекта Candy
Объект найден
После вызова метода Class.forName("Gum")
Загрузка класса Cookie
После создания объекта Cookie
*///:~

