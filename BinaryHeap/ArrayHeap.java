public class ArrayHeap implements Heap{
    private Array<Integer> data;
    
    public ArrayHeap(){
        this.data = new Array<Integer>();
    }

    public ArrayHeap(int E){
        this.data = new Array<Integer>(E);
    }
    private int father(int i){
        if(i == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (i-1)/2;
    }
    private int left_son(int i){
        return i*2+1;
    }
    private int right_son(int i){
        return i*2+2;
    }

    @Override
    public void add(int E){
        data.addLast(E);
        sift_up(data.getSize()-1);
    }
    private void sift_up(int E){
        while(E>0 && data.get(E) > data.get(father(E))){
            data.swap(E,father(E));
            E = father(E);
        }
    }
    @Override
    public int extractMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        int res = data.get(0);
        data.swap(0,data.getSize()-1);
        data.removeLast();
        sift_down(0);
        return res;
    }

    private void sift_down(int E){
        while(left_son(E)<data.getSize()){
            int j = left_son(E);
            if(j+1 < data.getSize() && data.get(j+1)>data.get(j)){
                j++;
            }
            if(data.get(E)>=data.get(j))
                break;
            data.swap(E,j);
            E=j;
        }
    }

    public static void main(String[] args) {
        //最大堆
        ArrayHeap n = new ArrayHeap();
        n.add(23);
        n.add(2);
        n.add(3);
        n.add(4);
        n.add(12);
        n.add(17);
        n.add(7);
        n.add(3);
        n.add(21);
        n.add(48);
        for(int i = 0;i<20;i++){
            System.out.println(n.extractMax());
        }
    }
}