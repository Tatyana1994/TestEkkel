//: polymorphism/PolyConstructors.java
// ������������ � ����������� ���� �� ���
// ���������, ������� ����� ���� �� �������
package by.iba.ekkel.polymorphism;

import static by.iba.ekkel.mindview.util.Print.*;

class Glyph {
	
	void draw() {
		print("Glyph draw()");
	}
	
	Glyph() {
		print("Glyph() ����� ������� draw()");
		draw();
		print("Glyph() ����� ������ draw()");
	}
	
}

class RoundGlyph extends Glyph {
	
	private int radius = 1;
	
	void draw() {
		print("RoundGlyph draw(), radius = " + radius);
	}
	
	RoundGlyph(int r) {
		radius = r;
		print("RoundGlyph RoundGlyph(), radius = " + radius);
	}
}

public class PolyConstructors {
	
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
	
} /* Output
Glyph() ����� ������� draw()
RoundGlyph draw(), radius = 0
Glyph() ����� ������� draw()
RoundGlyph RoundGlyph(), radius = 5
*///:~

