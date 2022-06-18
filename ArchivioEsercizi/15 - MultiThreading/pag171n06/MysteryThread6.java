
public class MysteryThread6 {/*
  (a) Escludendo i cosiddetti spurious wakeup, elencare tutte le sequenze di
      output possibili per il seguente programma.                             */
  public static void main(String[] args) throws InterruptedException {
    final Object x = new Object(), y = new Object();
    Thread t1 = new Thread(() -> {
      synchronized (x) {
        try {
          x.wait();
          synchronized (y) {
            y.notify();
          }
        }
        catch(Exception e) { return; }
        finally { System.out.println("t1"); }
      }
    });
    Thread t2 = new Thread(() -> {
      synchronized (y) {
        try { y.wait(); }
        catch (Exception e) { return; }
        finally { System.out.println("t2"); }
      }
    });
    t1.start(); // rimane perennemente in attesa poiché nessun'altro thread
                // fa x.notify(All)
    t2.start();
    // synchronized (y) {
    //   y.notify();
    // }
    // System.out.println("main");
    synchronized (y) {
        y.notify();
        System.out.println("main");
      }
  }
  /* Output possibili:
        t2 main       se viene eseguito prima t2 e poi il main
        main          se viene eseguito prima il main, quando t2 fa y.wait
                      non riacquisisce più il monitor di y e quindi rimane in
                      attesa perenne come t1
  *//*
  (b) Come cambiano le sequenze di output se le ultime righe del main vengono
      modificate come segue?
    synchronized (y) {
        y.notify();
        System.out.println("main");
      }
    }
    In questo caso l'output t2 main non è più possibile, quindi o stampa
    main e poi t2 oppure solo main se t2 viene eseguito dopo il main
  */

}
