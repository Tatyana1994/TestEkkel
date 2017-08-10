//: by.iba.ekkel.typeinfo/AnonymousImplementation.java
// Анонимные внутренние классы тоже скрыты от рефлексии
package by.iba.ekkel.typeinfo;

import by.iba.ekkel.typeinfo.interfacea.*;
import static by.iba.ekkel.mindview.util.Print.*;

class AnonymousA {
	public static A makeA() {
		return new A() {
			public void f() {
				print("public C.f()");
			}
			public void g() {
				print("public C.g()");
			}
			void u() {
				print("package C.u()");
			}
			protected void v() {
				print("protected C.v()");
			}
			private void w() {
				print("private C.w()");
			}
		};
	}
}

public class AnonymousImplementation {
	
	public static void main(String[] args) throws Exception {
		
		A a = AnonymousA.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// Рефлексия все равно позволяет добраться до приватного класса
		HiddenImplementation.callHiddenImplementation(a, "g");
		HiddenImplementation.callHiddenImplementation(a, "u");
		HiddenImplementation.callHiddenImplementation(a, "v");
		HiddenImplementation.callHiddenImplementation(a, "w");
		
	}

} /* Output
public C.f()
by.iba.ekkel.typeinfo.AnonymousA$1
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
