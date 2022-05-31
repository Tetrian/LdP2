/* Dire quali specifiche sono valide e perché.
 a) implementazione non valida poiché non gode di proprietà simmetrica, infatti
    presi x e y, con x.val = 1 e y.val = 0 risulta che x.equals(y) è vero ma
    y.equals(x) è falso.
 b) implementazione valida poiché gode di prorpietà riflessiva, simmetrica
    e transitiva
 c) valida essendo entrambe le condizioni relazioni di equivalenza, è evidente
    che la condizione composta dalla disgiunzione delle due continua a godere
    delle tre proprietà (per una o per l'altra).
 d) valida poichè gode di riflessività, simmetria e transitività              */

// implementare la specifica d
public boolean equals(Object o) {
  if (o == null) return false;
  if (!(o istanceof Z)) return false;
  Z z = (Z) o;
  return (this.other == null && z.other == null) ||
         (this.other != null && z.other != null && (this.other).val == (z.other).val)

}
