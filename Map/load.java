public class load{
    public static void main(String[] args) {
        Map n = new LinkedListmap();
        n.add('b', 20);
        n.add('c', 30);
        n.add('d', 40);
        n.add('e', 50);
        n.add('f', 60);
        System.out.println(n.remove('e'));
        System.out.println(n.remove('b'));
        System.out.println(n.getsize());
        n.setelement('e', 100);
        System.out.println(n.find('e'));
        System.out.println(n.toString());
    }
}