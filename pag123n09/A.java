/*
  La seguente classe A fa riferimento ad una classe B.
  Implementare la classe B in modo che venga compilata correttamente
  e permetta la compilazione della classe A.
*/
import java.util.List;
import java.util.Comparator;
import java.util.Set;

public class A {
  private List<? extends String> l = B.getList();

  public <T> void f(T x, Comparator<? super T> y) {
    y.compare(x, B.getIt(x));
  }
  public void g(Set<? super Integer> s) {
    Set<String> s2 = B.convert(s);
    f(new B(), B.something);
    f(new Integer(4), B.something);
  }
}
