//: polymorphism/music/Wind.java
package by.iba.ekkel.polymorphism.music;

import static by.iba.ekkel.mindview.util.Print.*;

// ќбъекты Wind также €вл€ютс€ объектами Instrument
// поскольку имеют тот же интерфейс
public class Wind extends Instrument {
	
	//ѕереопределение метода интерфейса
	public void play(Note n) {
		print("Wind.play() " + n);
	}

} /* Output
*///:~
