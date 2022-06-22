public abstract  class KeysWithValue {
  /* TRACCIA
  Il metodo keysWithValue accetta una mappa, un valore e una lista, e inserisce
  nella lista tutte le chiavi della mappa che hanno quel valore associato.
  Valutare ciascuna delle seguenti intestazioni in base ai criteri di
  funzionalità, completezza, correttezza, fornitura di ulteriori garanzie e
  semplicità. In caso di non completezza, indicare un controesempio.
  Infine, scegliere l’intestazione migliore oppure proporne un’altra.
  a) <K,V> void keysWithValue(Map<K,V> m, V value, List<K> out)
  b) <K> void keysWithValue(Map<K,?> m, Object value, List<Object> out)
  c) <K,V> void keysWithValue(Map<? extends K,V> m, V value, List<K> out)
  d) <K,V> void keysWithValue(Map<? extends K,V> m, V value, List<? extends K> out)
  e) <V> void keysWithValue(Map<?,V> m, V value, List<?> out)
  f) <K> void keysWithValue(Map<K,?> m, Object value, LinkedList<? super K> out)
  */

  /* SOLUZIONE
  a) funzionale corretta ma non completa, infatti si potrebbe benissimo passare
     come parametro value un valore non associato alla mappa, in quel caso
     semplicementente non si aggiungono i valori alla lista. Più "grave" è il
     fatto di non poter fare ad esempio la seguente chiamata:
     keysWithValue(Map<Manager,V>, V , List<Employee> ). Dovrebbe essere valida

  b) funzionale, completa, ma non corretta. Devo controllare a runtime che le
     chiavi della mappa siano assegnabili alla lista.

  c) funzionale, corretta ma non completa. Non posso passare un value non
     correlato con i valori della mappa.

  d) Corretta ma non completa per il motivo sopracitato. Inoltre
     offre la garanzie che questa lista non venga modificata

  e) Non funzionale, potrei fare solo out.add(null)

  f) funzionale, completa e corretta. Usa un solo parametro di tipo ed offre
     anche la garanzia che la lsita non venga letta. Dunque, questa è la firma
     migliore tra le candidate

  SCELTA:                                                                      */
    <K> void keysWithValue(Map<? extends K,?> m, Object value, LinkedList<? super K> out);
    // così da offrire anche la garanzia che la mappa non venga modificata.

}
