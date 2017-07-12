//: reusing/CADSystem.java
// Обеспечение необходимого завершения
package by.iba.ekkel.reusing;

import static by.iba.ekkel.mindview.util.Print.*;

class Shape {
	Shape(int i) {
		print("Constructor Shape");
	}
	
	void dispose() {
		print("End Shape");
	}
}

class Circle extends Shape {
	Circle(int i) {
		super(i);
		print("Draw circle Circle");
	}
	
	void dispose() {
		print("Erase circle Circle");
		super.dispose();
	}
}

class Triangle extends Shape {
	Triangle(int i) {
		super(i);
		print("Draw triangle Triangle");
	}
	
	void dispose() {
		print("Erase triangle Triangle");
		super.dispose();
	}
}

class Line extends Shape {
	private int start, end;
	Line(int start, int end) {
		super(start);
		this.start = start;
		this.end = end;
		print("Draw line Line: " + start + ", " + end);
	}
	
	void dispose() {
		print("Erase line Line: " + start + ", " + end);
		super.dispose();
	}
}

public class CADSystem extends Shape {
	
	private Circle c;
	private Triangle t;
	private Line[] lines = new Line[3];
	
	public CADSystem(int i) {
		super(i + 1);
		for (int j = 0; j < lines.length; j++) {
			lines[j] = new Line(j, j * j);
		}
		c = new Circle(1);
		t = new Triangle(1);
		print("Combine Constrructor");
	}
	
	void dispose() {
		print("CADSystem.dispose()");
		//Завершение осуществляется в порядке
		//обратном порядку инициализации
		t.dispose();
		c.dispose();
		for (int i = lines.length - 1; i >= 0; i--) {
			lines[i].dispose();
		}
		super.dispose();
	}
	
	public static void main(String[] args) {
		CADSystem x = new CADSystem(47);
		try {
			//Код и обработка исключений
		} finally {
			x.dispose();
		}
	}

} /* Output
Constructor Shape
Constructor Shape
Draw line Line: 0, 0
Constructor Shape
Draw line Line: 1, 1
Constructor Shape
Draw line Line: 2, 4
Constructor Shape
Draw circle Circle
Constructor Shape
Draw triangle Triangle
Combine Constrructor
CADSystem.dispose()
Erase triangle Triangle
End Shape
Erase circle Circle
End Shape
Erase line Line: 2, 4
End Shape
Erase line Line: 1, 1
End Shape
Erase line Line: 0, 0
End Shape
End Shape
*///:~

