class Traccia {/*
  Un polinomio è una espressione algebrica del tipo a_0 + a_1*x + ... + a_n*x^n.
  Si implementi una classe Polynomial, dotata di un costruttore che accetta un
  array contenente i coefficienti a_0, ..., a_n. Deve essere possibile iterare
  sulle coppie (esponente, coefficiente) in cui il coefficiente è diverso da
  zero. Cioè, Polynomial deve implementare Iterable<Pair<Integer, Double>> (vedi
  Pair.java). Infine, il metodo toString deve produrre una stringa simile a
  quella mostrata nel seguente caso d’uso.                                    */
  public static void main(String[] argv) {
    // Esempio d'uso:
    double a1[] = {1, 2, 0, 3};
    double a2[] = {0, 2};
    Polynomial p1 = new Polynomial(a1);
    Polynomial p2 = new Polynomial(a2);
    System.out.println(p1);
    System.out.println(p2);
    for (Pair<Integer, Double> p: p1)
      System.out.println(p.getFirst () + " : " + p.getSecond());
  }
  /* Output dell'esempio d'uso:
      1.0 + 2.0 x^1 + 3.0 x^3
      2.0 x^1
      0 : 1.0
      1 : 2.0
      3 : 3.0
  */
}
