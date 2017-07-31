//: by.iba.ekkel.typeinfo/PetCount4.java
package by.iba.ekkel.typeinfo;

import by.iba.ekkel.typeinfo.pets.*;
import static by.iba.ekkel.mindview.util.Print.*;
import by.iba.ekkel.mindview.util.*;

public class PetCount4 {
	
	public static void main(String[] args) {
	
		TypeCounter counter = new TypeCounter(Pet.class);
		for(Pet pet : Pets.createArray(20)) {
			printb(pet.getClass().getSimpleName() + " ");
			counter.count(pet);
		}
		print();
		print(counter);
		
	}

} /* Output
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric 
{Rodent=5, Cat=9, Cymric=5, Manx=7, Hamster=1, Mouse=2, Pug=3, Dog=6, Rat=2, Pet=20, EgyptianMau=2, Mutt=3}
*///:~
