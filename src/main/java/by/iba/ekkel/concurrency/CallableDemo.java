//: by.iba.ekkel.concurrency/CallableDemo.java
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.*;

class TaskWithResult implements Callable<String> {
	
	private int id;
	public TaskWithResult(int id) {
		this.id = id;
	}
	public String call() {
		return "result of TaskWith Result " + id;
	}
	
}

public class CallableDemo {
	
	public static void main(String[] args) {
		
	
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = 
				new ArrayList<Future<String>>();
		for(int i = 0; i < 10; i++) {
			results.add(exec.submit(new TaskWithResult(i)));
		}
		for(Future<String> fs : results) {
			try {
				// Call get() will be blocked when completed
				System.out.println(fs.get());
			} catch(InterruptedException e) {
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}
		}
	
	}

} /* Output
result of TaskWith Result 0
result of TaskWith Result 1
result of TaskWith Result 2
result of TaskWith Result 3
result of TaskWith Result 4
result of TaskWith Result 5
result of TaskWith Result 6
result of TaskWith Result 7
result of TaskWith Result 8
result of TaskWith Result 9
*///:~

