
// Elencare tutte le sequenze di output possibili per il seguente programma.
public class MysteryThread8 {
  private volatile int n;

  public int incrementAndGet() {
    return ++n;
  }

  public static void main(String[] args) {
    MysteryThread8 a = new MysteryThread8(), b = new MysteryThread8();
    Thread t1 = new Thread(() -> System.out.println(a.incrementAndGet())),
           t2 = new Thread(() -> System.out.println(b.incrementAndGet())),
           t3 = new Thread(() -> System.out.println(a.incrementAndGet()));
    t1.start(); t2.start(); t3.start();
  }
  /* Output:
    poichè t2 usa un oggetto differente da t1 e t3 ci sarà sempre la stampa di
    1. Mentre i thread t1 e t3, poiché volatile non dà garanzie di atomicità
    sull'incremento di n questi possono entrare in conflitto. Quindi i possibili
    output sono:
            1 1 1
            1 1 2
            1 2 1
            2 1 1
  */
}
