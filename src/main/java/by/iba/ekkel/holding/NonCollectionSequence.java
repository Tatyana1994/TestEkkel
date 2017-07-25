//: by.iba.ekkel.holding/NonCeoolectionSequence.java
package by.iba.ekkel.holding;

import java.util.*;
import by.iba.ekkel.typeinfo.pets.*;

class PetSequence {
	protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence {
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			private int index = 0;
			public boolean hasNext() {
				return index < pets.length;
			}
			public Pet next() {
				return pets[index++];
			}
			public void remove() {// Не реализован
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String[] args) {
	
		NonCollectionSequence nc = new NonCollectionSequence();
		InterfaceVsIterator.display(nc.iterator());
	
	}

} /* Output
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 
*///:~
