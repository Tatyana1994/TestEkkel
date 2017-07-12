//: reusing/PlaceSetting.java
// Совмещение композиции и наследования
package by.iba.ekkel.reusing;

import static by.iba.ekkel.mindview.util.Print.*;

class Plate {
	Plate(int i) {
		print("Конструктор Plate");
	}
}

class DinnerPlate extends Plate {
	DinnerPlate(int i) {
		super(i);
		print("Конструктор DinnerPlate");
	}
}

class Utensil {
	Utensil(int i) {
		print("Конструктор Utensil");
	}
}

class Spoon extends Utensil {
	Spoon(int i) {
		super(i);
		print("Конструктор Spoon");
	}
}

class Fork extends Utensil {
	Fork(int i) {
		super(i);
		print("Конструктор Fork");
	}
}

class Knife extends Utensil {
	Knife(int i) {
		super(i);
		print("Конструктор Knife");
	}
}

class Custom {
	public Custom(int i) {
		print("Конструктор Custom");
	}
}

public class PlaceSetting extends Custom {

	private Spoon sp;
	private Fork frk;
	private Knife kn;
	private DinnerPlate pl;
	
	public PlaceSetting(int i) {
		super(i + 1);
		sp = new Spoon(i + 2);
		frk = new Fork(i + 3);
		kn = new Knife(i + 4);
		pl = new DinnerPlate(i + 5);
		print("Конструктор PlaceSettng");
	}
	
	public static void main(String[] args) {
		PlaceSetting x = new PlaceSetting(9);
	}
	
}/* Output
Конструктор Custom
Конструктор Utensil
Конструктор Spoon
Конструктор Utensil
Конструктор Fork
Конструктор Utensil
Конструктор Knife
Конструктор Plate
Конструктор DinnerPlate
Конструктор PlaceSettng
*///:~
