class Traccia {/*
  Definire una classe Primes che rappresenta l’insieme dei numeri primi.
  Il campo statico iterable fornisce un oggetto su cui si può iterare, ottenendo
  l’elenco di tutti i numeri primi. Non deve essere possibile per un’altra
  classe creare oggetti di tipo Primes.
  Suggerimento: Primes potrebbe implementare sia Iterator<Integer> che
  Iterable<Integer>. In tal caso, il campo iterable potrebbe puntare ad un
  oggetto di tipo Primes.
*/
  public static void main(String[] argv) {
    // Esempio d'uso
    for (Integer i : Primes.iterable) {
      if (i > 20) break;
        System.out.println(i);
    }
  }
  /* Output:
        1
        3
        5
        7
        11
        13
        17
        19
*/}
