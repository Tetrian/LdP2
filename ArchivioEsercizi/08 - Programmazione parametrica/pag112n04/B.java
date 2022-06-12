import java.util.Set;
import java.util.Iterator;
import java.lang.Iterable;

public class B<T> implements Iterable<Integer> {

  // dalla linea 11 di A deduciamo che ci deve essere un costruttore che accetta
  // un argomento compatibile con null
  public B(T t) { }

  // poichè A() ha una chiamata implicita a B() è necessario il costruttore
  // senza argomenti
  public B() { }

  // dalla linea 18 capiamo che B deve essere iterabile su Integer o supertipo
  public Iterator<Integer> iterator() { return null; }

  // dalla linea 12 deduciamo che B deve avere un metodo statico con un suo
  // parametro di tipo che accetti come attributo un oggetto di quel tipo e
  // restituisca una stringa.
  public static <U> String buildMessage(U u) { return null; }

  // dalla linea 17 deduciamo che B deve avere un metodo check che accetti un
  // supertipo di Set<E>  ed un E e restituisca un booleano
  public <E> boolean check(Set<E> set, E t) { return false; }

  // dalla 18 e dalla 19 capiamo che B ha un metodo process che ha 3 parametri
  // compatibili rispettivamente sia con Set<Integer>, Set<String> e Integer che
  // con Set<String>, Set<Integer> e null; inoltre il metodo deve restituire un
  // oggetto compatibile con Set<? super Number>
  public <U, E> Set<Number> process(Set<U> s1, Set<E> s2, U t) { return null; }
}
