public class LinkedListmap implements Map{
    public class Node{
        private char e;
        private int v;
        private Node next;

        public Node(char e,int v){
            this.e = e;
            this.v = v;
            next = null;
        }
        public Node(){
            e = null;
            v = null;
            next = null;
        }
    }
    private Node head;
    private int size;

    public LinkedListmap(){
        head = null;
        size = 0;
    }

    @Override
    public void add(char e,int v){
        if(head == null){
            head = new Node(e, v);
            size++;
        }else{
            Node prev = head;
            while(prev.next != null){
                prev = prev.next;
            }
            size++;
            prev.next = new Node(e, v);
        }
    }
    @Override
    public int remove(char e){
        if(head == null){
            System.out.println("Map is empty");
            return 0;
        }else{
            Node prev = head;
            while(prev.e != e){
                prev = prev.next;
            }
            size--;
            return prev.v;
        }
    }
    @Override
    public void setelement(char e,int v){
        Node prev = head;
        while(prev.e != e){
            prev = prev.next;
        }
        prev.v = v;
    }
    @Override
    public int find(char e){
        Node prev = head;
        while(prev.e != e){
            prev = prev.next;
        }
        return prev.v;
    }
    @Override
    public int getsize(){
        return size;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Map[");
        Node prev = head;
        while(prev != null){
            res.append(prev.e + "->" + prev.v);
            res.append(" ");
            prev = prev.next;
        }
        res.append(']');
        return res.toString();
    }
    public static void main(String[] args) {
        LinkedListmap n = new LinkedListmap();
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