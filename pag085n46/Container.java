
import java.nio.BufferOverflowException;

public class Container {
  private static final double CAPACITY = 50;
  private double liters;
  private Container connected;

  public Container() {
    liters = 0;
    connected = null;
  }

  public void addWater(double lit) {
    if (liters + lit > CAPACITY)
      throw new BufferOverflowException();
    liters += lit;
  }

  public double getAmount() {
    balanceWater();
    return liters;
  }

  public void connect(Container con) {
    if (connected != null)
      throw new RuntimeException("This container is already connedted");
    connected = con;
  }

  private void balanceWater() {
    int n_con = 0;
    double tot_liters = 0;
    Container tmp = this;
    while (tmp != null) {
      n_con++;
      tot_liters += tmp.liters;
      tmp = tmp.connected;
    }
    double new_liters = tot_liters / n_con;
    tmp = this;
    for (int i = 0; i < n_con; ++i) {
      tmp.liters = new_liters;
      tmp = tmp.connected;
    }
  }
}
