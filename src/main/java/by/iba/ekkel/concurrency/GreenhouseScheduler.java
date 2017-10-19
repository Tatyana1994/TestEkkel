//: by.iba.ekkel.concurrency/GreenhouseScheduler.java
// New implementation of innerclasses/GreenhouseController.java
// by using ScheduledThreadPoolExecutor
// {Args: 5000}
package by.iba.ekkel.concurrency;

import java.util.concurrent.*;
import java.util.*;

public class GreenhouseScheduler {
	
	private volatile boolean light = false;
	private volatile boolean water = false;
	private String thermostat = "Day";
	public synchronized String getThermostat() {
		return thermostat;
	}
	public synchronized void setThermostat(String value) {
		thermostat = value;
	}
	
	ScheduledThreadPoolExecutor scheduler =
			new ScheduledThreadPoolExecutor(10);
	
	public void schedule(Runnable event, long delay) {
		scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
	}
	
	public void 
		repeat(Runnable event, long initialDelay, long period) {
			scheduler.scheduleAtFixedRate(
					event, initialDelay, period, TimeUnit.MILLISECONDS);
	}
	
	class LightOn implements Runnable {
		public void run() {
			// Here is the code 
			// of switching on the lightning
			System.out.println("Lightning is Switched On");
			light = true;
		}
	}
	
	class LightOff implements Runnable {
		public void run() {
			// Here is the code 
			// of switching off the lightning
			System.out.println("Lightning is Switched Off");
			light = false;
		}
	}
	
	class WaterOn implements Runnable {
		public void run() {
			// Here is the code 
			// of switching on the watering
			System.out.println("Watering is Switched On");
			light = true;
		}
	}
	
	class WaterOff implements Runnable {
		public void run() {
			// Here is the code 
			// of switching off the watering
			System.out.println("Watering is Switched Off");
			light = false;
		}
	}
	
	class ThermostatNight implements Runnable {
		public void run() {
			// Here is the code 
			// to manage the equipment
			System.out.println("Switching On the Night mode");
			setThermostat("Night");
		}
	}
	
	class ThermostatDay implements Runnable {
		public void run() {
			// Here is the code 
			// to manage the equipment
			System.out.println("Switching On the Day mode");
			setThermostat("Day");
		}
	}
	
	class Bell implements Runnable {
		public void run() {
			System.out.println("Baaaam!");
		}
	}

	class Terminate implements Runnable {
		public void run() {
			System.out.println("Finishing");
			scheduler.shutdownNow();
			// To execute this task
			// we should run the new task 
			// in case the scheduler was disabled
			new Thread() {
				public void run() {
					for(DataPoint d : data) {
						System.out.println(d);
					}
				}
			}.start();
		}
	}
	
	// New opportunity: the collection of the data
	static class DataPoint {
		final Calendar time;
		final float temperature;
		final float humidity;
		public DataPoint(Calendar d, float temp, float hum) {
			time = d;
			temperature = temp;
			humidity = hum;
		}
		public String toString() {
			return time.getTime() +
					String.format(" temperature: %1$.1f; humidity: %2f$.2f", temperature, humidity);
		}
	}
		
	private Calendar lastTime = Calendar.getInstance();
		{ // Adjustment date to half an hour
			lastTime.set(Calendar.MINUTE, 30);
			lastTime.set(Calendar.SECOND, 00);
		}
		
	private float lastTemp = 65.0f;
	private int tempDirection = +1;
	private float lastHumidity = 50.0f;
	private int humidityDirection = +1;
	private Random rand = new Random(47);
	List<DataPoint> data = Collections.synchronizedList(
			new ArrayList<DataPoint>());
	
	class CollectData implements Runnable {
		public void run() {
			System.out.println("Collecting of data");
			synchronized(GreenhouseScheduler.this) {
				lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
				// With the possibility 1/5 the direction will be changed
				if(rand.nextInt(5) == 4) {
					tempDirection = -tempDirection;
				}
				// Save the previous value
				lastTemp = lastTemp +
						tempDirection * (1.0f + rand.nextFloat());
				if(rand.nextInt(5) == 4) {
					humidityDirection = -humidityDirection;
				}
				lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();
				// The Calendar object should be copied 
				// otherwise DataPoint will store links
				// on the same lastTime
				// For the basic object -- such as Calendar --
				// clone() call is enough
				data.add(new DataPoint((Calendar)lastTime.clone(), lastTemp, lastHumidity));
			}
		}
	}
	
	public static void main(String[] args) {
		
		GreenhouseScheduler gh = new GreenhouseScheduler();
		gh.schedule(gh.new Terminate(), 5000);
		// Former "Restart" class not necessary
		gh.repeat(gh.new Bell(), 0, 1000);
		gh.repeat(gh.new ThermostatNight(), 0, 2000);
		gh.repeat(gh.new LightOn(), 0, 200);
		gh.repeat(gh.new LightOff(), 0, 400);
		gh.repeat(gh.new WaterOn(), 0, 600);
		gh.repeat(gh.new WaterOff(), 0, 800);
		gh.repeat(gh.new ThermostatDay(), 0, 1400);
		gh.repeat(gh.new CollectData(), 500, 500);
		
	}
	
} /* Output
Baaaam!
Switching On the Night mode
Lightning is Switched On
Lightning is Switched Off
Watering is Switched On
Watering is Switched Off
Switching On the Day mode
Lightning is Switched On
Lightning is Switched On
Lightning is Switched Off
Collecting of data
Lightning is Switched On
Watering is Switched On
Lightning is Switched Off
Lightning is Switched On
Watering is Switched Off
Baaaam!
Lightning is Switched On
Collecting of data
Lightning is Switched On
Watering is Switched On
Lightning is Switched Off
Lightning is Switched On
Switching On the Day mode
Collecting of data
Lightning is Switched On
Lightning is Switched Off
Watering is Switched Off
Lightning is Switched On
Watering is Switched On
Baaaam!
Switching On the Night mode
Lightning is Switched On
Lightning is Switched Off
Collecting of data
Lightning is Switched On
Lightning is Switched On
Lightning is Switched Off
Watering is Switched On
Watering is Switched Off
Collecting of data
Lightning is Switched On
Lightning is Switched On
Lightning is Switched Off
Switching On the Day mode
Baaaam!
Lightning is Switched On
Watering is Switched On
Collecting of data
Lightning is Switched On
Lightning is Switched Off
Watering is Switched Off
Lightning is Switched On
Collecting of data
Lightning is Switched On
Watering is Switched On
Lightning is Switched Off
Lightning is Switched On
Baaaam!
Lightning is Switched On
Switching On the Night mode
Lightning is Switched Off
Watering is Switched Off
Collecting of data
Lightning is Switched On
Watering is Switched On
Switching On the Day mode
Lightning is Switched On
Lightning is Switched Off
Collecting of data
Lightning is Switched On
Lightning is Switched On
Watering is Switched On
Lightning is Switched Off
Watering is Switched Off
Finishing
Thu Oct 19 15:00:00 AST 2017 temperature: 66,4; humidity: 66,399826$.2f
Thu Oct 19 15:30:00 AST 2017 temperature: 68,0; humidity: 67,977821$.2f
Thu Oct 19 16:00:00 AST 2017 temperature: 69,7; humidity: 69,715172$.2f
Thu Oct 19 16:30:00 AST 2017 temperature: 70,8; humidity: 70,829529$.2f
Thu Oct 19 17:00:00 AST 2017 temperature: 72,0; humidity: 72,030960$.2f
Thu Oct 19 17:30:00 AST 2017 temperature: 73,2; humidity: 73,188049$.2f
Thu Oct 19 18:00:00 AST 2017 temperature: 71,9; humidity: 71,938278$.2f
Thu Oct 19 18:30:00 AST 2017 temperature: 70,1; humidity: 70,137558$.2f
Thu Oct 19 19:00:00 AST 2017 temperature: 68,9; humidity: 68,939819$.2f
*///:~
	


