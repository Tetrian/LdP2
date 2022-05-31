
import java.util.Iterator;

class Traccia {/*
  Implementare una classe SuperclassIterator che rappresenta un iteratore su
  tutte le superclassi di un oggetto dato, a partire dalla classe stessa
  dell'oggetto fino ad arrivare ad Object. Ad esempio, nell'ambito della
  tradizionale gerarchia formata dalle classi Employee e Manager, si consideri
  il seguente caso d'uso.                                                     */
  public static void main(String[] argv) {
    // Esempio d'uso:
    Iterator<Class<?>> i = new SuperclassIterator(new Manager("Franco"));
    while (i.hasNext())
    System.out.println(i.next());
  }
  /* Output:
        class Manager
        class Employee
        class java.lang.Object
*/
}
