
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private Percolation perc;
    private double size;
    private double[] threshold;
    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;

    public PercolationStats(int n, int trials) {
        if (n <= 0) throw new IllegalArgumentException("n <= 0");
        if (trials <= 0)  throw new IllegalArgumentException("trails <= 0");
        size = n*n;
        threshold = new double[trials];
        for (int i = 0; i < trials; i++) {
            /* for (double t = 1.0; t <= size; t++) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                perc.open(row, col);
                if (perc.percolates()) {
                    threshold[i] = t / size;
                    break; }*/
            perc = new Percolation(n);
            double count = 0;
            while (!perc.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (!perc.isOpen(row, col)) {
                    perc.open(row, col);
                    count++; }
            }
            threshold[i] = count / size;
        }
        mean = StdStats.mean(threshold);
        stddev = StdStats.stddev(threshold);
        confidenceHi = mean + 1.96 * stddev / Math.sqrt((double) trials);
        confidenceLo = mean - 1.96 * stddev / Math.sqrt((double) trials);
    }
    public double mean() {
        return mean;
    }
    public double stddev() {
        return stddev;
    }
    public double confidenceLo() {
        return confidenceLo;
    }
    public double confidenceHi() {
        return confidenceHi;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats per = new PercolationStats(n, trials);
        System.out.println("mean                    = " + per.mean());
        System.out.println("stddev                  = " + per.stddev());
        System.out.println("95% confidence interval = [" + per.confidenceLo() + ", " +per.confidenceHi() + "]");

    }
}
