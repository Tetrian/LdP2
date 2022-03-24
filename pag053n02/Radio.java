
public class Radio {
  private Channel[] vec; // in ordine crescente di frequenza

  public class Channel {
    private String name;
    private double fm;

    protected Channel(String name, double fm) {
      this.name = name;
      this.fm = fm;
    }
  }

  public Radio() {}

  // aggiunge una nuova stazione se la frequenza è disponibile
  public Channel addChannel(String name, double fm) throws Exception {
    Channel [] newvec = new Channel [vec.length + 1];
    int index = 0;
    for (int idx = 0; idx < vec.length; ++idx) {
      if (vec[idx].fm == fm) throw new Exception("Frequenza già in uso");
      if (vec[idx].fm < fm) {
        newvec[idx] = vec[idx];
      }
      if (vec[idx].fm > fm) {
        index = idx;
        break;
      }
    }
    newvec[index] = new Channel(name, fm);
    for (int idx = index++; idx < newvec.length; ++idx) {
      newvec[idx] = vec[idx - 1];
    }
    vec = newvec;
    return vec[index];
  }

  // restituisce la stazione più vicina a quella data
  public Channel nearest(double fm) {
    for (int idx = 0; idx < vec.length; ++idx) {
      if (vec[idx].fm > fm) {
        if (fm - vec[idx - 1].fm < vec[idx].fm - fm)
          return vec[idx - 1];
        else
          return vec[idx];
      }
    }
    return vec[0];
  }
}
