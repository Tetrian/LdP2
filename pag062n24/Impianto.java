
public class Impianto {
  private final int max_watt;
  private int potenza; // assorbita attualmente dall'impianto

  /**
   * Crea un ogetto di tipo impianto con potenza massima (max_watt) pari a
   * quella passata come parametro.
   * @param max_watt la potenza massima erogata deve essere positiva
   */
  public Impianto(int max_watt) {
    if (max_watt < 0)
      throw new IllegalArgumentException("Valore potenza non valido");
    this.max_watt = max_watt;
    potenza = 0;
  }

  /**
   * Modifica in modo opportuno gli attributi dell'oggetto Apparecchio in modo
   * da collegarlo a questo impianto.
   * @param nuovo Oggetto di tipo Apparecchio
   * @see Apparecchio
   */
  public void collega(Apparecchio nuovo) {
    nuovo.i_rif = this;   // aggiorno il riferimento di Impianto in Apparecchio
    nuovo.acceso = false; // così da non dover gestire il collegamento di un
  }                       // apparecchio accesso;


  /**
   * Ritorna il valore della potenza totale assorbita dagli oggetti di tipo
   * Apparecchio (accesi) collegati all'attuale Impianto.
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
