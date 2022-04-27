class Traccia {/*
  Implementare la classe BoundedMap, che rappresenta una mappa con capacità
  limitata. Il costruttore accetta la dimensione massima della mappa.
  I metodi get e put sono analoghi a quelli dell’interfaccia Map. Se però la
  mappa è piena e viene invocato il metodo put con una chiave nuova, verrà
  rimossa dalla mappa la chiave che fino a quel momento è stata ricercata meno
  volte con get.                                                              */
  public static void main(String[] argv) {
    // L’implementazione deve rispettare il seguente caso d’uso:
    BoundedMap<String,String> m = new BoundedMap<String,String>(2);
    m.put("NA", "Napoli");
    m.put("SA", "Salerno");
    System.out.println(m.get("NA"));
    m.put("AV", "Avellino");
    System.out.println(m.get("SA"));
  }
  /* Output:
        Napoli
        null
  */
}
