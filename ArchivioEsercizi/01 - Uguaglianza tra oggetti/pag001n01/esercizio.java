/* TRACCIA
  Con riferimento alla classe Cart dell'esercizio 1 (pag069n01), dire quali
  delle seguenti sono specifiche valide per il metodo equals.
  In caso negativo, motivare la risposta con un controesempio.
  Due istanze di Cart sono uguali se:
    a) entrambi i carrelli contengono almeno un prodotto e il prodotto più caro
       del primo carrello ha lo stesso prezzo del prodotto più caro del secondo
       carrello;
    b) entrambi i carrelli sono vuoti, oppure entrambi contengono almeno un
       prodotto;
    c) i due carrelli contengono almeno un prodotto in comune;
    d) i prezzi totali di ciascun carrello differiscono al più di 10 euro
*/
/* SOLUZIONE
  a) Si poiché gode di riflessività, simmetria e transitività
  b) Si poiché è una relazione di equivalenza
  c) No poiché non gode di transitività, siano infatti car1 = {sedia, tavolo},
     car2 =  {tavolo, cuscino} e car3 = {cuscino, letto} avremo che car1 == car2
     e car2 == car3 ma risulta car1 != car3
  d) Manca di transitività, supposto infatti il prezzo di car1, car2, car3 di
     €10, €20, €30 rispettivamente. Avremo car1 == car2 e car2 == car3 ma
     car1 != car3 essendo la differenza di €20
*/
