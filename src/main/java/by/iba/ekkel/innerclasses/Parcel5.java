//: by.iba.ekkel.innerclasses/Parcel5.java
// Вложение класса в тело метода
package by.iba.ekkel.innerclasses;

public class Parcel5 {
	
	public Destination dest(String s) {
		class PDestination implements Destination {
			private String label;
			private PDestination(String whereTo) {
				label = whereTo;
			}
			public String readLabel() {
				return label;
			}		
		}
		return new PDestination(s);
	}
	
	public static void main(String[] args) {
	
		Parcel5 p = new Parcel5();
		Destination d = p.dest("Тасмания");
	
	}

}
