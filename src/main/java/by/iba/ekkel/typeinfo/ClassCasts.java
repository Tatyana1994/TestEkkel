//: by.iba.ekkel.typeinfo/ClassCasts.java
package by.iba.ekkel.typeinfo;

class Building {
	
}

class House extends Building {
	
}

public class ClassCasts {

	public static void main(String[] args) {
	
		Building b = new House();
		//������ ��������� ������� � ��� ���������, ����� �������
		//�������������� ����������. 
		//������ ��� ���������� �����, ����� ��� ���������
		//������������������ ���� ������ �� Class
		//����������� ��� �������������� � �������.
		Class<House> houseType = House.class;
		House h = houseType.cast(b);
		
		h = (House)b; // �����������
	
	}
	
}
