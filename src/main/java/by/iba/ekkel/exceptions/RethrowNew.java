//: by.iba.ekkel.exceptions/RethrowNew.java
// ��������� ����������� �������
// ������������� �� ���������������
package by.iba.ekkel.exceptions;

class OneException extends Exception {
	public OneException(String s) {
		super(s);
	}
}

class TwoException extends Exception {
	public TwoException(String s) {
		super(s);
	}
}

public class RethrowNew {
	
	public static void f() throws OneException {
		System.out.println("�������� ���������� � f()");
		throw new OneException("�� f()");
	}
	
	public static void main(String[] args) {
	
		try {
			try {
				f();
			} catch(OneException e) {
				System.out.println("�� ���������� ����� try, e.printStackTrace()");
				e.printStackTrace(System.out);
				throw new TwoException("�� ����������� ����� try");
			}
		} catch(TwoException e) {
				System.out.println("�� ������� ����� try, e.printStackTrace()");
				e.printStackTrace(System.out);
			}
	
	}

} /* Output
�������� ���������� � f()
�� ���������� ����� try, e.printStackTrace()
by.iba.ekkel.exceptions.OneException: �� f()
	at by.iba.ekkel.exceptions.RethrowNew.f(RethrowNew.java:22)
	at by.iba.ekkel.exceptions.RethrowNew.main(RethrowNew.java:29)
�� ������� ����� try, e.printStackTrace()
by.iba.ekkel.exceptions.TwoException: �� ����������� ����� try
	at by.iba.ekkel.exceptions.RethrowNew.main(RethrowNew.java:33)
*///:~
