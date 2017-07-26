//: by.iba.ekkel.exceptions/FinallyWorks.java
// Блок finally выполняется всегда
package by.iba.ekkel.exceptions;

class ThreeException extends Exception {
	
}

public class FinallyWorks {
	
	static int count = 0;
	public static void main(String[] args) {
		while(true) {
			try {
				//Операция постфиксного приращения, в первый раз 0
				if(count++ == 0) {
					throw new ThreeException();
				}
				System.out.println("Нет исключения");
			} catch(ThreeException e) {
				System.out.println("ThreeException");
			} finally {
				System.out.println("В блоке finally");
				if(count == 2) break; //вне цикла "while"
			}
		}
	}
} /* Output
ThreeException
В блоке finally
Нет исключения
В блоке finally
*///:~

//блок finally в цикле while, выполняется для каждой итерации