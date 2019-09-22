public interface Stack<E>{
    void push(E e);
    E pop();
    int getSize();
    E peek();
    boolean isEmpty();
}