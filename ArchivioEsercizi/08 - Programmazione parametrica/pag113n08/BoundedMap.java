
import java.util.Map;
import java.util.HashMap;

public class BoundedMap<K,V> {
  private static class Pair<V> {
    private V value;
    private int search;

    private Pair(V value) {
      this.value = value;
      search = 0;
    }
  }
  private Map<K,Pair<V>> map;
  private int max_size;

  public BoundedMap(int max_size) {
    if (max_size <= 0)
      throw new IllegalArgumentException("Dimensione non corretta.");
    map = new HashMap<K,Pair<V>>();
    this.max_size = max_size;
  }

  // inserisce un elemento nella mappa, se questa è piena lo sostituisce con
  // l'elemento cercato meno volte
  public V put(K key, V value) {
    if (map.size() == max_size && !map.containsKey(key)) {
      removeLessSearched();
    }
    map.put(key, new Pair<V>(value));
    return value;
  }

  // ritorna il valore associato alla chiave e aggiorna il numero di volte che
  // questa chiava è stata cercata.
  public V get(K key) {
    Pair<V> p = map.get(key);
    if (p != null) {
      p.search++;
      return p.value;
    }
    return null;
  }

  // rimuove una delle chiavi cercata meno volte
  private void removeLessSearched() {
    Pair<V> min = new Pair<>(null);
    min.search = Integer.MAX_VALUE;
    K key = null;
    for(K i: map.keySet()) {
      Pair<V> temp = map.get(i);
      if (temp.search < min.search)
        min = temp;
        key = i;
      if (min.search == 0)
        break;
    }
    map.remove(key);
  }

}
