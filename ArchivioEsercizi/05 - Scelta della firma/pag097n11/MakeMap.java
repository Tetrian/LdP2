
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MakeMap {
  /* TRACCIA
    Il metodo statico makeMap accetta una lista di chiavi e una lista di valori
    (di pari lunghezza), e restituisce una mappa ottenuta accoppiando ciascun
    elemento della prima lista al corrispondente elemento della seconda lista.
    Valutare ciascuna delle seguenti intestazioni in base ai criteri di
    funzionalità, completezza, correttezza, fornitura di ulteriori garanzie,
    semplicità e specificità del tipo di ritorno. Infine, scegliere
    l’intestazione migliore oppure proporne un’altra.

    a) <K,V> Map<? extends K,? extends V> makeMap(List<K> keys, List<V> vals)
      funzionale e completa, ma non offre alcuna faranzia sulle liste

    b) <K,V> Map<? extends K,?> makeMap(List<K> keys, List<?> vals)
      funzionale e completa ma ha un parametro di tipo inutilizzato e il tipo di
      ritorno è poco specifico.

    c) <K,V> Map<K,V> makeMap(List<K> keys, List<?> vals)
      completa ma non funzionale, il tipo di ritorno è specifico ma potendo
      accedere  agli oggetti di vals solo come Object dovremmo ricorre a cast
      espliciti per fare le put in map.

    d) <T> Map<T,T> makeMap(List<? extends T> keys, List<? extends T> vals)
      funzionale ma non completa, offre garanzie di sola lettura nelle liste
      ma non rende possibile chiamate valide come List<Integer> keys e
      List<String> vals

    e) <K> Map<K,?> makeMap(List<K> keys, List<Object> vals)
      funzionale e completa, è più semplice delle precedenti avendo un unico
      tipo parametrico ma il tipo di ritorno è poco specifico

    f) <K, V extends K> Map<K,V> makeMap(List<K> keys, List<V> vals)
      funzionale ma non completa, anche se accetta più della d ha gli stessi
      problemi
  */
  /*
    Non è possibile definire un parametro che accetti liste di stessa lunghezza
    quindi nessuna delle firme potrà essere corretta.
    Poiché bisogna accedere alle liste, senza modificarne la collezione il tipo
    più adatto è List<? extends T>, inoltre per avere un tipo di ritorno più
    utile e specifico possibile bisogna avere 2 tipi parametrici.
    La mia soluzione è la seguente (tanto per fornisco una implementazione del
    metodo):
  */
  public static <K,V> Map<K,V> makeMap(List<? extends K> keys,
                                            List<? extends V> vals)
  {
    if (keys.size() != vals.size())
      throw new IllegalArgumentException();
    Map<K,V> map = new HashMap<>();
    int i = 0;
    for(K key: keys)
      map.put(key, vals.get(i++));
    return map;
  }

}
