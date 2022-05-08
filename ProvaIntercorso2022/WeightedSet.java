public interface WeightedSet<T> {
  void add(T obj, int weight);
  WeightedSet<T> atLeast(int threshold);
}
