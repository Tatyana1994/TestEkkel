//: polymorphism/RTTI.java
// Нисходящее преобразование и динамическое определение типов
// (RTTI)
// {ThrowException}
package by.iba.ekkel.polymorphism;

class Useful {
	
	public void f() {}
	
	public void g() {}
	
}

class MoreUseful extends Useful {
	
	public void f() {};
	public void g() {};
	public void u() {};
	public void v() {}
	public void w() {}
	
}

public class RTTI {

	public static void main(String[] args) {
		Useful[] x = {
				new Useful(),
				new MoreUseful()
		};
		x[0].f();
		x[1].g();
		// Стадия компиляции: метод не найден в классе Useful
		//! x[1].u();
		((MoreUseful)x[1]).u(); //Нисходящее преобразование RTTI
		((MoreUseful)x[0]).u(); //Происходит исключения
	}
	
} /* Output
Exception in thread "main" java.lang.ClassCastException: by.iba.ekkel.polymorphism.Useful cannot be cast to by.iba.ekkel.polymorphism.MoreUseful
	at by.iba.ekkel.polymorphism.RTTI.main(RTTI.java:37)
*///:~
