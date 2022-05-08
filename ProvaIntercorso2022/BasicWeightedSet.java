
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class BasicWeightedSet<T> implements WeightedSet<T> {
  private Map<T, Integer> map;

  public BasicWeightedSet() {
    map = new HashMap<T, Integer>();
  }

  public void add(T obj, int weight) {
    map.put(obj, weight);
  }

  public WeightedSet<T> atLeast(int threshold) {
    BasicWeightedSet<T> bws = new BasicWeightedSet<>() {

      @Override
      public void add(T obj, int weight) {
        if (weight < threshold)
          throw new IllegalArgumentException();
        map.put(obj, weight);
      }

      @Override
      public String toString() {
        Set<T> tmp = new HashSet<>();
        for (T obj: map.keySet()) {
          int weight = map.get(obj);
          if (weight >= threshold)
            tmp.add(obj);
        }
        return tmp.toString();
      }
    };
    bws.map = map;
    return bws;
  }

  @Override
  public String toString() {
    return map.keySet().toString();
  }
}
