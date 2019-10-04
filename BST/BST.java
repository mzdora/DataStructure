public class BST<E>
{
    public class Node(){
        private E e;
        private Node left;
        private Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private int Size;
    private Node root;

    public BST(){
        Size = 0;
        root = null;
    }

    public Boolean isEmpty(){
        return Size==0;
    }

    public int getSize(){
        return Size;
    }

    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node,E e){
        if(node == null){
            Size++;
            return new Node(e);
        }

        if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right = add(node.right,e);
        }
    }

    public Boolean search(E e){
        return search(e,node);
    }

    private Boolean search(E e,Node node){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e)=0){
            return true;
        }else if(e.compareTo(node.e)<0){
            node.left = search(e,node.left);
        }else{
            node.right = search(e,node.right);
        }
    }

    //前序遍历 最自然最常用的遍历方式
    public void pretraverse(){
        pretraverse(root);
    }

    private void pretraverse(Node node){
        if(node == null)
            return;
        System.out.println(node.e);
        pretraverse(node.left);
        pretraverse(node.right);
    }

    //中序遍历，从左->右遍历。Node放中间。
    //是二分搜索树里数字从小到大排列。
    //二分搜索树也叫排序树

    //后续遍历，为二分搜索树释放内存
}