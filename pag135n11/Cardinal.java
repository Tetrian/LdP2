
public enum Cardinal {
  N, NNE, NE, ENE,
  E, ESE, SE, SSE,
  S, SSO, SO, OSO,
  O, ONO, NO, NNO;

  public boolean isOpposite(Cardinal c) {
    return this.ordinal() == (c.ordinal() + 8 % 16);
  }

  public static Cardinal mix(Cardinal x, Cardinal y) {
    if (x.isOpposite(y))
      throw new IllegalArgumentException("I punti non devono essere opposti");
    int mid;
    if (x.ordinal() + y.ordinal() <= 8)
      mid = (x.ordinal() + y.ordinal()) / 2;
    else
      mid = (x.ordinal() + y.ordinal() + 16) / 2;
    return values()[mid];
  }
}
