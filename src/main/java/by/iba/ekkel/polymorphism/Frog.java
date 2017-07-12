//: polymorphism/Frog.java
// Наследование и завершающие действия
package by.iba.ekkel.polymorphism;

import static by.iba.ekkel.mindview.util.Print.*;

class Characteristic {
	private String s;
	
	Characteristic(String s) {
		this.s = s;
		print("Создаем Characteristic " + s);
	}
	
	protected void dispose() {
		print("Завершаем Characteristic " + s);
	}
}

class Description {
	private String s;
	
	Description(String s) {
		this.s = s;
		print("Создаем Description " + s);
	}
	
	protected void dispose() {
		print("Завершаем Description " + s);
	}
}

//живое существо
class LivingCreature {
	private Characteristic p = 
			new Characteristic("живое существо");
	private Description t = 
			new Description("обычное живое существо");
	LivingCreature() {
		print("LivingCreature()");
	}
	protected void dispose() {
		print("dispose() в LivingCreature");
		t.dispose();
		p.dispose();
	}
}

//животное
class Animal extends LivingCreature {
	private Characteristic p = 
			new Characteristic("имеет сердце");
	private Description t = 
			new Description("животное, не растение");
	Animal() {
		print("Animal()");
	}
	protected void dispose() {
		print("dispose() в Animal");
		t.dispose();
		p.dispose();
		super.dispose();
	}
}

//земноводное
class Amphibian extends Animal {
	private Characteristic p = 
			new Characteristic("может жить в воде");
	private Description t = 
			new Description("и в воде, и на земле");
	Amphibian() {
		print("Amphibian()");
	}
	protected void dispose() {
		print("dispose() в Amphibian");
		t.dispose();
		p.dispose();
		super.dispose();
	}
}

//лягушка
public class Frog extends Amphibian {
	private Characteristic p = 
			new Characteristic("квакает");
	private Description t = 
			new Description("есть жуков");
	Frog() {
		print("Frog()");
	}
	protected void dispose() {
		print("dispose() в Frog");
		t.dispose();
		p.dispose();
		super.dispose();
	}
	public static void main(String[] args) {
		Frog frog = new Frog();
		print("Пока");
		frog.dispose();
	}

} /* Output
Создаем Characteristic живое существо
Создаем Description обычное живое существо
LivingCrature()
Создаем Characteristic имеет сердце
Создаем Description животное, не растение
Animal()
Создаем Characteristic может жить в воде
Создаем Description и в воде, и на земле
Amphibian()
Создаем Characteristic квакает
Создаем Description есть жуков
Frog()
Пока
dispose() в Frog
Завершаем Description есть жуков
Завершаем Characteristic квакает
dispose() в Amphibian
Завершаем Description и в воде, и на земле
Завершаем Characteristic может жить в воде
dispose() в Animal
Завершаем Description животное, не растение
Завершаем Characteristic имеет сердце
dispose() в LivingCreature
Завершаем Description обычное живое существо
Завершаем Characteristic живое существо
*///:~
