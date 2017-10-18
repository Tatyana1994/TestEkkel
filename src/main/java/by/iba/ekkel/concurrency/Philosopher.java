//: by.iba.ekkel.concurrency/Philosopher.java
// Philosopher that has dinner
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

public class Philosopher implements Runnable {
	
	private Chopstick left;
	private Chopstick right;
	private final int id;
	private final int ponderFactor;
	private Random rand = new Random(47);
	private void pause() throws InterruptedException {
		if(ponderFactor == 0) {
			return;
		}
		TimeUnit.MILLISECONDS.sleep
			(rand.nextInt(ponderFactor* 250));
	}
	
	public Philosopher(Chopstick left, Chopstick right,
			int ident, int ponder) {
		
				this.left = left;
				this.right = right;
				id = ident;
				ponderFactor = ponder;
		
	}
	
	public void run() {
		try {
			while(!Thread.interrupted()) {
				print(this + " " + " is thinking");
				pause();
				//Philosopher got hungry
				print(this + " " + " takes right stick");
				right.take();
				print(this + " " + " takes left stick");
				left.take();
				print(this + " is eating");
				pause();
				right.drop();
				left.drop();
			}
		} catch(InterruptedException e) {
			print(this + " " + " exit by the interruption");
		}
	}
	
	public String toString() {
		return "Philosopher " + id;
	}

}
