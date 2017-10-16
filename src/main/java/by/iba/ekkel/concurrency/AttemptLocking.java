//: by.iba.ekkel.concurrency/AttemptLocking.java
// Lock objects from Java concurrent library make possible
// attempts of setting the locks during some period of time
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

import javax.management.RuntimeErrorException;

public class AttemptLocking {
	
	private ReentrantLock lock = new ReentrantLock();
	public void untimed() {
		boolean captured = lock.tryLock();
		try {
			System.out.println("tryLock(): " + captured);
		} finally {
			if(captured) {
				lock.unlock();
			}
		}
	}
	public void timed() {
		boolean captured = false;
		try {
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		try {
			System.out.println("tryLock(2, TimeUnit.SECONDS): " +
						captured);
		} finally {
			if(captured) {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
	
		final AttemptLocking al = new AttemptLocking();
		al.untimed();  //True -- the lock is available
		al.timed();    //True -- the lock is available
		
		//Creating the separate task to set the locks
		new Thread() {
			{
				setDaemon(true);
			}
			public void run() {
				al.lock.lock();
				System.out.println("acquired");
			}
		}.start();
		Thread.yield(); //Give the opportunity to the second task
		al.untimed();   //False -- the lock is captured by another task
		al.timed();     //False -- the lock is captured by another task
	
	}

}
