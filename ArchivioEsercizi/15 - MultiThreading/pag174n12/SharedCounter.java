/*
  Realizzare la classe SharedCounter, che rappresenta un contatore thread-safe,
  che parte dal valore zero. Il suo metodo incr incrementa il contatore, mentre
  decr lo decrementa. Il contatore non può assumere un valore negativo, quindi
  invocare decr quando il valore è zero non ha alcun effetto.
  Il metodo waitForValue accetta un valore intero n e mette il chiamante in
  attesa finché il contatore non assuma il valore n (se il contatore vale già n,
  il metodo restituisce subito il controllo al chiamante).
*/

// Soluzione proposta da V.TRAMO
// Nota: i commenti aggiunti in questa classe sono scritti da me in base a ciò
// che il prof ha detto durante la correzione dell'esecizio
public class SharedCounter {
    private final Object counterMonitor = new Object();
    private volatile int counter;
    private final Map<Integer, Set<Thread>> threads = new HashMap<>();
    // non c'è bisogno di questa mappa se tutte le wait aspettano sulla stessa
    // condiction variable e incr e decr fanno sempre notifyAll (tutti in attesa
    // su counter monitor)
    public void incr() {
        synchronized (counterMonitor) {
            counter++;
            notifyWhoIsWaitingForThisCounter();
        }
    }

    public void decr() {
        synchronized (counterMonitor) {
            if (counter == 0) return;
            counter--;
            notifyWhoIsWaitingForThisCounter();
        }
    }

    private void notifyWhoIsWaitingForThisCounter() {
        synchronized (threads) {
            Set<Thread> waitingThreads = threads.get(counter);
            if (waitingThreads == null)
                return;
            for (Thread thread: waitingThreads) {
                synchronized (thread) {
                    thread.notify();
                }
            }

            threads.remove(counter);
        }
    }

    public void waitForValue(final Integer exceptedValue) throws InterruptedException {
        if (counter == exceptedValue) return;
        Thread currentThread = Thread.currentThread();
        addThreadWaiting(exceptedValue, currentThread);
        synchronized (currentThread) {
            while (counter != exceptedValue) { // questo accesso non è mutuamente
                                               // esclusivo con i vari incr e decr
                currentThread.wait();
            }
        }
    }

    private void addThreadWaiting(final Integer exceptedValue, final Thread thread) {
        synchronized (threads) {
            Set<Thread> waitingThreads = threads.get(exceptedValue);
            if (waitingThreads == null) {
                waitingThreads = new HashSet<>();
            }
            waitingThreads.add(thread);
            threads.put(exceptedValue, waitingThreads);
        }
    }
}

// CORREZIONE DEL PROF DELLA SOLUZIONE DI V.TRAMO
public class SharedCounter {
    private final Object counterMonitor = new Object();
    int counter;

    public void incr() {
        synchronized (counterMonitor) {
            counter++;
            notifyAll();
        }
    }

    public void decr() {
        synchronized (counterMonitor) {
            if (counter == 0) return;
            counter--;
            notifyAll();
        }
    }

    public void waitForValue(final Integer exceptedValue) throws InterruptedException {
        synchronized (counterMonitor) {
          if (counter == exceptedValue) return;
          while (counter != exceptedValue) {
            counterMonitor.wait();
          }
        }
    }
}
