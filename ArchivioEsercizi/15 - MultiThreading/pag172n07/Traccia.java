class Traccia {/*
  Implementare la classe RandomExecutor che esegue degli oggetti Runnable
  sequenzialmente e in ordine casuale. Precisamente, la classe offre un
  costruttore senza argomenti e i seguenti metodi:
    * Il metodo void addTask(Runnable r) aggiunge un task. Questo metodo può
      essere chiamato solo prima di launch.
    * Il metodo void launch() avvia l’esecuzione dei task. Questo metodo non è
      bloccante.
    * Il metodo bloccante void join(Runnable r) attende la terminazione del
      corrispondente task. Questo metodo può essere chiamato prima o dopo launch
*/
  public static void main(String[] args) throws InterruptedException {
    // Esempio d'uso:
    RandomExecutor e = new RandomExecutor();
    Runnable r1 = () -> { System.out.println(1); };
    Runnable r2 = () -> { System.out.println(2); };
    Runnable r3 = () -> { System.out.println(3); };
    e.addTask(r1);
    e.addTask(r2);
    e.addTask(r3);
    e.launch();
    e.join(r2);
  }
}
