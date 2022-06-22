/* TRACCIA
  Il seguente thread accede ad un array di interi, precedentemente istanziato. */
  class MyThread extends Thread {
    public void run() {
      /*_____1_____*/
      for (int i=0; i<array.length; i++) {
        /*_____2_____*/
        array[ i]++;
        /*_____3_____*/
      }
      /*_____4_____*/
    }
  }
/*
  Un programma avvia due thread di tipo MyThread, con l’obiettivo di
  incrementare ogni elemento dell’array di 2. Dire quali dei seguenti
  inserimenti rendono il programma corretto ed esente da race condition
  (è possibile indicare più risposte):
    (a) 1 = “synchronized (this){” 4 = “}”
    (b) 1 = “synchronized {” 4 = “}”
    (c) 1 = “synchronized (array){” 4 = “}”
    (d) 2 = “synchronized (this){” 3 = “}”
    (e) 2 = “synchronized (array){” 3 = “}”
    (f) 2 = “array.wait();” 3 = “array.notify();”
*/

/* SOLUZIONE
  (a) non offre mutua esclusività
  (b) errore in compilazione
  (c) funziona
  (d) stesso problema di a, sincronizziamo su monitor diversi
  (e) funzione ed offre più concorrenza rispetto a c
  (f) errore alla linea 2 poiché sto facendo una wait senza il monitor
*/
