//: by.iba.ekkel.concurrency/ExchangerDemo.java
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.*;
import by.iba.ekkel.mindview.util.*;

class ExchangeProducer<T> implements Runnable {
	private Generator<T> generator;
	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	public ExchangeProducer(Exchanger<List<T>> exchg,
			Generator<T> gen, List<T> holder) {
		
				exchanger = exchg;
				generator = gen;
				this.holder = holder;
		
	}
	
	public void run() {
		try {
			while(!Thread.interrupted()) {
				for(int i = 0; i < ExchangerDemo.size; i++) {
					holder.add(generator.next());
				}
				// Populated container will be replaced by empty one
				holder = exchanger.exchange(holder);
			}
		} catch(InterruptedException e) {
			 // Acceptable variant to exit
		}
	}
}

class ExchangerConsumer<T> implements Runnable {
	
	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	private volatile T value;
	public ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder) {
		exchanger = ex;
		this.holder = holder;
	}
	
	public void run() {
		try {
			while(!Thread.interrupted()) {
				holder = exchanger.exchange(holder);
				for(T x : holder) {
					value = x; // Value selection
					holder.remove(x); // Is normal for CopyOnWriteArrayList
				}
			}
		} catch(InterruptedException e) {
			// Acceptable variant to exit
		}
		System.out.println("Final value: " + value);
	}
	
}

public class ExchangerDemo {
	
	static int size = 10;
	static int delay = 5; // Seconds
	public static void main(String[] args) throws Exception {
	
		if(args.length > 0) {
			size = new Integer(args[0]);
		}
		if(args.length > 1) {
			delay = new Integer(args[1]);
		}
		ExecutorService exec = Executors.newCachedThreadPool();
		Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();
		List<Fat>
			producerList = new CopyOnWriteArrayList<Fat>(),
			consumerList = new CopyOnWriteArrayList<Fat>();
		exec.execute(new ExchangeProducer<Fat>(xc, 
				BasicGenerator.create(Fat.class), producerList));
		exec.execute(
				new ExchangerConsumer<Fat>(xc, consumerList));
		TimeUnit.SECONDS.sleep(delay);
		exec.shutdownNow();
	
	}

} /* Output
Final value: Fat id: 84719
*///:~

