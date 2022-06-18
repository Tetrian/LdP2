/*
Le istanze della seguente classe MyThread condividono due array di interi
(int[]), a e b, precedentemente istanziati e inizializzati.
*/
class MyThread extends Thread {
  public void run() {
    /*_____1_____*/
    for (int i=0; i<a.length; i++) {
      /*_____2_____*/
      if (a[i] > b[i]) {
        int temp = b[i];
        b[i] = a[i];
        a[i] = temp;
      }
      /*_____3_____*/
    }
    /*_____4_____*/
  }
}
/*
Un programma avvia due thread di tipo MyThread, con l’obiettivo che, dopo
l’esecuzione, ciascun elemento di a sia minore o uguale del corrispondente
elemento di b. Dire quali dei seguenti inserimenti rendono il programma corretto
ed esente da race condition (è possibile indicare più risposte):
  (a) non è necessario aggiungere nulla
  (b) 1 = “synchronized (this){” 4 = “}”
  (c) 1 = “synchronized (MyThread.class){” 4 = “}”
  (d) 1 = “synchronized {” 4 = “}”
  (e) 1 = “synchronized (a){” 4 = “}”
  (f) 1 = “synchronized (b){” 4 = “}”
  (g) 2 = “synchronized (this){” 3 = “}”
  (h) 2 = “synchronized (a[i]){” 3 = “}”
  (i) 2 = “synchronized (b){” 3 = “}”
  (j) 2 = “a.wait();” 3 = “a.notifyAll();”
*/

/* SOLUZIONE
(a) assolutamente no, totale anarchia
(b) non serve a nulla poiché i due thread sono diversi, e quindi non da nessuna
    garanzia
(c) funziona, il programma non è più concorrente e abbiamo risolto tutti i
    problemi di sincronizzazione che avevamo
(d) errore di compilazione
(e) funziona, è equivalente a (c)
(f) come (c)
(g) stessi problema di (b)
(h) da evitare poiché l'identità del monito può cambiare
(i) funziona perché rende mutuamente esclusivi tutti gli swap; inoltre, è la
    scelta migliore poiché lascia più concorrenza rispetto le altre
(j) il primo thread che arriva ad a.wait solleva l'eccezione poiché non ha il
    mutex
*/
