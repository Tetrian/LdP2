
import java.util.Set;
import java.util.HashSet;

public class RandomExecutor {
  private Set<Runnable> set;
  private boolean launched;
  private volatile Runnable runToWait;
  private Thread threadToWait;

  public RandomExecutor() {
    set = new HashSet<Runnable>();
    launched = false;
    runToWait = null;
    threadToWait = new Thread(() -> {return;});
  }

  public void addTask(Runnable r) {
    if (launched)
      throw new IllegalStateException("RandomExecutor is launched yet");
    set.add(r);
  }

  public void launch() {
    new Thread() {
      @Override
      public void run() {
        for (Runnable r: set) {
          r.run();
          if (r == runToWait)
            threadToWait.start();
        }
      }
    }.start();
  }

  public void join(Runnable r) throws InterruptedException {
    runToWait = r;
    threadToWait.join();
  }
}
