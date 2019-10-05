public class Main {
    public static void main(String[] args) {
        BST<Integer> a = new BST<>();
        a.add(432);
        a.add(34);
        a.add(32);
        a.add(654);
        a.add(432);
        a.add(43);
        a.add(765);
        a.add(535);
        a.add(213);
        a.add(346);
        a.add(327);
        a.remove(327);
        System.out.println(a);
    }
}
