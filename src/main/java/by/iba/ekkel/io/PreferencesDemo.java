//: by.iba.ekkel.io/PreferencesDemo.java
package by.iba.ekkel.io;

import java.util.prefs.*;
import static by.iba.ekkel.mindview.util.Print.*;

public class PreferencesDemo {
	
	public static void main(String[] args) throws Exception {
	
		Preferences prefs = Preferences
				.userNodeForPackage(PreferencesDemo.class);
		prefs.put("Location", "Oz");
		prefs.put("Footwear", "Ruby Slippers");
		prefs.putInt("Companions", 4);
		prefs.putBoolean("Are there witches?", true);
		int usageCount = prefs.getInt("UsageCount", 0);
		usageCount++;
		prefs.putInt("UsageCount", usageCount);
		for(String key : prefs.keys()) {
			print(key + ": " + prefs.get(key, null));
		}
		
		//It's always necessary to define default value
		print("How many companies does Dorothy have? " +
				prefs.getInt("Companions", 0));
	
	}

} /* Output
Location: Oz
Footwear: Ruby Slippers
Companions: 4
Are there witches?: true
UsageCount: 2
How many companies does Dorothy have? 4
*///:~
