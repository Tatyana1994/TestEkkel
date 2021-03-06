//: by.iba.ekkel.exceptions/InputFile.java
// ��������� ����������� � �������������
package by.iba.ekkel.exceptions;

import java.io.*;

import javax.management.RuntimeErrorException;

public class InputFile {
	
	private BufferedReader in;
	public InputFile(String fname) throws Exception {
		try {
			in = new BufferedReader(new FileReader(fname));
			//��������� ���, ��������� ���������� ����������
		} catch(FileNotFoundException e) {
			System.out.println("���������� ������� " + fname);
			//���� �� ����������, ������� �� ����� ���� ������
			throw e;
		} catch (Exception e) {
			//��� ������ ����������� ���� ������ ���� ������
			try {
				in.close();
			} catch(IOException e2) {
				System.out.println("in.close() �������� ��������");
			}
			throw e; //��������� �����������
		} finally {
			//�� ���������� ���� �����!!!
		}
	}
	
	public String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch(IOException e) {
			throw new RuntimeException("readLine() �������� ��������");
		}
		return s;
	}
	
	public void dispose() {
		try {
			in.close();
			System.out.println("dispose() �������");
		} catch(IOException e2) {
			throw new RuntimeException("in.close() �������� ��������");
		}
	}

} /* Output
*///:~
