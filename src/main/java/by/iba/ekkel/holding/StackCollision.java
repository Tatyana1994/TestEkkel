//: by.iba.ekkel.holding/StackCollision.java
package by.iba.ekkel.holding;

import by.iba.ekkel.mindview.util.*;

public class StackCollision {
	
	public static void main(String[] args) {
	
		Stack<String> stack = 
				new Stack<String>();
		for(String s : "My dog fleas".split(" ")) {
			stack.push(s);
		}
		while(!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		java.util.Stack<String> stack2 = 
				new java.util.Stack<String>();
		for(String s : "My dog fleas".split(" ")) {
			stack2.push(s);
		}
		while(!stack2.empty()) {
			System.out.print(stack2.pop() + " ");
		}
	
	}

} /* Output
fleas dog My 
fleas dog My 
*///:~
