//: by.iba.ekkel.typeinfo/NullRobot.java
// Использование динамического посредника для создания
// объекта с неопределенным состоянием
package by.iba.ekkel.typeinfo;

import java.lang.reflect.*;
import java.util.*;
import by.iba.ekkel.mindview.util.*;

class NullRobotProxyHandler implements InvocationHandler {
	
	private String nullName;
	private Robot proxied = new NRobot();
	public NullRobotProxyHandler(Class<? extends Robot> type) {
		nullName = type.getSimpleName() + " NullRobot";
	}
	public Object
		invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
				return method.invoke(proxied, args); 
	}
	
	private class NRobot implements Null, Robot {
		public String name() {
			return nullName;
		}
		public String model() {
			return nullName;
		}
		public List<Operation> operations() {
			return Collections.emptyList();
		}
	}
	
}
	
public class NullRobot {
		public static Robot 
			newNullRobot(Class<? extends Robot> type) {
				return (Robot)Proxy.newProxyInstance(
						NullRobot.class.getClassLoader(), 
						new Class[] {Null.class, Robot.class}, 
						new NullRobotProxyHandler(type));
		}
		
		public static void main(String[] args) {
		
			Robot[] bots = {
					new SnowRemovalRobot("SnowBee"),
					newNullRobot(SnowRemovalRobot.class)
			};
			for(Robot bot : bots) {
				Robot.Test.test(bot);
			}
		
		}
		
}/* Output
Название: SnowBee
Модель: SnowBot Series 11
SnowBee  может убирать снег
SnowBee убирает снег
SnowBee  может чистить крышу
SnowBee чистит крышу
[Null Robot]
Название: SnowRemovalRobot NullRobot
Модель: SnowRemovalRobot NullRobot
*///:~


