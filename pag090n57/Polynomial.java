
import java.util.Iterator;

public class Polynomial implements Iterable<Pair<Integer, Double>> {
  private double[] coef;

  public Polynomial(double[] coefficienti) {
    coef = coefficienti;
  }

  public Iterator<Pair<Integer, Double>> iterator() {
    return new Iterator<>() {
      private int idx = 0;

      public boolean hasNext() {
        return idx < coef.length;
      }

      public Pair<Integer, Double> next() {
        return new Pair<>(idx, coef[idx++]);
      }

      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  @Override
  public String toString() {
    String polinomio = "";
    if (coef[0] != 0) polinomio = coef[0] + " + ";
    for (int i = 1; i < coef.length; ++i) {
      if (coef[i] != 0.0)
        polinomio += coef[i] + " x^" + i + " + ";
    }
    return polinomio.substring(0, polinomio.length() - 3);
  }
}
