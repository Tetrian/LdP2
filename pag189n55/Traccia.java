
import java.util.Set;
import java.util.HashSet;

class Traccia {/*
  Si consideri la seguente interfaccia.
  public interface RunnableWithArg<T> {
    void run(T x);
  }
  Un oggetto RunnableWithArg è simile ad un oggetto Runnable, tranne per il
  fatto che il suo metodo run accetta un argomento.
  Si implementi una classe RunOnSet che esegue il metodo run di un oggetto
  RunnableWithArg su tutti gli oggetti di un dato insieme, in parallelo.      */
  public static void main(String[] argv) {
    Set<Integer> s = new HashSet<Integer>();
    s.add(3); s.add(13); s.add(88);
    RunnableWithArg<Integer> r = new RunnableWithArg<Integer>() {
      public void run(Integer i) {
        System.out.println(i/2);
      }
    };
    Thread t = new RunOnSet<Integer>(r, s);
    t.start();
  }
  /* Possibile Output:
        1
        6
        44
  */
}
