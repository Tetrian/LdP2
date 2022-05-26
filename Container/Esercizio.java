/*
  aggiungere alla classe Container un metodo isolate() che isola (scollega)
  questo contenitore dal suo gruppo. Fornire un'implementazione ottimizzata
  sul tempo e una ottimizzata sullo spazio.
*/

// Speed1
public class Container {
    private Group group = new Group(this);

    private static class Group {
        double amountPerContainer;
        Set<Container> members;

        Group(Container c) {
            members = new HashSet<>();
            members.add(c);
        }
    }

    ...

    public void isolate() {
      if (group.members.size() == 1) return;
      group.members.remove(this);
      group = new Group(this);
    }
}

// Speed2
public class Container {
    private double amount;
    private Container next = this;

    ...

    public void isolate() {
      if (this.next == this) return;
      Container current = this;
      do {
        current = current.next;
      } while (current.next != this);
      current.next = this.next;
      this.next = this;
    }
}

// Speed3
/*
  non è possibile una implementazione del metodo isolate per come è pensata
  l'implementazione (tramite solo il puntatore al padre)
*/

// Memory1
public class Container {
    private List<Container> group;
    private float amount;

    ...

    public void isolate() {
      if(group.size() == 1) return;

      group.remove(this);
      group = new ArrayList<>();
      group.add(this);
    }
}

// Memory2
public class Container {
    private Container[] group;
    private float amount;

    ...

    public void isolate() {
      if (group == null) return;
      Container[] newGroup = new Container[group.length - 1];
      int j = 0;
      for (int i = 0; i < group.length; ++i) {
        if (group[i] != this) {
          group[i].group  = newGroup;
          newGroup[j++] = group[i];
        }
      }
      this.group = null;
    }
}

// Memory3

// Memory4
