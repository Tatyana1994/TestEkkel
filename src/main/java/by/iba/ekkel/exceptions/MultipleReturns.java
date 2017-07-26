//: by.iba.ekkel.exceptions/MultipleReturns.java
package by.iba.ekkel.exceptions;

import static by.iba.ekkel.mindview.util.Print.*;

public class MultipleReturns {
	
	public static void f(int i) {
		print("�������������, ��������� ����������");
		try {
			print("�����1");
			if(i == 1) return;
			print("�����2");
			if(i == 2) return;
			print("�����3");
			if(i == 3) return;
			print("�����");
			return;
		} finally {
			print("����������");
		}
	}
	
	public static void main(String[] args) {
	
		for(int i = 1; i <= 4; i++) {
				f(i);
		}
		
	}

} /* Output
�������������, ��������� ����������
�����1
����������
�������������, ��������� ����������
�����1
�����2
����������
�������������, ��������� ����������
�����1
�����2
�����3
����������
�������������, ��������� ����������
�����1
�����2
�����3
�����
����������
*///:~
