
import java.util.Collection;
import java.util.LinkedList;

public enum Coin {
  TWOEUROS(200), ONEEUROS(100), FIFTY(50),
  TWENTY(20), TEN(10), FIVE(5), TWO(2), ONE(1);

  private final int centValue;
  private Coin(int centValue) {
    this.centValue = centValue;
  }

  public static Collection<Coin> convert(int cent) {
    Collection<Coin> c = new LinkedList<>();
    cent = getRestAndAddCoin(c, cent, TWOEUROS);
    cent = getRestAndAddCoin(c, cent, ONEEUROS);
    cent = getRestAndAddCoin(c, cent, FIFTY);
    cent = getRestAndAddCoin(c, cent, TWENTY);
    cent = getRestAndAddCoin(c, cent, TEN);
    cent = getRestAndAddCoin(c, cent, FIVE);
    cent = getRestAndAddCoin(c, cent, TWO);
    getRestAndAddCoin(c, cent, ONE);
    return c;
  }

  private static int getRestAndAddCoin(Collection<Coin> c, int cent, Coin coin) {
    while(cent > coin.centValue) {
      cent -= coin.centValue;
      c.add(coin);
    }
    return cent;
  }
}
