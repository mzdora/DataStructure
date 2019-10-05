import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>>
{
    public class Node{
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
        return node;
    }

    public Boolean search(E e){
        return search(e,root);
    }

    private Boolean search(E e,Node node){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e)==0){
            return true;
        }else if(e.compareTo(node.e)<0){
            return search(e,node.left);
        }else{
            return search(e,node.right);
        }
    }

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

    public void weightraverse(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            System.out.println(node.e);
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
    }

    public E getMin(){
        if(Size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        E res = getMin(root).e;
        return res;
    }

    private Node getMin(Node node){
        if(node.left == null){
            return node;
        }
        return getMin(node.left);
    }

    public E getMax(){
        if(Size == 0){
            throw new IllegalArgumentException("BST is empty");
        }
        E res = getMax(root).e;
        return res;
    }

    private Node getMax(Node node){
        if(node.right == null){
            return node;
        }
        return getMax(node.right);
    }

    public E removemin(){
        E res = getMin();
        root = removemin(root);
        return res;
    }

    private Node removemin(Node node){
        if(node.left == null){
            Node res = node.right;
            node.right = null;
            Size--;
            return res;
        }
        node.left = removemin(node.left);
        return node;
    }

    public E removemax(){
        E res = getMax();
        root = removemax(root);
        return res;
    }

    private Node removemax(Node node){
        if(node.right == null){
            Node res = node.left;
            node.left = null;
            Size--;
            return res;
        }

        node.right = removemax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(e,root);
    }

    private Node remove(E e,Node node){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left = remove(e,node.left);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right = remove(e, node.right);
            return node;
        }else{
            if(node.left == null){
                Node res = node.right;
                node.right = null;
                Size--;
                return res;
            }else if(node.right == null){
                Node res = node.left;
                node.left = null;
                Size--;
                return res;
            }else{
                Node res = getMin(node.right);
                res.right = removemin(node.right);
                res.left = node.left;
                node.right = node.left = null;
                return res;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}