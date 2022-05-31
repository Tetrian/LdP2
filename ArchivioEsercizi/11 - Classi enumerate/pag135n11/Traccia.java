class Traccia {/*
  Implementare l’enumerazione Cardinal, che rappresenta le 16 direzioni della
  rosa dei venti, i, chiamate N (per Nord), NNE (per Nord Nord Est), NE, ENE, E,
  etc.. Il metodo isOpposite prende come argomento un punto cardinale x e
  restituisce vero se questo punto cardinale è diametralmente opposto ad x, e
  falso altrimenti. Il metodo statico mix prende come argomento due punti
  cardinali, non opposti, e restituisce il punto cardinale intermedio tra
  i due.  Se i due punti cardinali sono opposti, viene lanciata un'eccezione.
*/
  public static void main(String[] argv) {
    // Esempio d'uso:
    Cardinal nord = Cardinal.N;
    System.out.println(nord.isOpposite(Cardinal.S));
    Cardinal nordest = Cardinal.mix(Cardinal.N, Cardinal.E);
    assert nordest == Cardinal.NE : "Errore inaspettato!";
    Cardinal nordnordest = Cardinal.mix(nordest, Cardinal.N);
    System.out.println(nordnordest);
  }
  /* Output:
        true
        NNE
  */
}
