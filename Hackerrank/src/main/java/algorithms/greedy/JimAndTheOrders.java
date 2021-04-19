package algorithms.greedy;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class JimAndTheOrders {

    public static class Order {

        int index;
        int start;
        int duration;

        Order(int index, int t, int d) {
            this.index = index;
            this.start = t;
            this.duration = d;
        }

        public int getIndex() {
            return this.index;
        }

        public int getStart() {
            return this.start;
        }

        public int getDuration() {
            return this.duration;
        }

        public int getEnd() {
            return getStart() + getDuration();
        }

        @Override
        public String toString() {
            return "(" + this.index + " " + this.start + " " + this.duration + ")";
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();

            TreeSet<Order> queue = new TreeSet<>((o1, o2) -> {
                int res = o1.getEnd() - o2.getEnd();
                if (res == 0) {
                    res = o1.getIndex() - o2.getIndex();
                }
                return res;
            });

            for (int i = 0; i < N; i++) {
                queue.add(new Order(i + 1, in.nextInt(), in.nextInt()));
            }
            //System.err.println(queue);

            Iterator<Order> it = queue.iterator();
            String delimiter = "";
            while (it.hasNext()) {
                System.out.print(delimiter  + it.next().getIndex());
                delimiter = " ";
            }
            System.out.println();
        }
    }
}
