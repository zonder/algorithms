import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/******************************************************************************
 *  Compilation:  javac-algs4 Percolation.java
 *  Execution:    java-algs4 Percolation n
 *
 *
 ******************************************************************************/

public class Percolation {
  private WeightedQuickUnionUF _weightedQuickUnionUF;

  /**
   * create n-by-n grid, with all sites blocked
   *
   * @param n - size of grid
   */
  public Percolation(int n) {
    _weightedQuickUnionUF = new WeightedQuickUnionUF(n);
  }

  /**
   * open site (row, col) if it is not open already
   *
   * @param row - row index of site
   * @param col - col index of site
   */
  public void open(int row, int col) {
    int p = row - 1;
    int q = col - 1;

    if (p > 0)
      _weightedQuickUnionUF.union();
  }

  /**
   * Detects if site (row, col) is open?
   *
   * @param row - row index of site
   * @param col - col index of site
   * @return site openness
   */
  public boolean isOpen(int row, int col) {
    return false;
  }

  /**
   * Detects if site (row, col) is full?
   *
   * @param row - row index of site
   * @param col - col index of site
   * @return site fullness
   */
  public boolean isFull(int row, int col) {
    return false;
  }

  /**
   * Calculates number of open sites
   *
   * @return number of open sites
   */
  public int numberOfOpenSites() {
    return 0;
  }

  /**
   * Checks if the system percolate?
   *
   * @return percolates or not
   */
  public boolean percolates() {
    return false;
  }

  public static void main(String[] args) {
    System.out.print("Percolation");
  }
}