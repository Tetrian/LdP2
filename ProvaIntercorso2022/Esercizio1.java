class Esercizio1 {/*
  La seguente interfaccia rappresenta un insieme in cui ad ogni oggetto è
  associato un peso intero:
  public interface WeightedSet<T> {
    void add(T obj, int weight);
    WeightedSet<T> atLeast(int threshold);
  }
  Il metodo add aggiunge un oggetto con un dato peso. Ad ogni oggetto può essere
  associato un unico peso, mentre oggetti diversi possono avere lo stesso peso.
  Il metodo atLeast accetta un peso threshold e restituisce una vista sull'
  insieme degli oggetti di peso maggiore o uguale di threshold. Questa vista
  supporta l'inserimento di nuovi oggetti con add, ma solo se il loro epso è
  almeno threshold, altrimenti add deve lanciare un'eccezione.
  Il metodo toString di un WeightedSet deve elencare gli oggetti contenuti,
  senza il loro peso. Implementare la classe BasicWeightedSet, che implementa
  WeightedSet rispettando il seguente esempio d'uso.                          */

  public static void main(String[] argv) {
    // Esempio d'uso:
    WeightedSet<Object> set = new BasicWeightedSet<>();
    set.add(Double.valueOf(3.14), 100);
    set.add(new Object(), 5);
    set.add("Skylar", 50);
    set.add("Jesse", 5);
    System.out.println(set);
    WeightedSet<Object> set10 = set.atLeast(10);
    System.out.println(set10);
    set.add("Walter", 60);
    System.out.println(set);
    System.out.println(set10);
  }
  /* Output:
        [Jesse, java.lang.Object@6b95977, Skylar, 3.14]
        [Skylar, 3.14]
        [Jesse, java.lang.Object@6b95977, Skylar, Walter, 3.14]
        [Skylar, Walter, 3.14]
  */
}
