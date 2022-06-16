
import java.util.Comparator;

public class Combine {
  /* TRACCIA
  Implementare il metodo combine, che accetta due comparatori e li combina
  lessicograficamente, ovvero restituisce un comparatore che, dati due oggetti,
  restituisce il valore del primo comparatore, se diverso da zero; altrimenti,
  restituisce il valore del secondo comparatore. Inoltre, valutare ciascuna
  delle seguenti intestazioni in base ai criteri di funzionalità, completezza,
  correttezza, fornitura di ulteriori garanzie, semplicità e specificità del
  tipo di ritorno.  Infine, scegliere l’intestazione migliore oppure proporne
  un’altra.

  a) <T> Comparator<T> combine(Comparator<T> a, Comparator<T> b)
    funzionale, corretta ma non completa poiché non accetta valori validi come
    Comparator<Employee> e Comparator<Manager>.

  b) <T> Comparator<T> combine(Comparator<T> a, Comparator<?> b)
    Funzionale, completa ma non corretta. Infatti ci costringe a controllare
    a runtime che b sia un comparatore compatibile con gli oggetti di tipo T

  c) <S, T extends S, U extends S> Comparator<S> combine(Comparator<T> a,
                                                         Comparator<U> b)
    funzionale, completa e corretta. Usa 3 parametri di tipo e quindi risulta
    complessa alla lettura.

  d) <T> Comparator<T> combine(Comparator<? super T> a, Comparator<? super T> b)
    funzionale, completa e corretta. Più semplice della 3.

  e) <T> Comparator<T> combine(Comparator<Object> a, Comparator<Object> b)
    Non funzionale, Comparator<T> darà errore a runtime poiché non è assegnabile
    a Comparator<Object> eccetto se non si richiama il metodo con <Object>combine.

  f) <T> Comparator<? extends T> combine(Comparator<? super T> a,
                                         Comparator<? super T> b)
    come la d, ma è più specifica nel tipo di ritorno, infatti concede all'utente
    la possibilità di assegnare il risultato ad un Comparator<U> con U sottotipo
    di T
  */
  // Reputo la firma f la migliore, di seguito la mia implementazione:
  public static <T> Comparator<? extends T> combine(Comparator<? super T> a,
                                                    Comparator<? super T> b)
  {
    return (x, y) -> {
      return (a.compare(x,y) != 0) ? a.compare(x,y) : b.compare(x,y);
    };
  }
}
