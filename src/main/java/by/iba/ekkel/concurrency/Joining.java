//: by.iba.ekkel.concurrency/Joining.java
// Demo of join()
package by.iba.ekkel.concurrency;

import static by.iba.ekkel.mindview.util.Print.*;

class Sleeper extends Thread {
	private int duration;
	public Sleeper(String name, int sleepTime) {
		super(name);
		duration = sleepTime;
		start();
	}
	
	public void run() {
		try {
			sleep(duration);
		} catch(InterruptedException e) {
			print(getName() + " interrupted " +
					"isInterrupted() " + isInterrupted());
			return;
		}
		print(getName() + " is activated");
	}
}

class Joiner extends Thread {
	private Sleeper sleeper;
	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	public void run() {
		try {
			sleeper.join();
		} catch(InterruptedException e) {
			print("Is interrupted");
		}
		print(getName() + " join is completed");		
	}
}

public class Joining {
	
	public static void main(String[] args) {
	
		Sleeper 
			sleepy = new Sleeper("Sleepy", 1500),
			grumpy = new Sleeper("Grumpy", 1500);
		Joiner
			dopey = new Joiner("Dopey", sleepy),
			doc   = new Joiner("Doc", grumpy);
		grumpy.interrupt();
	
	}

} /* Output
Grumpy interrupted isInterrupted() false
Doc join is completed
Sleepy is activated
Dopey join is completed
*///:~
