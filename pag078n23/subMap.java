public class subMap {
/*
Implementare il metodo subMap che accetta una mappa e una collezione e
restituisce una nuova mappa ottenuta restringendo la prima alle sole chiavi che
compaiono nella collezione. Il metodo non modifica i suoi argomenti.
Valutare le seguenti intestazioni per il metodo subMap, in base ai criteri di
funzionalità, completezza, correttezza, fornitura di ulteriori garanzie,
semplicità e specificità del tipo di ritorno. Infine, scegliere l'intestazione
migliore oppure proporne un'altra.
*/
/*
  prerequisiti: accetta come argomento una mappa ed una collezione, non è
  necessario una relazione tra il tipo della collezione e quello della chiave
  nella mappa (ne la collezione ne la mappa verranno modificate).
  postrequisito: restituisce una nuova mappa di coppie chiave/valori con le
  chiavi contenute nella collezione.
  Il metodo richiede un iterazione della mappa ma non della collezione, quindi
  possiamo dare un valore qualsiasi a quest'ultimo (poichè il metodo contains
  di Collection accetta come argomento Object).
*/
/*(a)*/ <K> Map<K,?> subMap(Map<K,?> m, Collection<K> c)                      /*
        Funzionale, corretta ma non completa. Non accetta collezioni di tipo
        diverso a quello delle mappe. Inoltre, il tipo di ritorno è poco
        specifico, non da informazioni sui valori.
     */
/*(b)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<?> c)                    /*
        Funzionale, corretta e completa. Offre ottime garanzie sulla collezione
        ma nessuna sulla mappa. Il tipo di ritorno è il più specifico possibile
     */
/*(c)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<? super K> c)            /*
        Funzionale (si potrebbe pensare che non si possa leggere la collezione
        ma in realtà posso accedere agli elementi di c come Object, e ciò mi
        baste per usare il metodo contains), corretta ma non completa (accetta
        comunque elementi in più rispetto alla a).
     */
/*(d)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<? extends K> c)          /*
        Funzionale, corretta ma non completa.
     */
/*(e)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Set<K> c)                           /*
        Funzionale, corretta ma non completa. Usare un Set è troppo specifico,
        inoltre anche il tipo di parametro di Set non rende possibile passargli
        parametri leciti per i prerequisiti.
     */
/*(f)*/ <K,V,K2 extends K> Map<K,V> subMap(Map<K,V> m, Collection<K2> c)      /*
        Questa è praticamente una versione più complessa della d.
     */

// Ne consegue che la firma più adatta sia la b, ma a questa si possono
// esprimere ulteriori garanzie sulla mappa nel seguente modo (si riporta anche
// una possibile implementazione del metodo):
  public static <K,V> Map<K,V> subMap(Map<? extends K, ? extends V> m,
                                      Collection<? extends K> c)
  {
    Map<K,V> newMap = new HashMap<>();
    for (K key: m.keySet()) {
      if (c.contains(key))
        newMap.put(key, get(key));
    }
    return newMap;
  }
}
