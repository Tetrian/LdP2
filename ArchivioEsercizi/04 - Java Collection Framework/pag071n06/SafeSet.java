
import java.util.Set;
import java.util.HashSet;

public class SafeSet<T> {
  private Set<T> set;
  private Set<T> trash;

  public SafeSet() {
    set = new HashSet<T>();
    trash = new HashSet<T>();
  }

  public boolean add(T t) {
    synchronized (set) {
      trash.remove(t);
      return set.add(t);
    }
  }

  public boolean remove(T t) {
    synchronized (set) {
      if (!set.remove(t)) {
        return trash.remove(t);
      }
      trash.add(t);
    }
    return true;
  }

  public boolean contains(T t) {
    synchronized (set) {
      return set.contains(t);
    }
  }

}
