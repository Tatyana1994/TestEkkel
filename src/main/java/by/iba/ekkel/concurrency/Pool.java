//: by.iba.ekkel.concurrency/Pool.java
// Using Semaphore in Pool restricts the amount
// of tasks that can use resource
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.*;

public class Pool<T> {
	
	private int size;
	private List<T> items = new ArrayList<T>();
	private volatile boolean[] checkedOut;
	private Semaphore available;
	public Pool(Class<T> classObject, int size) {
		this.size = size;
		checkedOut = new boolean[size];
		available = new	Semaphore(size, true);
		// Populate pool with objects
		for(int i = 0; i < size; ++i) {
			try {
				// Default constructor is assumed to exist
				items.add(classObject.newInstance());
			} catch(Exception e) {
				throw new RuntimeException();
			}
		}
	}
	
	public T checkOut() throws InterruptedException {
		available.acquire();
		return getItem();
	}
	
	public void checkIn(T x) {
		if(releaseItem(x)) {
			available.release();
		}
	}
	
	private synchronized T getItem() {
		for(int i = 0; i < size; ++i) {
			if(!checkedOut[i]) {
				checkedOut[i] = true;
				return items.get(i);
			}
		}
		return null; // Semaphore prevent the transfer to the point
	}
	
	private synchronized boolean releaseItem(T item) {
		int index = items.indexOf(item);
		if(index == -1) {
			return false; // is not in the list
		}
		if(checkedOut[index]) {
			checkedOut[index] = false;
			return true;
		}
		return false; // was not free
	}

} /* Output
*///:~
