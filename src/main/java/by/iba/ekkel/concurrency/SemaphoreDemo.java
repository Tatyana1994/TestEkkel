//: by.iba.ekkel.concurrency/SemaphoreDemo.java
// Testing of Pool class
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

//Task to get resource from the Pool
class CheckoutTask<T> implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private Pool<T> pool;
	public CheckoutTask(Pool<T> pool) {
		this.pool = pool;
	}
	public void run() {
		try {
			T item = pool.checkOut();
			print(this + " checked out " + item);
			TimeUnit.SECONDS.sleep(1);
			print(this + " checking in " + item);
			pool.checkIn(item);
		} catch(InterruptedException e) {
			// Acceptable variant to exit
		}
	}
	public String toString() {
		return "CheckoutTask " + id + " ";
	}
}

public class SemaphoreDemo {
	
	final static int SIZE = 25;
	
	public static void main(String[] args) throws Exception {
	
		final Pool<Fat> pool = 
				new Pool<Fat>(Fat.class, SIZE);
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < SIZE; i++) {
			exec.execute(new CheckoutTask<Fat>(pool));
		}
		print("All CheckoutTasks created");
		List<Fat> list = new ArrayList<Fat>();
		for(int i = 0; i < SIZE; i++) {
			Fat f = pool.checkOut();
			printb(i + " main() thread checked out");
			f.operation();
			list.add(f);
		}
		Future<?> blocked = exec.submit(new Runnable() {
			
			@Override
			public void run() {
				try {
					// Semaphore prevents the last call of checkout
					// that's why the next call is blocked
					pool.checkOut();
				} catch(InterruptedException e) {
					print("checkOut() Interrupted");
				}
			}
		});
		TimeUnit.SECONDS.sleep(2);
		blocked.cancel(true); // Exit from the clocked call
		print("Checking in objects in " + list);
		for(Fat f : list) {
			pool.checkIn(f);
		}
		for(Fat f : list) {
			pool.checkIn(f); // The second call of CheckIn is ignored
		}
		exec.shutdown();
	
	}

} /* Output
CheckoutTask 1  checked out Fat id: 1
CheckoutTask 2  checked out Fat id: 3
CheckoutTask 0  checked out Fat id: 0
CheckoutTask 6  checked out Fat id: 4
CheckoutTask 7  checked out Fat id: 5
CheckoutTask 3  checked out Fat id: 2
CheckoutTask 5  checked out Fat id: 6
CheckoutTask 9  checked out Fat id: 8
CheckoutTask 4  checked out Fat id: 7
CheckoutTask 10  checked out Fat id: 9
CheckoutTask 11  checked out Fat id: 10
CheckoutTask 8  checked out Fat id: 11
CheckoutTask 12  checked out Fat id: 12
CheckoutTask 13  checked out Fat id: 13
CheckoutTask 14  checked out Fat id: 14
CheckoutTask 15  checked out Fat id: 15
CheckoutTask 16  checked out Fat id: 16
CheckoutTask 17  checked out Fat id: 17
CheckoutTask 18  checked out Fat id: 18
CheckoutTask 19  checked out Fat id: 19
CheckoutTask 20  checked out Fat id: 20
CheckoutTask 21  checked out Fat id: 21
CheckoutTask 22  checked out Fat id: 22
CheckoutTask 23  checked out Fat id: 23
All CheckoutTasks created
CheckoutTask 24  checked out Fat id: 24
CheckoutTask 0  checking in Fat id: 0
CheckoutTask 5  checking in Fat id: 6
0 main() thread checked outFat id: 0
CheckoutTask 1  checking in Fat id: 1
CheckoutTask 9  checking in Fat id: 8
CheckoutTask 10  checking in Fat id: 9
CheckoutTask 4  checking in Fat id: 7
CheckoutTask 3  checking in Fat id: 2
CheckoutTask 6  checking in Fat id: 4
CheckoutTask 7  checking in Fat id: 5
CheckoutTask 2  checking in Fat id: 3
1 main() thread checked outFat id: 6
2 main() thread checked outFat id: 1
3 main() thread checked outFat id: 2
4 main() thread checked outFat id: 3
5 main() thread checked outFat id: 4
6 main() thread checked outFat id: 5
7 main() thread checked outFat id: 7
8 main() thread checked outFat id: 8
9 main() thread checked outFat id: 9
CheckoutTask 12  checking in Fat id: 12
CheckoutTask 17  checking in Fat id: 17
CheckoutTask 18  checking in Fat id: 18
CheckoutTask 16  checking in Fat id: 16
CheckoutTask 14  checking in Fat id: 14
10 main() thread checked outFat id: 12
11 main() thread checked outFat id: 14
12 main() thread checked outFat id: 16
13 main() thread checked outFat id: 17
CheckoutTask 19  checking in Fat id: 19
CheckoutTask 13  checking in Fat id: 13
14 main() thread checked outFat id: 18
CheckoutTask 15  checking in Fat id: 15
CheckoutTask 11  checking in Fat id: 10
CheckoutTask 8  checking in Fat id: 11
CheckoutTask 20  checking in Fat id: 20
15 main() thread checked outFat id: 13
16 main() thread checked outFat id: 10
17 main() thread checked outFat id: 11
18 main() thread checked outFat id: 15
19 main() thread checked outFat id: 19
20 main() thread checked outFat id: 20
CheckoutTask 23  checking in Fat id: 23
CheckoutTask 21  checking in Fat id: 21
21 main() thread checked outFat id: 23
CheckoutTask 22  checking in Fat id: 22
CheckoutTask 24  checking in Fat id: 24
22 main() thread checked outFat id: 21
23 main() thread checked outFat id: 22
24 main() thread checked outFat id: 24
checkOut() Interrupted
Checking in objects in [Fat id: 0, Fat id: 6, Fat id: 1, 
Fat id: 2, Fat id: 3, Fat id: 4, Fat id: 5, Fat id: 7, Fat id: 8, 
Fat id: 9, Fat id: 12, Fat id: 14, Fat id: 16, Fat id: 17, Fat id: 18, 
Fat id: 13, Fat id: 10, Fat id: 11, Fat id: 15, Fat id: 19, Fat id: 20, 
Fat id: 23, Fat id: 21, Fat id: 22, Fat id: 24]
*///:~
