class Traccia {
  /*
  Nell’ambito di un programma di geometria, si implementi la classe Triangolo,
  il cui costruttore accetta le misure dei tre lati. Se tali misure non danno
  luogo ad un triangolo, il costruttore deve lanciare un’eccezione. Il metodo
  getArea restituisce l’area di questo triangolo. Si implementino anche la
  classe Triangolo.Rettangolo, il cui costruttore accetta le misure dei due
  cateti, e la classe Triangolo.Isoscele, il cui costruttore accetta le misure
  della base e di uno degli altri lati.

  Si ricordi che:
      Tre numeri a, b e c possono essere i lati di un triangolo a patto che
      a < b + c, b < a + c e c < a + b.

      L’area di un triangolo di lati a, b e c è data da:
        sqrt(p * (p - a) * (p - b) * (p - c)) (formula di Erone)
      dove p è il semiperimetro.
  */

  // L’implementazione deve rispettare il seguente esempio d’uso
  public static void main(String[] args) {
    Triangolo x = new Triangolo(10,20,25);
    Triangolo y = new Triangolo.Rettangolo(5,8);
    Triangolo z = new Triangolo.Isoscele(6,5);
    System.out.println(x.getArea());
    System.out.println(y.getArea());
    System.out.println(z.getArea());
  }
  /* Output:
      94.9918
      19.9999
      12.0
  */
}
