import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationStats {
    private Percolation p;
    private double[] trials;

    private final static double VAL = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) throws IllegalArgumentException {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();

        this.p = new Percolation(n);
        this.trials = new double[trials];

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(trials);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(trials);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - VAL * stddev() / Math.sqrt(trials.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + VAL * stddev() / Math.sqrt(trials.length);
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats percolation = new PercolationStats(n, T);

        for (int i = 0; i < T; i++) {
            percolation.p = new Percolation(n);
            boolean percolates = false;
            while (!percolates) {
                int row = (int) (StdRandom.uniform() * n) + 1;
                int col = (int) (StdRandom.uniform() * n) + 1;
                percolation.p.open(row, col);
                percolates = percolation.p.percolates();
            }
            percolation.trials[i] = (double) percolation.p.numberOfOpenSites() / (n * n);
        }

        System.out.println(n + " " + T);
        System.out.println("mean                        = " + percolation.mean());
        System.out.println("stddev                      = " + percolation.stddev());
        System.out.println("95% confidence interval     = " + "[" + percolation.confidenceLo() + ", " + percolation.confidenceHi() + "]");

    }

}