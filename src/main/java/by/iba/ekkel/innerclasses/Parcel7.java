//: by.iba.ekkel.innerclasses/Parcel7.java
// Метод возвращает экземпляр безымянного внутреннего класса
package by.iba.ekkel.innerclasses;

public class Parcel7 {
	
	public Contents contents() {
		return new Contents() { //Вставить определение класса
			
			private int i = 11;	

			public int value() {
				return i;
			}
		}; // В данном случае точка с запятой необходима
	}

	public static void main(String[] args) {
	
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
	
	}
	
} /* Output
*///:~
