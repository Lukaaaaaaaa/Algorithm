/**
 * @author lukaaaaaaaa
 * @date 2018/03/26
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {
    private Node sentinel = new Node();
    private Node last;
    private int size;

    private class Node {
        private Item item;
        private Node next;
    }
    public Deque() {
        sentinel.next = null;
        size = 0;
    }
    public boolean isEmpty() {
        return sentinel.next == null;
    }
    public int size() {
        return size;
    }
    public void addFirst(Item item) {
        if (item == null) { throw new IllegalArgumentException(); }
        ++size;
        Node oldFirst = sentinel.next;
        sentinel.next = new Node();
        sentinel.next.item = item;
        sentinel.next.next = oldFirst;
    }
    public void addLast(Item item) {
        if (item == null) { throw new IllegalArgumentException(); }

        ++size;
        Node p = sentinel;
        while (p.next != null) { p = p.next; }
        p.next = new Node();
        p.next.item = item;
        p.next.next = null;
    }
    public Item removeFirst() {
        if (sentinel.next == null) { throw new NoSuchElementException(); }
        --size;
        Item item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        return item;
    }
    public Item removeLast() {
        if (sentinel.next == null) { throw new NoSuchElementException(); }
        --size;
        Node p = sentinel;
        while (p.next.next != null) { p = p.next; }
        Item item = p.next.item;
        p.next = null;
        return item;
    }


    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    private class DequeIterator implements Iterator<Item> {
        private Node current = sentinel.next;
        public boolean hasNext() { return current != null; }
        public Item next() {
            if (current == null) { throw new NoSuchElementException(); }
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
