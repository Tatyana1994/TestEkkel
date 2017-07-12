//: control/VowelsAndConsonants.java
package by.iba.ekkel.control;

import java.util.*;

public class VowelsAndConsonants {
	
	public static void main(String[] args) {
		
		Random rand = new Random(70);
		for (int i = 0; i < 10; i++) {
			int c = rand.nextInt(26) + 'a';
			System.out.print((char)c + ". " + c + ": ");
			switch(c) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u': System.out.println("vowel");
						  break;
				case 'y':
				case 'w': System.out.println("Conditionally vowel");
				  		  break;
				default: System.out.println("consonant");
			}
		}
		
	}

}/* Output
o. 111: vowel
g. 103: consonant
s. 115: consonant
x. 120: consonant
d. 100: consonant
m. 109: consonant
y. 121: Conditionally vowel
o. 111: vowel
h. 104: consonant
d. 100: consonant
*///:~

