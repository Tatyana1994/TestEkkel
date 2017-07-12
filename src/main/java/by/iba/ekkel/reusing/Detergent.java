//: reusing/Detergent.java
// Синтаксис наследования и его свойств
package by.iba.ekkel.reusing;

import static by.iba.ekkel.mindview.util.Print.*;

class Cleanser {
	
	private String s = "Cleanser";
	
	public void append(String a) {
		s += a;
	}
	
	public void dilute() {		
		append(" dilute()");		
	}
	
	public void apply() {		
		append(" apply()");		
	}
	
	public void scrub() {		
		append(" scrub()");		
	}
	
	public String toString() {
		return s;
	}
	
	public static void main(String[] args) {
		Cleanser x = new Cleanser();
		x.dilute();
		x.apply();
		x.scrub();
		print(x);
	}
	
}

public class Detergent extends Cleanser {
	
	// Изменяем метод
	public void scrub() {
		append(" Detergent.scrub()");
		super.scrub(); //вызываем метод базового класса
	}
	
	//Добавляем новые методы к интрерфейсу
	public void foam() {
		append(" foam()");
	}
	
	//Проверяем новый класс
	public static void main(String[] args) {
		Detergent x = new Detergent();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		print(x);
		print("Проверяем базовый класс");
		Cleanser.main(args);
	}

} /* Output
Cleanser dilute() apply() Detergent.scrub() scrub() foam()
Проверяем базовый класс
Cleanser dilute() apply() scrub()
*///:~

