//: by.iba.ekkel.concurrency/ExplicitCriticalSection.java
// Using the Lock objects to create critical sections
package by.iba.ekkel.concurrency;

import java.util.concurrent.locks.*;

// Synchronization of the entire method
class ExplicitPairManager1 extends PairManager {
	private Lock lock = new ReentrantLock();
	public synchronized void increment() {
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			store(getPair());
		} finally {
			lock.unlock();
		}
	}
}

// Using of critical section
class ExplicitPairManager2 extends PairManager {
	private Lock lock = new ReentrantLock();
	public void increment() {
		Pair temp;
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		} finally {
			lock.unlock();
		}
		store(temp);
	}
}

public class ExplicitCriticalSection {
	
	public static void main(String[] args) throws Exception {
	
		PairManager 
			pman1 = new ExplicitPairManager1(),
			pman2 = new ExplicitPairManager2();
		CriticalSection.testApproaches(pman1, pman2);
	
	}

} /* Output
pm1: Pair: x: 10, y:  10 checkCounter = 91866097
pm2: Pair: x: 11, y:  11 checkCounter = 91668149
*///:~
