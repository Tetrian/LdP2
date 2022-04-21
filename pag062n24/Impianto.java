
import java.util.HashSet;
import java.util.Iterator;

public class Impianto extends HashSet<Apparecchio> {
  private final int max_watt;
  private int potenza;

  /**
   * Crea un ogetto di tipo impianto con potenza massima (max_watt) pari a
   * quella passata come parametro.
   * @param max_watt la potenza massima erogata deve essere positiva
   */
  public Impianto(int max_watt) {
    super(); // ridondante
    if (max_watt < 0)
      throw new IllegalArgumentException("Valore potenza non valido");
    this.max_watt = max_watt;
    potenza = 0;
  }

  /**
   * Aggiunge l'oggetto di tipo Apparecchio passato come argomento nell'HashSet
   * dell'attuale oggetto Impianto. Inoltre, modifica in modo opportuno gli
   * attributi dell'oggetto Apparecchio.
   * @param nuovo Oggetto di tipo Apparecchio
   * @see Apparecchio
   */
  public void collega(Apparecchio nuovo) {
    nuovo.i_rif = this;   // aggiorno il riferimento di Impianto in Apparecchio
    nuovo.acceso = false; // così da non dover gestire il collegamento di un
                          // apparecchio accesso;
    super.add(nuovo);
  }

  /**
   * Ritorna il valore della potenza totale assorbita dagli oggetti di tipo
   * Apparecchio collegati all'attuale Impianto.
   * @return this.potenza
   * @see Apparecchio
   */
  public int potenza() {
    return potenza;
  }

  /**
   * Ritorna un intero positivo che rappresenta la potenza massima erogata.
   * @return this.max_watt
   */
  int getMaxWatt() {
    return max_watt;
  }

  /**
   * Somma l'intero in ingresso alla variabile potenza che rappresenta
   * la potenza assorbita dall'impianto
   * @param watt intero
   */
  void aggiornaPotenza(int watt) {
    potenza += watt;
  }
}
