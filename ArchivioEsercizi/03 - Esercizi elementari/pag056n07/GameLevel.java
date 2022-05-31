
public class GameLevel {
  private int maxRow;
  private int maxClm;
  private int[][] grid;

  public GameLevel(int rowsNumber, int columnsNumber) {
    maxRow = rowsNumber;
    maxClm = columnsNumber;
    grid = new int[maxRow][maxClm];
  }

  public void setWall(int x, int y) {
    grid[x][y] = 1;
  }

  public boolean areConnected(int startRow, int startClm, int finishRow, int finishClm) {
    if (grid[startRow][startClm] == 1 || grid[finishRow][finishClm] == 1) return false;
    boolean[][] visited = new boolean[maxRow][maxClm];
    if (isPath(startRow, startClm, visited, finishRow, finishRow))
      return true;
    return false;
  }

  // Method for checking boundaries
  private boolean isSafe(int i, int j) {
    return i >= 0 && i < maxClm && j >= 0 && j < maxRow;
  }

  // Return true if there is a path from a source to a destination
  private boolean isPath(int i, int j, boolean[][] visited, int finishRow, int finishClm) {
    // checking the boundaries, walls and unvisited cell
    if(isSafe(i, j) && grid[i][j] == 0 && !visited[i][j]) {
      // mark the cell visited
      visited[i][j] = true;
      // if the cell is the destination return true
      if (i == finishRow && j == finishClm) return true;

      // check the cells on the up
      if (isPath(i - 1, j, visited, finishRow, finishClm)) return true;
      // check the cells on the left
      if (isPath(i, j - 1, visited, finishRow, finishClm)) return true;
      // check the cells on the down
      if (isPath(i + 1, j, visited, finishRow, finishClm)) return true;
      // check the cells on the right
      if (isPath(i, j + 1, visited, finishRow, finishClm)) return true;
    }
    return false;
  }
}
