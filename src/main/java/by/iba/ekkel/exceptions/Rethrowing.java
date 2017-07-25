//: by.iba.ekkel.exceptions/Rethrowing.java
// ������������ ������ fillInStackTrace()
package by.iba.ekkel.exceptions;

public class Rethrowing {
	
	public static void f() throws Exception {
		System.out.println("�������� ���������� � f()");
		throw new Exception("���������� �� f()");
	}
	
	public static void g() throws Exception {
		try {
			f();
		} catch(Exception e) {
			System.out.println("� ������ g() e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void h() throws Exception {
		try {
			f();
		} catch(Exception e) {
			System.out.println("� ������ h() e.printStackTrace()");
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
�������� ���������� � f()
� ������ g() e.printStackTrace()
java.lang.Exception: ���������� �� f()
	at by.iba.ekkel.exceptions.Rethrowing.f(Rethrowing.java:9)
	at by.iba.ekkel.exceptions.Rethrowing.g(Rethrowing.java:14)
	at by.iba.ekkel.exceptions.Rethrowing.main(Rethrowing.java:35)
main: printStackTrace()
java.lang.Exception: ���������� �� f()
	at by.iba.ekkel.exceptions.Rethrowing.f(Rethrowing.java:9)
	at by.iba.ekkel.exceptions.Rethrowing.g(Rethrowing.java:14)
	at by.iba.ekkel.exceptions.Rethrowing.main(Rethrowing.java:35)
�������� ���������� � f()
� ������ h() e.printStackTrace()
java.lang.Exception: ���������� �� f()
	at by.iba.ekkel.exceptions.Rethrowing.f(Rethrowing.java:9)
	at by.iba.ekkel.exceptions.Rethrowing.h(Rethrowing.java:24)
	at by.iba.ekkel.exceptions.Rethrowing.main(Rethrowing.java:42)
main: printStackTrace()
java.lang.Exception: ���������� �� f()
	at by.iba.ekkel.exceptions.Rethrowing.h(Rethrowing.java:28)
	at by.iba.ekkel.exceptions.Rethrowing.main(Rethrowing.java:42)
*///:~

