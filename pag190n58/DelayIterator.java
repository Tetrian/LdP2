
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class DelayIterator {
  /* TRACCIA
    Implementare un metodo statico delayIterator che prende come argomenti un
    iteratore i ed un numero intero n, e restituisce un nuovo iteratore dello
    stesso tipo di i, che restituisce gli stessi elementi di i, ma in cui ogni
    elemento viene restituito (dal metodo next) dopo un ritardo di n secondi.
    Viene valutato positivamente l’uso di classi anonime.
    Si ricordi che nella classe Thread è presente il metodo:
    public static void sleep(long milliseconds) throws InterruptedException
  */
  public static <T> Iterator<T> delayIterator(Iterator<T> iter, int delaySec) {
    return new Iterator<>() {
      @Override
      public boolean hasNext() {
        return iter.hasNext();
      }

      @Override
      public T next() {
        try {
          Thread.sleep(delaySec * 1000);
        } catch (InterruptedException e) {
        }
        return iter.next();
      }
    };
  }

  public static void main(String[] argv) {
    // Esempio d'uso:
    List<Integer> l = new LinkedList<Integer>();
    l.add(3);
    l.add(4);
    l.add(177);
    Iterator<Integer> i = delayIterator(l.iterator(), 2);
    while (i.hasNext()) {
      System.out.println(i.next());
    }
  }
  /* Output:
        il programma stampa il contenuto della lista, mostrando ciascun valore
        dopo 2 secondi di ritardo
  */
}
