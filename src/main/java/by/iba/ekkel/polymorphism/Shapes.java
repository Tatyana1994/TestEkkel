//: polymorphism/Shapes.java
package by.iba.ekkel.polymorphism;

import by.iba.ekkel.polymorphism.shape.*;

import static by.iba.ekkel.mindview.util.Print.*;

public class Shapes {
	
	private static RandomShapeGenerator gen = 
			new RandomShapeGenerator();
	
	public static void main(String[] args) {
		Shape[] s = new Shape[9];
		// Заполняем массив фигурами
		for(int i = 0; i < s.length; i++) {
			s[i] = gen.next();
		}
		//Полиморфные вызовы методов
		for(Shape shp : s) {
			shp.draw();
		}
	}

} /* Output
Triangle.Draw()
Triangle.Draw()
Square.Draw()
Triangle.Draw()
Square.Draw()
Triangle.Draw()
Square.Draw()
Triangle.Draw()
Circle.Draw()
*///:~

