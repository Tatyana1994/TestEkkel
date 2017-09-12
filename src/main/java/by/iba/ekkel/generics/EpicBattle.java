//: by.iba.ekkel.generics/EpicBattle.java
//Example with the big amount of levels
//Demonstrating bounds in Java generics
package by.iba.ekkel.generics;

import java.util.*;

interface SuperPower {
	
}

interface XRayVision extends SuperPower {
	void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
	void hearSubtleNoises();
}

interface SuperSmell extends SuperPower {
	void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
	POWER power;
	public SuperHero(POWER power) {
		this.power = power;
	}
	POWER getPower() {
		return power;
	}
}

class SuperSleuth<POWER extends XRayVision> 
	extends SuperHero<POWER> {
		
		public SuperSleuth(POWER power) {
			super(power);
		}
		void see() {
			power.seeThroughWalls();
		}
	
}

class CanineHero<POWER extends SuperHearing & SuperSmell> 
	extends SuperHero<POWER> {
	
		public CanineHero(POWER power) {
			super(power);
		}
		void hear() {
			power.hearSubtleNoises();
		}
		void smell() {
			power.trackBySmell();
		}

}

class SuperHearSmell implements SuperHearing, SuperSmell {
	public void hearSubtleNoises() {
		
	}
	public void trackBySmell() {
		
	}
}

class DogBoy extends CanineHero<SuperHearSmell> {
	DogBoy() {
		super(new SuperHearSmell());
	}
}

public class EpicBattle {
	
	//Restrictions in generic methods
	static <POWER extends SuperHearing>
		void useSuperHearing(SuperHero<POWER> hero) {
			hero.getPower();
	}
	static <POWER extends SuperHearing & SuperSmell>
		void superFind(SuperHero<POWER> hero) {
			hero.getPower();
			hero.getPower().trackBySmell();
	}
	public static void main(String[] args) {
	
		DogBoy dogBoy = new DogBoy();
		useSuperHearing(dogBoy);
		superFind(dogBoy);
		//It could be in that way
		List<? extends SuperHearing> audioBoys;
		//But not in that way
		//! List<? extends SuperHearing & SuperSmell> dogBoys;
	
	}

}
