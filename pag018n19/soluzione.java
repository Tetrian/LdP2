// prima di procedere con le chiamate si noti che l'istruzione
z.f(new C(), y, z); // nell'unico metodo della classe C è ambiguo
/* infatti sia il metodo f(B, A[], B) in B e il metodo f(A, A[], C) in C
   matchano, quindi procederemo rimuovendo questa istruzione dal metodo.
*/ x.f((A)x, y, z); // invece ha come unica firma possibile f(A, A[] B) in A

// prima chiamata
System.out.println(beta.f (gamma, array, gamma));
/*
 * beta è di tipo dichiarato B, quindi le firme candidate vanno ricercate in B,
   A oppure in Object
 * i parametri attuali della chiamata sono  C, A[] e C rispettivamente
 * la firma f(B, A[], B) è candidata poiché visibile e compatibile
 * la firma f(A, B[]. B) non è compatibile a causa dell'array
 * la firma f(A, A[], B) è candidata, mentre f(A, Object, B) ovviamente no
 * L'early binding si conclude con la scleta della firma f(B,A[],B) essendo
   questa la più specifica delle tre
 * Late binding: Il tipo effettivo di beta è C, quindi cerca la firma f(B,A[],B)
   che non è presente nella classe C
 * Sale in B, dove trova una funzione con quella firma
Quindi, l'output della chiamata è B1:A1
*/

// seconda chiamata
System.out.println(gamma.f(array[0], null, beta));
/*
 * gamma è di tipo dichiarato C, quindi le firme candidate vanno cercate in C,
   B, A, od al più Object
 * i parametri attuali della chiamata sono A, null, B rispettivamente.
   Si ricordi che null è sottotipo di tutti i tipi.
 * la firma f(A, A[], C) non è candidata essendo B non compatibile con C
 * la firma f(A, B[], B) è candidata poiché visibile e compatibile
 * la firma f(B, A[], B) non è candidata poichè A non è compatibile con B
 * la firma f(A, Object, B) è candidata poichè visibile e compatibile
 * la firma f(A, A[], B) è camdodata poichè visibile e compatibile
 * tra f(A, B[], B), f(A, A[], B) e f(A, Object, B) la più specifica è la prima
 * L'early binding si conclude quindi con la firma f(A, B[], B)
 * Il late binding cerca la firma candidata prima in C e poi in B, dove la trova
L'output del programma sarà, dunque, B2
*/

// terza chiamata
System.out.println(beta == gamma);
/*
 * Puntano allo stesso oggetto quindi l'output è true
*/
