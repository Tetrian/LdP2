
import java.util.Set;
import java.util.HashSet;

public class BinRel<T> {
  public static class Pair<T> {
    private T left;
    private T right;

    private Pair(T x, T y) {
      left = x;
      right = y;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null) return false;
      if (o.getClass() != getClass()) return false;
      Pair pair = (Pair) o;
      return pair.left.equals(left) && pair.right.equals(right);
    }

    @Override
    public int hashCode() {
      return left.hashCode() ^ right.hashCode();
    }
  }
  private Set<Pair<T>> rel = new HashSet<>();

  public void addPair(T x, T y) {
    rel.add(new Pair<T>(x,y));
  }

  public boolean areRelated(T x, T y) {
    return rel.contains(new Pair<T>(x,y));
  }

  public boolean isSymmetric() {
    for (Pair<T> pair: rel) {
      if (!areRelated(pair.right, pair.left))
        return false;
    }
    return true;
  }
}
