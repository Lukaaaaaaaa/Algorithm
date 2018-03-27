import edu.princeton.cs.algs4.StdIn;

/**
 * @author lukaaaaaaaa
 * @date 2018/03/27
 */
public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }
        while (k != 0) {
            System.out.println(rq.dequeue());
            k--;
        }
    }
}