//: reusing/Chess.java
// ������������, ������������ � ���������
package by.iba.ekkel.reusing;

import static by.iba.ekkel.mindview.util.Print.*;

class Game {
	
	Game(int i) {
		print("����������� Game");
	}
	
}

class BoardGame extends Game {
	
	BoardGame(int i) {
		super(i);
		print("����������� BoardGame");
	}
	
}

public class Chess extends BoardGame {
	
	Chess() {
		super(11);
		print("����������� Chess");
	}
	
	public static void main(String[] args) {
		Chess x = new Chess();
	}

} /* Output
����������� Game
����������� BoardGame
����������� Chess
*///:~

