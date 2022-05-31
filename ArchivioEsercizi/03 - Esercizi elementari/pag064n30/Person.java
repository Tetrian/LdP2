
import java.util.Set;
import java.util.HashSet;

public abstract class Person {
  private String nome;
  private String cognome;
  private Person genitore;
  protected Person coniuge;
  protected Set<Person> prole;

  public Person(String nome, String cognome) {
    this.nome = nome;
    this.cognome = cognome;
    genitore = null;
    coniuge = null;
    prole = new HashSet<Person>();
  }

  public void addChild(Person p) {
    p.genitore = this;
    prole.add(p);
    if (coniuge != null)
      coniuge.prole.add(p);
  }

  public abstract void marries(Person p);

  public static boolean areSiblings(Person x, Person y) {
    if (x.genitore == null || y.genitore == null) return false;
    for (Person p: x.genitore.prole)
      if (p == y) return true;
    return false;
  }
}
