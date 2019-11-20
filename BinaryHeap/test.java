import java.util.PriorityQueue;;

public class test{
    public static void main(String[] args) {
        //最小堆
        PriorityQueue<Integer> n = new PriorityQueue<>();
        n.offer(23);
        n.offer(2);
        n.offer(3);
        n.offer(4);
        n.offer(12);
        n.offer(17);
        n.offer(7);
        n.offer(3);
        n.offer(21);
        n.offer(48);
        for(int i=0;i<10;i++){
            System.out.println(n.poll());
        }
    }
}