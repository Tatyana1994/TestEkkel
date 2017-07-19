//: by.iba.ekkel.innerclasses.controller/Controller.java
// ���������� ������� ����������
package by.iba.ekkel.innerclasses.controller;

import java.util.*;

public class Controller {
	
	//����� �� ������ java.util ��� �������� ������� Event
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
