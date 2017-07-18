//: by.iba.ekkel.innerclasses/Parcel9.java
// Безымянный внутренний класс, выполняющий инициализацию
// Более короткая версия программы Parcel5.java
package by.iba.ekkel.innerclasses;

public class Parcel9 {
	
	// Для использования в безымянном внутреннем классе
	// аргументы должны быть неизменны (final)
	public Destination destination(final String dest) {
		return new Destination() {
			private String label = dest;
			public String readLabel() {
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
	
		Parcel9 p = new Parcel9();
		Destination d = p.destination("Тасмания");
		
	}

} /* Output
*///:~
