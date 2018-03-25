/**
 * Queue with two stacks.
 * Implement a queue with two stacks so that
 * each queue operations takes a constant amortized
 * number of stack operations.
 * @param <Item>
 * solution:
 * when performing 'enqueue', the 1st stack performs
 * 'push' and the 2nd stack performs 'addlast';
 * when performing 'dequeue', the 2nd stack performs
 * 'pop'.
 */

public class QueueWithTwoStacks<Item> {
    Stacks<Item> ins, outs;

    public boolean isEmpty() {
        return ins.isEmpty();
    }
    public void enqueue(Item item) {
        ins.push(item);
        if (outs.isEmpty()) { outs.push(item); }
        else {outs.addlast(item); }
    }
    public Item dequeue() {
         return outs.pop();
    }
}
