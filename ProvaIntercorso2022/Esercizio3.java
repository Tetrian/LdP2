// Date le seguenti classi:
public class A {
  private A other;
  public A(A other) {
    this.other = other;
  }
  public class B {
    private static int counter = 0;
    private int id = counter++;
  }
  public Object makeObj(int val) {
    return new B() {
      private int j = val;
    };
  }
}
/* Disegnare il memory layout che risulta al termine dell'esecuzione del
seguente frammento di codice, evidenziando gli eventuali riferimenti impliciti,
le variabili catturate e i loro valori:                                       */
  A a1 = new A(null);
  A a2 = new A(a1);
  A.B b = a1.new B();
  Object x = a1.makeObj(42);
  A.B y = (A.B) a2.makeObj(42);
