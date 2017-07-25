//: by.iba.ekkel.holding/ForEachCollections.java
// Синтаксис foreach работает с любыми коллекциями
package by.iba.ekkel.holding;

import java.util.*;

public class ForEachCollections {
	
	public static void main(String[] args) {
	
		Collection<String> cs = new LinkedList<String>();
		Collections.addAll(cs, 
				"Take the long way home".split(" "));
		for(String s : cs) {
			System.out.print("'" + s + "' ");
		}
	
	}

}/* Output
'Take' 'the' 'long' 'way' 'home' 
*///:~
