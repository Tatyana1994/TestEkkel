//: initialization/PassingThis.java
package by.iba.ekkel.initialization;

class Person {
	
	public void eat(Apple apple) {
		Apple peeled = apple.getPeeled();
		System.out.println("Yammy");
	}
}
	
class Peeler {
		static Apple peel(Apple apple) {
			return apple;
		}
}
	
class Apple {
		Apple getPeeled() {
			return Peeler.peel(this);
		}
}

class PassingThis {

	public static void main(String[] args) {
		new Person().eat(new Apple());
	}
	
} /* Output
Yammy
*///:~