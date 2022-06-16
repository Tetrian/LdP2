
import java.util.Comparator;

public class CountInBetween {
  /* TRACCIA
    Implementare il metodo statico countInBetween, che accetta un array, un
    comparatore e due oggetti a e b, e restituisce il numero di oggetti dell’
    array che, secondo il comparatore, sono maggiori di a e minori di b.
    Porre particolare attenzione alla scelta dell’intestazione.
  */
  public static <T> int countInBetween(T[] vec, Comparator<? super T> c, T a, T b) {
    int counter = 0;
    for (T t: vec) {
      if (c.compare(t, a) > 0 && c.compare(t, b) < 0) counter++;
    }
    return counter;
  }
  /* ANALISI DELLA FIRMA:
    Poiché bisogna comparare gli oggetti a e b con quelli dell'array non ha
    senso che il tipo di a e b non sia correlato con il comparatore e con l'
    array, poiché se non esiste nessun criterio di ordinamentro tra gli oggetti
    allora non si può decidere se questi siano minori o maggiori.

    Si deve dare la possibilità di passare un Comparator<Employee> ad un array
    di Manager poiché è possibile che quest'ultimi sfruttino il criterio di
    ordinamento della superclasse e quindi Comparable<? super T>
  */
}
