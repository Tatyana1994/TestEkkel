//: by.iba.ekkel.exceptions/ExceptionSilencer.java
package by.iba.ekkel.exceptions;

public class ExceptionSilencer {
	
	public static void main(String[] args) {
	
		try {
			throw new RuntimeException();
		} finally {
			// ������� 'return' � ����� finally
			// ��������� ��������� ����������
			return;
		}
	
	}

} /* Output
*///:~
