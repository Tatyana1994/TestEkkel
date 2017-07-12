//: polymorphism/music/Music2.java
// ���������� ������ ����������� ��������������
package by.iba.ekkel.polymorphism.music;

import static by.iba.ekkel.mindview.util.Print.*;

class Stringed extends Instrument {
	public void play(Note n) {
		print("Stringed.play() " + n);
	}
}

class Brass extends Instrument {
	public void play(Note n) {
		print("Brass.play() " + n);
	}
}

public class Music2 {
	
	public static void tune(Wind i) {
		i.play(Note.MIDDLE_C);
	}
	
	public static void tune(Stringed i) {
		i.play(Note.MIDDLE_C);
	}
	
	public static void tune(Brass i) {
		i.play(Note.MIDDLE_C);
	}
	
	public static void main(String[] args) {
		Wind flute = new Wind();
		Stringed violin = new Stringed();
		Brass frenchCorn = new Brass();
		tune(flute);//��� ����������� ��������������
		tune(violin);
		tune(frenchCorn);
	}

} /* Output
Wind.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
*///:~

