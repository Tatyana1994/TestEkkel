//: typeinfo/pets/ForNameCreator.java
package by.iba.ekkel.typeinfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "by.iba.ekkel.typeinfo.pets.Mutt",
    "by.iba.ekkel.typeinfo.pets.Pug",
    "by.iba.ekkel.typeinfo.pets.EgyptianMau",
    "by.iba.ekkel.typeinfo.pets.Manx",
    "by.iba.ekkel.typeinfo.pets.Cymric",
    "by.iba.ekkel.typeinfo.pets.Rat",
    "by.iba.ekkel.typeinfo.pets.Mouse",
    "by.iba.ekkel.typeinfo.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
