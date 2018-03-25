public class Stacks<Item> {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    private class Node {
        Item item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void push(Item item) {
        ++size;
        Node oldfirst = first;
        first.item = item;
        first.next = oldfirst;
    }
    public Item pop() {
        --size;
        Item res = first.item;
        first = first.next;
        return res;
    }
    public void addlast(Item item) {
        ++size;
        Node p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next.item = item;
        p.next.next = null;
    }
}
