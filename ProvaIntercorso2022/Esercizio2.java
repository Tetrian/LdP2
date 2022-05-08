// Considerare l'interfaccia Predicare<T>:
interface Predicate<T> {
  boolean test(T t);
}
/* Dire quali delle seguenti sono specifiche valide per un comparatore c tra
oggetti di tipo Predicate<T>. In caso nefativo, dire quali proprietà sono
violate e descrivere un controesempio. */ c.compare(x,y) /* restituisce (nei
casi non elenecati, restituisce zero):
 (a) -1 se x.test(...) restituisce sempre falso e y.test(...) restituisce sempre
     vero; 1 se y.test(...) restituisce sempre falso e x.test(...) restituisce
     sempre vero.
 (b) -1 se per tutti gli oggetti t il valore di x.test(t) è l'opposto di
     y.test(t); 1 se per tutti gli oggetti t il valore di x.test(t) è uguale a
     y.test(t).
 (c) -1 se l'insieme degli oggetti t per cui x.test(t) restituisce vero è un
     sottoinsieme proprio dell'insieme degli oggetti epr cui y.test(t)
     restituisce vero; 1 se esiste un oggetto t tale che x.test(t) restituisce
     vero e y.test(t) restituisce falso.
 (d) -1 se ci sono almeno 10 ogetti diversi su cui x.test(t) restituisce vero
     e y.test(t) restituisce falso; 1 se ci sono almeno 10 oggetti diversi su
     cui x.test(t) restituisce falso e y.test(t) restituisce vero.
*/

/* SOLUZIONI:
(a)
(b)
(c)
(d)
*/
