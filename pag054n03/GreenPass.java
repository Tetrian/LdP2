
public class GreenPass {
  private Person owner;
  private int expiration;

  protected GreenPass(Person owner, int expiration) {
    this.owner = owner;
    this.expiration = expiration;
  }

  public boolean isValidOn(int day) {
    if (day <= 0)
      throw new IllegalArgumentException();
    return day <= expiration;
  }

  public boolean belongsTo(Person p) {
    return p == owner;
  }
}
