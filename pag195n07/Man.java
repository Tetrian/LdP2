
public class Man extends Person {
  public Man(String nome, String cognome) {
    super(nome, cognome);
  }

  public void marries(Person p) {
    if (p instanceof Man)
      throw new IllegalArgumentException("Il coniuge deve essere Woman");
    coniuge = p;
    p.coniuge = this;
  }
}
