//: by.iba.ekkel.exceptions/FinallyWorks.java
// ���� finally ����������� ������
package by.iba.ekkel.exceptions;

class ThreeException extends Exception {
	
}

public class FinallyWorks {
	
	static int count = 0;
	public static void main(String[] args) {
		while(true) {
			try {
				//�������� ������������ ����������, � ������ ��� 0
				if(count++ == 0) {
					throw new ThreeException();
				}
				System.out.println("��� ����������");
			} catch(ThreeException e) {
				System.out.println("ThreeException");
			} finally {
				System.out.println("� ����� finally");
				if(count == 2) break; //��� ����� "while"
			}
		}
	}
} /* Output
ThreeException
� ����� finally
��� ����������
� ����� finally
*///:~

//���� finally � ����� while, ����������� ��� ������ ��������