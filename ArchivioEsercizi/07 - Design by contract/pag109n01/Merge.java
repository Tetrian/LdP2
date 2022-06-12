
import java.util.LinkedList;
import java.util.Iterator;

public class Merge {
  /* TRACCIA
    Realizzare un metodo chiamato merge che rispetti il seguente contratto:
    Pre-condizione: Accetta due LinkedList dello stesso tipo e di pari lunghezza
    Post-condizione: Restituisce una nuova LinkedList ottenuta alternando gli
                     elementi della prima lista e quelli della seconda.
                     Ad esempio, se la prima lista contiene (1, 2, 3) e la
                     seconda lista (4, 5, 6), la nuova lista deve contenere
                     (1, 4, 2, 5, 3, 6).
    Penale: Se le liste non hanno la stessa lunghezza, lancia
            IllegalArgumentException
  */
  public static <T> LinkedList<T> merge(LinkedList<T> a, LinkedList<T> b) {
    if (a.size() != b.size())
      throw new IllegalArgumentException();
    LinkedList<T> res = new LinkedList<T>();
    Iterator<T> aIter = a.iterator(),
                bIter = b.iterator();
    while (aIter.hasNext()) {
      res.add(aIter.next());
      res.add(bIter.next());
    }
    return res;
  }
}
