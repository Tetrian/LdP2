
import java.util.Iterator;

/* TRACCIA
  Individuare l’output del seguente programma. Dire se la classe FunnyIterator
  rispetta il contratto dell’interfaccia Iterator. In caso negativo,
  giustificare la risposta.
*/
public class FunnyIterator implements Iterator {
  private String msg = "";

  public Object next() { // rispetta il contratto di next
    if (msg.equals("")) msg = "ah";
    else msg += msg;
    return msg;
  }

  public boolean hasNext() { return msg.length() < 5; } // rispetta il contratto
                                                        // di hasNext
  public void remove() { } // non rispetta il contratto di remove, esso dovrebbe
                           // o rimuovere dalla collezione l'ultimo oggetto
                           // restituito da next altrimenti lanciare
                           // UnsupportedOperationException
  public void addChar() { msg += "b"; }

  public static void main(String[] args) {
    Iterator i = new FunnyIterator();

    do {
      System.out.println(i.next());
    } while (i.hasNext());
  }
  /* Output:
      ah
      ahah
      ahahahah
  */
}
