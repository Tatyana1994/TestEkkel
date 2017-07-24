//: by.iba.ekkel.holding/LinkedListFeatures.java
package by.iba.ekkel.holding;

import by.iba.ekkel.typeinfo.pets.*;
import static by.iba.ekkel.mindview.util.Print.*;
import java.util.*;

public class LinkedListFeatures {
	
	public static void main(String[] args) {
	
		LinkedList<Pet> pets =
				new LinkedList<Pet>(Pets.arrayList(5));
		print(pets);
		//Идентично
		print("pets.getFirst(): " + pets.getFirst());
		print("pets.element(): " + pets.element());
		//Различие проявляется только для пустых списков
		print("pets.peek(): " + pets.peek());
		//Идентично, удаление и возврат первого элемента
		print("pets.remove(): " + pets.remove());
		print("pets.removeFirst(): " + pets.removeFirst());
		//Различие проявляется только для пустых списков
		print("pets.poll(): " + pets.poll());
		print(pets);
		pets.addFirst(new Rat());
		print("After addFirst(): " + pets);
		pets.offer(Pets.randomPet());
		print("After offer(): " + pets);
		pets.add(Pets.randomPet());
		print("After add(): " + pets);
		pets.addLast(new Hamster());
		print("After addLast(): " + pets);
		print("pets.removeLast(): " + pets.removeLast());
	
	}

}/* Output
[Rat, Manx, Cymric, Mutt, Pug]
pets.getFirst(): Rat
pets.element(): Rat
pets.peek(): Rat
pets.remove(): Rat
pets.removeFirst(): Manx
pets.poll(): Cymric
[Mutt, Pug]
After addFirst(): [Rat, Mutt, Pug]
After offer(): [Rat, Mutt, Pug, Cymric]
After add(): [Rat, Mutt, Pug, Cymric, Pug]
After addLast(): [Rat, Mutt, Pug, Cymric, Pug, Hamster]
pets.removeLast(): Hamster
*///:~
