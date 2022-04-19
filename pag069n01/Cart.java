
import java.util.ArrayList;

public class Cart extends ArrayList<Product> {
  public double totalPrice() {
    double total = 0;
    for (Product i: this) {
      total += i.getPrice();
    }
    return total;
  }
}
