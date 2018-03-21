
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] id;
    private int opened = 0;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF uf2;
    private int top;
    private int bottom;
    private int len;

    public Percolation(int n) {
        if (n <= 0) { throw new IllegalArgumentException(); }
        uf = new WeightedQuickUnionUF(n*n + 2);
        uf2 = new WeightedQuickUnionUF(n*n + 1);
        id = new int[n][n];
        top = n*n;
        bottom = n*n + 1;
        len = n;

    }

    public void open(int row, int col) {
        if (indexCheck(row, col)) {
            if (!isOpen(row, col)) opened++;
            id[row - 1][col - 1] = 1;
            // access to the top is 2.
            if (row == 1) {
                uf.union(col - 1, top);
                uf2.union(col - 1, top);

                id[row - 1][col - 1] = 2;
            }
            if (row == len) {
                uf.union((row - 1) * len + col - 1, bottom);
            }
            // as long as one of the neighbor is 2,
            if ((row != 1) && isOpen(row - 1, col)) {
                uf.union((row - 1) * len + col - 1, (row - 2) * len + col - 1);
                uf2.union((row - 1) * len + col - 1, (row - 2) * len + col - 1);
                /* if ((id[row - 1][col - 1] == 2) || (id[row - 2][col - 1] == 2)) {
                    id[row - 1][col - 1] = 2;
                    id[row - 2][col - 1] = 2;
                } */
            }
            if ((row != len) && isOpen(row + 1, col)) {
                uf.union((row - 1) * len + col - 1, row * len + col - 1);
                uf2.union((row - 1) * len + col - 1, row * len + col - 1);
                /* if ((id[row - 1][col - 1] == 2) || (id[row - 2][col - 1] == 2)) {
                    id[row - 1][col - 1] = 2;
                    id[row][col - 1] = 2;
                } */
            }
            if ((col != 1) && isOpen(row, col - 1)) {
                uf.union((row - 1) * len + col - 1, (row - 1) * len + col - 2);
                uf2.union((row - 1) * len + col - 1, (row - 1) * len + col - 2);
                /* if ((id[row - 1][col - 1] == 2) || (id[row - 2][col - 1] == 2)) {
                    id[row - 1][col - 1] = 2;
                    id[row - 1][col - 2] = 2;
                }*/
            }
            if ((col != len) && isOpen(row, col + 1)) {
                uf.union((row - 1) * len + col - 1, (row - 1) * len + col);
                uf2.union((row - 1) * len + col - 1, (row - 1) * len + col);
                /* if ((id[row - 1][col - 1] == 2) || (id[row - 2][col - 1] == 2)) {
                    id[row - 1][col - 1] = 2;
                    id[row - 1][col] = 2;
                }*/
            }
            return;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isOpen(int row, int col) {
        if (indexCheck(row, col)) {
            return id[row - 1][col - 1] > 0;
        }
        throw new IllegalArgumentException("row or col out of bounds");
    }

    private boolean indexCheck(int row, int col) {
        if (row > 0 && row < len + 1 && col > 0 && col < len + 1) {
            return true;
        }
        return false;
    }
    public boolean isFull(int row, int col) {
        if (indexCheck(row, col)) {
            return uf2.connected((row - 1)*len + col - 1, top);
        }
        throw new IllegalArgumentException("row or col out of bounds");
    }
    public int numberOfOpenSites() {
        return opened;
    }
    public boolean percolates() {
        return uf.connected(top, bottom);
    }

}
