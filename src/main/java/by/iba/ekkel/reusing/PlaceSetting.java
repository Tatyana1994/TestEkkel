//: reusing/PlaceSetting.java
// ���������� ���������� � ������������
package by.iba.ekkel.reusing;

import static by.iba.ekkel.mindview.util.Print.*;

class Plate {
	Plate(int i) {
		print("����������� Plate");
	}
}

class DinnerPlate extends Plate {
	DinnerPlate(int i) {
		super(i);
		print("����������� DinnerPlate");
	}
}

class Utensil {
	Utensil(int i) {
		print("����������� Utensil");
	}
}

class Spoon extends Utensil {
	Spoon(int i) {
		super(i);
		print("����������� Spoon");
	}
}

class Fork extends Utensil {
	Fork(int i) {
		super(i);
		print("����������� Fork");
	}
}

class Knife extends Utensil {
	Knife(int i) {
		super(i);
		print("����������� Knife");
	}
}

class Custom {
	public Custom(int i) {
		print("����������� Custom");
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
		print("����������� PlaceSettng");
	}
	
	public static void main(String[] args) {
		PlaceSetting x = new PlaceSetting(9);
	}
	
}/* Output
����������� Custom
����������� Utensil
����������� Spoon
����������� Utensil
����������� Fork
����������� Utensil
����������� Knife
����������� Plate
����������� DinnerPlate
����������� PlaceSettng
*///:~
