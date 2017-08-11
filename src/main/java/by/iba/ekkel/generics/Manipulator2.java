//: by.iba.ekkel.generics/Manipulator2.java
package by.iba.ekkel.generics;

public class Manipulator2<T extends HasF> {
	private T obj;
	public Manipulator2(T x) {
		obj = x;
	}
	public void manipulate() {
		obj.f();
	}

} /* Output
*///:~
