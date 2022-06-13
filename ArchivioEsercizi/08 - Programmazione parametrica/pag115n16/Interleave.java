
import java.util.LinkedList;

public class Interleave {
  /* TRACCIA
    Implementare un metodo statico interleave che prende come argomento tre
    LinkedList: A, B e C. Senza modificare A e B, il metodo aggiunge tutti gli
    elementi di A e di B a C, in modo alternato (prima un elemento di A, poi uno
    di B, poi un altro elemento di A, e così via). Porre particolare attenzione
    alla scelta della firma di interleave, in modo che sia la più generale
    possibile, ma senza utilizzare parametri di tipo inutili.
  */
  public static <T> void interleave(LinkedList<? extends T> a,
                                    LinkedList<? extends T> b,
                                    LinkedList<T> c)
  {
    int size = (a.size() < b.size()) ? b.size() : a.size();
    for (int i = 0; i < size; ++i) {
      if (i < a.size()) c.add(a.get(i));
      if (i < b.size()) c.add(b.get(i));
    }
  }

  // Test
  public static void main(String[] args) {
    LinkedList<Integer> a = new LinkedList<Integer>();
    a.add(1); a.add(3); a.add(5);
    LinkedList<Double> b = new LinkedList<Double>();
    b.add(2.0); b.add(4.0);
    LinkedList<Number> c = new LinkedList<Number>();
    c.add(0);
    Interleave.<Number>interleave(a,b,c);
    System.out.println(c);
  }
}
