//: polymorphism/Transmogrify.java
// Динамическое изменение поведения объекта
// с помощью композиции (шаблон проектирования "Состояние")
package by.iba.ekkel.polymorphism;

import static by.iba.ekkel.mindview.util.Print.*;

class Actor {
	public void act() {
		
	};
}

class HappyActor extends Actor {
	public void act() {
		print("Happy Actor");
	}
}

class SadActor extends Actor {
	public void act() {
		print("Sad Actor");
	}
}

class Stage {
	private Actor actor = new HappyActor();
	
	public void change() {
		actor = new SadActor();
	}
	
	public void performPlay() {
		actor.act();
	}
	
}

public class Transmogrify {
	
	public static void main(String[] args) {
		Stage stage = new Stage();
		stage.performPlay();
		stage.change();
		stage.performPlay();
	}

} /* Output
Happy Actor
Sad Actor
*///:~
