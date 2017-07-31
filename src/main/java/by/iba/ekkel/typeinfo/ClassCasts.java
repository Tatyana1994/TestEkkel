//: by.iba.ekkel.typeinfo/ClassCasts.java
package by.iba.ekkel.typeinfo;

class Building {
	
}

class House extends Building {
	
}

public class ClassCasts {

	public static void main(String[] args) {
	
		Building b = new House();
		//Данный синтаксис полезен в тех ситуациях, когда обычное
		//преобразование невозможно. 
		//Обычно это происходит тогда, когда при написании
		//параметризованного кода ссылка на Class
		//сохраняется для преобразования в будущем.
		Class<House> houseType = House.class;
		House h = houseType.cast(b);
		
		h = (House)b; // Равнозначно
	
	}
	
}
