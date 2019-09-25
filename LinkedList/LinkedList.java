public class LinkedList<E>
{
    public class Node{
        private E data;
        private Node next;

        public Node(E e,Node node)
        {
            data = e;
            next = node;
        }

        public Node(E e){
            data = e;
            next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList()
    {
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

   public void addFirst(E e){
        head = new Node(e, head);
        size ++;
    }

    public void add(int index, E e){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        if(index == 0)
            addFirst(e);
        else{
            Node prev = head;
            for(int i = 0 ; i < index - 1 ; i ++)
                prev = prev.next;
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            size ++;
        }
    }

    public void addLast(E e){
        add(size, e);
    }

    public E get(int index){
        Node cur = head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.data;
    }

    public void set(E e,int index){
        Node cur = head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.data = e;
    }

    public boolean IsFind(E e){
        Node cur = head;
        for(int i=0;i<size;i++){
            if(cur.data == e)return true;
            else{
                cur = cur.next;
            }
        }
        return false;
    }

    public void removeFirst(){
        Node retNode = head;
        head = retNode.next;
        retNode.next = null;
        size--;
    }

    public void removeLast(){
        remove(size-1);
    }

    public void remove(int index){
        Node pre = head;
        for(int i=0;i<index-1;i++){
            pre = pre.next;
        }
        Node retNode = pre.next;
        pre.next = retNode.next;
        retNode.next = null;
        size--;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = head;
        while(cur != null){
            res.append(cur.data + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}