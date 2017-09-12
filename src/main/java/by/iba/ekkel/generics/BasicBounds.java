//: by.iba.ekkel.generics/BasicBounds.java
package by.iba.ekkel.generics;

interface HasColor {
	java.awt.Color getColor();
}

class Colored<T extends HasColor> {
	T item;
	Colored(T item) {
		this.item = item;
	}
	T getItem() {
		return item;
	}
	//Ограничение позволяет вызвать метод
	java.awt.Color color() {
		return item.getColor();
	}
}

class Dimension {
	public int x = 10, y = 10, z = 10;
}

//Не работает -- сначала класс, потом интерфейсы
//class ColoredDimension<T extends HasColor (интерфейс) & Dimension(класс)> {
//}

//Несколько ограничений
class ColoredDimension<T extends Dimension & HasColor> {
	T item;
	ColoredDimension(T item) {
		this.item = item;
	}
	T getItem() {
		return item;
	}
	java.awt.Color color() {
		return item.getColor();
	}
	int getX() {
		return item.x;
	}
	int getY() {
		return item.y;
	}
	int getZ() {
		return item.z;
	}
}

interface Weight {
	int weight();
}

//Как и при наследовании, конкретный класс может быть только один,
// а интерфейсов может быть несколько

class Solid<T extends Dimension & HasColor & Weight> {
	T item;
	Solid(T item) {
		this.item = item;
	}
	T getItem() {
		return item;
	}
	java.awt.Color color() {
		return item.getColor();
	}
	int getX() {
		return item.x;
	}
	int getY() {
		return item.y;
	}
	int getZ() {
		return item.z;
	}
	int weight() {
		return item.weight();
	}
}

class Bounded 
	extends Dimension implements HasColor, Weight {
		public java.awt.Color getColor() {
			return null;
		}
		public int weight() {
			return 0;
		}
}


public class BasicBounds {
	
	public static void main(String[] args) {
	
		Solid<Bounded> solid = 
				new Solid<Bounded>(new Bounded());
		solid.color();
		solid.getY();
		solid.weight();
	
	}

} /* Output
*///:~

