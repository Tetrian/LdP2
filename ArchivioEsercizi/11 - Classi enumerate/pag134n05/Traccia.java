
import java.util.Collection;

class Traccia {/*
  Realizzare la classe enumerata Coin, che rappresenta le 8 monete dell’euro.
  Il metodo statico convert accetta un numero intero n e restituisce una
  collezione di Coin che vale n centesimi.

  Nota: per ottenere lo stesso output del caso d’uso, non è necessario
  ridefinire alcun metodo toString.
*/
  public static void main(String[] args) {
    // Esempio d'uso:
    Collection<Coin> a = Coin.convert(34),
                     b = Coin.convert(296);
    System.out.println(a);
    System.out.println(b);
  }
  /* Output:
        [TWENTY, TEN, TWO, TWO]
        [TWOEUROS, FIFTY, TWENTY, TWENTY, FIVE, ONE]
  */
}
