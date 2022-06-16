class Traccia {
  // Determinare l’output del seguente frammento di codice Java:
  public static void main(String[] args) {
    Short s = 10;
    Integer a = 10;
    Float f = new Float(10f);
    Number aa = a; // tipo effettivo Integer di valore 10
    Object o = f; // tipo effettivo Float di valore 10
    System.out.println((Object) s == (Object) a); // false, si riferiscono a
                                                  // due oggetti diversi
    System.out.println((s+1) == (a+1)); // true, per autoboxing e conversione
                                        // implicita è 11 == 11 entrambi int
    System.out.println(aa == a); // true, puntano allo stesso oggetto
    System.out.println(a.getClass().equals(aa.getClass())); // true, il tipo
                                                            // effettivo è
                                                            // Class<Integer>
                                                            // ad entrambi
    System.out.println(o.getClass().equals(f.getClass())); // true, come sopra
    System.out.println(o.getClass().equals(Object.class)); // false, il tipo
                                                           // effettivo di
                                                           // o è Float
  }
  /* Output:
        false
        true
        true
        true
        true
        false
  */
}
