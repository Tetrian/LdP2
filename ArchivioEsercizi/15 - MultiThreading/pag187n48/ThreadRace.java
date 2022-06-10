import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadRace {
  /*
    Implementare il metodo statico threadRace, che accetta due oggetti Runnable
    come argomenti, li esegue contemporaneamente e restituisce 1 oppure 2, a
    seconda di quale dei due Runnable è terminato prima.
    Si noti che threadRace è un metodo bloccante.
    Sarà valutato negativamente l’uso di attesa attiva.
  */
  public static int threadRace(Runnable r1, Runnable r2)
                                        throws InterruptedException
  {
    final BlockingQueue<Thread> q = new ArrayBlockingQueue<Thread>(2);
    AtomicInteger winner = new AtomicInteger();
    Thread t1 = new Thread() {
      @Override
      public void run() {
        r1.run();
        synchronized (winner) {
          winner.set(1);
          q.remove(this);
        }
      }
    };
    Thread t2 = new Thread() {
      @Override
      public void run() {
        r2.run();
        synchronized (winner) {
          winner.set(2);
          q.remove(this);
        }
      }
    };
    q.put(t1); q.put(t2);
    t1.start(); t2.start();
    while(q.size() != 1) {}
    return winner.get();
  }
}
