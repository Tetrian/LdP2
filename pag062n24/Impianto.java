
import java.util.HashSet;
import java.util.Iterator;

public class Impianto extends HashSet<Apparecchio> {
  private final int max_watt;

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
   * Calcola il valore della potenza totale assorbita dagli oggetti di tipo
   * Apparecchio collegati all'attuale Impianto.
   * @return intero positivo che rappresenta l'attuale potenza assorbita
   * @see Apparecchio
   */
  public int potenza() {
    if (super.isEmpty()) return 0;
    int watt = 0;
    for (Apparecchio a : this) {
      if (a.acceso == true)
        watt += a.getWatt();
    }
    return watt;
  }

  /**
   * Ritorna un intero positivo che rappresenta la potenza massima erogata.
   * @return this.max_watt
   */
  int getMaxWatt() {
    return max_watt;
  }
}
