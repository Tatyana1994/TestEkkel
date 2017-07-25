//: by.iba.ekkel.holding/PrintingContainers.java
// Вывод контейнеров по умолчанию
package by.iba.ekkel.holding;

import java.util.*;

import static by.iba.ekkel.mindview.util.Print.*;

public class PrintingContainers {
	
	static Collection fill(Collection<String> collection) {
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		return collection;
	}
	
	static Map fill(Map<String,String> map) {
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "Spot");
		return map;
	}
	
	public static void main(String[] args) {
	
		print(fill(new ArrayList<String>()));
		print(fill(new LinkedList<String>()));
		print(fill(new HashSet<String>()));
		print(fill(new TreeSet<String>()));
		print(fill(new LinkedHashSet<String>()));
		print(fill(new HashMap<String, String>()));
		print(fill(new TreeMap<String, String>()));
		print(fill(new LinkedHashMap<String, String>()));
		
	}

} /* Output
[rat, cat, dog, dog]
[rat, cat, dog, dog]
[rat, cat, dog]
[cat, dog, rat]
[rat, cat, dog]
{rat=Fuzzy, cat=Rags, dog=Spot}
{cat=Rags, dog=Spot, rat=Fuzzy}
{rat=Fuzzy, cat=Rags, dog=Spot}
*///:~
