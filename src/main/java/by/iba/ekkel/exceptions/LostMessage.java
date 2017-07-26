//: by.iba.ekkel.exceptions/LostMessage.java
// ��� �������� ����������
package by.iba.ekkel.exceptions;

class VeryImportantException extends Exception {
	public String toString() {
		return "����� ������ ����������!";
	}
}

class NoHumException extends Exception {
	public String toString() {
		return "�������������� ����������!";
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
�������������� ����������!
*///:~
