public class Arr
{
    private int[] data;
    private int size;

    public Arr(int capacity)
    {
        data = new int[capacity];
        size = 0;
    }

    //public Array(){
    //    this(capacity:10);
    //}

    public int getSize(){
        return size;
    }

    public int GetCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(int e){
        if(size == data.length){
            System.out.println("Error");
        }
        data[size] = e;
        size ++;
    }

    public void add(int index,int e){
        if(size == data.length){
            System.out.println("Error");
        }
        if(index < 0 || index > size){
            System.out.println("Error");
        }
        for(int i = size -1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size ++;
    }

    public void show_array(){
        for(int i=0;i<data.length;i++){
            System.out.println(data[i]);
        }
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0;i<size;i++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}