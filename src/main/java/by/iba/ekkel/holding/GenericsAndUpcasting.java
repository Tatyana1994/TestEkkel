//: by.iba.ekkel.holding/GenericsAndUpcasting.java
package by.iba.ekkel.holding;

import java.util.*;

class GrannySmith extends Apple { 
	
}

class Gala extends Apple {
	
}

class Fuji extends Apple {
	
}

class Braeburn extends Apple {
	
}

public class GenericsAndUpcasting {
	
	public static void main(String[] args) {
	
		ArrayList<Apple> apples = new ArrayList<Apple>();
		apples.add(new GrannySmith());
		apples.add(new Gala());
		apples.add(new Fuji());
		apples.add(new Braeburn());
		for(Apple c : apples) {
			System.out.println(c);
		}
	
	}
	
} /* Output
by.iba.ekkel.holding.GrannySmith@15db9742
by.iba.ekkel.holding.Gala@6d06d69c
by.iba.ekkel.holding.Fuji@7852e922
by.iba.ekkel.holding.Braeburn@4e25154f
*///:~
