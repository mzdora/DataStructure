public class BST<E extends Comparable<E>>{
    private class Node{
        E e;
        Node left;
        Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int Size;

    public BST(){
        root = null;
        Size = 0;
    }

    public int getSize(){
        return Size;
    }

    public Boolean isEmpty(){
        return Size==0;
    }

/* 写法1
    public void add(E e){
        if(root == null){
            root = new Node(e);
            Size++;
        }else{
            add(root,e);
        }
    }

    private void add(Node node,E e){
        if(e.equals(node.e)){
            return;
        }else if(e.compareTo(node.e)<0 && node.left == null){
            node.left = new Node(e);
            Size++;
            return;
        }else if(e.compareTo(node.e)>0 && node.right == null){
            node.right = new Node(e);
            Size++;
            return;
        }
        
        if(e.compareTo(node.e)<0){
            add(node.left,e);
        }else{
            add(node.right,e);
        }
    }
*/

    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node,E e){
        if(node == null){
            Size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            add(node.right,e);
        }
        return node;
    }
}