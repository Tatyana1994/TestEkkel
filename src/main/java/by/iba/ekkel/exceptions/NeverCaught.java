//: by.iba.ekkel.exceptions/NeverCaught.java
// ������������� RuntimeExceptions
// {ThrowsException}
package by.iba.ekkel.exceptions;

public class NeverCaught {
	
	static void f() {
		throw new RuntimeException("�� f()");
	}
	static void g() {
		f();
	}
	public static void main(String[] args) {
	
		g();
	
	}

} /* Output
Exception in thread "main" java.lang.RuntimeException: �� f()
	at by.iba.ekkel.exceptions.NeverCaught.f(NeverCaught.java:9)
	at by.iba.ekkel.exceptions.NeverCaught.g(NeverCaught.java:12)
	at by.iba.ekkel.exceptions.NeverCaught.main(NeverCaught.java:16)
*///:~

