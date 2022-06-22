class Traccia {/*
  Realizzare la classe RotatingList, che rappresenta una lista in grado di
  ruotare, con le seguenti funzionalità:
    * Un costruttore senza argomenti che crea una lista vuota.
    * Il metodo add per inserire un elemento in coda.
    * I metodi rotateLeft e rotateRight che ruotano la lista di una posizione.
    * Un overriding di equals che consideri uguali due liste se contengono gli
      stessi elementi, anche in ordine diverso e in molteplicità diversa
      (ad  esempio, la lista [1, 2, 1] va considerata uguale a [2, 1, 2, 2]).
  Nota: le collezioni standard sovrascrivono toString in modo da stampare il
  proprio contenuto.                                                          */
  public static void main(String[] args) {
    // Esempio d'uso:
    RotatingList<Integer> l = new RotatingList<>();
    l.add(1); l.add(2); l.add(3);
    System.out.println(l);
    l.rotateLeft();
    System.out.println(l);
    l.add(4);
    System.out.println(l);
    l.rotateRight();
    System.out.println(l);

    // test aggiunto da me
    RotatingList<Integer> l2 = new RotatingList<>();
    l2.add(1); l2.add(2); l2.add(3); l2.add(4); l2.add(4);
    System.out.println(l.equals(l2)); // true;
  }
  /* Output:
        [1, 2, 3]
        [2, 3, 1]
        [2, 3, 1, 4]
        [4, 2, 3, 1]
  */
}
