//: initialization/Flower.java
// Calling constructors with "this"
package by.iba.ekkel.initialization;

public class Flower {
	
	int petalCount = 0;
	String s = "initial value";
	
	Flower(int petals) {
		petalCount = petals;
		System.out.println("����������� � ���������� int. petalCount= " 
							+ petalCount);
	}
	Flower(String ss) {
		System.out.println("����������� � ���������� String = " 
							+ ss);
	}
	Flower(String s, int petals) {
		this(petals);
		this.s = s;
		System.out.println("��������� String � int");
	}
	Flower() {
		this("hi", 47);
		System.out.println("����������� �� ��������� (��� ����������)");
	}
	
	void printPetalCount() {
		System.out.println("petalCount = " + petalCount + "; s = " + s);
	}
	
	public static void main(String[] args) {
		Flower x = new Flower();
		x.printPetalCount();
	}
	
} /* Output
Yammy
*///:~
