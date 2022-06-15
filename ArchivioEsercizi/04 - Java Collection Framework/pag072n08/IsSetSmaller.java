
import java.util.Set;
import java.util.Comparator;

public class IsSetSmaller {
  /* TRACCIA
  Implementare il metodo statico isSetSmaller, che accetta due insiemi e un
  comparatore, e restituisce vero se e solo se tutti gli elementi del primo
  insieme sono più piccoli, in base al comparatore, di tutti gli elementi del
  secondo insieme. Porre particolare attenzione alla scelta della firma.      */
  public static <T> boolean isSetSmaller(Set<? extends T> s1, Set<? extends T> s2,
                                         Comparator<? super T> c)
  {
    T maxS1 = null;
    for (T t: s1) {
      if (maxS1 == null || c.compare(t, maxS1) > 0)
        maxS1 = t;
    }
    T minS2 = null;
    for (T t: s2) {
      if (minS2 == null || c.compare(t, minS2) < 0)
        minS2 = t;
    }
    return c.compare(maxS1, minS2) < 0;
  }

}
