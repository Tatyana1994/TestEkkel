//: by.iba.ekkel.typeinfo.packageaccess/HiddenC.java
package by.iba.ekkel.typeinfo.packageaccess;

import by.iba.ekkel.typeinfo.interfacea.*;
import static by.iba.ekkel.mindview.util.Print.*;

class C implements A {
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

public class HiddenC {
		
	public static A makeA() {
		return new C();
	}


}
