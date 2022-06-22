
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class RotatingList<T> {
  private List<T> l;
  private Set<T> values;

  public RotatingList() {
    l = new ArrayList<T>();
    values = new HashSet<T>();
  }

  public void add(T elem) {
    l.add(elem);
    values.add(elem);
  }

  public void rotateLeft() {
    T tmp =  l.get(0);
    for (int i = 1; i < l.size(); ++i) {
      T tmp1 = l.get(i);
      l.set(i - 1, tmp1);
    }
    l.set(l.size() - 1, tmp);
  }

  public void rotateRight() {
    T tmp =  l.get(l.size() - 1);
    for (int i = l.size() - 2; i >= 0; --i) {
      l.set(i + 1, l.get(i));
    }
    l.set(0, tmp);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof RotatingList)) return false;
    RotatingList rl = (RotatingList) o;
    return values.equals(rl.values);
  }

  @Override
  public String toString() {
    return l.toString();
  }
}
