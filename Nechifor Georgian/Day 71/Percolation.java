import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    // creates n-by-n grid, with all sites initially blocked
    WeightedQuickUnionUF uf;
    private int[] grid;
    private int width;
    private int openSites;

    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        width = n;
        openSites = 0;
        grid = new int[n * n + 2];
        uf = new WeightedQuickUnionUF(n * n + 2);
        grid[0] = 1;
        grid[n * n + 1] = 1;
        connectTopBottom();
    }

    private boolean isSafe(int r, int c) {
        return (r > 0) && (c > 0) && (r <= width) && (c <= width);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row <= 0 || col <= 0 || row > width || col > width)
            throw new IllegalArgumentException();
        if (isOpen(row, col)) return;
        int[] rows = {0, 0, -1, 1};
        int[] cols = {1, -1, 0, 0};
        int current = width * (row - 1) + col;
        grid[current] = 1;
        openSites++;

        for (int i = 0; i < 4; i++) {
            int xRow = row + rows[i], xCol = col + cols[i];
            if (isSafe(xRow, xCol) && isOpen(xRow, xCol)) {
                int neighbour = width * (xRow - 1) + xCol;
                uf.union(current, neighbour);
            }
        }
    }

    private void connectTopBottom() {
        for (int i = 1; i < width; i++) {
            uf.union(0, i);
        }
        for (int i = width * (width - 1) + 1; i <= width * width; i++) {
            uf.union(i, (width * width + 1));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[width * (row - 1) + col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return uf.find(grid[width * (row - 1) + col]) == uf.find(0);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        int top = uf.find(0);
        int bottom = uf.find(width * width + 1);
        return top == bottom;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation p = new Percolation(5);
        p.open(1, 1);
        p.open(1, 2);
        p.open(1, 4);
        p.open(2, 4);
        p.open(3, 4);
        p.open(3, 2);
        p.open(3, 5);
        p.open(4, 1);
        p.open(4, 3);
        p.open(5, 1);
        p.open(5, 2);
        p.open(5, 4);
        p.open(5, 5);

        System.out.println(p.percolates());
    }
}
