class QuickSort{
    public static int partition( int[] arr,int left,int right ){
        int v = arr[left];
        int j = left;
        for(int i=left+1;i<right;i++){
            if( arr[i]<v ){
                j++;
                swap(arr,j,i);
                //j++;
            }
        }
        swap(arr,left,j);
        return j;
    }

    public static void quicksort( int[] arr,int left,int right ){
        if( left >= right ) return;
        int p = partition( arr,left,right );
        quicksort(arr, left, p-1);
        quicksort(arr, p+1, right);
    }

    public static void quicksort( int[] arr ){
        quicksort( arr,0,arr.length-1 );
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    
    public static void main(String[] args) {
        int[] arr = { 2,1,5,3,1,4,3,6,7 };
        quicksort( arr );
        for( int i=0;i<arr.length;i++ ){
            System.out.println(arr[i]);
        }
    }
}