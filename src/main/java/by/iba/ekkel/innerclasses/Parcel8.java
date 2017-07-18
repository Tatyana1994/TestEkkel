//: by.iba.ekkel.innerclasses/Parcel8.java
// Вызов конструктора базового класса
package by.iba.ekkel.innerclasses;

public class Parcel8 {
	
	public Wrapping wrapping(int x) {
		//Вызов конструктора базового класса
		return new Wrapping(x) { // аргумент конструктора
			public int value() {
				return super.value() * 47;
			}
		}; //требуется точка с запятой
	}
	
	public static void main(String[] args) {
	
		Parcel8 p = new Parcel8();
		Wrapping w = p.wrapping(10);
		
	}

} /* Output
*///:~
