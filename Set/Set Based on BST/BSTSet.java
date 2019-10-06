public class BSTSet<E extends Comparable <E>> implements Set{
    private BST bst;

    public BSTSet(){
        bst = new BST();
    }

    @Override
    public void add(E e){
        bst.add(e);
    }

    @Override
    public void remove(E e){
        bst.remove(e);
    }

    @Override
    public boolean contains(E e){
        return bst.search(e);
    }

    @Override
    public int getSize(){
        return bst.getSize();
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }
}