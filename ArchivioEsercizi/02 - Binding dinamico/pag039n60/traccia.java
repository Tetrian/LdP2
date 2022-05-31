// Dato il seguente programma (tutte le classi appartengono allo stesso pacchetto):
class A {
  public String f(double n, A x) { return "A1"; }
  public String f(double n, B x) { return "A2"; }
  public String f(int n, Object x) { return "A3"; }
}

class B extends A {
  public String f(double n, B x) { return "B1"; }
  public String f(float n, Object y) { return "B2"; }
}

class C extends A {
  public final String f(int n, Object x) { return "C1"; }
}

public class Test {
  public static void main (String[] args) {
    C gamma = new C();
    B beta = new B();
    A alfa = beta;
    System.out.println(alfa.f(3, beta));            // Errore in compilazione
    System.out.println(alfa.f(3.0, beta));          // Output: B1
    System.out.println(beta.f(3.0, alfa));          // Output A1
    System.out.println(gamma.f(3, gamma));          // Errore in compilazione
    System.out.println(false || alfa.equals(beta)); // Output: true
  }
}
/*
  Indicare l’output del programma. Se un’istruzione provoca un errore di
  compilazione, specificarlo e poi continuare l’esercizio ignorando
  quell’istruzione. (12 punti)

  Per ogni chiamata ad un metodo (escluso System.out.println) indicare la
  lista delle firme candidate. (15 punti)
*/
