class Traccia {/*
  Realizzare la classe BinRel, che rappresenta una relazione binaria tra un
  insieme e se stesso.
  Il metodo addPair aggiunge una coppia di oggetti alla relazione.
  Il metodo areRelated verifica se una data coppia di oggetti appartiene alla
  relazione.
  Il metodo isSymmetric verifica se la relazione è simmetrica.
*/
  public static void main(String[] argv) {
    // L’implementazione deve rispettare il seguente caso d’uso:
    BinRel<String> rel = new BinRel<>();
    rel.addPair("a", "albero");
    rel.addPair("a", "amaca");
    System.out.println(rel.isSymmetric());
    rel.addPair("albero", "a");
    rel.addPair("amaca", "a");
    System.out.println(rel.isSymmetric());
    System.out.println(rel.areRelated("a", "amaca"));
  }
  /* Output:
      false
      true
      true
  */
}
