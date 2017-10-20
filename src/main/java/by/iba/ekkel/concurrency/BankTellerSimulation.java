//: by.iba.ekkel.concurrency/BankTellerSimulation.java
// Example of queues and multi-threading programming usage
// {Args: 5}
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.sql.Time;
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

class TellerManager implements Runnable {
	private ExecutorService exec;
	private CustomerLine customers;
	private PriorityQueue<Teller> workingTellers = 
			new PriorityQueue<Teller>();
	private Queue<Teller> tellersDoingOtherThings =
			new LinkedList<Teller>();
	private int adjustmentPeriod;
	private static Random rand = new Random(47);
	public TellerManager(ExecutorService e,
			CustomerLine customers, int adjustmentPeriod) {
				exec = e;
				this.customers = customers;
				this.adjustmentPeriod = adjustmentPeriod;
				// Start from the one cashier:
				Teller teller = new Teller(customers);
				exec.execute(teller);
				workingTellers.add(teller);
	}
	
	public void adjustTellerNumber() {
		// In fact, it is the system of control
		// Adjustment of params allows you to reveal the problems
		// of stability in the mechanism
		// If the queue is very long, you should add another cashier
		if(customers.size() / workingTellers.size() > 2) {
			// If the cashiers have a rest or busy
			// with other stuff, you should return one of them
			if(tellersDoingOtherThings.size() > 0) {
				Teller teller = tellersDoingOtherThings.remove();
				teller.serveCustomerLine();
				workingTellers.offer(teller);
				return;
			}
			// otherwise create (employ) the new cashier
			Teller teller = new Teller(customers);
			exec.execute(teller);
			workingTellers.add(teller);
			return;
		}
		// If the queue is rather short we should free the cashier
		if(workingTellers.size() > 1 &&
				customers.size() / workingTellers.size() < 2) {
					reassignOneTeller();
		}
		// If there is no queue one cashier is enough
		if(customers.size() == 0) {
			while (workingTellers.size() > 1) {
					reassignOneTeller();
			}
		}
	}
	
	// Delegate the cashier other work or send him on vacation
	private void reassignOneTeller() {
		Teller teller = workingTellers.poll();
		teller.doSomethingElse();
		tellersDoingOtherThings.offer(teller);
	}
	
	public void run() {
		try {
			while(!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
				adjustTellerNumber();
				System.out.print(customers + " { ");
				for(Teller teller : workingTellers) {
					System.out.print(teller.shortString() + " ");
				}
				System.out.println("}");
			}
		} catch(InterruptedException e) {
			System.out.println(this + " is interrupted");
		}
		System.out.println(this + " is finishing");
	}
	
	public String toString() {
		return "TellerManager ";
	}
}

public class BankTellerSimulation {
	
	static final int MAX_LINE_SIZE = 50;
	static final int ADJUSMENT_PERIOD = 1000;
	
	public static void main(String[] args) throws Exception {
	
		ExecutorService exec = Executors.newCachedThreadPool();
		//If the queue is too long, the clients are leaving
		CustomerLine customers = 
				new CustomerLine(MAX_LINE_SIZE);
		exec.execute(new CustomerGenerator(customers));
		// TellerManager adds and remove cashiers 
		// in case it's necessary
		exec.execute(new TellerManager(
				exec, customers, ADJUSMENT_PERIOD));
		if(args.length > 0) { // Not compulsory argument
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
		} else {
			System.out.println("Press 'Enter' to quit");
			System.in.read();
		}
		exec.shutdownNow();
	
	}

} /* Output
[200][207] { C: 1 C: 0 }
TellerManager  is interrupted
TellerManager  is finishing
CustomerGenerator interrupted
CustomerGenerator terminating
Cashier: 0  is interrupted
Cashier: 1  is interrupted
Cashier: 1  is completing
Cashier: 0  is completing
*///:~
