//: access/Lunch.java
// �������������  ������� ��� �������.
// ������������� �������������, ����������� private
// ������ ����� ����������� ��� �������� ��������.
package by.iba.ekkel.access;

import static by.iba.ekkel.mindview.util.Print.*;

class Soup1 {
	 
	public static final int COPY_LIMIT = 2;
	
	private static int copyCount = 0;
	
	public static int getCopyCount() {
		return copyCount;
	}
	
	private Soup1() {
		copyCount++;
		//(1) ��������� �������� �������� � ���������� ������
		// ������������� ������� ����������� ������ �� ������� ��� ��������
	}
	
	public static Soup1 makeSoup() {
		if (Soup1.getCopyCount() < COPY_LIMIT) {
			return new Soup1();
		} else {
			print("Copy Limit exceed!!! Can't create the new one");
			return null;
		}
	}	
	
}

class Soup2 {
	 
	private Soup2() {
		//(2) ������� ���� ����������� ������ �
		// �� ���������� ���������� ������ �� ����
	}
	
	private static Soup2 ps1 = new Soup2();
	
	public static Soup2 access() {
		return ps1;
	}
	
	public void f() {
		
	}
	
}

// � ����� ����� ���� ��������� ������ ���� public-�����
public class Lunch {
	
	void testPrivate() {
		//���������, ��� ��� ����������� �������� ���������
		//! Soup1 soup1 = new Soup1();
	}
	
	void testStatic() {
		Soup1 soup1 = Soup1.makeSoup();
	}
	
	void testSingleton() {
		Soup2.access().f();
	}
	
}
