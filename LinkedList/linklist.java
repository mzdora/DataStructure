public class linklist<E>{
    public class Node{
        private E data;
        private Node next;

        public Node(E e,Node node){
            data = e;
            next = node;
        }
    }

    private Node head;
    private int size;
    public linklist(){
        head = new Node(null,null);//dummy head node;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addFirst(E e){
        add(e,1);
    }

    public void add(E e,int index){
        Node node = new Node(e);
        Node pre=head;

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

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
}