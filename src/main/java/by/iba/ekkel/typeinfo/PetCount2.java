//: by.iba.ekkel.typeinfo/PetCount2.java
package by.iba.ekkel.typeinfo;

import by.iba.ekkel.typeinfo.pets.*;

public class PetCount2 {
	
	public static void main(String[] args) {
	
		PetCount.PetCounter.countPets(Pets.creator);
		
	}

} /* Output
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric 
{EgyptianMau=7, Pug=3, Rat=2, Cymric=7, Mouse=2, Cat=9, Manx=7, Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}
*///:~
