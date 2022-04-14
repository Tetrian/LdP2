
import java.util.Iterator;
import java.util.Stack;

public class BinaryTreePreIterator implements Iterator<BinaryTreeNode> {
  BinaryTreeNode curr;
  Stack<BinaryTreeNode> stk;

  public BinaryTreePreIterator(BinaryTreeNode node) {
    if(node != null) {
      curr = node;
      stk = new Stack<BinaryTreeNode>();
    }
    else {
      curr = null;
    }
  }

  @Override
  public boolean hasNext() {
    return curr != null;
  }

  @Override
  public BinaryTreeNode next() {
    if (this.hasNext()) {
      if (curr.getLeft() != null) {
        if (curr.getRight() != null)
          stk.push(curr.getRight());
        return curr = curr.getLeft();
      }
      if (curr.getRight() != null)
        return curr = curr.getRight();
      if (!stk.empty())
        return curr = stk.pop();
      else return curr = null;
    }
    else
      throw new IndexOutOfBoundsException("The iterator has terminated yet");
  }
}
