//: by.iba.ekkel.innerclasses/Parcel1.java
// —оздание внутренних классов
package by.iba.ekkel.innerclasses;

public class Parcel1 {
	
	class Contents {
		private int i = 11;
		public int value() {
			return i;
		}
	}
	
	class Destination {
		private String label;
		Destination(String whereTo) {
			label = whereTo;
		}
		String readLabel() {
			return label;
		}
	}
	
	//»спользование внутренних классов имеет много общего
	//с использованием любых других классов в пределах Parcel1:
	public void ship(String dest) {
		Contents c = new Contents();
		Destination d = new Destination(dest);
		System.out.println(d.readLabel());
	}
	
	public static void main(String[] args) {
	
		Parcel1 p = new Parcel1();
		p.ship("“асмани€");
		
	}

} /* Output
“асмани€
*///:~
