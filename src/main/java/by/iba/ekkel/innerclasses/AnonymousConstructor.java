//: by.iba.ekkel.innerclasses/AnonymousConstructor.java
// Создание конструктора для безымянного внутреннего класса
package by.iba.ekkel.innerclasses;

import static by.iba.ekkel.mindview.util.Print.*;

abstract class Base {
	public Base(int i) {
		print("Конструктор Base, i = " + i);
	}
	public abstract void f();
}

	public class AnonymousConstructor {
		
		public static Base getBase(int i) {
			return new Base(i) {
				{
					print("Инициализация экземпляра");
				}
				public void f() {
					print("Безымянный f()");
				}
			};
		}
	
	public static void main(String[] args) {
	
		Base base = getBase(47);
		base.f();
	
	}

} /* Output
Конструктор Base, i = 47
Инициализация экземпляра
Безымянный f()
*///:~
