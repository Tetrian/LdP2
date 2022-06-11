
import java.lang.Cloneable;
import java.lang.Comparable;

public class Pizza implements Comparable<Pizza>, Cloneable {
  public static enum Ingrediente {
    POMODORO, AGLIO, MOZZARELLA;
  }
  private int calorie;

  public Pizza() { calorie = 0; }

  private Pizza(int cal) { calorie = cal; }

  public void addIngrediente(Ingrediente i) {
    calorie += i.ordinal();
  }

  public Pizza clone() {
    return new Pizza(calorie);
  }

  public int compareTo(Pizza p) {
    return calorie - p.calorie;
  }
}
