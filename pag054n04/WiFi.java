
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;

public class WiFi implements Iterable<WiFi.Network> {
  public static class Network {
    private String name;
    private double signal;

    private Network(String name, double signal) {
      this.name = name; this.signal = signal;
    }

    public void updateStrength(double newSignal) {
      signal = newSignal;
    }

    @Override
    public String toString() {
      return name + " (" + signal + " dBm)";
    }

    public static final Comparator<Network> comparatorByIntensity = new Comparator<>() {
      public int compare(Network a, Network b) {
        Double x = a.signal;
        Double y = b.signal;
        return -(x.compareTo(y));
      }
    };
  }
  private List<Network> networks;

  public WiFi() {
    networks = new ArrayList<Network>();
  }

  public Network addNetwork(String name, double signal) {
    if (signal >= 0)
      throw new IllegalArgumentException("the signal must be negative");
    Network network = new Network(name, signal);
    networks.add(network);
    return network;
  }

  public Network strongest() {
    networks.sort(Network.comparatorByIntensity);
    return networks.get(0);
  }

  public Iterator<Network> iterator() {
    networks.sort(Network.comparatorByIntensity);
    return networks.iterator();
  }
}
