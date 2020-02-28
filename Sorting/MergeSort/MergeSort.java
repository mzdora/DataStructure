class MergeSort{
    public static void merge(int[] arr,int left,int mid,int right,int[] copy){
        int l = left;
        int r = mid+1;
        int t = 0;
        while(l <= mid && r <= right){
            if(arr[l]<arr[r]){
                copy[t] = arr[l];
                l++;
                t++;
            }else{
                copy[t] = arr[r];
                r++;
                t++;
            }
        }
        while( l <= mid ){
            copy[t] = arr[l];
            l++;
            t++;
        }
        while( r <= right ){
            copy[t] = arr[r];
            r++;
            t++;
        }
        t = 0;
        while(left <= right){
            arr[left++] = copy[t++];
        }
    }

    public static void sort(int[] arr,int left,int right,int[] copy){
        if( left >= right ) return;
        int mid = (left+right)/2;
        sort(arr, left, mid,copy);
        sort(arr, mid+1, right,copy);
        merge(arr,left,mid,right,copy);
    }

    public static void mergeSort(int[] arr) {
        int[] copy = new int[arr.length];
        sort(arr, 0, arr.length - 1,copy);
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 1, 2, 3, 4, 5, 6, 1, 2, 7 };
        mergeSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}