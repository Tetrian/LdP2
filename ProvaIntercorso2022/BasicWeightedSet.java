
import java.util.Map;
import java.util.HashMap;

public class BasicWeightedSet<T> implements WeightedSet<T> {
    private Map<T,Integer> map;
    private int threshold;

    public BasicWeightedSet() {
        map = new HashMap<>();
        threshold = Integer.MIN_VALUE;
    }

    private BasicWeightedSet(BasicWeightedSet<T> other, int threshold) {
        this.map = other.map;
        this.threshold = threshold;
    }

    public void add(T obj, int weight) {
        if (weight < threshold)
            throw new IllegalArgumentException("Weight is too small.");
        map.put(obj, weight);
    }

    public String toString() {
        List<T> list = new ArrayList<>();
        for (T key: map.keySet()) {
            if (map.get(key) >= threshold)
                list.add(key);
        }
        return list.toString();
    }

    public WeightedSet<T> atLeast(int newThreshold) {
        return new BasicWeightedSet<T>(this, Integer.max(threshold, newThreshold));
    }
}
