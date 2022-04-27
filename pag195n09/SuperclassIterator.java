
import java.util.Iterator;

public class SuperclassIterator implements Iterator<Class<?>> {
  Class<?> current;

  public <T> SuperclassIterator(T t) {
    current = t.getClass();
  }

  public boolean hasNext() {
    return current != null;
  }

  public Class<?> next() {
    Class<?> temp = current;
    current = current.getSuperclass();
    return temp;
  }

  public void remove() {
    throw new UnsupportedOperationException();
  }
}
