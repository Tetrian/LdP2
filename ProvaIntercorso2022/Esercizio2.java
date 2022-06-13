// Considerare l'interfaccia Predicare<T>:
interface Predicate<T> {
  boolean test(T t);
}
/* Dire quali delle seguenti sono specifiche valide per un comparatore c tra
oggetti di tipo Predicate<T>. In caso negativo, dire quali proprietà sono
violate e descrivere un controesempio. */ c.compare(x,y) /* restituisce (nei
casi non elenecati, restituisce zero):
 (a) -1 se x.test(...) restituisce sempre falso e y.test(...) restituisce sempre
     vero; 1 se y.test(...) restituisce sempre falso e x.test(...) restituisce
     sempre vero.
 (b) -1 se per tutti gli oggetti t il valore di x.test(t) è l'opposto di
     y.test(t); 1 se per tutti gli oggetti t il valore di x.test(t) è uguale a
     y.test(t).
 (c) -1 se l'insieme degli oggetti t per cui x.test(t) restituisce vero è un
     sottoinsieme proprio dell'insieme degli oggetti per cui y.test(t)
     restituisce vero; 1 se esiste un oggetto t tale che x.test(t) restituisce
     vero e y.test(t) restituisce falso.
 (d) -1 se ci sono almeno 10 ogetti diversi su cui x.test(t) restituisce vero
     e y.test(t) restituisce falso; 1 se ci sono almeno 10 oggetti diversi su
     cui x.test(t) restituisce falso e y.test(t) restituisce vero.
*/

/* SOLUZIONI: nessuna è una specifica valida
(a) non rispetta la proprietà 3 dell'ordinamento (coerenza rispetto l'
    uguaglianza); infatti, se compare(x,y) == 0 e quindi sia x.test(...) che
    y.test(...) danno sempre falso potrebbe succedere che compare(x,z) < 0 ma
    compare(y,z) == 0
(b) non rispetta la proprietà 1; infatti se mi da -1 per una coppia allora mi
    darà -1 anche scambiandoli di posto e quindi non è antisimmetrica.
(c) non rispetta la proprietà 1, infatti se compare(x,y) < 0, allora si avrà
    compare(x,y) == 0 poiché y.test(t) è sottoinsieme proprio di x.test(t) e
    entrambi restituiscono vero al test (e quindi non è tra i casi elencati)
(d) non rispetta la proprietà due, infatti se compare(x,y)<0 e compare(y,z)<0
    significa che i 10 oggetti del primo compare sono diversi dal secondo,
    quindi nulla vieta che compare(x,z) sia uguale a 0 (ovvero che non ci sono
    10 oggetti diversi per cui x.test(t) sia vero e z.test(t) sia falso).
*/
