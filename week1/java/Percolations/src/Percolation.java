import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdRandom;

/******************************************************************************
 *  Compilation:  javac-algs4 Percolation.java
 *  Execution:    java-algs4 Percolation n
 *
 *
 ******************************************************************************/

public class Percolation {
  private QuickFindUF _unionFindAlgorithm;
  private int _n;
  private int _openCount = 0;

  private boolean[] _states;

  /**
   * create n-by-n grid, with all sites blocked
   *
   * @param n - size of grid
   */
  public Percolation(int n) {
    if (n <= 0)
      throw new java.lang.IllegalArgumentException();

    _unionFindAlgorithm = new QuickFindUF(n * n);
    _n = n;
    _states = new boolean[n * n];
  }

  /**
   * open site (row, col) if it is not open already
   *
   * @param row - row index of site
   * @param col - col index of site
   */
  public void open(int row, int col) {
    var rowIndex = row - 1;
    var colIndex = col - 1;

    int p = (_n * rowIndex) + colIndex;
    if (p < 0)
      return;

    if (row > 1 && isOpen(row - 1, col)) {
      int q = (_n * (rowIndex - 1)) + colIndex;
      _unionFindAlgorithm.union(p, q);
    }
    if (row < _n && isOpen(row + 1, col)) {
      int q = (_n * (rowIndex + 1)) + colIndex;
      _unionFindAlgorithm.union(p, q);
    }

    if (col > 1 && isOpen(row, col - 1)) {
      int q = (_n * rowIndex) + (colIndex - 1);
      _unionFindAlgorithm.union(p, q);
    }

    if (col < _n && isOpen(row, col + 1)) {
      int q = (_n * rowIndex) + (colIndex + 1);
      _unionFindAlgorithm.union(p, q);
    }

    _states[p] = true;
    _openCount++;
  }

  /**
   * Detects if site (row, col) is open?
   *
   * @param row - row index of site
   * @param col - col index of site
   * @return site openness
   */
  public boolean isOpen(int row, int col) {
    int p = (_n * (row - 1)) + (col - 1);
    if (p < 0)
      return false;
    return _states[p];
  }

  /**
   * Detects if site (row, col) is full?
   *
   * @param row - row index of site
   * @param col - col index of site
   * @return site fullness
   */
  public boolean isFull(int row, int col) {
    int p = (_n * (row - 1)) + (col - 1);
    for (int i = 0; i < _n; i++) {
      if (_unionFindAlgorithm.connected(p, i))
        return true;
    }
    return false;
  }

  /**
   * Calculates number of open sites
   *
   * @return number of open sites
   */
  public int numberOfOpenSites() {
    return _openCount;
  }

  /**
   * Checks if the system percolate?
   *
   * @return percolates or not
   */
  public boolean percolates() {
    for (int i = 0; i < _n; i++) {
      for (int j = 0; j < _n; j++)
        if (_unionFindAlgorithm.connected((_n * _n) - j - 1, i))
          return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int n = 20;
    var percolation = new Percolation(n);
    boolean isPercolated = false;
    int counter = 0;
    do {

      var row = StdRandom.uniform(1, n + 1);
      var column = StdRandom.uniform(1, n + 1);
      if (!percolation.isOpen(row, column)) {
        percolation.open(row, column);
        if (percolation.percolates())
          isPercolated = true;

        counter++;
      }

    } while (!isPercolated);
    System.out.println(counter + "/" + n * n);
  }
}
