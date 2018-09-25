import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/* *****************************************************************************
 *  Name:    Alexander Masalov
 *  Description:  Program that calculates percolation threshold via Monte Carlo simulation.
 *
 *  Written:       09/23/2018
 *  Last updated:  09/25/2018
 *
 *  % javac-algs4 Percolation.java
 *  % java-algs4 Percolation
 *  226/400
 *
 **************************************************************************** */


public class Percolation {
    private WeightedQuickUnionUF _unionFindAlgorithm; // Algorithm to perform quick union and find

    private int _n; // Size of grid
    private int _openCount = 0; // count of open sites
    private boolean[] _states; // states of sites

    /**
     * create n-by-n grid, with all sites blocked
     *
     * @param n - size of grid
     */
    public Percolation(int n) {
        if (n <= 0)
            throw new java.lang.IllegalArgumentException();

        _unionFindAlgorithm = new WeightedQuickUnionUF(n * n);
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
        if (row <= 0 || col <= 0)
            throw new java.lang.IllegalArgumentException();

        int rowIndex = row - 1;
        int colIndex = col - 1;

        int p = (_n * rowIndex) + colIndex;

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

        if (row <= 0 || col <= 0)
            throw new java.lang.IllegalArgumentException();

        int p = (_n * (row - 1)) + (col - 1);
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
        if (row <= 0 || col <= 0)
            throw new java.lang.IllegalArgumentException();
        if(row == 1)
            return isOpen(row, col);

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
        for (int i = 1; i <= _n; i++) {
            if(isFull(_n, i))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 20;
        Percolation percolation = new Percolation(n);
        boolean isPercolated = false;
        int counter = 0;
        do {

            int row = StdRandom.uniform(1, n + 1);
            int column = StdRandom.uniform(1, n + 1);
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
