
import java.nio.BufferOverflowException;

public class Apparecchio {
  private final int watt;
  protected boolean acceso;
  protected Impianto i_rif;

  /**
   * Crea un oggetto di tipo apparecchio con potenza assorbita (watt) quella
   * passata come parametro.
   * @param watt la potenza assorbita deve essere positiva
   */
   public Apparecchio(int watt) {
     if (watt < 0)
       throw new IllegalArgumentException("Valore potenza non valido");
     this.watt = watt;
     acceso = false;
   }

   /**
    * Se l'apparecchio è attualmente spento e l'Impianto ha ancora potenza
    * sufficiente ad alimentare questo apparecchio lo accende settanto la
    * variabile acceso a true.
    * @see Impianto
    */
   public void on() {
     if (!acceso) {
      if (i_rif.potenza() + watt > i_rif.getMaxWatt())
        throw new BufferOverflowException();
      acceso = true;
     }
   }

   /**
    * Se l'apparecchio è attualmente acceso lo spegne impostando l'attributo
    * acceso a false-
    * @see Impianto
    */
   public void off() {
       acceso = false;
   }

   /**
    * Ritorna un intero positivo che rappresenta la potenza di questo Apparecchio
    * @return this.watt
    */
   protected int getWatt() {
     return watt;
   }
}
