//: reusing/Wind.java
// ������������ � ���������� ��������������
package by.iba.ekkel.reusing;

class Instrument {
	public void play() {}
	static void tune(Instrument i) {
		// ...
		i.play();
	}
}

// ������� Wind ����� �������� ��������� Instrument.
// ��������� ��� ����� ��� �� ���������

public class Wind extends Instrument {
	public static void main(String[] args) {
		Wind flute = new Wind();
		Instrument.tune(flute); //���������� �������������� (upcasting)
	}
} /* Output
*///:~
