/**
 * Stack with max. Create a data structure that efficiently
 * supports the stack operations (push and pop) and also a
 * return-the-maximum operation. Assume the elements are
 * real numbers so that you can compare them.
 *
 * Solution:
 * Iterate over the stack and find the max.  //time: O(n)
 */

public class StackWithMax {
    private Node first = null;
    private Node last = null;
    private int size = 0;
    private double max = 0;

    private class Node {
        double item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void push(double item) {
        ++size;
        Node oldfirst = first;
        first.item = item;
        first.next = oldfirst;
    }
    public double pop() {
        --size;
        double res = first.item;
        first = first.next;
        return res;
    }
    public double findMax() {
        Node p = first;
        max = p.item;
        while (p.next != null) {
            p = p.next;
            if (p.item > max) { max = p.item; }
        }
        return max;
    }
}
