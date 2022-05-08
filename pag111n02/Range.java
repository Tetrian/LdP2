
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

  public boolean isInside(Object obj) {
    if (obj == null) return false;
    if (min.getClass() != obj.getClass()) return false;
    T t = (T) obj;
    if (t.compareTo(min) < 0) return false;
    if (t.compareTo(max) > 0) return false;
    return true;
  }

  public boolean isOverlapping(Range<?> ran) {
    if (min.getClass() != ran.min.getClass()) return false;
    if (min.compareTo((T) ran.min) > 0) return false;
    if (max.compareTo((T) ran.max) < 0) return false;
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
