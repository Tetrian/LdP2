
class Traccia {/*
  Implementare la classe MutexWithLog che rappresenta un mutex, con i classici
  metodi lock e unlock, che in aggiunta scrive un messaggio a video ogni volta
  che un thread riesce ad acquisirlo e ogni volta che un thread lo rilascia. Il
  metodo unlock deve lanciare un’eccezione se viene chiamato da un thread
  diverso da quello che ha acquisito il mutex.                                */

  public static void main(String[] args) {
    // Esempio d'uso:
    final MutexWithLog m = new MutexWithLog();
    Thread t = new Thread("Secondo") {
      public void run() {
        m.lock();
        try { sleep(3000); } catch (Exception e) {}
        System.out.println("Due!");
        m.unlock();
      }
    };
    t.start();
    m.lock();
    System.out.println("Uno!");
    m.unlock();
  }
}
