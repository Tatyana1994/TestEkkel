//: reusing/Bath.java
// ������������� � ������������ � �����������
package by.iba.ekkel.reusing;

import static by.iba.ekkel.mindview.util.Print.*;

class Soap {
	
	private String s;
	
	Soap() {
		
		print("Soap()");
		s = "��������������";
		
	}
	
	public String toString() {
		return s;
	}
	
}

public class Bath {
	
	private String //������������� � ����� �����������
		s1 = "����������",
		s2 = "����������",
		s3, 
		s4;
	
	private Soap castille;
	private int i;
	private float toy;
	
	public Bath() {
		print("� ������������ Bath()");
		s3 = "���������";
		toy = 3.14f;
		castille = new Soap();
	}	
	//������������� ����������
	{
		i = 47;
	}
	
	public String toString() {
		if (s4 == null) //���������� �������������
			s4 = "���������";
		return 
				"s1 = " + s1 + "\n" +
				"s2 = " + s2 + "\n" +
				"s3 = " + s3 + "\n" +
				"s4 = " + s4 + "\n" +
				"i = " + i + "\n" +
				"toy = " + toy + "\n" +
				"castille = " + castille;
	}
	
	public static void main(String[] args) {
		Bath b = new Bath();
		print(b);
	}
	
}/* Output
� ������������ Bath()
Soap()
s1 = ����������
s2 = ����������
s3 = ���������
s4 = ���������
i = 47
toy = 3.14
castille = ��������������
*///:~
