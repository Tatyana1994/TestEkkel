//: polymorphism/shape/RandomShapeGenerator.java
// "Фабрика", случайным образом создающая объекты
package by.iba.ekkel.polymorphism.shape;

import static by.iba.ekkel.mindview.util.Print.*;

import java.util.*;

public class RandomShapeGenerator {

	private Random rand = new Random(47);
	public Shape next() {
		switch(rand.nextInt(3)) {
			default:
			case 0 : return new Circle();
			case 1 : return new Square();
			case 2 : return new Triangle(); 
		}
	}
	
}
