//: by.iba.ekkel.typeinfo.toys/ToyTest.java
// ������������ ������ Class
package by.iba.ekkel.typeinfo.toys;

import static by.iba.ekkel.mindview.util.Print.*;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
	// ���� ������������������ ��������� ����� �����������
	// �� ���������, ����� � ������ � �������� *1*
	// ��������� ������ NoSuchMethosError
	Toy() {
		
	}
	Toy(int i) {
		
	}
}

class FancyToy extends Toy 
	implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc) {
		print("��� ������: " + cc.getName() +
				" ��� ���������? [" + cc.isInterface() + "]");
		print("������� ���: " + cc.getSimpleName());
		print("������������ ���: " + cc.getCanonicalName());
	}
	
	public static void main(String[] args) {
	
		Class c = null;
		try {
			c = Class.forName("by.iba.ekkel.typeinfo.toys.FancyToy");
		} catch(ClassNotFoundException e) {
			print("�� ������ ����� FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class face : c.getInterfaces()) {
			printInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			//��������� ����������� �� ���������
			obj = up.newInstance();
		} catch(InstantiationException e) {
			print("�� ������� ������� ������");
			System.exit(1);
		} catch (IllegalAccessException e) {
			print("��� �������");
			System.exit(1);
		}
		printInfo(obj.getClass());
	
	}

} /* Output
��� ������: by.iba.ekkel.typeinfo.toys.FancyToy ��� ���������? [false]
������� ���: FancyToy
������������ ���: by.iba.ekkel.typeinfo.toys.FancyToy
��� ������: by.iba.ekkel.typeinfo.toys.HasBatteries ��� ���������? [true]
������� ���: HasBatteries
������������ ���: by.iba.ekkel.typeinfo.toys.HasBatteries
��� ������: by.iba.ekkel.typeinfo.toys.Waterproof ��� ���������? [true]
������� ���: Waterproof
������������ ���: by.iba.ekkel.typeinfo.toys.Waterproof
��� ������: by.iba.ekkel.typeinfo.toys.Shoots ��� ���������? [true]
������� ���: Shoots
������������ ���: by.iba.ekkel.typeinfo.toys.Shoots
��� ������: by.iba.ekkel.typeinfo.toys.Toy ��� ���������? [false]
������� ���: Toy
������������ ���: by.iba.ekkel.typeinfo.toys.Toy
*///:~
