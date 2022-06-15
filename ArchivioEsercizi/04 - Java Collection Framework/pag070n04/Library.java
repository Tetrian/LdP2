
import java.util.Set;
import java.util.Collection;
import java.util.LinkedList;
import java.util.HashSet;

public class Library {
  private Set<Book> books;
  private Collection<Book> loans;

  public Library() {
    books = new HashSet<Book>();
    loans = new LinkedList<Book>(); // usiamo una lista così abbiamo l'ordine
                                    // posizionale (ci serve per printLoans)
  }

  public boolean addBook(Book b) {
    return books.add(b);
  }

  public boolean loanBook(Book b) {
    if (!books.remove(b)) {
      if (loans.contains(b)) return false;
      else throw new IllegalArgumentException(b + " isn't in this library");
    }
    return loans.add(b); // ritorna sempre true
  }

  public void returnBook(Book b) {
    if (!loans.remove(b)) throw new IllegalArgumentException();
    books.add(b);
  }

  public void printLoans() {
    System.out.println(loans);
  }
}
