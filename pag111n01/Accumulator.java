
import java.util.Collection;
import java.util.ArrayList;

public class Accumulator<T extends Number> {
  private Collection<T> numbers = new ArrayList<>();
  private Collection<T> neg = new ArrayList<>();
  private Collection<T> pos = new ArrayList<>();

  public void add(T num) {
    numbers.add(num);
    if (num.doubleValue() < 0.0) neg.add(num);
    else pos.add(num);
  }

  public Collection<? extends T> negatives() {
    return neg;
  }

  public Collection<? extends T> positives() {
    return pos;
  }

  public double sum() {
    double sum = 0;
    for (T n: numbers) {
      sum += n.doubleValue();
    }
    return sum;
  }
}
