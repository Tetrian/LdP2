class Traccia {/*
  Implementare la classe GameLevel, che rappresenta un livello in un gioco 2D,
  in cui un personaggio si muove su una griglia di caselle. Il costruttore
  accetta le dimensioni del livello (larghezza e altezza). Il metodo setWall
  accetta le coordinate di una casella e mette un muro in quella casella.
  Il metodo areConnected accetta le coordinate di due caselle e restituisce vero
  se e solo se esiste un percorso tra di loro.                                */

  public static void main(String[] args) {
    // Caso d'uso:
    GameLevel map = new GameLevel(3, 3);
    System.out.println(map.areConnected(0,0,2,2));
    map.setWall(0,1);
    map.setWall(1,1);
    System.out.println(map.areConnected(0,0,2,2));
    map.setWall(2,1);
    System.out.println(map.areConnected(0,0,2,2));
  }
  /* Output:
        true
        true
        false
  */
}
