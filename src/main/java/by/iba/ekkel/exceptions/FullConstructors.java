//: by.iba.ekkel.exceptions/FullConstructors.java
package by.iba.ekkel.exceptions;

class MyException extends Exception {
	public MyException() {
		
	}
	public MyException(String msg) {
		super(msg);
	}
}

public class FullConstructors {
	public static void f() throws MyException {
		System.out.println("Возбуждаем MyException() из f()");
		throw new MyException(); 
	}
	public static void g() throws MyException {
		System.out.println("Возбуждаем MyException() из g()");
		throw new MyException("Создано в g()");
	}
	public static void main(String[] args) {
	
		try {
			f();
		} catch(MyException e) {
			e.printStackTrace(System.err);
		}
		
		try {
			g();
		} catch(MyException e) {
			e.printStackTrace(System.err);
		}
	
	}
	
} /* Output
Возбуждаем MyException() из f()
Возбуждаем MyException() из g()
by.iba.ekkel.exceptions.MyException
	at by.iba.ekkel.exceptions.FullConstructors.f(FullConstructors.java:16)
	at by.iba.ekkel.exceptions.FullConstructors.main(FullConstructors.java:25)
by.iba.ekkel.exceptions.MyException: Создано в g()
	at by.iba.ekkel.exceptions.FullConstructors.g(FullConstructors.java:20)
	at by.iba.ekkel.exceptions.FullConstructors.main(FullConstructors.java:31)
*///:~
