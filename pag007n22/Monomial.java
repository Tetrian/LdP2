
public class Monomial extends Polynomial {
  private double coefficiente;
  private int grado;

  public Monomial(int grado, double coefficiente) {
    this.coefficiente = coefficiente;
    this.grado = grado;
  }

  int getGrado() { return grado; }
  double getCoefficiente() { return coefficiente; }

  @Override
  public String toString() {
    if (grado == 0) return "" + coefficiente;
    return coefficiente + " x^" + grado;
  }

  @Override
  public boolean equals(Object o) {
    if (o != null && o instanceof Monomial) {
      Monomial mon = (Monomial) o;
      return coefficiente == mon.coefficiente && grado == mon.grado;
    }
    double[] polinomio = new double[grado + 1];
    polinomio[grado] = coefficiente;
    return (new Polynomial(polinomio)).equals(o);
  }
}
