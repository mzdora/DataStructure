public class LinkedListStack<E> implements stack<E>
{
    private LinkList<E> link;

    public LinkedListStack(){
        link = new LinkList();
    }

    @Override
    public void push(E e){
        link.addFirst(e);
    }
    
    @Override
    public void pop(){
        link.removeFirst();
    }

    @Override
    public int getSize(){
        return link.getSize();
    }

    @Override
    public boolean isEmpty(){
        return link.isEmpty();
    }

    @Override
    public E peek(){
        return link.Findele(0);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Top[");
        res.append(link);
        res.append("]Tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}