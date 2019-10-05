import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    //前序遍历 深度优先遍历非递归写法
    public void deepthtraverse(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    //中序遍历，从左->右遍历。Node放中间。
    //中序遍历是二分搜索树里数字从小到大排列。
    //二分搜索树也叫排序树
    public void midtraverse(){
        midtraverse(root);
    }

    private void midtraverse(Node node){
        if(node == null){
            return;
        }

        midtraverse(node.left);
        System.out.println(node.e);
        midtraverse(node.right);
    }

    //后续遍历，为二分搜索树释放内存
    public void posttraverse(){
        posttraverse(root);
    }

    private void posttraverse(Node node){
        if(node == null){
            return;
        }

        posttraverse(node.left);
        posttraverse(node.right);
        System.out.println(node.e);
    }

    //广度优先遍历，只能用非递归实现
    public void weightraverse(){
        //Queue只是一个接口，需要用LinkedList来Implement.
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            System.out.println(node.e);
            if(node.left != null)
                q.add(node.right);
            if(node.right != null)
                q.add(node.left);
        }
    }

    //找到树中的最小值
    public E getMin(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        E res = getMin(root).e;
        return res;
    }

    private Node getMin(Node node){
        if(node.left == null){
            return node;
        }
        getMin(node.left);
    }

    //找到树中的最大值
    public E getMax(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        E res = getMin(root).e;
        return res;
    }

    private Node getMax(Node node){
        if(node.right == null){
            return node;
        }
        getMin(node.right);
    }

    //删除树中的最小值
    public E removemin(){
        removemin(root);
        return getMin();
    }

    private Node removemin(Node node){
        if(node.left == null){
            Node res = node.right;
            node.right = null;
            Size--;
            return res;
        }

        removemin(node.left);
    }

    //删除树中的最大值
    public E removemax(){
        removemax(root);
        return getMax();
    }

    private Node removemax(Node node){
        if(node.right == null){
            Node res = node.left;
            node.left = null;
            Size--;
            return res;
        }

        removemin(node.right);
    }
}
