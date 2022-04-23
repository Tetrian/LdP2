class Traccia {/*
  Realizzare la classe parametrica Accumulator, che accetta come parametro di
  tipo una sottoclasse di Number e offre i seguenti servizi:
   * inserimento di un numero (metodo add);
   * scorrimento di tutti i numeri inseriti fino a quel momento, divisi tra
     negativi e non (metodi negatives e positives);
   * somma di tutti i numeri inseriti fino a quel momento (metodo sum).
  Suggerimento:
    Si ricordi che la classe Number prevede il metodo double doubleValue().
*/
  public static void main(String[] argv) {
    // L’implementazione deve rispettare il seguente esempio d’uso:
    Accumulator<Integer> acc1 = new Accumulator<>();
    acc1.add(10);
    acc1.add(42);
    acc1.add(-5);
    acc1.add(10);
    for (Integer n: acc1.positives()) System.out.println(n);
    for (Integer n: acc1.negatives()) System.out.println(n);
    Accumulator<Double> acc2 = new Accumulator<>();
    acc2.add(-10.0);
    acc2.add(42.0);
    System.out.println(acc2.sum());
    /* Invece, ciascuna delle seguenti due istruzioni deve provocare un errore
    di compilazione: */
    // acc1.positives().add(5);
    // Accumulator<String> acc3 = new Accumulator<>();
  }
/* Output:
      10
      42
      10
      -5
      32.0
*/
}
