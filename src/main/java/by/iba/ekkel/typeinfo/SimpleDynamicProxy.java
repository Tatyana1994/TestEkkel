//: by.iba.ekkel.typeinfo/SimpleDynamicProxy.java
package by.iba.ekkel.typeinfo;

import java.lang.reflect.*;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	public Object 
		invoke(Object proxy, Method method, Object[] args) 
				throws Throwable {
		
		System.out.println("**** proxy. " + proxy.getClass() +
				", method: " + method + ", args: " + args);
		
		if(args != null) {
			for(Object arg : args) {
				System.out.println(" " + arg);
			}
		}
		return method.invoke(proxied, args);
	}
}

public class SimpleDynamicProxy {
	
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	
	public static void main(String[] args) {
	
		RealObject real = new RealObject();
		consumer(real);
		//Вставляем посредника и вызываем снова
		Interface proxy = (Interface)Proxy.newProxyInstance(
				Interface.class.getClassLoader(), 
				new Class[] {
						Interface.class
				}, 
				new DynamicProxyHandler(real));
		consumer(proxy);
	
	}

} /* Output
doSomething()
somethingElse bonobo
**** proxy. class by.iba.ekkel.typeinfo.$Proxy0, method: public abstract void by.iba.ekkel.typeinfo.Interface.doSomething(), args: null
doSomething()
**** proxy. class by.iba.ekkel.typeinfo.$Proxy0, method: public abstract void by.iba.ekkel.typeinfo.Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@6bc7c054
 bonobo
somethingElse bonobo
*///:~
