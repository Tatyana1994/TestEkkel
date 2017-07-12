//: reusing/Bath.java
// Инициализация в конструкторе с композицией
package by.iba.ekkel.reusing;

import static by.iba.ekkel.mindview.util.Print.*;

class Soap {
	
	private String s;
	
	Soap() {
		
		print("Soap()");
		s = "Сконструирован";
		
	}
	
	public String toString() {
		return s;
	}
	
}

public class Bath {
	
	private String //Инициализация в точке определения
		s1 = "Счастливый",
		s2 = "Счастливый",
		s3, 
		s4;
	
	private Soap castille;
	private int i;
	private float toy;
	
	public Bath() {
		print("В конструкторе Bath()");
		s3 = "Радостный";
		toy = 3.14f;
		castille = new Soap();
	}	
	//Инициализация экземпляра
	{
		i = 47;
	}
	
	public String toString() {
		if (s4 == null) //отложенная инициализация
			s4 = "Радостный";
		return 
				"s1 = " + s1 + "\n" +
				"s2 = " + s2 + "\n" +
				"s3 = " + s3 + "\n" +
				"s4 = " + s4 + "\n" +
				"i = " + i + "\n" +
				"toy = " + toy + "\n" +
				"castille = " + castille;
	}
	
	public static void main(String[] args) {
		Bath b = new Bath();
		print(b);
	}
	
}/* Output
В конструкторе Bath()
Soap()
s1 = Счастливый
s2 = Счастливый
s3 = Радостный
s4 = Радостный
i = 47
toy = 3.14
castille = Сконструирован
*///:~
