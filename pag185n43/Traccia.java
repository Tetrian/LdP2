
import java.util.Set;
import java.util.HashSet;

class Traccia {/*
  Data la seguente interfaccia:
  public interface Selector<T> {
    boolean select(T x);
  }
  implementare il metodo (statico) concurrentFilter, che prende come argomenti
  un Set X e un Selector S, di tipi compatibili, e restituisce un nuovo insieme
  Y che contiene quegli elementi di X per i quali la funzione select di S
  restituisce il valore true. Inoltre, il metodo deve invocare la funzione
  select in parallelo su tutti gli elementi di X (dovrà quindi creare tanti
  thread quanti sono gli elementi di X).                                      */

  public static <T> Set<T> concurrentFilter(Set<T> x, Selector<T> p) {
  	Set<T> set = new HashSet<>();
  	for (T t: x) {
  		new Thread(() -> {
  			if (p.select(t))
  					set.add(t);
  		}).start();
  	}
  	try {
  		Thread.sleep(set.size());
  	} catch (InterruptedException e) {}
  	return set;
  }

  public static void main(String[] argv) {
    // Esempio d'uso:
    Set<Integer> x = new HashSet<Integer>();
    x.add(1); x.add(2); x.add(5);
    // Selector<Integer> oddSelector = new Selector<Integer>() {
    //   public boolean select(Integer n) {
    //     return (n%2 != 0);
    //   }
    // };
    Selector<Integer> oddSelector = n -> n%2 != 0;
    Set<Integer> y = concurrentFilter(x, oddSelector);
    for (Integer n: y)
     System.out.println(n);
  }
  /* Output:
      1
      5
  */
}
