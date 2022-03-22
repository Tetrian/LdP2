public class B extends RuntimeException {

  public B() {/*
    public A(double inutile) ci costringe ad aggiungere
    il costruttore vuoto, poiché fa implicitamente una
    chiamata super() e quindi senza costruttore vuoto
    nella superclasse avremmo un errore in compilazione
  */}

public B(int n, double d) {/*
  per l'espressione x / 2.0 il compilatore fa una promozione
  implicita a double, da cui il parametro double b
*/}

  public B(String s) {/*
    il metodo stampa(String s) lancia una eccezione
    tramite il costruttore della classe B(stringa) da
    cui ricaviamo che la classe B estende una eccezione,
    il fatto che il metodo in A non sia definito throws
    significa che B deve essere di tipo unchecked. Quindi
    bisogna estendere RuntimeException o Error
  */}
}
