
import java.util.List;
import java.util.ArrayList;

public class MultiQueue<T> {
  List<List<T>> lis;
  int lessfull;

  public MultiQueue(int size) {
    lessfull = 0;
    lis = new ArrayList<List<T>>(size);
    for (int i = 0; i < size; ++i) {
        lis.add(new ArrayList<T>());
    }
  }

  public void add(T elem) {
    synchronized (lis) {
      lis.get(lessfull++).add(elem); // aggiunge in coda
      if (lessfull == lis.size())
        lessfull = 0;
      lis.notifyAll();
    }
  }

  public T get(int i) throws InterruptedException {
    synchronized (lis) {
      while (lis.get(i).size() == 0)
        lis.wait();
      return lis.get(i).remove(0); // rimuove in testa
    }
  }
}
