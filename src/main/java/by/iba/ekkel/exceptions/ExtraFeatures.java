//: by.iba.ekkel.exceptions/ExtraFeatures.java
// Дальнейшее расширение классов исключений
package by.iba.ekkel.exceptions;

import static by.iba.ekkel.mindview.util.Print.*;


class MyException2 extends Exception {
	private int x;
	public MyException2() {
		
	}
	public MyException2(String msg) {
		super(msg);
	}
	public MyException2(String msg, int x) {
		super(msg);
		this.x = x;
	}
	public int val() {
		return x;
	}
	public String getMessage() {
		return "Подробное сообщение: " + x + " " + super.getMessage();
	}
}

public class ExtraFeatures {
	
	public static void f() throws MyException2 {
		print("MyException2 в f()");
		throw new MyException2();
	}
	
	public static void g() throws MyException2 {
		print("MyException2 в g()");
		throw new MyException2("Возбуждено в g()");
	}
	
	public static void h() throws MyException2 {
		print("MyException2 в h()");
		throw new MyException2("Возбуждено в h()", 47);
	}
	
	public static void main(String[] args) {
	
		try {
			f();
		} catch(MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			g();
		} catch(MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			h();
		} catch(MyException2 e) {
			e.printStackTrace(System.out);
			System.out.println("e.val() = " + e.val());
		}
	
	}
	
}/* Output
MyException2 в f()
by.iba.ekkel.exceptions.MyException2: Подробное сообщение: 0 null
	at by.iba.ekkel.exceptions.ExtraFeatures.f(ExtraFeatures.java:33)
	at by.iba.ekkel.exceptions.ExtraFeatures.main(ExtraFeatures.java:49)
MyException2 в g()
by.iba.ekkel.exceptions.MyException2: Подробное сообщение: 0 Возбуждено в g()
	at by.iba.ekkel.exceptions.ExtraFeatures.g(ExtraFeatures.java:38)
	at by.iba.ekkel.exceptions.ExtraFeatures.main(ExtraFeatures.java:54)
MyException2 в h()
by.iba.ekkel.exceptions.MyException2: Подробное сообщение: 47 Возбуждено в h()
	at by.iba.ekkel.exceptions.ExtraFeatures.h(ExtraFeatures.java:43)
	at by.iba.ekkel.exceptions.ExtraFeatures.main(ExtraFeatures.java:59)
e.val() = 47
*///:~
