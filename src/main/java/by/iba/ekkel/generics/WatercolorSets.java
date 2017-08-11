//: by.iba.ekkel.generics/WatercolorSets.java
package by.iba.ekkel.generics;

import by.iba.ekkel.generics.watercolors.*;
import java.util.*;
import static by.iba.ekkel.mindview.util.Print.*;
import static by.iba.ekkel.mindview.util.Sets.*;
import static by.iba.ekkel.generics.watercolors.Watercolors.*;

public class WatercolorSets {
	
	public static void main(String[] args) {
	
		Set<Watercolors> set1 = 
				EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
		Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
		print("set1. " + set1);
		print("set2. " + set2);
		print("union(set1, set2): " + union(set1, set2));
		Set<Watercolors> subset = intersection(set1, set2);
		print("intersection(set1, set2): " + subset);
		print("difference(set1, subset): " + 
						difference(set1, subset));
		print("difference(set2, subset): " + 
				difference(set2, subset));
		print("complement(set1, set2): " +
				complement(set1, set2));
	}

} /* Output
set1. [BRILLIANT_RED, CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE]
set2. [CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN, YELLOW_OCHRE, BURNT_SIENNA, RAW_UMBER, BURNT_UMBER]
union(set1, set2): [VIOLET, CERULEAN_BLUE_HUE, ROSE_MADDER, SAP_GREEN, BURNT_SIENNA, ULTRAMARINE, RAW_UMBER, MAGENTA, PERMANENT_GREEN, BURNT_UMBER, CRIMSON, VIRIDIAN_HUE, YELLOW_OCHRE, COBALT_BLUE_HUE, BRILLIANT_RED, PHTHALO_BLUE]
intersection(set1, set2): [CERULEAN_BLUE_HUE, VIRIDIAN_HUE, COBALT_BLUE_HUE, ULTRAMARINE, PERMANENT_GREEN, PHTHALO_BLUE]
difference(set1, subset): [CRIMSON, VIOLET, ROSE_MADDER, BRILLIANT_RED, MAGENTA]
difference(set2, subset): [SAP_GREEN, BURNT_SIENNA, YELLOW_OCHRE, RAW_UMBER, BURNT_UMBER]
complement(set1, set2): [VIOLET, ROSE_MADDER, SAP_GREEN, BURNT_SIENNA, RAW_UMBER, MAGENTA, BURNT_UMBER, CRIMSON, YELLOW_OCHRE, BRILLIANT_RED]
*///:~
