import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/* *****************************************************************************
 *  Name:    Alexander Masalov
 *  Description:  Program that calculates percolation threshold via Monte Carlo simulation.
 *
 *  Written:       09/23/2018
 *  Last updated:  09/25/2018
 *
 *  % javac-algs4 PercolationStats.java
 *  % java-algs4 PercolationStats 2 10000
 *  mean                    = 0.668475
 *  stddev                  = 0.11720195392910741
 *  95% confidence interval = [0.6661778417029895,0.6707721582970105]
 *
 **************************************************************************** */

public class PercolationStats {

    private final double confidenceFactor = 1.96;

    private final int trials; // Count of trails
    private final int n; // Size of grid
    private final double[] thresholds; // Array of thresholds for each trail

    /**
     * perform trials independent experiments on an n-by-n grid
     *
     * @param n      - size of grid
     * @param trials - count of experiments
     */
    public PercolationStats(int n, int trials) {

        if (n <= 0 || trials <= 0)
            throw new java.lang.IllegalArgumentException();

        this.n = n;
        this.trials = trials;
        thresholds = new double[trials];

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
            thresholds[i] = (double) counter / (n * n);
        }
    }

    /**
     * Calculates sample mean of percolation threshold
     *
     * @return sample mean
     */
    public double mean() {
        return StdStats.mean(thresholds);
    }

    /**
     * Calculates sample standard deviation of percolation threshold
     *
     * @return sample standard deviation of percolation threshold
     */
    public double stddev() {
        if (n == 1)
            return Double.NaN;

        return StdStats.stddev(thresholds);
    }

    /**
     * Calculates low endpoint of 95% confidence interval
     *
     * @return low endpoint of 95% confidence interval
     */
    public double confidenceLo() {
        return mean() - ((confidenceFactor * stddev()) / Math.sqrt(trials));
    }

    /**
     * Calculates high endpoint of 95% confidence interval
     *
     * @return high endpoint of 95% confidence interval
     */
    public double confidenceHi() {
        return mean() + ((confidenceFactor * stddev()) / Math.sqrt(trials));
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
