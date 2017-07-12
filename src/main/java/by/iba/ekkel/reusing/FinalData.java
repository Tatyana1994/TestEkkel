//: reusing/FinalData.java
// Действие ключевого слова final для полей
package by.iba.ekkel.reusing;

import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

class Value {
	
	int i; //доступ в пределах пакета
	public Value(int i) {
		this.i = i;
	}
	
	public String toString() {
		return "i = " + i;
	}
}

public class FinalData {

	private static Random rand = new Random(47);
	private String id;
	
	public FinalData(String id) {
		this.id = id;
	}
	
	//могут быть константами времени компиляции
	private final int valueOne = 9;
	private static final int VALUE_TWO = 99;
	//типичная открытая константа
	public static final int VALUE_THREE = 39;
	//не может быть константой времени компиляции
	private final int i4 = rand.nextInt(20);
	static final int INT_5 = rand.nextInt(20); //инициализируется один раз, во время загрузки класса
	private Value v1 = new Value(11);
	private final Value v2 = new Value(22);
	private static final Value VAL_3 = new Value(33);
	
	//массивы
	private final int[] a = {1, 2, 3, 4, 5, 6};
	public String toString() {
		return id + ": " + "i4 = " + i4 + ". INT_5 = " + INT_5; 
	}
	
	public static void main(String[] args) {
		
		FinalData fd1 = new FinalData("fd1");
		print(fd1.v1);
		//! fd1.valueOne++; //ошибка! значение нельзя изменить
		fd1.v2.i++; // объект не является неизменным!
		fd1.v1 = new Value(9); //ОК - не является неизменным
		for (int i = 0; i < fd1.a.length; i++) {
			fd1.a[i]++; //Объект не является неизменным!
		}
		//! fd1.v2 = new Value(0); //Ошибка: ссылку
		//! fd1.VAL_3 = new Value(1); // нельзя изменить
		//! fd1.a = new int[3];
		print(fd1);
		print("Создаем FinalData");
		FinalData fd2 = new FinalData("fd2");
		print(fd1);
		print(fd2);
	}
	
} /* Output
i = 11
fd1: i4 = 15. INT_5 = 18
Создаем FinalData
fd1: i4 = 15. INT_5 = 18
fd2: i4 = 13. INT_5 = 18
*///:~
