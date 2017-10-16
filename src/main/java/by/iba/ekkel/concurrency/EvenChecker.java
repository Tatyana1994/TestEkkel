//: by.iba.ekkel.concurrency/EvenChecker.java
package by.iba.ekkel.concurrency;

import java.util.Random;
import java.util.concurrent.*;

import static by.iba.ekkel.mindview.util.Print.*;

public class EvenChecker implements Runnable {
	
	private IntGenerator generator;
	private final int id;
	public EvenChecker(IntGenerator g, int ident) {
		generator = g;
		id = ident;
	}
	public void run() {
		while(!generator.isCanceled()) {
			int val = generator.next();
			if(val % 2 != 0) {
				System.out.println(val + " is not even!");
				generator.cancel(); //Cancel all EvenCheckers
			}
		}
	}
	
	//Test the random type of IntGenerator
	public static void test(IntGenerator gr, int count) {
		System.out.println("Press Ctrl+c to exit the programm");
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < count; i++) {
			exec.execute(new EvenChecker(gr, i));
		}
		exec.shutdown();
	}
	
	//Default values for count
	public static void test(IntGenerator gr) {
		test(gr, 10);
	}
	
	public static void main(String[] args) {
	
		IntGenerator ig = new IntGenerator() {
			
			Random rand = new Random(47);
			
			@Override
			public int next() {
				int randInt;
				randInt = rand.nextInt(100);
				print("The number generated: " + randInt);
				return randInt;
			}
			
		};
		
		test(ig, 2);
	
	}
	
} /* Output
Press Ctrl+c to exit the programm
The number generated: 55
The number generated: 61
61 is not even!
The number generated: 93
93 is not even!
The number generated: 29
29 is not even!
The number generated: 61
61 is not even!
The number generated: 58
55 is not even!
*///:~
