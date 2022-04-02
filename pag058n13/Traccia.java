class Traccia {
  /*
    Implementare la classe Time, che rappresenta un orario della giornata
    (dalle 00:00:00 alle 23:59:59). Gli orari devono essere confrontabili
    secondo Comparable. Il metodo minus accetta un altro orario x come
    argomento e restituisce la differenza tra questo orario e x, sotto forma
    di un nuovo oggetto Time.
    La classe fornisce anche gli orari predefiniti MIDDAY e MIDNIGHT.
  */

  // L’implementazione deve rispettare il seguente esempio d’uso
  public static void main(String[] args) {
    Time t1 = new Time(14,35,0);
    Time t2 = new Time(7,10,30);
    Time t3 = t1.minus(t2);
    System.out.println(t3) ;
    System.out.println(t3.compareTo(t2));
    System.out.println(t3.compareTo(Time.MIDDAY));
  }
  /* Output:
      7:24:30
      1
      -1
  */
}
