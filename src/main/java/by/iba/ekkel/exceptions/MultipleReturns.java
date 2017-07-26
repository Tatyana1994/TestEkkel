//: by.iba.ekkel.exceptions/MultipleReturns.java
package by.iba.ekkel.exceptions;

import static by.iba.ekkel.mindview.util.Print.*;

public class MultipleReturns {
	
	public static void f(int i) {
		print("Инициализация, требующая завершения");
		try {
			print("Точка1");
			if(i == 1) return;
			print("Точка2");
			if(i == 2) return;
			print("Точка3");
			if(i == 3) return;
			print("Конец");
			return;
		} finally {
			print("Завершение");
		}
	}
	
	public static void main(String[] args) {
	
		for(int i = 1; i <= 4; i++) {
				f(i);
		}
		
	}

} /* Output
Инициализация, требующая завершения
Точка1
Завершение
Инициализация, требующая завершения
Точка1
Точка2
Завершение
Инициализация, требующая завершения
Точка1
Точка2
Точка3
Завершение
Инициализация, требующая завершения
Точка1
Точка2
Точка3
Конец
Завершение
*///:~
