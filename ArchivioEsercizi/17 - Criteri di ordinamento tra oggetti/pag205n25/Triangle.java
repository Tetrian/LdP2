
import java.util.Arrays;
import java.util.Comparator;

public class Triangle {
  private double a, b, c;

  public Triangle(double x, double y, double z) {
    if (x < y + z && y < x + z && z < x + y) {
      a = x; b = y; c = z;
    }
    else throw new RuntimeException("Fail: incorrect measurements");
  }

  public boolean equals(Triangle tria) {
    double[] thisVec = new double[] {a, b, c};
    double[] triaVec = new double[] {tria.a, tria.b, tria.c};
    Arrays.sort(thisVec);
    Arrays.sort(triaVec);
    for(int i = 0; i < 3; ++i) {
      if (thisVec[i] != triaVec[i])
        return false;
    }
    return true;
  }

  public boolean similar(Triangle tria) {
    double[] thisVec = new double[] {a, b, c};
    double[] triaVec = new double[] {tria.a, tria.b, tria.c};
    Arrays.sort(thisVec);
    Arrays.sort(triaVec);
    double ratio = thisVec[0] / triaVec[0];
    if (ratio == thisVec[1] / triaVec[1] && ratio == thisVec[2] / triaVec[2])
      return true;
    else
      return false;
  }

  public static Comparator<Triangle> perimeterComparator() {
    return new Comparator<>() {
      @Override
      public int compare(Triangle x, Triangle y) {
        double perim1 = x.a + x.b + x.c;
        double perim2 = y.a + y.b + y.c;
        if (perim1 < perim2)
          return -1;
        if (perim1 > perim2)
          return 1;
        return 0;
      }
    };
  }
}
