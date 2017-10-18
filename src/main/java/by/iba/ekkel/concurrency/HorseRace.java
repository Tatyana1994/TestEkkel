//: by.iba.ekkel.concurrency/HorseRace.java
// Using CyclicBarriers
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;

class Horse implements Runnable {
	
	private static int counter = 0;
	private final int id = counter++;
	private int strides = 0;
	private static Random rand = new Random(47);
	private static CyclicBarrier barrier;
	public Horse(CyclicBarrier b) {
		barrier = b;
	}
	public synchronized int getStrides() {
		return strides;
	}
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized (this) {
					strides += rand.nextInt(3); // Produces 0, 1 or 2
				}
				barrier.await();
			}
		} catch(InterruptedException e) {
			// Acceptable variant of exit
		} catch (BrokenBarrierException e) {
			// Exception that we are interested in
			throw new RuntimeException();
		}
	}
	
	public String toString() {
		return "#" + id;
	}
	
}

public class HorseRace {
	
	static final int FINISH_LINE = 75;
	private List<Horse> horses = new ArrayList<Horse>();
	private ExecutorService exec =
			Executors.newCachedThreadPool();
	private CyclicBarrier barrier;
	public HorseRace(int nHorses, final int pause) {
		barrier = new CyclicBarrier(nHorses, new Runnable() {
			
			@Override
			public void run() {
				StringBuilder s = new StringBuilder();
				for(int i = 0; i < FINISH_LINE; i++) {
					s.append("="); //As a fence on the running trace
				}
				print(s);
				for(Horse horse : horses) {
					if(horse.getStrides() >= FINISH_LINE) {
						print(horse + " won!");
						exec.shutdownNow();
						return;
					}
				}
				try {
					TimeUnit.MILLISECONDS.sleep(pause);
				} catch(InterruptedException e) {
					print("barrier-action sleep interrupted");
				}
			}
		});
		for(int i = 0; i < nHorses; i++) {
			Horse horse = new Horse(barrier);
			horses.add(horse);
			exec.execute(horse);
		}
	}
	
	public static void main(String[] args) {
	
		int nHorses = 7;
		int pause = 200;
		if(args.length > 0) { //Unrequired argument
			int p = new Integer(args[1]);
			pause = p > -1 ? p : pause;
		}
		HorseRace hr = new HorseRace(nHorses, pause);
		print("Competitors: " + Arrays.toString(hr.horses.toArray()));
		
	
	}

} /* Output
Competitors: [#0, #1, #2, #3, #4, #5, #6]
===========================================================================
===========================================================================
===========================================================================
...
===========================================================================
#2 won!
*///:~
