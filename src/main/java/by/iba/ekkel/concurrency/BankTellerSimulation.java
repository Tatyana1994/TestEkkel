//: by.iba.ekkel.concurrency/BankTellerSimulation.java
// Example of queues and multi-threading programming usage
// {Args: 5}
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.*;

// Objects that are available only for reading 
// but not require synchronization
class Customer {
	private final int serviceTime;
	public Customer(int tm) {
		serviceTime = tm;
	}
	public int getServiceTime() {
		return serviceTime;
	}
	public String toString() {
		return "[" + serviceTime + "]";
	}
}

// Queue of clients can output the info about its state
class CustomerLine extends ArrayBlockingQueue<Customer> {
	public CustomerLine(int maxLineSize) {
		super(maxLineSize);
	}
	public String toString() {
		if(this.size() == 0) {
			return "[Empty]";
		}
		StringBuilder result = new StringBuilder();
		for(Customer customer : this) {
			result.append(customer);
		}
		return result.toString();
	}
}

// Random adding of clients to the queue
class CustomerGenerator implements Runnable {
	private CustomerLine customers;
	private static Random rand = new Random(47);
	public CustomerGenerator(CustomerLine cq) {
		customers = cq;
	}
	public void run() {
		try {
			while(!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
				customers.put(new Customer(rand.nextInt(1000)));
			}
		} catch(InterruptedException e) {
			System.out.println("CustomerGenerator interrupted");
		}
		System.out.println("CustomerGenerator terminating");
	}
}

class Teller implements Runnable, Comparable<Teller> {
	private static int counter = 0;
	private final int id = counter++;
	// Counter of clients that were served while current session
	private int customerServed = 0;
	private CustomerLine customers;
	private boolean servingCustomerLine = true;
	public Teller(CustomerLine cq) {
		customers = cq;
	}
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Customer customer = customers.take();
				TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
				synchronized (this) {
					customerServed++;
					while(!servingCustomerLine) {
						wait();
					}
				}
			}
		} catch(InterruptedException e) {
			System.out.println(this + " is interrupted");
		}
		System.out.println(this + " is completing");
	}
	public synchronized void doSomethingElse() {
		customerServed = 0;
		servingCustomerLine = false;
	}
	public synchronized void serveCustomerLine() {
		assert !servingCustomerLine: " is already being served: " + this;
		servingCustomerLine = true;
		notifyAll();
	}
	public String toString() {
		return "Cashier: " + id + " ";
	}
	public String shortString() {
		return "C: " + id;
	}
	
	// Is used by prioritized queue
	public synchronized int compareTo(Teller other) {
		return customerServed < other.customerServed ? -1 :
				(customerServed == other.customerServed ? 0 : 1);
	}
	
}



public class BankTellerSimulation {

}
