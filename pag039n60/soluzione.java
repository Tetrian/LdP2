
// prima chiamata
System.out.println(alfa.f(3, beta));
/*
 * alfa è di tipo dichiarato A, quindi le firme candidate vanno cercate nella
   classe A (o tutt'al più in Object)
 * i due parametri attuali della chiamata sono di tipo (dichiarato) int e B,
   rispettivamente
 * la firma f(double, A) è candidata, in quanto visibile e compatibile, essa è
   compatibile perché int è assegnabile a double (conversione implicita) e B è
   assegnabile ad A (sottotipo)
 * la firma f(double, B) è candidata, in quanto visibile e compatibile
 * la firma f(int, Object) è candidata, in quanto visibile e compatibile
 * non vi sono altre firme candidate
 * Delle tre firme candidate, la seconda è più specifica della prima, ma non è
   confrontabile con la terza
 * Quindi, nessuna firma è più specifica di tutte le altre
Il risultato è un errore di compilazione
ATTENZIONE: ricordate che la scelta della firma più specifica non dipende dal
            tipo dei parametri attuali della chiamata
*/

// seconda chiamata
System.out.println(alfa.f(3.0, beta));
/*
 * alfa è di tipo dichiarato A, quindi le firme candidate vanno cercate nella
   classe A (o tutt'al più in Object)
 * i due parametri attuali della chiamata sono di tipo (dichiarato) double e B,
   rispettivamente
 * la firma f(double, A) è candidata, in quanto visibile e compatibile
 * la firma f(double, B) è candidata, in quanto visibile e compatibile
 * la firma f(int, Object) non è candidata, in quanto non compatibile
 * non vi sono altre firme candidate
 * Delle due firme candidate, la seconda è più specifica della prima
 * Quindi, l'early binding si conclude con la selezione della firma f(double,B)
 * Per il late binding, cerchiamo il metodo da eseguire a partire dalla classe
   effettiva di alfa: B
 * Nella classe B, troviamo un metodo visibile con quella firma
Quindi, l'output di questa chiamata è B1
*/

// terza chiamata
System.out.println(beta.f(3.0, alfa));
/*
 * beta è di tipo dichiarato B, quindi le firme candidate vanno cercate in B,
   in A e in Object
 * i due parametri attuali della chiamata sono di tipo (dichiarato) double ed A,
   rispettivamente
 * la firma f(double, B) non è candidata, in quanto non compatibile
   (secondo argomento)
 * la firma f(float, Object) non è candidata, in quanto non compatibile
   (primo argomento)
 * la firma f(int, Object) non è candidata, in quanto non compatibile
   (primo argomento)
 * la firma f(double, A) è candidata, in quanto visibile e compatibile
 * Essendoci una sola firma candidata, l'early binding si conclude con la
   selezione della firma f(double, A)
 * Per il late binding, cerchiamo il metodo da eseguire a partire dalla classe
   effettiva di beta: B
 * Nella classe B, non c'è alcun metodo con la firma scelta
 * Passiamo alla classe A, in cui troviamo un metodo con la firma scelta
Quindi, l'output di questa chiamata è A1
*/

// quarta chiamata
System.out.println(gamma.f(3, gamma));
/*
 * gamma è di tipo dichiarato C, quindi le firme candidate vanno cercate in C,
   in A e in Object
 * i due parametri attuali della chiamata sono di tipo (dichiarato) int e C,
   rispettivamente
 * la firma f(int, Object) è candidata, in quanto visibile e compatibile
 * la firma f(double, A) è candidata, in quanto visibile e compatibile
 * la firma f(double, B) non è candidata, in quanto non compatibile
   (secondo argomento)
 * Le due firme candidate non sono confrontabili
Quindi, l'early binding si conclude con un errore di compilazione
*/

// quinta chiamata
System.out.println(false || alfa.equals(beta));
// alfa.equals è true, quindi la condizione è true e stampa dunque true
