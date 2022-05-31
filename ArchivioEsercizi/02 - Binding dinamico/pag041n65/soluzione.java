
// prima chiamata
System.out.println(alfa.f(3.0, gamma));
/*
 * alfa è di tipo dichiarato A, quindi le firme candidate vanno cercate nella
   classe A (o tuu'al più in Object)
 * i due parametri della chiamata sono di tipo (dichiarato) double e C
   rispettivamente
 * la firma f(double, Object) è candidata, in quanto visibile e compatibile
 * la firma f(double, A) è candidata in quanto visibile e compatibile
 * la firma f(int, Object) non è candidata, in quanto incompatibile
 * non ci sono altre firme candidate
 * delle due firme candidate, la seconda è più specifica della prima
 * quindi l'early binding si conclude con la selezione della firma f(double, A)
 * Per il late binding, cerchiamo il metodo da eseguire a partire dalla classe
   effettiva di alfa, ovvero C
 * nella classe C troviamo un metodo visibile con quella firma
Quindi, l'output di questa chiamata è C1;
*/

// seconda chiamata
System.out.println(beta.f(3, beta));
/*
 * beta è di tipo dichiarato B, quindi le firme candidate vanno cercate in B,
   in A oppure in Object
 * i due parametri attuali della chiamata sono di tipo int e B, rispettivamente
 * la firma f(double, Object) è candidata, in quanto visibile e compatibile
 * la firma f(float, Object) è candidata, in quanto visibile e compatibile
 * la firma f(double, A) è candidata, in quanto visibile e compatibile
 * la firma f(int n, Object) è candidata, in quanto visibile e compatibile
 * delle firme candidate f(double, A) è la più specifica delle prime tre, ma
   non è confrontabile con f(int, Object)
 * quindi nessuna firma è più specifica delle altre
Dunque, ci sarà un errore in compilazione
*/

// terza chiamata
System.out.println(beta.f(3.0, null));
/*
 * beta è di tipo dichiarato B, quindi le firme vanno cercate in B, A o Object
 * i due parametri attuali della chiamata sono di tipo Double e null,
   rispettivamente
 * la firma f(float, Object) non è candidata, in quanto incompatibile
 * la firma f(double, Object) è candidata, in quanto visibile e compatibile
 * la firma f(int, Object) non è candidata, in quanto incompatibile
 * la firma f(double, A) è candidata, in quanto visibile e compatibile
 * delle firme candidate la più specifica è f(double, A)
 * Per il late binding cerchiamo il metodo da eseguire a partire dalla classe
   effettiva, cioè B
 * in B non ci sono metodi con quella firma
 * salendo in A troveremo un metodo visibile con la firma f(double, A)
Quindi l'output di questa chiamata è A2
*/

// quarta chiamata
System.out.println(gamma.f(3.0, gamma));
/*
 * gamma è di tipo dichiarato C, quindi le firme candidate vanno cercate in
   C, B, A oppure Object
 * i due parametri attuali della chiamata sono di tipo double e C
 * le firme candidate sono f(double, A) e f(double, Object)
 * L'early binding si conclude con la scelta della firma più specifica delle
   due, ovvero f(double, A)
 * Per il late binding cerchiamo il metodo da eseguire a partire dalla classe
   effettiva, ovvero C
 * C possiede un metodo visibile con quella firma
Quindi l'output di questa chiamata è C1
*/

// quinta chiamata
System.out.println(true && (alfa==beta));
// alfa == beta è false, quindi la condizione è false e stampa false
