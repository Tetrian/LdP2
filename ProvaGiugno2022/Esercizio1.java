
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class Esercizio1 {/*
  Implementare il metodo allValues, che accetta una mappa e una lista di chiavi
  e restituisce la lista dei valori corrispondenti a quelle chaivi.
  Esprimere una valutazione per ciascuna delle seguenti intestazioni in base
  ai criteri di funzionalità, completezza, correttezza, fornitura di ulteriori
  garanzie, semplicità e specificità del tipo di ritorno. Infine, scegliere
  l'intestazione migliore oppure proporne un'altra.

    a) <K,V> Collection<V> allValues(Map<K,V> map, List<K> keys)
       funzionale, corretta ma non completa. Non accetta valori validi come
       Map<Employee, V> e List<Manager>, i quali potrebbero essere equivalenti
       secondo equals (criterio di equivalenza uniforme) ed inoltre il tipo di
       ritorno non rispetta la postcondizione (ritorna una Collection invece di
       una List)

    b) <K> List<?> allValues(Map<K,?> map, List<K> keys)
       come la precedente ma più semplice e con un tipo di ritorno meno
       specifico e quindi peggiore (la specificità del tipo di ritorno vale più
       della semplicità della firma)

    c) <K> List<K> allValues(Map<K,K> map, List<K> keus)
       come la a ma ancora più restrittiva. Accetta solo mappe con valori dello
       stesso tipo delle chiavi.

    d) <K,V> List<V> allValues(Map<? super K,V> map, List<K> keys)
       funzionale completa e corretta. Possiamo accedere alle chiavi della
       mappa come fossero Object e ciò ci basta, però con ? super K diamo
       la falsa garanzia che questa mappa non venga letta

    e) <K,V> List<? extends V> allValues(Map<? extends K, V> map, List<kìK> keys)
       funzionale completa e corretta. Il tipo di ritorno dà l'informazione
       sbagliata di poter ritornare una lista di un sottotipo dei valori della
       mappa. Abbiamo la garanzia che la mappa non venga modificata

    f) <K,V> List<V> allValues(Map<?,V> map, List<? extends K> keys)
       funzionale completa e corretta. Accetta una mappa con chaivi di qualsiasi
       tipo, ma ciò significa semplicemente che si ritorna una lsita vuota
       se le chiavi della mappa non sono in relazione con gli elementi della
       lista. Questa firma è la miglioere delle precedenti.
  */
  // Poichè bisogna comunque usare due parametri di tipo, di seguito propongo
  // la mia intestazione con la corrispettiva implementazione:
  public static <K,V> List<V> allValues(Map<? extends K, ? extends V> map,
                                        List<? extends K> keys)
  {
    List<V> l = new LinkedList<>();
    for(K k: keys) {
      V v = map.get(k);
      if (v != null)
        l.add(v);
    }
    return l;
  }
}
