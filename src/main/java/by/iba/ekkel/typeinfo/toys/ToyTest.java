//: by.iba.ekkel.typeinfo.toys/ToyTest.java
// Тестирование класса Class
package by.iba.ekkel.typeinfo.toys;

import static by.iba.ekkel.mindview.util.Print.*;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
	// Если закомментироваться следующий далее конструктор
	// по умолчанию, тогда в строке с пометкой *1*
	// возникнет ошибка NoSuchMethosError
	Toy() {
		
	}
	Toy(int i) {
		
	}
}

class FancyToy extends Toy 
	implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc) {
		print("Имя класса: " + cc.getName() +
				" это интерфейс? [" + cc.isInterface() + "]");
		print("Простое имя: " + cc.getSimpleName());
		print("Каноническое имя: " + cc.getCanonicalName());
	}
	
	public static void main(String[] args) {
	
		Class c = null;
		try {
			c = Class.forName("by.iba.ekkel.typeinfo.toys.FancyToy");
		} catch(ClassNotFoundException e) {
			print("Не найден класс FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class face : c.getInterfaces()) {
			printInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			//Необходим конструктор по умолчанию
			obj = up.newInstance();
		} catch(InstantiationException e) {
			print("Не удалось создать объект");
			System.exit(1);
		} catch (IllegalAccessException e) {
			print("Нет доступа");
			System.exit(1);
		}
		printInfo(obj.getClass());
	
	}

} /* Output
Имя класса: by.iba.ekkel.typeinfo.toys.FancyToy это интерфейс? [false]
Простое имя: FancyToy
Каноническое имя: by.iba.ekkel.typeinfo.toys.FancyToy
Имя класса: by.iba.ekkel.typeinfo.toys.HasBatteries это интерфейс? [true]
Простое имя: HasBatteries
Каноническое имя: by.iba.ekkel.typeinfo.toys.HasBatteries
Имя класса: by.iba.ekkel.typeinfo.toys.Waterproof это интерфейс? [true]
Простое имя: Waterproof
Каноническое имя: by.iba.ekkel.typeinfo.toys.Waterproof
Имя класса: by.iba.ekkel.typeinfo.toys.Shoots это интерфейс? [true]
Простое имя: Shoots
Каноническое имя: by.iba.ekkel.typeinfo.toys.Shoots
Имя класса: by.iba.ekkel.typeinfo.toys.Toy это интерфейс? [false]
Простое имя: Toy
Каноническое имя: by.iba.ekkel.typeinfo.toys.Toy
*///:~
