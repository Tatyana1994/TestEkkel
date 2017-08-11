//: by.iba.ekkel.generics/ReturnGenericType.java
package by.iba.ekkel.generics;

public class ReturnGenericType<T extends HasF> {
	
	private T obj;
	public ReturnGenericType(T x) {
		obj = x;
	}
	public T get() {
		return obj;
	}

} /* Output
*///:~
