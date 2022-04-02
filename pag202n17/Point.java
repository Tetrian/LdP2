// La classe Point rappresenta un punto del piano cartesiano  con coordinate intere:
public class Point {
  private int x, y;
  /*
    ...
  */
}

// Spiegare quali delle seguenti sono implementazioni valide per il metodo
compare(Point a, Point b) /* tratto dall’interfaccia */ Comparator<Point>
// supponendo che tale metodo abbia accesso ai campi privati di Point.
a) return a.x - b.x;
  /* Questa è una implementazione che considera un punto maggiore di un altro
     se il primo è dopo il secondo rispetto l'asse delle ascisse. In ogni caso
     rispetta le proprietà di ordinamento. */
b) return a.x - b.y;
  /* Non è una implmentazione valida poiché non rispetta la proprietà transitiva
     infatti presi i punti A(10, 2), B(4,20) e C(2, 5) ho che A < B e B < C  ma
     risulta A > C essendo 10 - 5 > 0 */
c) return ((a.x*a.x)+(a.y*a.y)) - ((b.x*b.x)+(b.y*b.y));
  /* implementazione valida poiché rispetta le 3 proprietà di ordinamento:
      1) sgn(x.compareTo(y)) == -sgn(y.compareTo(x))
      2) se x.compareTo(y)<0 e y.compareTo(z)<0 allora x.compareTo(z)<0
      3) se x.compareTo(y)==0 allora sgn(x.compareTo(z))==sgn(y.compareTo(z))
     dove x, y e z sono Point. Nota che eccetto per la mancanza della radice
     quadrata (a.x*a.x)+(a.y*a.y) è praticamente il modulo del vettore a che
     va dall'origine (0,0) al punto (x,y) */
d) return (a.x-b.x)+(a.y-b.y);
  /* Mi sembri rispetti le 3 proprietà, anche se mi puzza */
e) return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
  /* Questa espressione è del tipo val1^2 + val2^2 ed è evidente quindi che non
     è valida come implementazione di compere poiché ritorna sempre un valore >0 */
