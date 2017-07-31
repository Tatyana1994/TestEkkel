//: by.iba.ekkel.typeinfo/FamilyVsExactType.java
// Различия между instanceOf и class
package by.iba.ekkel.typeinfo;

import static by.iba.ekkel.mindview.util.Print.*;

class Base {
	
}

class Derived extends Base {
	
}

public class FamilyVsExactType {
	
	static void test(Object x) {
		print("Тестируем x типа " + x.getClass());
		print("x instanceof Base " + (x instanceof Base));
		print("x instanceof Derived " + (x instanceof Derived));
		print("Base.isInstance(x) " + Base.class.isInstance(x));
		print("Derived.isInstance(x) " 
				+ Derived.class.isInstance(x));
		print("x.getClass() == Base.class " + 
				(x.getClass() == Base.class));
		print("x.getClass() == Derived.class " + 
				(x.getClass().equals(Derived.class)));
		print("x.getClass().equals(Base.class) " + 
				(x.getClass() == Base.class));
		print("x.getClass().equals(Derived.class) " + 
				(x.getClass().equals(Derived.class)));
	}
	
	public static void main(String[] args) {
	
		test(new Base());
		test(new Derived());
		
	}

} /* Output
Тестируем x типа class by.iba.ekkel.typeinfo.Base
x instanceof Base true
x instanceof Derived false
Base.isInstance(x) true
Derived.isInstance(x) false
x.getClass() == Base.class true
x.getClass() == Derived.class false
x.getClass().equals(Base.class) true
x.getClass().equals(Derived.class) false
Тестируем x типа class by.iba.ekkel.typeinfo.Derived
x instanceof Base true
x instanceof Derived true
Base.isInstance(x) true
Derived.isInstance(x) true
x.getClass() == Base.class false
x.getClass() == Derived.class true
x.getClass().equals(Base.class) false
x.getClass().equals(Derived.class) true
*///:~
