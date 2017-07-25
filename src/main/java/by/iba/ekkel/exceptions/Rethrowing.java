//: by.iba.ekkel.exceptions/Rethrowing.java
// Демонстрация метода fillInStackTrace()
package by.iba.ekkel.exceptions;

public class Rethrowing {
	
	public static void f() throws Exception {
		System.out.println("Создание исключения в f()");
		throw new Exception("возбуждено из f()");
	}
	
	public static void g() throws Exception {
		try {
			f();
		} catch(Exception e) {
			System.out.println("В методе g() e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void h() throws Exception {
		try {
			f();
		} catch(Exception e) {
			System.out.println("В методе h() e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();
		}
	}
	
	public static void main(String[] args) {
	
		try {
			g();
		} catch(Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
		
		try {
			h();
		} catch(Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
	
	}

} /* Output
Создание исключения в f()
В методе g() e.printStackTrace()
java.lang.Exception: возбуждено из f()
	at by.iba.ekkel.exceptions.Rethrowing.f(Rethrowing.java:9)
	at by.iba.ekkel.exceptions.Rethrowing.g(Rethrowing.java:14)
	at by.iba.ekkel.exceptions.Rethrowing.main(Rethrowing.java:35)
main: printStackTrace()
java.lang.Exception: возбуждено из f()
	at by.iba.ekkel.exceptions.Rethrowing.f(Rethrowing.java:9)
	at by.iba.ekkel.exceptions.Rethrowing.g(Rethrowing.java:14)
	at by.iba.ekkel.exceptions.Rethrowing.main(Rethrowing.java:35)
Создание исключения в f()
В методе h() e.printStackTrace()
java.lang.Exception: возбуждено из f()
	at by.iba.ekkel.exceptions.Rethrowing.f(Rethrowing.java:9)
	at by.iba.ekkel.exceptions.Rethrowing.h(Rethrowing.java:24)
	at by.iba.ekkel.exceptions.Rethrowing.main(Rethrowing.java:42)
main: printStackTrace()
java.lang.Exception: возбуждено из f()
	at by.iba.ekkel.exceptions.Rethrowing.h(Rethrowing.java:28)
	at by.iba.ekkel.exceptions.Rethrowing.main(Rethrowing.java:42)
*///:~

