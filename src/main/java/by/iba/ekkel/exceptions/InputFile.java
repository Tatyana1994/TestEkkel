//: by.iba.ekkel.exceptions/InputFile.java
// Специфика ислключений в конструкторах
package by.iba.ekkel.exceptions;

import java.io.*;

import javax.management.RuntimeErrorException;

public class InputFile {
	
	private BufferedReader in;
	public InputFile(String fname) throws Exception {
		try {
			in = new BufferedReader(new FileReader(fname));
			//Остальной код, способный возбуждать исключения
		} catch(FileNotFoundException e) {
			System.out.println("Невозможно открыть " + fname);
			//Файл не открывался, поэтому не может быть закрыт
			throw e;
		} catch (Exception e) {
			//При других исключениях файл должен быть закрыт
			try {
				in.close();
			} catch(IOException e2) {
				System.out.println("in.close() исполнен неудачно");
			}
			throw e; //Повторное возбуждение
		} finally {
			//Не закрывайте файд здесь!!!
		}
	}
	
	public String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch(IOException e) {
			throw new RuntimeException("readLine() исполнен неудачно");
		}
		return s;
	}
	
	public void dispose() {
		try {
			in.close();
			System.out.println("dispose() успешен");
		} catch(IOException e2) {
			throw new RuntimeException("in.close() исполнен неудачно");
		}
	}

} /* Output
*///:~
