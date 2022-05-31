
public class Box implements Comparable<Box> {
  private int height;
  private int width;
  private int depth;

  public Box(int height, int width, int depth) {
    this.height = height;
    this.width = width;
    this.depth = depth;
  }

  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof Box)) return false;
    Box b = (Box) o;
    return height == b.height && width == b.width && depth == b.depth;
  }

  public int compareTo(Box b) {
    if (equals(b)) return 0;
    if (((height * width * depth) - (b.height * b.width * b.depth)) < 0)
      return -1;
    return 1;
  }

  public boolean fitsIn(Box b) {
    return height < b.height && width < b.width && depth < b.depth;
  }
}
