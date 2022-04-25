/* L'esercizio non richiede l'implementazione di questa classe poiché questa
dovrebbe essere stata scritta in un esercizio precedente del compito (pag090n57).
Riporto una versione riadattata per la compilazione di questo esercizio.      */

public class Polynomial {
  private double[] coef;

  public Polynomial() {};

  public Polynomial(double[] coefficienti) {
    coef = coefficienti;
  }

  @Override
  public String toString() {
    String polinomio = "";
    if (coef[0] != 0) polinomio = coef[0] + " + ";
    for (int i = 1; i < coef.length; ++i) {
      if (coef[i] != 0.0)
        polinomio += coef[i] + " x^" + i + " + ";
    }
    return polinomio.substring(0, polinomio.length() - 3);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof Polynomial)) return false;

    // se o è un monomio controllo che this sia tutti 0.0 eccetto per il grado
    // pari a quello del monomio che dovrà avere stesso coefficiente
    if(o instanceof Monomial) {
      Monomial mon = (Monomial) o;
      for (int i = 0; i < mon.getGrado(); ++i)
        if (coef[i] != 0) return false;
      for (int i = mon.getGrado() + 1; i < coef.length; ++i)
        if (coef[i] != 0) return false;
      return coef[mon.getGrado()] == mon.getCoefficiente();
    }

    // se sono due polinomi controllo che abbiano stessi coefficienti per gradi
    // uguali (se manca il grado allora il coefficiente deve essere pari a 0)
    Polynomial pol = (Polynomial) o;
    if (coef.length < pol.coef.length) {
      for (int i = coef.length; i < pol.coef.length; ++i)
        if (pol.coef[i] != 0.0)
          return false;
    }
    if (coef.length > pol.coef.length) {
      for (int i = pol.coef.length; i < coef.length; ++i)
        if (coef[i] != 0.0)
          return false;
    }
    for (int i = 0; i < coef.length; ++i)
      if (coef[i] != pol.coef[i])
        return false;
    return true;
  }
}
