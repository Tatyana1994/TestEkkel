//: by.iba.ekkel.innerclasses/GreenhouseControls.java
// Пример конкретного приложения на основе
// системы управления, где все находится в одном классе
// Внутренние классы дают возможность инкапсулировать различную 
// функциональность для каждого отдельного события
package by.iba.ekkel.innerclasses;

import by.iba.ekkel.innerclasses.controller.*;

public class GreenhouseControls extends Controller {
	private boolean light = false;
	public class LightOn extends Event {
		public LightOn(long delayTime) {
			super(delayTime);
		}
		public void action() {
			// Сюда помещается аппаратный вызов, выполняющий
			// физическое включение света
			light = true;
		}
		public String toString() {
			return "Свет включен";
		}
	}
	
	public class LightOff extends Event {
		public LightOff(long delayTime) {
			super(delayTime);
		}
		public void action() {
			// Сюда помещается аппаратный вызов, выполняющий
			// физическое выключение света
			light = false;
		}
		public String toString() {
			return "Свет выключен";
		}
	}
	
	private boolean water = false;
	public class WaterOn extends Event {
		public WaterOn(long delayTime) {
			super(delayTime);
		}
		public void action() {
			// Здесь размещается код включения 
			// системы полива
			water = true;
		}
		public String toString() {
			return "Полив включен";
		}
	}
	
	public class WaterOff extends Event {
		public WaterOff(long delayTime) {
			super(delayTime);
		}
		public void action() {
			// Здесь размещается код выключения 
			// системы полива
			water = false;
		}
		public String toString() {
			return "Полив отключен";
		}
	}
	
	private String thermostat = "День";
	public class ThermostatNight extends Event {
		public ThermostatNight(long delayTime) {
			super(delayTime);
		}
		public void action() {
			// Здесь размещается управления оборудованием 
			thermostat = "Ночь";
		}
		public String toString() {
			return "Термостат использует ночной режим";
		}
	}
	public class ThermostatDay extends Event {
		public ThermostatDay(long delayTime) {
			super(delayTime);
		}
		public void action() {
			// Здесь размещается управления оборудованием 
			thermostat = "День";
		}
		public String toString() {
			return "Термостат использует дневной режим";
		}
	}
	
	// Пример метода action(), вставляющего
	// самого себя в список событий
	public class Bell extends Event {
		public Bell(long delayTime) {
			super(delayTime);
		}
		public void action() {
			addEvent(new Bell(delayTime));
		}
		public String toString() {
			return "Бам!";
		}
	}
	
	public class Restart extends Event {
		private Event[] eventList;
		public Restart(long delayTime, Event[] eventList) {
			super(delayTime);
			this.eventList = eventList;
			for (Event e : eventList) {
				addEvent(e);
			}
		}
		public void action() {
			for(Event e : eventList) {
				e.start(); //Перезапуск каждый раз
				addEvent(e);
			}
			start(); // Возвращаем это событие Event
			addEvent(this);
		}
		public String toString() {
			return "Перезапуск системы";
		}
	}
	
	public static class Terminate extends Event {
		public Terminate(long delayTime) {
			super(delayTime);
		}
		public void action() {
			System.exit(0);
		}
		public String toString() {
			return "Отключение";
		}
	}

} /* Output
*///:~
