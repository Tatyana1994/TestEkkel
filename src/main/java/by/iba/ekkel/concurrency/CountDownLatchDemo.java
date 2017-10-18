//: by.iba.ekkel.concurrency/CountDownLatchDemo.java
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

//The part of the main task
class TaskPortion implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private static Random rand = new Random(47);
	private final CountDownLatch latch;
	
	TaskPortion(CountDownLatch latch) {
		this.latch = latch;
	}
	
	public void run() {
		try {
			doWork();
			latch.countDown();
		} catch(InterruptedException ex) {
			// Acceptable variant of exit
		}
	}
	
	public void doWork() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
		print(this + " is finishing");
	}
	
	public String toString() {
		return String.format("%1$-3d", id);
	}
}

//Waiting for CountDownLatch object
class WaitingTask implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final CountDownLatch latch;
	WaitingTask(CountDownLatch latch) {
		this.latch = latch;
	}
	public void run() {
		try {
			latch.await();
			print("Barrier is handled for: " + this);
		} catch(InterruptedException ex) {
			print(this + " interrupted");
		}
	}
	
	public String toString() {
		return String.format("WaitingTask %1$-3d ", id);
	}
}

public class CountDownLatchDemo  {
	
	public static final int SIZE = 100;
	
	public static void main(String[] args) throws Exception {
	
		ExecutorService exec = Executors.newCachedThreadPool();
		// All the subtasks use the same object CountDownLatch
		CountDownLatch latch = new CountDownLatch(SIZE);
		for(int i = 0; i < 10; i++) {
			exec.execute(new WaitingTask(latch));
		}
		for(int i = 0; i < SIZE; i++) {
			exec.execute(new TaskPortion(latch));
		}
		print("All the tasks are lauched");
		exec.shutdown(); // Exit after all the tasks are completed
		
	}

} /* Output
All the tasks are lauched
99  is finishing
36  is finishing
43  is finishing
95  is finishing
94  is finishing
11  is finishing
21  is finishing
77  is finishing
7   is finishing
9   is finishing
75  is finishing
10  is finishing
79  is finishing
40  is finishing
96  is finishing
64  is finishing
23  is finishing
34  is finishing
29  is finishing
38  is finishing
55  is finishing
90  is finishing
88  is finishing
28  is finishing
5   is finishing
50  is finishing
8   is finishing
1   is finishing
12  is finishing
13  is finishing
27  is finishing
98  is finishing
72  is finishing
2   is finishing
71  is finishing
45  is finishing
91  is finishing
14  is finishing
31  is finishing
17  is finishing
6   is finishing
97  is finishing
35  is finishing
69  is finishing
20  is finishing
4   is finishing
32  is finishing
68  is finishing
37  is finishing
47  is finishing
87  is finishing
70  is finishing
84  is finishing
86  is finishing
66  is finishing
54  is finishing
42  is finishing
41  is finishing
46  is finishing
74  is finishing
57  is finishing
0   is finishing
65  is finishing
80  is finishing
19  is finishing
60  is finishing
15  is finishing
89  is finishing
51  is finishing
25  is finishing
53  is finishing
62  is finishing
58  is finishing
92  is finishing
76  is finishing
22  is finishing
18  is finishing
56  is finishing
85  is finishing
61  is finishing
30  is finishing
59  is finishing
67  is finishing
24  is finishing
26  is finishing
48  is finishing
39  is finishing
33  is finishing
3   is finishing
52  is finishing
93  is finishing
81  is finishing
78  is finishing
73  is finishing
44  is finishing
82  is finishing
49  is finishing
16  is finishing
63  is finishing
83  is finishing
Barrier is handled for: WaitingTask 3   
Barrier is handled for: WaitingTask 4   
Barrier is handled for: WaitingTask 8   
Barrier is handled for: WaitingTask 2   
Barrier is handled for: WaitingTask 7   
Barrier is handled for: WaitingTask 0   
Barrier is handled for: WaitingTask 6   
Barrier is handled for: WaitingTask 5   
Barrier is handled for: WaitingTask 1   
Barrier is handled for: WaitingTask 9   
*///:~
