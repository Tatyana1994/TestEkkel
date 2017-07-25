//: by.iba.ekkel.exceptions/ExceptionMethods.java
// демонстрация методов класса Exception
package by.iba.ekkel.exceptions;

import static by.iba.ekkel.mindview.util.Print.*;

public class ExceptionMethods {
	
	public static void main(String[] args) {
	
		try {
			throw new Exception("Мое исключение");
		} catch(Exception e) {
			print("Перехвачено");
			print("getMessage(): " + e.getMessage());
			print("getLocalizedMessage(): " + 
					e.getLocalizedMessage());
			print("toString(): " + e);
			print("printStackTrace(): ");
			e.printStackTrace(System.out);
		}
	
	}

} /* Output
Перехвачено
getMessage(): Мое исключение
getLocalizedMessage(): Мое исключение
toString(): java.lang.Exception: Мое исключение
printStackTrace(): 
java.lang.Exception: Мое исключение
	at by.iba.ekkel.exceptions.ExceptionMethods.main(ExceptionMethods.java:12)
*///:~
