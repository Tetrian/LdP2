class Traccia {/*
  Realizzare la classe SortedList, che rappresenta una lista di oggetti dotati
  di ordinamento naturale. Come una normale lista, una SortedList accetta
  duplicati. Inoltre, è iterabile e i suoi iteratori la percorrono in ordine non
  decrescente.
  Nessun metodo di questa classe può avere una complessità superiore a O(n),
  dove n è la lunghezza della lista.                                          */

  public static void main(String[] args) {
    // L’implementazione deve rispettare il seguente esempio d’uso:
    SortedList<Integer> list = new SortedList<>();
    list.add(100); list.add(50); list.add(25); list.add(50);
    for (Integer n: list)
      System.out.println(n);
  }
  /* Output:
        25
        50
        50
        100
  */
}
