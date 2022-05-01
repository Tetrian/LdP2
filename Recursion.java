
public class Recursion {
  public void test() {
    test();
    System.out.println("Recursion!!!");
}
  // Stampare solo una volta la stringa senza modificare la classe Recursion

  public static void main(String[] argv) {
    // una soluzione è fare una sottoclasse ed un override di test() in modo
    // che salti il passo ricorsivo:
    new Recursion() {
      boolean first_time = true;

      @Override
      public void test() {
        if(first_time) {
          first_time = false;
          super.test();
        }
      }
    }.test();

    // Soluzione molto più elegante:
    new Recursion() {
      { super.test(); } // blocco di inizializzazione delle istanze (è una sorta
                        // di costruttore per le classi anonime)
      public void test() { }
    };
  }
}
