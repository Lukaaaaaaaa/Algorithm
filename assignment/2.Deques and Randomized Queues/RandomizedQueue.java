import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;


/**
 * @author lukaaaaaaaa
 * @date 2018/03/26
 * @param <Item>
 */


public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] s;
    /**
     * size of the queue
     */
    private int n;

    public RandomizedQueue() {
        s = (Item[]) new Object[1];
        n = 0;
    }
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; ++i) { temp[i] = s[i]; }
        s = temp;

    }

    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return n;
    }
    public void enqueue(Item item) {
        if (item == null) { throw new IllegalArgumentException(); }
        if (n == s.length) { resize(2*s.length); }
        s[n] = item; n++;
    }
    public Item dequeue() {
        if (isEmpty()) { throw new NoSuchElementException(); }
        int i = StdRandom.uniform(n);
        Item item = s[i];
        if (i < n - 1) {
            for (int j = i; j < n - 1; j++) {
                s[j] = s[j + 1];
            }
        }
        s[n - 1] = null;
        --n;
        if ((n > 0) && (n == s.length / 4)) { resize(s.length/4); }
        return item;
    }
    public Item sample() {
        if (isEmpty()) { throw new NoSuchElementException(); }
        int i = StdRandom.uniform(n);
        return s[i];
    }
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }
    private class RandomizedQueueIterator implements Iterator<Item> {
        private int i = n;
        public boolean hasNext() { return i > 0; }
        public Item next() {
            if (i == 0) { throw new NoSuchElementException(); }
            int k = StdRandom.uniform(i);
            Item item = s[k];
            if (k < i - 1) {
                for (int j = k; j < i - 1; j++) { s[j] = s[j + 1]; }
            }
            s[i - 1] = null;
            --i;
            return item;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
