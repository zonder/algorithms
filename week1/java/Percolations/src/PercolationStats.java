import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/******************************************************************************
 * Compilation: javac-algs4 Percolation.java Execution: java-algs4 Percolation n
 *
 *
 ******************************************************************************/

public class PercolationStats {

    private int _trials;
    private double[] _thresholds;

    /**
     * perform trials independent experiments on an n-by-n grid
     *
     * @param n      - size of grid
     * @param trials - count of experiments
     */
    public PercolationStats(int n, int trials) {

        if (n <= 0 || trials <= 0)
            throw new java.lang.IllegalArgumentException();

        _trials = trials;
        _thresholds = new double[trials];

        for (int i = 0; i < trials; i++) {
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
            _thresholds[i] = (double) counter / (n * n);
        }
    }

    /**
     * Calculates sample mean of percolation threshold
     *
     * @return sample mean
     */
    public double mean() {
        return StdStats.mean(_thresholds);
    }

    /**
     * Calculates sample standard deviation of percolation threshold
     *
     * @return sample standard deviation of percolation threshold
     */
    public double stddev() {
        return StdStats.stddev(_thresholds);
    }

    /**
     * Calculates low endpoint of 95% confidence interval
     *
     * @return low endpoint of 95% confidence interval
     */
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(_trials));
    }

    /**
     * Calculates high endpoint of 95% confidence interval
     *
     * @return high endpoint of 95% confidence interval
     */
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(_trials));
    }

    /**
     * @param args n - number of columns and rows T - count of experiments
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, trials);
        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println("95% confidence interval = [" + stats.confidenceLo() + "," + stats.confidenceHi() + "]");
    }
}
