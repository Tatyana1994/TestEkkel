//: by.iba.ekkel.generics/BankTeller.java
// ќчень проста€ имитаци€ банковского обслуживани€
package by.iba.ekkel.generics;

import java.util.*;
import by.iba.ekkel.mindview.util.*;

class Customer {
	private static long counter = 1;
	private final long id = counter++;
	
	private Customer() {
		
	}
	
	public String toString() {
		return "Customer: " + id;
	}
	
	//ћетод дл€ получени€ объектов Generator
	public static Generator<Customer> generator() {
		return new Generator<Customer>() {
			public Customer next() {
				return new Customer();
			}
		};
	}
}

class Teller {
	private static long counter = 1;
	private final long id = counter++;
	private Teller() {
		
	}
	public String toString() {
		return "Teller: " + id;
	}
	//—инглетный объект Generator
	public static Generator<Teller> generator = 
			new Generator<Teller>() {		
				public Teller next() {
						return new Teller();
		}
	};
}

public class BankTeller {

	public static void serve(Teller t, Customer c) {
		System.out.println(t + " обслуживает " + c);
	}
	
	public static void main(String[] args) {
	
		Random rand = new Random(47);
		Queue<Customer> line = new LinkedList<Customer>();
		Generators.fill(line, Customer.generator(), 15);
		List<Teller> tellers = new ArrayList<Teller>();
		Generators.fill(tellers, Teller.generator, 4);
		for(Customer c : line) {
			serve(tellers.get(rand.nextInt(tellers.size())), c);
		}
	
	}
	
} /* Output
Teller: 3 обслуживает Customer: 1
Teller: 2 обслуживает Customer: 2
Teller: 3 обслуживает Customer: 3
Teller: 1 обслуживает Customer: 4
Teller: 1 обслуживает Customer: 5
Teller: 3 обслуживает Customer: 6
Teller: 1 обслуживает Customer: 7
Teller: 2 обслуживает Customer: 8
Teller: 3 обслуживает Customer: 9
Teller: 3 обслуживает Customer: 10
Teller: 2 обслуживает Customer: 11
Teller: 4 обслуживает Customer: 12
Teller: 2 обслуживает Customer: 13
Teller: 1 обслуживает Customer: 14
Teller: 1 обслуживает Customer: 15
*///:~
