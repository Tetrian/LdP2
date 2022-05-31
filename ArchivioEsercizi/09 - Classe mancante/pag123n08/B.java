
import java.lang.Iterable;
import java.util.Iterator;

public class B implements A.Convertible<A>, Iterable<A> {

  // implemento il metodo dell'interfaccia A.Convertible
  public A convert() {
    return new A();
  }

  // per compilare private Convertible<A> x = new B();
  public B() {}

  // implemento il metodo astratto di Iterable
  public Iterator<A> iterator() {
    return new Iterator<A>() {
      @Override
      public boolean hasNext() {
        return true;
      }

      @Override
      public A next() {
        return new A();
      }
    };
  }

  // per compilare private Iterable<A> y = new B(3);
  public B(int n) { }

  // per compilare private Iterable<A> z = B.g(x);
  public static <T> Iterable<A> g(T x) {
    return new B();
  }

  // per compilare private Iterable<? extends B> t = B.g(B.b);
  protected static boolean b = false;
  public static Iterable<B> g(boolean b) {
    class Inner implements Iterable<B> {
      public Iterator<B> iterator() {
        return new Iterator<B>(){
          @Override
          public boolean hasNext() {
            return true;
          }

          @Override
          public B next() {
            return new B();
          }
        };
      }
    }
    return new Inner();
  }

}
