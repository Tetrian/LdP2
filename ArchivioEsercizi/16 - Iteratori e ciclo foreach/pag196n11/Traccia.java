
import java.util.Iterator;

class Traccia {
  // Il seguente frammento di classe definisce un nodo in un albero binario.
      // vedi BinaryTreeNode.java
  /* Si implementi una classe iteratore BinaryTreePreIterator che visiti i
  nodi dell’albero in preorder (ciascun nodo prima dei suoi figli).
  Tale classe deve poter essere usata nel seguente modo: */
  public static void main(String[] args) {
    // lBinaryTreeNode root = ...;
    BinaryTreeNode root = new BinaryTreeNode("Radice",
                                new BinaryTreeNode("Sinistro", null, null),
                                new BinaryTreeNode("Destro", null,
                                    new BinaryTreeNode("Ultimo", null, null)));
    Iterator i = new BinaryTreePreIterator(root);
    while (i.hasNext()) {
      BinaryTreeNode node = (BinaryTreeNode) i.next();
      // ...
      // aggiunta da me:
      System.out.println(node);
    }
  }
/* Output atteso:
    Sinistro
    Destro
    Ultimo
Nota: non mi aspetto "Radice" poiché chiamo le stampe dopo il primo next.
*/}
