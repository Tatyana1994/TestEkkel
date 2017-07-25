//: by.iba.ekkel.innerclasses/BigEgg.java
// Внутренний класс нельзя переопределить 
// подобно обычному методу
package by.iba.ekkel.innerclasses;

import static by.iba.ekkel.mindview.util.Print.*;

class Egg {
	private Yolk y;
	protected class Yolk {
		public Yolk() {
			print("Egg.Yolk()");
		}
	}
	public Egg() {
		print("New Egg()");
		y = new Yolk();
	}
}

public class BigEgg extends Egg {
	
	public class Yolk {
		public Yolk() {
			print("BiggEgg.Yolk()");
		}
	}
	
	public static void main(String[] args) {
	
		new BigEgg();
	
	}

} /* Output
New Egg()
Egg.Yolk()
*///:~

