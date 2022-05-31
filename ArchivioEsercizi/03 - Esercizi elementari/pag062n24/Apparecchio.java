
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
    * variabile acceso a true e aggiorna la potenza assorbita dall'impianto.
    * @see Impianto
    */
   public void on() {
     if (!acceso && i_rif != null) {
      if (i_rif.potenza() + watt > i_rif.getMaxWatt())
        throw new BufferOverflowException();
      acceso = true;
      i_rif.aggiornaPotenza(watt);
     }
   }

   /**
    * Se l'apparecchio è attualmente acceso e collegato ad un impianto lo
    * spegne impostando l'attributo acceso a false e aggiorna la potenza
    * assorbita dall'impianto
    * @see Impianto
    */
   public void off() {
       if (acceso && i_rif != null) {
         acceso = false;
         i_rif.aggiornaPotenza(-watt);
       }
   }
}
