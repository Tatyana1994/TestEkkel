//: by.iba.ekkel.generics/ErasureAndInheritance.java
package by.iba.ekkel.generics;

class GenericBase<T> {
	private T element;
	public void set(T arg) {
		arg = element;
	}
	public T get() {
		return element;
	}
}

class Derived1<T> extends GenericBase<T> {
	
}

class Derived2<T> extends GenericBase {
	
} //Без предупреждений

//class Derived3 extends GenericBase<?> {
//	!!!Err: The type Derived3 cannot extend or implement GenericBase<?>. A supertype may not specify any wildcard
//}

public class ErasureAndInheritance {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Derived2 d2 = new Derived2();
		Object obj = d2.get();
		d2.set(obj); //Warning!!!
		
	}
} /* Output
*///:~
