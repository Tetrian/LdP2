
import java.util.List;
import java.util.ArrayList;
import java.lang.Comparable;
import java.lang.Iterable;
import java.util.Iterator;

public class SortedList<T extends Comparable<? super T>> implements Iterable<T> {
  private List<T> l;

  public SortedList() {
    l = new ArrayList<T>();
  }

  public void add(T elem) {
    int idx = 0;
    for (T t: l) {
      if (t.compareTo(elem) > 0) break;
      idx++;
    }
    l.add(idx, elem);
  }

  public Iterator<T> iterator() {
    return l.iterator();
  }
}
