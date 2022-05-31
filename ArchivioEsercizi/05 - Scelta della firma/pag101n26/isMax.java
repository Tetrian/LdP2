public class isMax {
/*
Il metodo isMax accetta un oggetto x, un comparatore ed un insieme di oggetti,
e restituisce true se, in base al comparatore, x è maggiore o uguale di tutti
gli oggetti contenuti nell'insieme. Altrimenti, il metodo restituisce false.
Valutare ciascuna delle seguenti intestazioni per il metodo isMax, in base ai
criteri di funzionalità, completezza, correttezza, fornitura di ulteriori
garanzie e semplicità. Infine, scegliere l'intestazione migliore oppure proporne
un'altra, motivando brevemente la propria scelta.
*/
/*
  Dato che per un Comparator<T> c, per poter utilizzare il metodo senza fare
  cast c.compare(T x, T y) si richiede che il tipo di x e di y sia assegnabile
  a T, ne consegue che sia l'oggetto x che l'insieme siano sottotipi del
  parametro del comparatore.
*/
/*(a)*/ boolean isMax(Object x, Comparator<Object> c, Set<Object> s)          /*
        Funzonale, completa ma non corretta. Posso accettare qualsiasi
        comparatore, invece mi aspetto che dopo un controllo tra x ed s, possa
        usare il comparatore c senza dover fare ulteriori controlli.
     */
/*(b)*/ <T> boolean isMax(T x, Comparator<T> c, Set<T> s)                     /*
        Funzionale, corretta ma non completa. Rifiuta insiemi non correlati con
        l'oggetto x o persino relazioni di sottotipo tra x ed s
     */
/*(c)*/ <T> boolean isMax(T x, Comparator<? super T> c, Set<T> s)             /*
        Funzionale, corretta ma non completa. Ma accetta più della b
     */
/*(d)*/ <T> boolean isMax(T x, Comparator<? extends T> c, Set<? super T> s)   /*
        Non funzionale, se il tipo effettivo del comparatore è sottotipo dell'
        oggetto x, quest'ultimo potrebbe non avere i campi usati da c
     */
/*(e)*/ <T> boolean isMax(T x, Comparator<? super T> c, Set<? super T> s)     /*
        Funzionale, corretta ma non completa. Non accetta insiemi non correlati
        con l'oggetto x. Ma resta la scelta migliore rispetto le precedenti.
     */
/*(f)*/ <S,T extends S> boolean isMax(T x, Comparator<? super S> c, Set<S> s) /*
        Funzionale, corretta e completa. Di conseguenza questa è la firma
        migliore ma è possibile renderla più semplice.
     */
// la mia scelta:
  <T> boolean isMax(T x, Comparator<? super T> c, Set<?> s)
}
