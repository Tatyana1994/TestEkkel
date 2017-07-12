//: control/BreakAndContinue.java
package by.iba.ekkel.control;

import java.util.Random;

public class BreakAndContinue {
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if(i == 74) break;
			if(i % 9 != 0) continue;
			System.out.print(i + " ");
		}
		System.out.println();
		
		//Использование foreach
		int arr[] = new int[100];
		Random rand = new Random(47);
		for (int i = 0; i < 100; i++) {
			arr[i] = rand.nextInt(100);
		}
		for(int i : arr) {	
			if(i == 74) {
				break;
			}
			if(i % 9 != 0) {
				continue;
			}
			System.out.print(i + " ");
		}
		System.out.println();
		
		//"Бесконечный цикл"
		int i = 0;
		while (true) {
			i++;
			int j = i * 27;
			if(j == 1269) {
				break;
			}
			if(i % 10 != 0) {
				continue;
			}
			System.out.print(i + " ");
		}		
	}
}/* Output
0 9 18 27 36 45 54 63 72 
0 9 
10 20 30 40 
*///:~
