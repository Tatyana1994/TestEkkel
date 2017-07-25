//: by.iba.ekkel.innerclasses/LocalInnerClass.java
// ������ ������������������ ��������
package by.iba.ekkel.innerclasses;

import static by.iba.ekkel.mindview.util.Print.*;

interface Counter {
	int next();
}

public class LocalInnerClass {
	
	private int count = 0;
	Counter getCounter(final String name) {
		//��������� ���������� �����
		class LocalCounter implements Counter {
			public LocalCounter() {
				// � ���������� ����������� ������
				// ����� ���� ����������� �����������
				print("LocalCounter()");
			}
			public int next() {
				printb(name); //���������� ��������
				return count++;
			}
		}
		return new LocalCounter();
	}
	
	//�� �� ����� � ���������� ���������� �������
	Counter getCounter2(final String name) {
		return new Counter() {
			//� ����������� ����������� ������ �� ����� ����
			//������������ ������������, "��������" ������ 
			//������������� �����������
			{
				print("Counter()");
			}
			public int next() {
				printb(name); //���������� ��������
				return count++;
			}
		};
	}
	
	public static void main(String[] args) {
	
		LocalInnerClass lic = new LocalInnerClass();
		Counter
			c1 = lic.getCounter(" ���������"),
			c2 = lic.getCounter2(" ����������");
			for(int i = 0; i < 5; i++) {
				print(c1.next());
			}
			for(int i = 0; i < 5; i++) {
				print(c2.next());
			}
	
	}

}/* Output
LocalCounter()
Counter
 ���������0
 ���������1
 ���������2
 ���������3
 ���������4
 ����������5
 ����������6
 ����������7
 ����������8
 ����������9
 *///:~
