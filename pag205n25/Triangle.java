
import java.util.Arrays;

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

  public Comparator perimeterComparator()
}
