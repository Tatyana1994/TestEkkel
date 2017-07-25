//: by.iba.ekkel.exceptions/ExtraFeatures.java
// ���������� ���������� ������� ����������
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
		return "��������� ���������: " + x + " " + super.getMessage();
	}
}

public class ExtraFeatures {
	
	public static void f() throws MyException2 {
		print("MyException2 � f()");
		throw new MyException2();
	}
	
	public static void g() throws MyException2 {
		print("MyException2 � g()");
		throw new MyException2("���������� � g()");
	}
	
	public static void h() throws MyException2 {
		print("MyException2 � h()");
		throw new MyException2("���������� � h()", 47);
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
MyException2 � f()
by.iba.ekkel.exceptions.MyException2: ��������� ���������: 0 null
	at by.iba.ekkel.exceptions.ExtraFeatures.f(ExtraFeatures.java:33)
	at by.iba.ekkel.exceptions.ExtraFeatures.main(ExtraFeatures.java:49)
MyException2 � g()
by.iba.ekkel.exceptions.MyException2: ��������� ���������: 0 ���������� � g()
	at by.iba.ekkel.exceptions.ExtraFeatures.g(ExtraFeatures.java:38)
	at by.iba.ekkel.exceptions.ExtraFeatures.main(ExtraFeatures.java:54)
MyException2 � h()
by.iba.ekkel.exceptions.MyException2: ��������� ���������: 47 ���������� � h()
	at by.iba.ekkel.exceptions.ExtraFeatures.h(ExtraFeatures.java:43)
	at by.iba.ekkel.exceptions.ExtraFeatures.main(ExtraFeatures.java:59)
e.val() = 47
*///:~
