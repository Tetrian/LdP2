
import java.util.Iterator;

public class Radio implements Iterable<Radio.Channel> {

  public static class Channel {
    private String name;
    private double fm;
    private Channel next;

    private Channel(String name, double fm) {
      this.name = name;
      this.fm = fm;
      next = null;
    }

    @Override
    public String toString() {
      return name + " (" + fm + ")";
    }
  }
  private Channel first;

  public Radio() {}

  // aggiunge una nuova stazione in ordine se la frequenza è disponibile
  public Channel addChannel(String name, double fm) {
    if (first == null) {
      first = new Channel(name, fm);
      return first;
    }
    Channel newChannel = new Channel(name, fm);
    if (first.fm > fm) {
      newChannel.next = first;
      first = newChannel;
    }
    Channel slide = first;
    while (slide.next != null) {
      if (slide.fm == fm || slide.next.fm == fm)
        throw new Error("Frequenza non disponibile");

      if (slide.next.fm > fm) {
        newChannel.next = slide.next;
        slide.next = newChannel;
        return newChannel;
      }
      slide = slide.next;
    }
    slide.next = newChannel;
    return newChannel;
  }

  // restituisce la stazione più vicina a quella data
  public Channel nearest(double fm) {
    Channel result = first;
    for (Channel slide = first; slide != null; slide = slide.next) {
      if (slide.next != null && slide.next.fm > fm) {
        if ((fm - slide.fm) < (slide.next.fm - fm))
          return slide;
        else
          return slide.next;
      }
      result = slide;
    }
    return result;
  }

  // iteratore per il forEach
  public Iterator<Channel> iterator() {
    return new Iterator<Channel>() {
      Channel curr = first;

      @Override
      public boolean hasNext() {
        return curr != null;
      }

      @Override
      public Channel next() {
        Channel result = curr;
        curr = curr.next;
        return result;
      }
    };
  }

}
