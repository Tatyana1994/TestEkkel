//: by.iba.ekkel.exceptions/TurnOffCheking.java
// "����������" �������������� ����������
package by.iba.ekkel.exceptions;

import java.io.*;
import static by.iba.ekkel.mindview.util.Print.*;

class WrapCheckedException {
	void throwRuntimeException(int type) {
		try {
			switch(type) {
				case 0 : throw new FileNotFoundException();
				case 1 : throw new IOException();
				case 2 : throw new RuntimeException("��� �?");
				default : return;
			}
		} catch(Exception e) {
			//���������� � ����������������
			throw new RuntimeException(e);
		}
	}
}

class SomeOtherException extends Exception {
	
}

public class TurnOffCheking {
	
	public static void main(String[] args) {
	
		WrapCheckedException wce = new WrapCheckedException();
		// ����� ������� throwRuntimeException() ��� ����� try
		// � ��������� ���������� RuntimeException �������� �����
		wce.throwRuntimeException(3);
		// ��� ����������� ����������
		for(int i = 0; i < 4; i++) {
			try {
				if(i < 3) {
					wce.throwRuntimeException(i);
				} else {
					throw new SomeOtherException();
				}
			} catch(SomeOtherException e) {
				print("SomeOtherException: " + e);
			} catch(RuntimeException re) {
				try {
					throw re.getCause();
				} catch(FileNotFoundException e) {
					print("FileNotFoundException: " + e);
				} catch (IOException e) {
					print("IOException: " + e);
				} catch(Throwable e) {
					print("Throwable: " + e);
				}
			}
		}
	
	}

} /* Output
FileNotFoundException: java.io.FileNotFoundException
IOException: java.io.IOException
Throwable: java.lang.RuntimeException: ��� �?
SomeOtherException: by.iba.ekkel.exceptions.SomeOtherException
*///:~
