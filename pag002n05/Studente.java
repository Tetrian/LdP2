
public class Studente {
  private String nome;
  private String matricola;

  private Studente(String nome, String matricola) {
    this.nome = nome;
    this.matricola = matricola;
  }

  static class Triennale extends Studente {
    private static String prefisso = null;

    public Triennale(String nome, String matricola) {
      super(nome, prefisso + "/" + matricola);
      if (prefisso == null)
        throw new RuntimeException("Impostare prima un prefisso con setPrefisso");
    }
    public static void setPrefisso(String pre) {
      prefisso = pre;
    }
  }

  static class Magistrale extends Studente {
    private static String prefisso = null;
    public Magistrale(String nome, String matricola) {
      super(nome, prefisso + "/" + matricola);
      if (prefisso == null)
        throw new RuntimeException("Impostare prima un prefisso con setPrefisso");
    }
    public static void setPrefisso(String pre) {
      prefisso = pre;
    }
  }

  @Override
  public String toString() {
    return nome + " " + matricola;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof Studente)) return false;
    Studente stud = (Studente) o;
    return nome.equals(stud.nome) && matricola.equals(stud.matricola);
  }
}
