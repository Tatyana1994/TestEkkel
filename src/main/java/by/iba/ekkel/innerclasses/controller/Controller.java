//: by.iba.ekkel.innerclasses.controller/Controller.java
// Обобщенная система управления
package by.iba.ekkel.innerclasses.controller;

import java.util.*;

public class Controller {
	
	//Класс из пакета java.util для хранения событий Event
	private List<Event> eventList = new ArrayList<Event>();
	public void addEvent(Event c) {
		eventList.add(c);
	}
	public void run() {
		while(eventList.size() > 0) {
			for(Event e : new ArrayList<Event>()) {
				if(e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
} /* Output
*///:~
