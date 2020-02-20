public class SelectionSort{
    public static void selectionSort( int[] arr ){
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            //swap(arr[i],arr[min]);
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }    
    }

    public static void main( String[] args ) {
        int[] arr = { 5,1,2,2,3,4,5 };
        selectionSort( arr );
        for( int i=0;i<arr.length;i++ ){
            System.out.println(arr[i]);
        }
    }
}