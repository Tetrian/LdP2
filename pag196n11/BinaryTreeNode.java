
public class BinaryTreeNode {
  private BinaryTreeNode left, right;
  public BinaryTreeNode getLeft() { return left; }
  public BinaryTreeNode getRight() { return right; }
  // aggiunti da me
  private String name;
  public BinaryTreeNode(String name, BinaryTreeNode left, BinaryTreeNode right) {
    this.name = name;
    this.left = left;
    this.right = right;
  }
  @Override
  public String toString() {
    return name;
  }
}
