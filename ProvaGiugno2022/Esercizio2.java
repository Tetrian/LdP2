// Data la seguente classe:
public class A {
  private final int id;
  public A(int id) { this.id = id; }
  public class B {
    private int id2 = id + 1;
  }
  public Runnable makeObj(String msg) {
    return () -> System.out.println(id + ":" + msg);
  }
  // Disegnare il memory layout che risulta al termine dell'esecuzione del
  // seguente frammento di codice, evidenzianod gli eventuali riferimenti
  // impliciti, le variabili catturate e i loro valori:
  public static void main(String[] args) {
    A a5 = new A(5);
    A a10 = new A(10);
    A.B b = a10.new B();
    A.B c = a10.new B();
    Runnable x = a5.makeObj("Hello");
    Object y = a5.makeObj("Bye");
  }
}
