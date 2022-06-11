
public class Engine {
  private double volume;
  private double power;

  public Engine(double volume, double power) {
    if(volume <= 0 || power <= 0)
      throw new IllegalArgumentException("Volume and Power must be positive");
    this.volume = volume;
    this.power = power;
  }

  public Engine byVolume() {
    return new Engine(volume, power) {
      @Override
      public boolean equals(Object o) {
        if (!(o instanceof Engine)) return false;
        Engine e = (Engine) o;
        return volume == e.volume;
      }
    };
  }

  public Engine byPower() {
    return new Engine(volume, power) {
      @Override
      public boolean equals(Object o) {
        if (!(o instanceof Engine)) return false;
        Engine e = (Engine) o;
        return power == e.power;
      }
    };
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Engine)) return false;
    Engine e = (Engine) o;
    return volume == e.volume && power == e.power;
  }

  @Override
  public String toString() {
    return "(" + volume + " cm^3, " + power + "CV)";
  }
}
