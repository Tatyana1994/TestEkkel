//: by.iba.ekkel.exceptions/LostMessage.java
// Как теряются исключения
package by.iba.ekkel.exceptions;

class VeryImportantException extends Exception {
	public String toString() {
		return "Очень важное исключение!";
	}
}

class NoHumException extends Exception {
	public String toString() {
		return "Второстепенное исключение!";
	}
}

public class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	void dispose() throws NoHumException {
		throw new NoHumException();
	}
	
	public static void main(String[] args) {
	
		try {
			LostMessage lm = new LostMessage();
			try {
				lm.f();
			} finally {
				lm.dispose();
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	
	}

} /* Output
Второстепенное исключение!
*///:~
