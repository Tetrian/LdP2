
public class Book {
  private String title;

  public Book(String title) {
    this.title = title;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Book)) return false;
    Book b = (Book) o;
    return title.equals(b.title);
  }

  @Override
  public int hashCode() {
    return title.hashCode();
  }

  @Override
  public String toString() {
    return title;
  }
}
