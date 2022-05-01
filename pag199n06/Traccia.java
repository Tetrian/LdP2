class Traccia {/*
  Implementare la classe Book, che rappresenta un libro diviso in capitoli. Il
  metodo addChapter aggiunge un capitolo in coda al libro, caratterizzato da
  titolo e contenuto. I capitoli sono automaticamente numerati a partire da 1.
  Il metodo getChapterTitle(i) restituisce il titolo del capitolo i-esimo, mentre
  il metodo getChapterContent(i) ne restituisce il contenuto. Gli oggetti Book
  devono essere clonabili. Inoltre, la classe deve essere dotata di ordinamento
  naturale, basato sul numero di capitoli.                                    */

  public static void main(String[] argv) {
    // L’implementazione deve rispettare il seguente esempio d’uso:
    Book b = new Book();
    b.addChapter("Prefazione", "Sono passati pochi anni...");
    b.addChapter("Introduzione", "Un calcolatore digitale...");
    b.addChapter("Sistemi di elaborazione", "Un calcolatore...");
    Book bb = b.clone();
    System.out.println(bb.getChapterContent(1));
    System.out.println(bb.getChapterTitle(2));
  }
  /* Output:
        Sono passati pochi anni...
        Introduzione
  */
}
