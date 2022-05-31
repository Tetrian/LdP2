
public class Triangolo {
  private double a, b, c;

  public Triangolo(double x, double y, double z) {
      if (x < y + z && y < x + z && z < x + y) {
          a = x; b = y; c = z;
      }
      else throw new IllegalArgumentException("Incorrect measurements");
  }

  public final double getArea() {
    double halfp = (a + b + c) / 2;
    return Math.sqrt(halfp * (halfp - a) * (halfp - b) * (halfp - c));
  }

  static class Rettangolo extends Triangolo {
    public Rettangolo(double c1, double c2) {
      super(c1, c2, Math.sqrt((c1*c1) + (c2*c2)));
    }
  }

  static class Isoscele extends Triangolo {
    public Isoscele(double base, double side) {
      super(base, side, side);
    }
  }
}
