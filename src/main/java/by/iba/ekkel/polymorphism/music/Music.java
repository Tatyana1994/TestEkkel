//: polymorphism/music/Music.java
// Наследование и восходящее преобразование
package by.iba.ekkel.polymorphism.music;

public class Music {

	public static void tune(Instrument i) {
		//...
		i.play(Note.MIDDLE_C);
	}
	
	public static void main(String[] args) {
		Wind flute = new Wind();
		tune(flute); //Восходящее преобразование
	}
	
} /* Output
Wind.play() MIDDLE_C
*///:~
