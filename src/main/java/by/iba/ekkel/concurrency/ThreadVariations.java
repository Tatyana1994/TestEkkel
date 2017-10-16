//: by.iba.ekkel.concurrency/ThreadVariations.java
// Create the threads using inner classes
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import static by.iba.ekkel.mindview.util.Print.*;

//Use nominated inner class
//if the inner class has its own specialties: new methods
class InnerThread1 {
	private int countDown = 5;
	private Inner inner;
	private class Inner extends Thread {
		Inner(String name) {
			super(name);
			start();
		}		
		public void run() {
			try {
				while(true) {
					print(this);
					if(--countDown == 0) {
						return;
					}
					sleep(10);
				}
			} catch(InterruptedException e) {
				print("interrupted");
			}
		}
		public String toString() {
			return getName() + ": " + countDown;
		}
	}
	public InnerThread1(String name) {
		inner = new Inner(name);
	}	
}

//Use non-nominated inner class
class InnerThread2 {
	private int countDown = 5;
	private Thread t;
	public InnerThread2(String name) {
		t = new Thread(name) {
			public void run() {
				try {
					while(true) {
						print(this);
						if(--countDown == 0) {
							return;
						}
						sleep(10);
					}
				} catch(InterruptedException e) {
					print("sleep() interrupted");
				}
			}	
			public String toString() {
				return getName() + ": " + countDown;
			}
		};	
		t.start();
	}
}

//Use the nominated implementation of Runnable
class InnerRunnable1 {
	private int countDown = 5;
	private Inner inner;
	private class Inner implements Runnable {
		Thread t;
		Inner(String name) {
			t = new Thread(this, name);
			t.start();
		}
		public void run() {
			try {
							while(true) {
				print(this);
				if(--countDown == 0) {
					return;
				}
				TimeUnit.MILLISECONDS.sleep(10);
				}
			} catch(InterruptedException e) {
				print("sleep() interrupted");
			}
		}
		public String toString() {
			return t.getName() + ": " + countDown;
		}
	}
	public InnerRunnable1(String name) {
		inner = new Inner(name);
	}
}

//Use the anonymous implementation of Runnable
class InnerRunnable2 {
	private int countDown = 5;
	private Thread t;
	public InnerRunnable2(String name) {
			t = new Thread(new Runnable() {
				
				public void run() {
					try {
						while(true) {
							print(this);
							if(--countDown == 0) {
								return;
							}
							TimeUnit.MILLISECONDS.sleep(10);
						}
					} catch(InterruptedException e) {
						print("sleep() interrupted");
					}
				}
			public String toString() {
				return Thread.currentThread().getName() +
						": " + countDown;
			}
		}, name);
		t.start();
	}
}

//Separate method to execute the code in the thread
class ThreadMethod {
	private int countDown = 5;
	private Thread t;
	private String name;
	public ThreadMethod(String name) {
		this.name = name;
	}
	public void runTask() {
		if(t == null) {
			t = new Thread(name) {
				public void run() {
					try {
						while(true) {
							print(this);
							if(--countDown == 0) {
								return;
							}
							sleep(10);
						}
					} catch(InterruptedException e) {
						print("sleep() interrupted");
					}
				}
				public String toString() {
					return getName() + ": " + countDown;
				}
			};
			t.start();
		}
	}
}

public class ThreadVariations {
	
	public static void main(String[] args) {
	
		new InnerThread1("InnerThread1");
		new InnerThread2("InnerThread2");
		new InnerRunnable1("InnerRunnable1");
		new InnerRunnable2("InnerRunnable2");
		new ThreadMethod("ThreadMethod").runTask();
	
	}

} /* Output
InnerThread1: 5
InnerThread2: 5
InnerRunnable1: 5
InnerRunnable2: 5
ThreadMethod: 5
InnerThread2: 4
InnerThread1: 4
InnerRunnable1: 4
InnerRunnable2: 4
ThreadMethod: 4
InnerThread2: 3
InnerThread1: 3
InnerRunnable1: 3
ThreadMethod: 3
InnerRunnable2: 3
InnerThread2: 2
InnerThread1: 2
InnerRunnable1: 2
ThreadMethod: 2
InnerRunnable2: 2
InnerThread2: 1
InnerThread1: 1
InnerRunnable1: 1
ThreadMethod: 1
InnerRunnable2: 1
*///:~
