//: by.iba.ekkel.exceptions/ExceptionMethods.java
// ������������ ������� ������ Exception
package by.iba.ekkel.exceptions;

import static by.iba.ekkel.mindview.util.Print.*;

public class ExceptionMethods {
	
	public static void main(String[] args) {
	
		try {
			throw new Exception("��� ����������");
		} catch(Exception e) {
			print("�����������");
			print("getMessage(): " + e.getMessage());
			print("getLocalizedMessage(): " + 
					e.getLocalizedMessage());
			print("toString(): " + e);
			print("printStackTrace(): ");
			e.printStackTrace(System.out);
		}
	
	}

} /* Output
�����������
getMessage(): ��� ����������
getLocalizedMessage(): ��� ����������
toString(): java.lang.Exception: ��� ����������
printStackTrace(): 
java.lang.Exception: ��� ����������
	at by.iba.ekkel.exceptions.ExceptionMethods.main(ExceptionMethods.java:12)
*///:~
