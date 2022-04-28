
import java.util.Iterator;

class Traccia {/*
  Con riferimento all’Esercizio 1 (pag064n30), definire una classe
  AncestorIterator che itera su tutti gli antenati conosciuti di una persona,
  in ordine arbitrario. Ad esempio, si consideri il seguente caso d’uso,
  che fa riferimento alle persone a,b,c,d ed e dell’Esercizio 1               */
  public static void main(String[] argv) {
    Person a = new Man("Mario", "Rossi");
    Person b = new Woman("Luisa", "Verdi");
    Person c = new Man("Luca", "Rossi");
    Person d = new Woman("Anna", "Rossi");
    Person e = new Woman("Daniela", "Rossi");
    a.marries(b);
    a.addChild(c);
    b.addChild(d);
    c.addChild(e);

    // ESEMPIO D'USO:
    // Iterator i = new AncestorIterator(e);
    Iterator i = e.new AncestorIterator();
    while (i.hasNext()) {
      System.out.println(i .next());
    }
  }/* OUTPUT:
        Luca Rossi
        Mario Rossi
        Luisa Verdi
    */
/*
  Dei 25 punti, 10 sono riservati a coloro che implementaranno AncestorIterator
  come classe interna di Person. In tal caso, il primo rigo dell’esempio
  d’uso diventa: Iterator i = e.new AncestorIterator();
  Suggerimento: si ricorda che se B è una classe interna di A, all’interno di B
  il riferimento implicito all’oggetto di tipo A si chiama A.this.
*/
}
