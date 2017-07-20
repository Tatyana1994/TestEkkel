//: by.iba.ekkel.holding/ApplesAndOrangesWithGenerics.java
package by.iba.ekkel.holding;

import java.util.*;

public class ApplesAndOrangesWithGenerics {
	
	public static void main(String[] args) {
	
		ArrayList<Apple> apples = new ArrayList<Apple>();
		for(int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		//ќшибка компил€ции
		//!apples.add(new Orange());
		for(int i = 0; i < apples.size(); i++) {
			System.out.println(apples.get(i).id());
		}
		//»спользование синтаксиса foreach
		for(Apple c : apples) {
			System.out.println(c.id());
		}
	
	}

} /* Output
0
1
2
0
1
2
*///:~
