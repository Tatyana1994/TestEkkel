//: interfaces/music4/Music4.java
// Абстрактные классы и методы
package by.iba.ekkel.interfaces.music4;

import by.iba.ekkel.polymorphism.music.Note;
import static by.iba.ekkel.mindview.util.Print.*;

abstract class Instrument {
	private int i; //Память выделяется для каждого объекта
	public abstract void play(Note n);
	public String what() {
		return "Instrument";
	}
	public abstract void adjust();
}

class Wind extends Instrument {
	public void play(Note n) {
		print("Wind.play() " + n);
	}
	public String what() {
		return "Wind";
	}
	public void adjust() {
		
	}
}

class Percussion extends Instrument {
	public void play(Note n) {
		print("Percussion.play() " + n);
	}
	public String what() {
		return "Percussion";
	}
	public void adjust() {
		
	}
}

class Stringed extends Instrument {
	public void play(Note n) {
		print("Stringed.play() " + n);
	}
	public String what() {
		return "Stringed";
	}
	public void adjust() {
		
	}
}

class Brass extends Wind {
	public void play(Note n) {
		print("Brass.play() " + n);
	}
	public void adjust() {
		print("Brass adjust()");
	}
}

class WoodWind extends Wind {
	public void play(Note n) {
		print("WoodWind.play() " + n);
	}
	public String what() {
		return "WoodWind";
	}
}


public class Music4 {
	// работа метода не зависит от фактического типа объекта
	//поэтому типы, добавленные в систему, будут работать правильно
	
	static void tune(Instrument i) {
		//
		i.play(Note.MIDDLE_C);
	}
	
	static void tuneAll(Instrument[] e) {
		for(Instrument i : e) {
			tune(i);
		}
	}
	
	public static void main(String[] args) {
		//Восходящее преобразование при добавлении в массив
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new WoodWind()
		};
		tuneAll(orchestra);
	}

} /* Output
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
WoodWind.play() MIDDLE_C
*///:~
