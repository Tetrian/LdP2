
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

class TwoSteps {/*
  TRACCIA:
    Implementare un metodo statico twoSteps che accetta come argomento un
    iteratore e restituisce un iteratore dello stesso tipo, che compie due
    passi per ogni chiamata a next.                                         */

  //SOLUZIONE:
  public static <T> Iterator<T> twoSteps(Iterator<T> iter) {
    LinkedList<T> l = new LinkedList<>();
    for (Iterator<T> i = iter; iter.hasNext() == true; iter.next())
      l.add(iter.next());
    return l.iterator();
  }

  // Come esempio, si consideri il seguente caso d’uso.
  public static void main(String[] argv) {
    List<Integer> l = new LinkedList<Integer>();
    l.add(3); l.add(5); l.add(7); l.add(9);
    Iterator<Integer> iter1 = twoSteps(l.iterator());
    System.out.println("Iterazione 1:");
    System.out.println(iter1.next());
    System.out.println(iter1.next());
    Iterator<Integer> iter2 = twoSteps(l.iterator());
    System.out.println("Iterazione 2:");
    while (iter2.hasNext())
      System.out.println(iter2.next());
  }/* OUTPUT:
        Iterazione 1:
        3
        7
        Iterazione 2:
        3
        7
  */
}
