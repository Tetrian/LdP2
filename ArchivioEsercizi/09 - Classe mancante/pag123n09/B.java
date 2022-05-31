
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;

public class B {

  // getList è un metodo statico senza argomenti che restituisce
  // List<? extends String> e qualiasi tipo ad esso assegnabile
  public static LinkedList<String> getList() {
    return new LinkedList<String>(); // oppure return null;
  }

  // getIt è un metodo statico con un argomento qualsiasi (quindi si potrebbe
  // anche metter Object) e come parametro di ritorno ha T o un suo sottotipo
  public static <T> T getIt(T x)  { return x; }

  // Il metodo convert prende un Set<? super Integer> e restituisce un
  // Set<String> o qualsiasi tpo ad esso assegnabile
  public static HashSet<String> convert(Set<? super Integer> s) {
    return new HashSet<String>(); // oppure return null;
  }

  // per compilare le chiamate f(new B(),B.something) e f(new Integer(4),B.something);
  public static final Comparator<Object> something = new Comparator<>() {
    public int compare(Object a, Object b) { return 0; }
  };

}
