//: operators/Casting.java
package by.iba.ekkel.operators;

public class Casting {
	
	public static void main(String[] args) {
		
		int i = 200;
		long lng = (long) i;
		lng = i; //"Расширение". Явное преобразование не обязательно
		long lng2 = (long)200;
		lng2 = 200; 
		//"Сужающее" преобразование
		i = (int)lng2; //Преобразование необходимо
			
	}

} ///:~
