public class LinkList<E>
{

    public class Node
    {
        private E data;
        private Node next;

        public Node(E e,Node node){
            data = e;
            next = node;
        }

        public Node(E e){
            data = e;
            next = null;
        }
    }

    private Node dummyhead;
    private int size;

    public LinkList(){
        dummyhead = new Node(null,null);
        size = 0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int getSize(){
        return size;
    }

    public void addFirst(E e){
        add(e,0);
    }

    public void add(E e,int index){
        Node pre = dummyhead;
        Node node = new Node(e);
        for(int i=0;i<index;i++){
            pre = pre.next;
        }
        node.next = pre.next;
        pre.next = node;
        size++;
    }

    public void addLast(E e){
        add(e,size);
    }

    public E Findele(int index){
        Node cur = dummyhead.next;
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }
        return cur.data;
    }

    public void Fixele(E e,int index){
        Node cur = dummyhead.next;
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }
        cur.data = e;
    }

    public boolean isExist(E e){
        Node cur = dummyhead.next;
        for(int i = 0;i < size;i++){
            if(cur.data == e)return true;
            cur = cur.next;
        }
        return false;
    }

    public void removeFirst(){
        remove(0);
    }

    public void remove(int index){
        if(isEmpty() == false){
            Node pre = dummyhead;
            for(int i = 0;i < index;i++){
                pre = pre.next;
            }
            pre.next = pre.next.next;
            size--;
        }
    }
    public void removeLast(){
        remove(size-1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyhead.next;
        while(cur != null){
            res.append(cur.data + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {

        LinkList<Integer> linkedList = new LinkList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(666, 2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeLast();    
        System.out.println(linkedList);
        linkedList.addLast(12); 
        System.out.println(linkedList);           
    }
}