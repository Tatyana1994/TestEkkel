//: reusing/Chess.java
// Наследование, конструкторы и аргументы
package by.iba.ekkel.reusing;

import static by.iba.ekkel.mindview.util.Print.*;

class Game {
	
	Game(int i) {
		print("Конструктор Game");
	}
	
}

class BoardGame extends Game {
	
	BoardGame(int i) {
		super(i);
		print("Конструктор BoardGame");
	}
	
}

public class Chess extends BoardGame {
	
	Chess() {
		super(11);
		print("Конструктор Chess");
	}
	
	public static void main(String[] args) {
		Chess x = new Chess();
	}

} /* Output
Конструктор Game
Конструктор BoardGame
Конструктор Chess
*///:~

