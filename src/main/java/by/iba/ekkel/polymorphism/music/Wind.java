//: polymorphism/music/Wind.java
package by.iba.ekkel.polymorphism.music;

import static by.iba.ekkel.mindview.util.Print.*;

// ������� Wind ����� �������� ��������� Instrument
// ��������� ����� ��� �� ���������
public class Wind extends Instrument {
	
	//��������������� ������ ����������
	public void play(Note n) {
		print("Wind.play() " + n);
	}

} /* Output
*///:~
