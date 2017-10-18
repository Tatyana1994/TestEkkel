//: by.iba.ekkel.concurrency/CriticalSection.java
// Synchronization of blocks instead of entire methods.
// At the same time it demonstrates the protection
// of class that is unadapted to multi-threading by other classes  

package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

class Pair { //Not thread-safe
	
	private int x, y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Pair() {
		this(0, 0);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void incrementX() {
		x++;
	}
	
	public void incrementY() {
		y++;
	}
	
	public String toString() {
		return "x: " + x + ", y:  " + y;
	}
	
	public class PairValuesNotEqualException 
		extends RuntimeException {
			public PairValuesNotEqualException() {
				super("Pair values not equal: " + Pair.this);
			}
	}
	
	// Arbitrary variant -- both variables should be equal
	public void checkState() {
		if(x != y) {
			throw new PairValuesNotEqualException();
		}
	}
	
	
}

// Protection of Pair class inside adapted to threads class
abstract class PairManager {
	
	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pair p = new Pair();
	private List<Pair> storage = 
			Collections.synchronizedList(new ArrayList<Pair>());
	
	public synchronized Pair getPair() {
		//Create the copy to save the original in safety
		return new Pair(p.getX(), p.getY());
	}
	
	// It is supposed that operation takes some time
	protected void store(Pair p) {
		storage.add(p);
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch(InterruptedException ignore) {
			
		}
	}
	public abstract void increment();
	
}

//Synchronization of the entire method
class PairManager1 extends PairManager {
	public synchronized void increment() {
		p.incrementX();
		p.incrementY();
		store(getPair());
	}
}

//Using the cricital section
class PairManager2 extends PairManager {
	public void increment() {
		Pair temp;
		synchronized (this) {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}
}

class PairManipulator implements Runnable {
	private PairManager pm;
	public PairManipulator(PairManager pm) {
		this.pm = pm;
	}
	public void run() {
		while(true) {
			pm.increment();
		}
	}
	public String toString() {
		return "Pair: " + pm.getPair() +
				" checkCounter = " + pm.checkCounter.get();
	}
}

class PairChecker implements Runnable {
	private PairManager pm;
	public PairChecker(PairManager pm) {
		this.pm = pm;
	}
	public void run() {
		while(true) {
			pm.checkCounter.incrementAndGet();
			//pm.getPair().checkState();
		}
	}
}

public class CriticalSection {
	
	// Comparing of 2 approaches
	static void testApproaches(PairManager pman1, PairManager pman2) {
		ExecutorService exec = Executors.newCachedThreadPool();
		PairManipulator
			pm1 = new PairManipulator(pman1),
			pm2 = new PairManipulator(pman2);
		PairChecker 
			pcheck1 = new PairChecker(pman1),
			pcheck2 = new PairChecker(pman2);
		exec.execute(pm1);
		exec.execute(pm2);
		exec.execute(pcheck1);
		exec.execute(pcheck2);
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch(InterruptedException e) {
			System.out.println("Sleep interrupted");
		}
		System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
		System.exit(0);
	}
	
	public static void main(String[] args) {
	
		PairManager
			pman1 = new PairManager1(),
			pman2 = new PairManager2();
		testApproaches(pman1, pman2);
	
	}

} /* Output
pm1: Pair: x: 10, y:  10 checkCounter = 7366
pm2: Pair: x: 11, y:  11 checkCounter = 30700126
*///:~
