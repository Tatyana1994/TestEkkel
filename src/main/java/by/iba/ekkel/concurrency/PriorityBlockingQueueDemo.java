//: by.iba.ekkel.concurrency/PriorityBlockingQueueDemo.java
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

class PrioritizedTask
	implements Runnable, Comparable<PrioritizedTask> {
		private Random rand = new Random(47);
		private static int counter = 0;
		private final int id = counter++;
		private final int priority;
		protected static List<PrioritizedTask> sequence = 
			new ArrayList<PrioritizedTask>();
		public PrioritizedTask(int priority) {
			this.priority = priority;
		}
		public int compareTo(PrioritizedTask arg) {
			return priority < arg.priority ? 1 :
					(priority > arg.priority ? -1 : 0);
		}
		
		public void run() {
			try {
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
			} catch(InterruptedException e) {
				//Acceptable variant of exit
			}
			print(this);
		}
		
		public String toString() {
			return String.format("[%1$-3d]", priority) +
						" Task " + id;
		}
		
		public String summary() {
			return "(" + id + ":" + priority + ")";
		}
		
		public static class EndSentinel extends PrioritizedTask {
			
			private ExecutorService exec; 
			
			private EndSentinel(ExecutorService e) {
				super(-1); //The lowest priority in this program
				exec = e;
			}
			
			public void run() {
				int count = 0;
				for(PrioritizedTask pt : sequence) {
					printb(pt.summary());
					if(++count % 5 == 0) {
						print();
					}
				}
				print();
				print(this + " Calling shutdownNow()");
				exec.shutdownNow();
			}
			
		}
		
}

class PrioritizedTaskProducer implements Runnable {
	private Random rand = new Random(47);
	private Queue<Runnable> queue;
	private ExecutorService exec;
	public PrioritizedTaskProducer(
			Queue<Runnable> q, ExecutorService e) {
				queue = q;
				exec = exec; //It is used to EndSentinel
	}
	public void run() {
		// Unlimited queue without blocking
		// Quick population with random priorities
		for(int i = 0; i < 20; i++) {
			queue.add(new PrioritizedTask(rand.nextInt(10)));
			Thread.yield();
		}
		// Adding of high-priority tasks
		try {
			for(int i = 0; i < 10; i++) {
				TimeUnit.MILLISECONDS.sleep(250);
				queue.add(new PrioritizedTask(10));
			}
			// Adding of tasks starting from the lowest priorities
			for(int i = 0; i < 10; i++) {
				queue.add(new PrioritizedTask(i));
			}
		} catch(InterruptedException e) {
			//Acceptable variant of exit
		}
		print("Completing of PrioritizedTaskProducer");
	}
}

class PrioritizedTaskConsumer implements Runnable {
	private PriorityBlockingQueue<Runnable> q;
	public PrioritizedTaskConsumer(
			PriorityBlockingQueue<Runnable> q) {
				this.q = q;
	}
	public void run() {
		try {
			while(!Thread.interrupted()) {
				//Using current thread to run the task
				q.take().run();
			}
		} catch(InterruptedException e) {
			//Acceptable variant of exit
		}
		print("Completing of PrioritizedTaskConsumer");
	}
}

public class PriorityBlockingQueueDemo {
	
	public static void main(String[] args) throws Exception {
		
		Random rand = new Random(47);
		ExecutorService exec = Executors.newCachedThreadPool();
		PriorityBlockingQueue<Runnable> queue = 
				new PriorityBlockingQueue<Runnable>();
		exec.execute(new PrioritizedTaskProducer(queue, exec));
		exec.execute(new PrioritizedTaskConsumer(queue));
		
	}

} /* Output
[9  ] Task 5
[10 ] Task 20
[9  ] Task 13
[9  ] Task 14
[8  ] Task 15
[8  ] Task 16
[8  ] Task 10
[8  ] Task 0
[8  ] Task 19
[8  ] Task 11
[8  ] Task 6
[7  ] Task 9
[5  ] Task 1
[3  ] Task 2
[2  ] Task 8
[1  ] Task 12
[1  ] Task 4
[1  ] Task 17
[1  ] Task 3
[0  ] Task 7
[0  ] Task 18
[10 ] Task 21
[10 ] Task 22
[10 ] Task 23
[10 ] Task 24
[10 ] Task 25
[10 ] Task 26
[10 ] Task 27
[10 ] Task 28
Completing of PrioritizedTaskProducer
[10 ] Task 29
[9  ] Task 39
[8  ] Task 38
[7  ] Task 37
[6  ] Task 36
[5  ] Task 35
[4  ] Task 34
[3  ] Task 33
[2  ] Task 32
[1  ] Task 31
[0  ] Task 30
*///:~
