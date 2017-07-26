//: by.iba.ekkel.exceptions/AlwaysFinally.java
// Finally ����������� ������
package by.iba.ekkel.exceptions;

import static by.iba.ekkel.mindview.util.Print.*;

class FourException extends Exception {
	
}

public class AlwaysFinally {
	
	public static void main(String[] args) {
	
		print("������ � ������ ���� try");
		try {
			print("������ �� ������ ���� try");
			try {
				throw new FourException();
			} finally {
				print("finally �� ������ ����� try");
			}
		} catch(FourException e) {
			System.out.println("����������� FourException � ������ ����� try");
		} finally {
			System.out.println("finally � ������ ����� try");
		}
	
	}

} /* Output
������ � ������ ���� try
������ �� ������ ���� try
finally �� ������ ����� try
����������� FourException � ������ ����� try
finally � ������ ����� try
*///:~


