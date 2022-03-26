class Traccia {
  /*
  La classe Triangle rappresenta un triangolo. Il suo costruttore accetta la
  misura dei suoi lati, e lancia un’eccezione se tali misure non danno luogo ad
  un triangolo.

  Il metodo equals stabilisce se due triangoli sono isometrici (uguali).

  Il metodo similar stabilisce se due triangoli sono simili
  (hanno gli stessi angoli, ovvero lo stesso rapporto tra i lati).

  Il metodo perimeterComparator restituisce un comparatore che confronta i
  triangoli in base al loro perimetro.

  Nota: tre numeri positivi x, y e z possono essere le misure dei lati di un
  triangolo a patto che x < y + z, y < x + z e z < x + y.
  */

  // L’implementazione deve rispettare il seguente esempio d’uso
  public static void main(String[] args) {
    Triangle a = new Triangle(3,4,5);
    Triangle b = new Triangle(4,5,3);
    Triangle c = new Triangle(8,6,10);
    System.out.println(a.equals(b));
    System.out.println(a.similar(b));
    System.out.println(a.similar(c));

    Comparator<Triangle> pc = Triangle.
    perimeterComparator();
    System.out.println(pc.compare(b, c));
  }
  /* Output:
      true
      true
      true
      -1
  */
}
