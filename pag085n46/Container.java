
import java.util.Set;
import java.util.HashSet;

public class Container {
	private double amount;
	private Set<Container> group;

  public Container() {
		group = new HashSet<Container>();
		group.add(this);
  }

  public void addWater(double amount) {
		double distributed = amount / group.size();
		for (Container c: group)
			c.amount = distributed;
  }

  public double getAmount() {
    return amount;
  }

  public void connect(Container other) {
		if (group == other.group) return;

		int size1 = group.size(),
			size2 = other.group.size();
		double tot1 = amount * size1,
			   tot2 = other.amount * size2,
			   newAmount = (tot1 + tot2) / (size1 + size2);
		group.addAll(other.group);

		for (Container c: other.group)
			c.group = group;
		for (Container c: group)
			c.amount = newAmount;
  }
}
