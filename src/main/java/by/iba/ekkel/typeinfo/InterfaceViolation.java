//: by.iba.ekkel.typeinfo/InterfaceViolation.java
// Интерфейс можно обойти
package by.iba.ekkel.typeinfo;

import by.iba.ekkel.typeinfo.interfacea.*;

class B implements A {
	public void f() {}
	public void g() {}
}

public class InterfaceViolation {
	
	public static void main(String[] args) {
	
		A a = new B();
		a.f();
		// a.g(); //Ошибка компиляции
		System.out.println(a.getClass().getName());
		if(a instanceof B) {
			B b = (B)a;
			b.g();
		}
	
	}

} /* Output
by.iba.ekkel.typeinfo.B
*///:~

