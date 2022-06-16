class Traccia {
  // Determinare l’output del seguente frammento di codice Java:
  public static void main(String[] args) {
    Short s = 10;
    Integer a = 10;
    Double b = 11.0;
    Number aa = a; // tipo effettivo Integer
    Number bb = b; // tipo effettivo double
    System.out.println(((Object) s) == ((Object) a));
    System.out.println(aa == a);
    System.out.println(a.getClass().equals(aa.getClass()));
    System.out.println(aa.getClass().equals(bb.getClass()));
    Object o = s; // tipo effettivo Shor
    System.out.println(o.getClass().equals(Short.class));
  }
  /* Output:
      false
      true
      true
      false
      true
  */
}
