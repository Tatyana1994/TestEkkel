//: reusing/Car.java
// Композиция с использованием открытых объектов
package by.iba.ekkel.reusing;

//двигатель
class Engine {
	//запустить
	public void start() {}
	//переключить
	public void rev() {}
	//остановить
	public void stop() {}
}

//колесо
class Wheel {
	// накачать
	public void inflate(int psi) {}
}

//окно
class Window {
	//поднять
	public void rollup() {}
	//опустить
	public void rolldown() {}
}

//дверь
class Door {
	//окно двери
	public Window window = new Window();
	//открыть
	public void open() {}
	//закрыть
	public void close() {}
}

//машина
public class Car {
	public Engine engine = new Engine();
	public Wheel[] wheel = new Wheel[4];
	public Door 
		left = new Door(),
		right = new Door(); //двухдверная машина

	public Car() {
		for(int i = 0; i < 4; i++) {
			wheel[i] = new Wheel();
		}
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		car.left.window.rollup();
		car.wheel[0].inflate(72);
	}
	
} /* Output
*///:~

