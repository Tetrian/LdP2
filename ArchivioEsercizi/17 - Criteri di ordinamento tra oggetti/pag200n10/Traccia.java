class Traccia {/*
  Realizzare la classe Box, che rappresenta una scatola, caratterizzata dalle
  sue tre dimensioni: altezza, larghezza e profondità. Due scatole sono
  considerate uguali (da equals) se hanno le stesse dimensioni. Le scatole sono
  dotate di ordinamento naturale basato sul loro volume. Infine, il metodo
  fitsIn, invocato su una scatola x, accetta un’altra scatola y e restituisce
  true se e solo se y è sufficientemente grande da contenere x.               */

  public static void main(String[] argv) {
    // Esempio d'uso:
    Box grande = new Box(20, 30, 40),
        grande2 = new Box(30, 20, 40),
        piccolo = new Box(10, 10, 50);
    System.out.println(grande.equals(grande2));
    System.out.println(grande.compareTo(piccolo));
    System.out.println(piccolo.fitsIn(grande));
  }
  /* Output:
        false
        1
        false
  */
}
