
import java.lang.Comparable;

public class Range<T extends Comparable<T>> {
  T min;
  T max;

  public Range(T x, T y) {
    if (x.compareTo(y) < 0) {
      min = x;
      max = y;
    }
    else {
      min = y;
      max = x;
    }
  }

  public boolean isInside(T obj) {
    if (min.getClass() != obj.getClass()) return false;
    if (obj.compareTo(min) < 0) return false;
    if (obj.compareTo(max) > 0) return false;
    return true;
  }

  // questa firma non è completa poiché non accetta come parametri gli
  // intervalli di tipo diverso da quello di questa classe.
  public boolean isOverlapping(Range<T> ran) {
    if (min.compareTo(ran.min) > 0) return false;
    if (max.compareTo(ran.max) < 0) return false;
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof Range)) return false;
    Range ran = (Range) o;
    return min.equals(ran.min) && max.equals(ran.max);
  }

  @Override
  public int hashCode() {
    return min.hashCode() ^ max.hashCode();
  }
}
