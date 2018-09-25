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
    private final WeightedQuickUnionUF unionFindAlgorithm; // Algorithm to perform quick union and find

    private final int n; // Size of grid
    private int openCount = 0; // count of open sites
    private boolean[] states; // states of sites

    /**
     * create n-by-n grid, with all sites blocked
     *
     * @param n - size of grid
     */
    public Percolation(int n) {
        if (n <= 0)
            throw new java.lang.IllegalArgumentException();

        unionFindAlgorithm = new WeightedQuickUnionUF(n * n + 2);
        this.n = n;
        states = new boolean[n * n];
        for(int i=0;i<n;i++) {
            unionFindAlgorithm.union((n*n + 1), n*n - i - 1);
            unionFindAlgorithm.union(n*n, i);
        }
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

        int p = xyTo1D(row, col);
        if (row > 1 && isOpen(row - 1, col)) {
            int q = (n * (rowIndex - 1)) + colIndex;
            unionFindAlgorithm.union(p, q);
        }
        if (row < n && isOpen(row + 1, col)) {
            int q = (n * (rowIndex + 1)) + colIndex;
            unionFindAlgorithm.union(p, q);
        }

        if (col > 1 && row != 1 && isOpen(row, col - 1)) {
            int q = (n * rowIndex) + (colIndex - 1);
            unionFindAlgorithm.union(p, q);
        }

        if (col < n && row != 1 && isOpen(row, col + 1)) {
            int q = (n * rowIndex) + (colIndex + 1);
            unionFindAlgorithm.union(p, q);
        }

        states[p] = true;
        openCount++;
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

        int p = xyTo1D(row, col);
        return states[p];
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

        int p = xyTo1D(row, col);
        return isOpen(row, col) && unionFindAlgorithm.connected(n*n, p);
    }

    /**
     * Calculates number of open sites
     *
     * @return number of open sites
     */
    public int numberOfOpenSites() {
        return openCount;
    }

    /**
     * Checks if the system percolate?
     *
     * @return percolates or not
     */
    public boolean percolates() {
        return unionFindAlgorithm.connected(n*n, n*n+1);
    }

    public static void main(String[] args) {
        int n = 3;
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
    private int xyTo1D(int row, int col){
        return (n * (row - 1)) + (col - 1);
    }
}
