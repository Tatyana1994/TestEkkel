//: by.iba.ekkel.holding/SimpleCollection.java
package by.iba.ekkel.holding;

import java.util.*;

public class SimpleCollection {
	
	public static void main(String[] args) {
	
		Collection<Integer> c = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			c.add(i); //�������������� ��������
		}
		for(Integer i : c) {
			System.out.print(i + ". ");
		}
	}

} /* Output
0. 1. 2. 3. 4. 5. 6. 7. 8. 9. 
*///:~
