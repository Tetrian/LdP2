
public class Woman extends Person {
  public Woman(String nome, String cognome) {
    super(nome, cognome);
  }

  public void marries(Person p) {
    if (p instanceof Woman)
      throw new IllegalArgumentException("Il coniuge deve essere Man");
    coniuge = p;
    p.coniuge = this;
  }
}
