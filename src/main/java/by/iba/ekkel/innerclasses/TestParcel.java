//: by.iba.ekkel.innerclasses/TestParcel.java
package by.iba.ekkel.innerclasses;

class Parcel4 {
	private class PContents implements Contents {
		private int i = 11;
		public int value() {
			return i;
		}
	}
	
	protected class PDestination implements Destination {
		private String label;
		private PDestination(String whereTo) {
			label = whereTo;
		}
		public String readLabel() {
			return label;
		}	
	}
	
	public Destination destintaion(String s) {
		return new PDestination(s);
	}
	public Contents contents() {
		return new PContents();
	}
}

public class TestParcel {
	
	public static void main(String[] args) {
	
		Parcel4 p = new Parcel4();
		Contents c = p.contents();
		Destination d = p.destintaion("Тасмания");
		// Запрещено - нет доступа к private-классу
		//! Parcel4.PContents pc = p.new PContents();
		
	}

}
