// Dato il seguente programma (tutte le classi appartengono allo stesso pacchetto):
class A {
  public String f(A x, A[] y, B z) { return "A1"; }
  public String f(A x, Object y, B z) { return "A2"; }
}

class B extends A {
  public String f(B x, A[] y, B z) {
    return "B1:" + x.f((A)x, y, z); // output B1:A1
  }
  public String f(A x, B[] y, B z) { return "B2"; }
}

class C extends B {
  public String f(A x, A[] y, C z) {
    return "C1:" + z.f(new C(), y, z); // errore di compilazione fai solo C1:
  }
}

public class Test {
  public static void main(String[] args) {
    C gamma = new C();
    B beta = gamma;
    A[] array = new A[10];
    System.out.println(beta.f (gamma, array, gamma));
    System.out.println(gamma.f(array[0], null, beta));
    System.out.println(beta == gamma);
  }
}
/*
 * Per ogni chiamata ad un metodo (escluso System.out.println) indicare la
   lista delle firme candidate.
 * Indicare l’output del programma. Se un’istruzione provoca un errore di
   compilazione, specificarlo e poi continuare l’esercizio ignorando
   quell’istruzione.
 */
