//: by.iba.ekkel.generics/Store.java
// Построение сложной модели на базе параметризованных контейнеров
package by.iba.ekkel.generics;

import java.util.*;
import by.iba.ekkel.mindview.util.*;

class Product {
	private final int id;
	private String description;
	private double price;
	public Product(int IDNumber, String descr, double price) {
		id = IDNumber;
		description = descr;
		this.price = price;
		System.out.println(toString());
	}
	public String toString() {
		return id + ": " + description + ", цена: $" + price;
	}
	public void priceChange(double change) {
		price += change;
	}
	public static Generator<Product> generator = 
		new Generator<Product>() {
			private Random rand = new Random(47);
			public Product next() {
				return new Product(rand.nextInt(1000), "Test", 
						Math.round(rand.nextDouble() * 1000.0) + 0.99);
			}
		};
	}

class Shelf extends ArrayList<Product> {
	public Shelf(int nProducts) {
		Generators.fill(this, Product.generator, nProducts);
	}
}

class Aisle extends ArrayList<Shelf> {
	public Aisle(int nShelves, int nProducts) {
		for(int i = 0; i < nShelves; i ++) {
			add(new Shelf(nProducts));
		}
	}
}

class CheckOutStand {
	
}

class Office {
	
}

public class Store extends ArrayList<Aisle> {
	
	private ArrayList<CheckOutStand> checkouts = 
			new ArrayList<CheckOutStand>();
	private Office office = new Office();
	public Store(int nAisles, int nShelves, int nProducts) {
		for(int i = 0; i < nAisles; i++) {
			add(new Aisle(nShelves, nProducts));
		}
	}
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Aisle a : this) {
			for(Shelf s : a) {
				for(Product p : s) {
					result.append(p);
					result.append("\n");
				}
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
	
		System.out.println(new Store(14, 5, 10));
	
	}

} /* Output
258: Test, цена: $400.99
861: Test, цена: $160.99
868: Test, цена: $417.99
207: Test, цена: $268.99
551: Test, цена: $114.99
278: Test, цена: $804.99
520: Test, цена: $554.99
140: Test, цена: $530.99
...
*///:~
