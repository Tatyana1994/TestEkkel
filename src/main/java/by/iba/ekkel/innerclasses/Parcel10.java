//: by.iba.ekkel.innerclasses/Parcel10.java
// Демонстрация "инициализации экземпляра" ждя
// конструирования безымянного внутреннего класса
package by.iba.ekkel.innerclasses;

public class Parcel10 {
	
	public Destination 
		destination(final String dest, final float price) {
			return new Destination() {
				private int cost;
				//Инициализация экземпляра для каждого объекта
				{
					cost = Math.round(price);
					if(cost > 100) {
						System.out.println("Превышение бюджета!");
					}
				}
				
				private String label = dest;
				
				public String readLabel() {
					return label;
				}

			};
	}
	public static void main(String[] args) {
	
		Parcel10 p = new Parcel10();
		Destination d = p.destination("Тасмания", 101.395F);
		System.out.println(d.readLabel());
	}

}/* Output
Превышение бюджета!
*///:~
