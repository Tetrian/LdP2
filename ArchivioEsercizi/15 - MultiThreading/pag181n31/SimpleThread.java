// Indicare tutti gli output possibili di un programma che faccia partire
// contemporaneamente due istanze della seguente classe SimpleThread.
public class SimpleThread extends Thread {
  private static volatile int n = 0;

  public void run() {
    n++;
    int m = n;
    System.out.println(m);
  }
}

/* SOLUZIONE

  Output 1    Output 2
      1           2       se viene eseguito prima il Thread 1 e poi il 2
      2           1       se il thread 1 ferma l'esecuzione prima della stampa
                          e poi viene eseguito il Thread 2 per intero, ed infine
                          la s.o.p del Thread 1
      1          1        volatile non rente atomica l'istruzione di incremento
      2          2        Il Thread 1 esegue l'incremento, poi il thread 2
                          esegue il suo incremento e poi finiscono le istruzioni
*/
