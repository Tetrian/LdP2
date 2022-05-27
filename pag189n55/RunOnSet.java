
import java.util.Set;
import java.util.HashSet;

public class RunOnSet<T> extends Thread {
  private RunnableWithArg<T> rwa;
  private Set<T> set;

  public RunOnSet(RunnableWithArg<T> rwa, Set<T> set) {
    this.rwa = rwa;
    this.set = set;
  }

  public void run() {
    for (T t: set) {
      new Thread( () -> {
        rwa.run(t);
      }).start();
    }
  }
}
