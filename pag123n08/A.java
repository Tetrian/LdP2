/*
  La seguente classe A fa riferimento ad una classe B.
  Implementare la classe B in modo che venga compilata correttamente
  e permetta la compilazione della classe A.
*/
public class A {
  public interface Convertible<T> {
    public T convert();
  }
  private Convertible<A> x = new B();
  private Iterable<A> y = new B(3);
  private Iterable<A> z = B.g(x);
  private Iterable<? extends B> t = B.g(B.b);
}
