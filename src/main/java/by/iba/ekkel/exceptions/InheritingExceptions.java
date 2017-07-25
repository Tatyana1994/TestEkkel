//: by.iba.ekkel.exceptions/InheritingExceptions.java
// �������� ������������ ����������
package by.iba.ekkel.exceptions;

class SimpleException extends Exception {
	
}

public class InheritingExceptions {
	
	public void f() throws SimpleException {
		System.out.println("���������� SimpleException �� f()");
		throw new SimpleException();
	}
	
	public static void main(String[] args) {
	
		InheritingExceptions sed = new InheritingExceptions();
		try {
			sed.f();
		} catch(SimpleException e) {
			System.out.println("�����������!");
		}
		
	}

} /* Output
���������� SimpleException �� f()
�����������!
*///:~
