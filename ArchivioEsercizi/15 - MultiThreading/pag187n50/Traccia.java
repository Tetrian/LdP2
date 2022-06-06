class Traccia {/*
  Si implementi la classe VoteBox, che rappresenta un'urna elettorale, tramite
  la quale diversi thread possono votare tra due alternative, rappresentate dai
  due valori booleani.
  Il costruttore accetta il numero totale n di thread aventi diritto al voto.
  La votazione termina quando n thread diversi hanno votato.
  In caso di pareggio, vince il valore false.

  Metodi:
    * Il metodo vote, con parametro boolean e nessun valore di ritorno, permette
      ad un thread di votare, e solleva un'eccezione se lo stesso thread tenta
      di votare più di una volta.
    * Il metodo waitForResult, senza argomenti e con valore di ritorno booleano,
      restituisce il risultato della votazione, mettendo il thread corrente in
      attesa se la votazione non è ancora terminata.
    * Infine, il metodo isDone restituisce true se la votazione è terminata, e
      false altrimenti.

  E' necessario evitare attesa attiva e race condition.                       */

  public static void main(String[] argv) {
    // Esempio d'uso:
    VoteBox b = new VoteBox(10);
    b.vote(true);
    System.out.println(b.isDone());
    b.vote(false);
  }
  /* Output:
        false
        Exception in thread "main"...
  */
}
