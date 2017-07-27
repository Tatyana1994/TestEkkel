//: by.iba.ekkel.exceptions/MainException.java
package by.iba.ekkel.exceptions;

import java.io.*;

public class MainException {
	
	//�������� ��� ���������� �� �������
	public static void main(String[] args) throws Exception {
	
		//��������� ����
		FileInputStream file = 
				new FileInputStream("MainException.java");
		//���������� ����
		//��������� ����
		file.close();
	
	}

} /* Output
Exception in thread "main" java.io.FileNotFoundException: MainException.java (The system cannot find the file specified)
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(Unknown Source)
	at java.io.FileInputStream.<init>(Unknown Source)
	at java.io.FileInputStream.<init>(Unknown Source)
	at by.iba.ekkel.exceptions.MainException.main(MainException.java:13)
*///:~
