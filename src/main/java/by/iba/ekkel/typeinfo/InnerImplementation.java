//: by.iba.ekkel.typeinfo/InnerImplementation.java
// Приватные внутренние классы не скрываются от рефлексии
package by.iba.ekkel.typeinfo;

import by.iba.ekkel.typeinfo.interfacea.*;
import static by.iba.ekkel.mindview.util.Print.*;

class InnerA {
	private static class C implements A {
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
	}
	public static A makeA() {
		return new C();
	}
}

public class InnerImplementation {
	
	public static void main(String[] args) throws Exception {
	
		A a = InnerA.makeA();
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
by.iba.ekkel.typeinfo.InnerA$C
public C.g()
package C.u()
protected C.v()
private C.w()
*///:~
