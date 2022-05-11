
public class Person {
  private String name;
  private int recalls;

  public Person(String name) {
    this.name = name;
    recalls = 0;
  }

  public GreenPass vaccinate(int day) {
    if (recalls++ == 0)
        return new GreenPass(this, day + 180);
    return new GreenPass(this, day + 270);
  }
}
