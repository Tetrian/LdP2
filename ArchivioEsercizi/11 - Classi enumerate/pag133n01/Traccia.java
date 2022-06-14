class Traccia {/*
  Realizzare l’enumerazione LengthUnit, che rappresenta le principali unità di
  misura di lunghezza, dei sistemi metrico e imperiale: centimetri (CM), metri
  (M), kilometri (KM), pollici (INCH), iarde (YARD), e miglia (MILE). Il metodo
  convertTo accetta un’altra unità di misura u e un numero in virgola mobile x,
  e converte x da questa unità di misura a u.

  I fattori di conversione per le misure imperiali sono i seguenti:
  1 pollice = 0.025 metri, 1 iarda = 0.914 metri, 1 miglio = 1609 metri.
*/
  public static void main(String[] argv) {
    // L’implementazione deve rispettare il seguente esempio d’uso.
    System.out.println(LengthUnit.CM.convertTo(LengthUnit.INCH, 10));
    System.out.println(LengthUnit.KM.convertTo(LengthUnit.YARD, 3.5));
    System.out.println(LengthUnit.MILE.convertTo(LengthUnit.M, 6.2));
  }
  /* Output:
      3.9370078740157486
      3829.3216630196935
      9975.800000000001
  */
}
