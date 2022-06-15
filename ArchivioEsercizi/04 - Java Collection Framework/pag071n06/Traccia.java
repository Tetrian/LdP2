public class Traccia {/*
  Realizzare la classe SafeSet, che rappresenta un insieme che richiede due
  passaggi per rimuovere completamente un oggetto. Il metodo add aggiunge un
  elemento all’insieme, restituendo true se l’inserimento ha avuto successo.
  Il metodo remove rimuove un elemento dall’insieme, ma la rimozione è
  definitiva solo dopo una seconda chiamata. Il metodo contains verifica se
  l’insieme contiene un dato elemento (in base a equals). Infine, un SafeSet
  deve essere thread-safe.

  Nel pdf c'è un diagramma che rappresentail ciclo di vita di un oggetto all'
  interno di un SafeSet di cui non riporto la rappresentazione.
*/
  public static void main(String[] args) {
    // Esempio d'uso:
    SafeSet<String> a = new SafeSet<>();
    System.out.println(a.add("ciao"));
    System.out.println(a.add("mondo"));
    System.out.println(a.remove("ciao"));
    System.out.println(a.contains("ciao"));
    System.out.println(a.remove("ciao"));
    System.out.println(a.contains("ciao"));
  }
  /* Output:
        true
        true
        true
        false
        true
        false
  */
}
