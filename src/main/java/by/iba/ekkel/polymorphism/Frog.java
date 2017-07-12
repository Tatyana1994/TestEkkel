//: polymorphism/Frog.java
// ������������ � ����������� ��������
package by.iba.ekkel.polymorphism;

import static by.iba.ekkel.mindview.util.Print.*;

class Characteristic {
	private String s;
	
	Characteristic(String s) {
		this.s = s;
		print("������� Characteristic " + s);
	}
	
	protected void dispose() {
		print("��������� Characteristic " + s);
	}
}

class Description {
	private String s;
	
	Description(String s) {
		this.s = s;
		print("������� Description " + s);
	}
	
	protected void dispose() {
		print("��������� Description " + s);
	}
}

//����� ��������
class LivingCreature {
	private Characteristic p = 
			new Characteristic("����� ��������");
	private Description t = 
			new Description("������� ����� ��������");
	LivingCreature() {
		print("LivingCreature()");
	}
	protected void dispose() {
		print("dispose() � LivingCreature");
		t.dispose();
		p.dispose();
	}
}

//��������
class Animal extends LivingCreature {
	private Characteristic p = 
			new Characteristic("����� ������");
	private Description t = 
			new Description("��������, �� ��������");
	Animal() {
		print("Animal()");
	}
	protected void dispose() {
		print("dispose() � Animal");
		t.dispose();
		p.dispose();
		super.dispose();
	}
}

//�����������
class Amphibian extends Animal {
	private Characteristic p = 
			new Characteristic("����� ���� � ����");
	private Description t = 
			new Description("� � ����, � �� �����");
	Amphibian() {
		print("Amphibian()");
	}
	protected void dispose() {
		print("dispose() � Amphibian");
		t.dispose();
		p.dispose();
		super.dispose();
	}
}

//�������
public class Frog extends Amphibian {
	private Characteristic p = 
			new Characteristic("�������");
	private Description t = 
			new Description("���� �����");
	Frog() {
		print("Frog()");
	}
	protected void dispose() {
		print("dispose() � Frog");
		t.dispose();
		p.dispose();
		super.dispose();
	}
	public static void main(String[] args) {
		Frog frog = new Frog();
		print("����");
		frog.dispose();
	}

} /* Output
������� Characteristic ����� ��������
������� Description ������� ����� ��������
LivingCrature()
������� Characteristic ����� ������
������� Description ��������, �� ��������
Animal()
������� Characteristic ����� ���� � ����
������� Description � � ����, � �� �����
Amphibian()
������� Characteristic �������
������� Description ���� �����
Frog()
����
dispose() � Frog
��������� Description ���� �����
��������� Characteristic �������
dispose() � Amphibian
��������� Description � � ����, � �� �����
��������� Characteristic ����� ���� � ����
dispose() � Animal
��������� Description ��������, �� ��������
��������� Characteristic ����� ������
dispose() � LivingCreature
��������� Description ������� ����� ��������
��������� Characteristic ����� ��������
*///:~
