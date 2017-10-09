//: by.iba.ekkel.io/MyWord.java
package by.iba.ekkel.io;

import java.io.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

class House implements Serializable {
	
}

class Animal implements Serializable {
	private String name;
	private House preferredHouse;
	Animal(String nm, House h) {
		name = nm;
		preferredHouse = h;
	}
	public String toString() {
		return name + "[" + super.toString() +
				"]" + preferredHouse + "\n";
	}
}

public class MyWord {
	
	public static void main(String[] args) 
		throws IOException, ClassNotFoundException {
	
		House house = new House();
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Bosco the dog", house));
		animals.add(new Animal("Ralph the hamster", house));
		animals.add(new Animal("Molly the cat", house));
		print("animals: " + animals);
		
		ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
		ObjectOutputStream o1 = new ObjectOutputStream(buf1);
		o1.writeObject(animals);
		o1.writeObject(animals); // Record the second set
		//Record to the other stream
		ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
		ObjectOutputStream o2 = new ObjectOutputStream(buf2);
		o2.writeObject(animals);
		// Now recover the written objects
		ObjectInputStream in1 = new ObjectInputStream(
				new ByteArrayInputStream(buf1.toByteArray()));
		ObjectInputStream in2 = new ObjectInputStream(
				new ByteArrayInputStream(buf2.toByteArray()));
		List
			animals1 = (List)in1.readObject(),
			animals2 = (List)in1.readObject(),
			animals3 = (List)in2.readObject();
		print("animals1: " + animals1);
		print("animals2: " + animals2);
		print("animals3: " + animals3);
	
	}

} /* Output
animals: [Bosco the dog[by.iba.ekkel.io.Animal@15db9742]by.iba.ekkel.io.House@6d06d69c
, Ralph the hamster[by.iba.ekkel.io.Animal@7852e922]by.iba.ekkel.io.House@6d06d69c
, Molly the cat[by.iba.ekkel.io.Animal@4e25154f]by.iba.ekkel.io.House@6d06d69c
]
animals1: [Bosco the dog[by.iba.ekkel.io.Animal@6d03e736]by.iba.ekkel.io.House@568db2f2
, Ralph the hamster[by.iba.ekkel.io.Animal@378bf509]by.iba.ekkel.io.House@568db2f2
, Molly the cat[by.iba.ekkel.io.Animal@5fd0d5ae]by.iba.ekkel.io.House@568db2f2
]
animals2: [Bosco the dog[by.iba.ekkel.io.Animal@6d03e736]by.iba.ekkel.io.House@568db2f2
, Ralph the hamster[by.iba.ekkel.io.Animal@378bf509]by.iba.ekkel.io.House@568db2f2
, Molly the cat[by.iba.ekkel.io.Animal@5fd0d5ae]by.iba.ekkel.io.House@568db2f2
]
animals3: [Bosco the dog[by.iba.ekkel.io.Animal@2d98a335]by.iba.ekkel.io.House@16b98e56
, Ralph the hamster[by.iba.ekkel.io.Animal@7ef20235]by.iba.ekkel.io.House@16b98e56
, Molly the cat[by.iba.ekkel.io.Animal@27d6c5e0]by.iba.ekkel.io.House@16b98e56
]
*///:~
