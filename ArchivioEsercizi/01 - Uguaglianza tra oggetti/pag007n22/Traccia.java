class Traccia {/*
  Un monomio è una espressione algebrica del tipo a_n * x^n, cioè è un
  particolare tipo di polinomio composto da un solo termine.
  Implementare una classe Monomial come sottoclasse di Polynomial.
  La classe Monomial deve offrire un costruttore che accetta il grado n e il
  coefficiente a_n che identificano il monomio.
  Ridefinire il metodo equals in modo che si possano confrontare liberamente
  polinomi e monomi, con l’ovvio significato matematico di eguaglianza.       */
  public static void main(String[] argv) {
    // Esempio d'uso:
    double a1[] = {1, 2, 3};
    double a2[] = {0, 0, 0, 5};
    Polynomial p1 = new Polynomial(a1);
    Polynomial p2 = new Polynomial(a2);
    Polynomial p3 = new Monomial(3, 5);
    System.out.println(p2);
    System.out.println(p3);
    System.out.println(p3.equals(p1));
    System.out.println(p3.equals(p2));
    System.out.println(p2.equals(p3));
    System.out.println(p2.equals((Object) p3));
  }
  /* Output:
        5.0 x^3
        5.0 x^3
        false
        true
        true
        true
  */
}
