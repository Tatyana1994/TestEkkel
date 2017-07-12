//: mindview/util/Print.java
// ������ ������, ������� ����� �������������� ��� ��������������, ���������
// ����������� JAVA SE5 static import
package by.iba.ekkel.mindview.util;

import java.io.*;

public class Print {
	
	//������ � ��������� ������
	public static void print(Object obj) {
		System.out.println(obj);
	}
	
	//������� ������
	public static void print() {
		System.out.println();
	}
	
	//������ ��� �������� ������
	public static void printb(Object obj) {
		System.out.print(obj);
	}
	
	 
	//����� ����������� Java SE5 printf() (�� ����� �)
	public static PrintStream printf(String format, Object... args) {
		return System.out.printf(format, args);
	}
	
}
