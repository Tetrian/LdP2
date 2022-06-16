
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Clinica {
  private Map<String, Integer> map;

  public Clinica() {
    map = new HashMap<String, Integer>();
  }

  public void prenota(Specialista spe, String str) {
    if (map.containsKey(str)) return;
    map.put(str, spe.ordinal());
  }

  public void cancellaPrenotazione(Specialista spe, String str) {
    map.remove(str, spe.ordinal());
  }

  public Set<String> getPrenotati(Specialista spe) {
    Set<String> c = new HashSet<>();
    for (String k: map.keySet()) {
      if (map.get(k) == spe.ordinal())
        c.add(k);
    }
    return c;
  }
}
