
public enum LengthUnit {
  CM(0.01),    M(1),        KM(1000),
  INCH(0.025), YARD(0.914), MILE(1609);

  private final double metersFactor;
  private LengthUnit(double m) { metersFactor = m; }

  public double convertTo(LengthUnit u, double x) {
    return (this.metersFactor * x) / u.metersFactor;
  }
}
