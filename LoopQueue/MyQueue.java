public class MyQueue<E> implements Queue<E>
{
    private E[] data;
    private int head,tail,size;


    public MyQueue(int Capacity){
        data = (E[])new Object[Capacity + 1];
        head = 0;
        tail = 0;
        size = 0;
    }
    
    public MyQueue(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == tail;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    public void enqueue(E e){
        if((tail + 1)%data.length == head)
            resize(2*getCapacity());
        data[tail] = e;
        tail = (tail + 1)%data.length;
        size ++;
    }

    public E dequeue(){
        if(isEmpty())
            throw new IllegalArgumentException();
        E n = data[head];
        data[head] = null;
        head = (head + 1)%data.length;
        size --;
        if(size <= getCapacity()/4)
            resize(getCapacity()/2);
        return n;
    }

    public E getfront(){
        if(isEmpty())
            throw new IllegalArgumentException();
        return data[head];
    }

    private void resize(int newCapacity){
        E[] newdata = (E[])new Object[newCapacity + 1];
        for(int i=0;i<size;i++)
            newdata[i] = data[(i + head)%data.length];
        data = newdata;
        head = 0;
        tail = size;
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("head [");
        for(int i=head;i != tail;i=(i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length != tail)
                res.append(",");;
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}