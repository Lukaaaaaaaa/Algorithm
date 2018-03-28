import edu.princeton.cs.algs4.StdIn;
/**
 * @date 2018/03/28
 * Question: Intersection of two sets
 * Given two arrays a[] and b[], each containing N distinct 2D points in the plane,
 * design a subquadratic algorithm to count the number of points that are contained
 * both in array a[] and array b[].
 *
 * Solution:
 * 1.Combine the 2 arrays;   O(2*n)
 * 2.Sort the combined array(x then y);    O((2*n)^(3/2))
 * 3.Started at 0th element, compare it with the next.   O(n)
 */

public class IntersectionOfTwoSets {
    private static class Point implements Comparable<Point>{
        double x, y;
        private Point (double i, double j) {
            x = i;
            y = j;
        }

        public int compareTo(Point that) {
            if (this.x > that.x) { return 1; }
            if (this.x < that.x) { return -1; }
            if (this.y > that.y) { return 1; }
            if (this.y < that.y) { return -1; }
            return 0;
        }
    }

    private static void sort(Point[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) { h = h*3 + 1; }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }
    private static boolean less(Point a, Point b) {
        return a.compareTo(b) < 0;
    }
    private static void exch(Point[] a, int i, int j) {
        Point temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        Point[] a, b;
        int count = 0;
        int n = Integer.parseInt(args[0]);
        a = new Point[n];
        b = new Point[n];
        // initialize the 2 arrays.
        for (int i = 0; i < n; i++) {
            a[i] = new Point(StdIn.readDouble(), StdIn.readDouble());
            b[i] = new Point(StdIn.readDouble(), StdIn.readDouble());
        }
        // combine the 2 arrays.
        Point[] s = new Point[2*n];
        for(int i = 0; i < n; i++) { s[i] = a[i]; }
        for(int i = n; i < 2*n; i++) { s[i] = b[i-n]; }
        // sort the array.
        sort(s);
        // compare with the next point.
        for(int i = 0; i < 2*n; i += 2) {
            if (a[i] == a[i+1]) { count++; }
        }
        System.out.print(count);
    }

}
