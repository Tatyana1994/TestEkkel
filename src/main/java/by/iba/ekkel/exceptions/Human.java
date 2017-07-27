//: by.iba.ekkel.exceptions/Human.java
//�������� �������� ����������
package by.iba.ekkel.exceptions;

class Annoyance extends Exception {}

class Sneeze extends Annoyance {}

public class Human {
	
	public static void main(String[] args) {
	
		//�������� ������� ����
		try {
			throw new Sneeze();
		} catch(Sneeze s) {
			System.out.println("����������� Sneeze");
		} catch (Annoyance a) {
			System.out.println("����������� Annoyance");
		}
		
		//�������� �������� ����
		try {
			throw new Sneeze();
		} catch(Annoyance a) {
			System.out.println("����������� Annoyance");
		}
	
	}

} /* Output
����������� Sneeze
����������� Annoyance
*///:~
