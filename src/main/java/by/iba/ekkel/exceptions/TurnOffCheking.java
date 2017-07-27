//: by.iba.ekkel.exceptions/TurnOffCheking.java
// "Подавление" контролируемых исключений
package by.iba.ekkel.exceptions;

import java.io.*;
import static by.iba.ekkel.mindview.util.Print.*;

class WrapCheckedException {
	void throwRuntimeException(int type) {
		try {
			switch(type) {
				case 0 : throw new FileNotFoundException();
				case 1 : throw new IOException();
				case 2 : throw new RuntimeException("Где я?");
				default : return;
			}
		} catch(Exception e) {
			//Превращаем в неконтролируемое
			throw new RuntimeException(e);
		}
	}
}

class SomeOtherException extends Exception {
	
}

public class TurnOffCheking {
	
	public static void main(String[] args) {
	
		WrapCheckedException wce = new WrapCheckedException();
		// Можно вызвать throwRuntimeException() без блока try
		// и позволить исключению RuntimeException покинуть метод
		wce.throwRuntimeException(3);
		// или перехватить исключение
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
Throwable: java.lang.RuntimeException: Где я?
SomeOtherException: by.iba.ekkel.exceptions.SomeOtherException
*///:~
