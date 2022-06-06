import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Set;
import java.util.HashSet;
import java.lang.Runnable;
import java.lang.InterruptedException;
import java.lang.Thread;

public class ExecuteInParallel {
  /*
    Implementare il metodo statico executeInParallel, che accetta come argomenti
    un array di oggetti di tipo Runnable e un numero naturale k, ed esegue tutti
    i Runnable dell'array, k alla volta. In altre parole, all'inizio il metodo
    fa partire in parallelo i primi k Runnable dell'array.
    Poi, non appena uno dei Runnable in esecuzione termina, il metodo ne fa
    partire un altro, preso dall'array, fino ad esaurire tutto l'array.
    Risolvere l'esercizio senza utilizzare attesa attiva
  */

  // SOLUZIONE DI V. TRAMO
  public static void executeInParallel(Runnable[] runnables, int capacity)
                                                  throws InterruptedException {
        if (capacity > runnables.length)
            capacity = runnables.length;
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(capacity);

        // Runnable di un consumatore
        Runnable consumes = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    queue.take().run();
                } catch (InterruptedException e) {
                    return;
                }
            }
        };
        // Creazione, memorizzazione e avvio dei consumatori
        Set<Thread> consumers = new HashSet<>(capacity);
        do {
            Thread consumer = new Thread(consumes);
            consumers.add(consumer);
            consumer.start();
        } while (consumers.size() < capacity);

        // Inizio produzione runnables
        for (Runnable runnable: runnables)
            queue.put(runnable);

        // Interrompi tutti i consumatori
        for (Thread consumer: consumers)
            consumer.interrupt();
    }

  // SOLUZIONE DEL PROF
  public static void executeInParallel(Runnable[] ra, int k)
                                                  throws InterruptedException {
    final BlockingQueue<Thread> q = new ArrayBlockingQueue<Thread>(k);

    for (final Runnable r: ra) {
      Thread t = new Thread() { // classe anonima che estende Thread
        @Override
        public void run() {
          r.run();          // cattura r: copia nascosta
          q.remove(this);   // cattura q: copia nascosta
                            // this è l'oggetto di classe anonima
                            // remove è thread-safe perchè q è una coda bloccante
        }
      };
      q.put(t); // attesa (passiva) di poter inserire, se coda piena
      t.start();
    }
    // manca l'attesa che la coda si svuoti
  }
}
