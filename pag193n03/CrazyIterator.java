import java.util.Iterator;
/* Individuare l’output del seguente programma.
 * Dire se la classe CrazyIterator rispetta il contratto dell’interfaccia
 * Iterator. In caso negativo, giustificare la risposta.
 */
public class CrazyIterator implements Iterator {
	private int n = 0;
	public Object next() { // nessuna violazione
		int j;
		while (true) {
			for (j=2; j<=n/2 ;j++)
				if (n % j == 0) break;
			if (j > n/2) break;
			n++;
		}
		return new Integer(n);
	}
	public boolean hasNext() { // viola il contratto
		n++; // modifica l'iteratore, cosa che hasNext non ha diritto di fare
		return true;
	}
	public void remove() { // viola il contratto
		throw new RuntimeException(); // l'eccezione da lanciare nel caso in cui non
    // si vuole implementare remove deve essere UnsupportedOperationException
	}

	public static void main(String[] args) {
		Iterator i = new CrazyIterator();
		while (i.hasNext() && (Integer)i.next()<10) {
			System.out.println(i.next());
		}
	} // Output: 1 2 3 5 7
}
