
import java.util.List;
import java.util.ArrayList;

public class Book implements Comparable<Book>, Cloneable {
  private static class Chapter {
    private String title;
    private String content;
    private int page;

    private Chapter(String title, String content, int page) {
      this.title = title;
      this.content = content;
      this.page = page;
    }
  }
  private List<Chapter> chapters;

  public Book() {
    chapters = new ArrayList<Chapter>();
  }

  public void addChapter(String title, String content) {
    chapters.add(new Chapter(title, content, chapters.size() + 1));
  }

  public String getChapterTitle(int page) {
    return (chapters.get(page - 1)).title;
  }

  public String getChapterContent(int page) {
    return (chapters.get(page - 1)).content;
  }

  public int compareTo(Book b) {
    return chapters.size() - b.chapters.size();
  }

  public Book clone() {
    Book tmp = new Book();
    tmp.chapters.addAll(this.chapters);
    return tmp;
  }
}
