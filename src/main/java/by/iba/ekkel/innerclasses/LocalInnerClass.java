//: by.iba.ekkel.innerclasses/LocalInnerClass.java
// ’ранит последовательность объектов
package by.iba.ekkel.innerclasses;

import static by.iba.ekkel.mindview.util.Print.*;

interface Counter {
	int next();
}

public class LocalInnerClass {
	
	private int count = 0;
	Counter getCounter(final String name) {
		//Ћокальный внутренний класс
		class LocalCounter implements Counter {
			public LocalCounter() {
				// ” локального внутреннего класса
				// может быть собственный конструктор
				print("LocalCounter()");
			}
			public int next() {
				printb(name); //неизменный аргумент
				return count++;
			}
		}
		return new LocalCounter();
	}
	
	//“о же самое с безым€нным внутренним классом
	Counter getCounter2(final String name) {
		return new Counter() {
			//” безым€нного внутреннего класса не может быть
			//именованного конструктора, "легальна" только 
			//инициализаци€ экземпл€ром
			{
				print("Counter()");
			}
			public int next() {
				printb(name); //неизменный аргумент
				return count++;
			}
		};
	}
	
	public static void main(String[] args) {
	
		LocalInnerClass lic = new LocalInnerClass();
		Counter
			c1 = lic.getCounter(" локальный"),
			c2 = lic.getCounter2(" безым€нный");
			for(int i = 0; i < 5; i++) {
				print(c1.next());
			}
			for(int i = 0; i < 5; i++) {
				print(c2.next());
			}
	
	}

}/* Output
LocalCounter()
Counter
 локальный0
 локальный1
 локальный2
 локальный3
 локальный4
 безым€нный5
 безым€нный6
 безым€нный7
 безым€нный8
 безым€нный9
 *///:~
