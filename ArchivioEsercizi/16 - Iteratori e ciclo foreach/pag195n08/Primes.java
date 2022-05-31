
import java.util.Iterator;

// Affinchè la classe non sia istanziabile la dichiariamo abstract
public abstract class Primes {
  // l'esempio d'suo nel main ci fa capire che iterable sia un campo statico,
  // naturalmente public (per essere visibile all'esterno) e final (per non
  // essere modificato), inoltre deve puntare ad un oggetto che implementi
  // Iterable<Integer>
  public static final Iterable<Integer> iterable = new Iterable<Integer>() {
    public Iterator<Integer> iterator() {
      return new Iterator<Integer>() {
        private int n = 1;

        public boolean hasNext()  {
          return true; // i numeri primi sono infiniti
        }
        public Integer next() {
          int j, temp = n;
          while (true) {
            n++;
            // cerca un divisore j di n
            for (j = 2; j <= n/2; ++j)
              if (n % j == 0) break;
            // esce dal while se n è primo
            if (j > n/2) break;
          }
          return temp;
        }
        public void remove() {
          throw new UnsupportedOperationException();
        }
      }; // fine classe anonima derivata da Iterator
    } // fine metodo iterator()
  }; // fine classe anonima derivata da Iterable
}
