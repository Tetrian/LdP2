
public class MysteryThread6 {
  // Escludendo i cosiddetti spurious wakeup, elencare tutte le sequenze di
  // output possibili per il seguente programma.
  public static void main(String[] args) throws InterruptedException {
    final Object x = new Object();
    final int [] count = new int[1];
    class MyThread extends Thread {
      int id;
      MyThread(int n) { id = n; }
      public void run() {
        synchronized (x) {
          count[0]++;
          synchronized (count) {
            count.notify();
          }
          try {
            x.wait();
          } catch (Exception e) { }
        }
        System.out.println(id);
      }
    }
    Thread t1 = new MyThread(1), t2 = new MyThread(2), t3 = new MyThread(3);
    t1.start(); t2.start(); t3.start();
    synchronized (count) {
      while (count[0] < 3) {
        count.wait();
        System.out.println("Incremento");
      }
    }
    System.out.println("Fatto");
    synchronized (x) {
      x.notifyAll();
    }
  }
}
/* Output:
  In base a quanti Thread partono prima del main (sia x tale valore) ci sarà
  la stampa di "Incremento" 3-x volte seguito dalla stampa di "Fatto" e infine i
  valori 1,2,3 nell'ordine in cui i thread vengono risvegliati.
*/
