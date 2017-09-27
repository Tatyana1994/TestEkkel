//: by.iba.ekkel.io/DirList3.java
// Anonymous inner class "in place" creation
// {Params: "D.*\.java"}
package by.iba.ekkel.io;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class DirList3 {
	
	//String[] args is final in case anonymous inner
	//class uses args[0] as parameter
	public static void main(final String[] args) {
	
		File path = new File("src/main/java/by/iba/ekkel/io");
		String list[];
		if(args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
			});
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list) {
			System.out.println(dirItem);
		}
	
	}

} /* Output
DirList.java
DirList2.java
DirList3.java
*///:~
