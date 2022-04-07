
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;

public class B {

  // affinchè la linea 7 compili il metodo getlist() deve ritornare una lista di
  // stringhe o suo sottotipo in modo che sia compatibile con <? extends String>
  public static LinkedList<String> getList() {
    return new LinkedList<String>();
  }

  // get it deve accettare qualsiasi parametro e restituirne uno dello stesso tipo
  public static <T> T getIt(T x)  { return x; }

  // Il metodo convert deve accettare un tipo Set<Integer o suo supertipo> e
  // ritornare una classe che implementa Set<String> (usiamo HashSet)
  public static HashSet<String> convert(Set<? super Integer> s) {
    return new HashSet<String>();
  }

  // per compilare le chiamate f(new B(),B.something) e f(new Integer(4),B.something);
  public static final Comparator<Object> something = new Comparator<>() {
    public int compare(Object a, Object b) { return 0; }
  };

}
