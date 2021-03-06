//: polymorphism/PrivateOverride.java
// Попытка переопределения приватного метода
package by.iba.ekkel.polymorphism;

import static by.iba.ekkel.mindview.util.Print.*;

public class PrivateOverride {
	
	private void f() {
		print("private f()");
	}
	
	public static void main(String[] args) {
		PrivateOverride po = new Derived();
		po.f();
	}

}

class Derived extends PrivateOverride {
	public void f() {
		print("public f()");
	}
} /* Output
private f()
*///:~
