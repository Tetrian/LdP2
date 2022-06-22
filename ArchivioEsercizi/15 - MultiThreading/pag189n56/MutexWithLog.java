
import java.util.concurrent.atomic.AtomicBoolean;

public class MutexWithLog {
  private AtomicBoolean locked = new AtomicBoolean(false);
  private Thread current = null;

  public void lock() {
    synchronized (locked) {
      if (locked.get()) {
        try { locked.wait(); }
        catch (Exception e) { return; }
      }
      current = currentThread();
      System.out.println(current.getName() + " ha acquisito il lock");
      locked.set(true);
    }
  }

  public void unlock() {
    synchronized (locked) {
      if (locked.get() && Thread.currentThread() == current) {
        locked.set(false);
        locked.notify();
        System.out.println(Thread.currentThread().getName() + " ha rilasciato il lock");
      }
      else {
        throw new RuntimeException();
      }
    }
  }
}
