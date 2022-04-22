
import java.util.Set;
import java.util.HashSet;

public class Product {
  private String description;
  private double price;
  private static Set<String> stringSet = new HashSet<>();

  public Product(String description, double price) {
    if(stringSet.add(description)) {
      this.description = description;
      this.price = price;
    }
    else
      throw new RuntimeException("This description already exists.");
  }

  protected double getPrice() {
    return price;
  }
}
