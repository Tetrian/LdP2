
public class Time implements Comparable<Time> {
  private int h;
  private int m;
  private int s;

  public static final Time MIDDAY = new Time(12, 00, 00);
  public static final Time MIDNIGHT = new Time(00, 00, 00);

  public Time(int h, int m, int s) {
    if (h < 0 || m < 0 || s < 0)
      throw new IllegalArgumentException("parameters must to be positive");
    this.s = s % 60;
    this.m = (m + (s / 60)) % 60;
    this.h = (h + ((m + (s / 60)) / 60)) % 24;
  }

  public Time minus(Time t) {
    int new_h = this.h - t.h;
    int new_m = this.m - t.m;
    int new_s = this.s - t.s;
    if (new_s < 0) {
      new_s = 60 + new_s;
      new_m--;
    }
    if (new_m < 0) {
      new_m = 60 + new_m;
      new_h--;
    }
    if (new_h < 0)
      new_h = 24 + new_h;
    return new Time(new_h, new_m, new_s);
  }

  @Override
  public String toString() {
    return h + ":" + m + ":" + s;
  }

  @Override
  public int compareTo(Time t) {
    if (this.h == t.h) {
      if (this.m == t.m) {
        if (this.s == t.s)
          return 0;
        if (this.s > t.s)
          return 1;
      }
      if (this.m > t.m)
        return 1;
    }
    if (this.h > t.h)
      return 1;
    return -1;
  }
}
