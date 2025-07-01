package sorting ;
import java.util.Arrays  ;

public class SelectionSort {

    public static void swap(int[] arr , int i , int j ) {
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
    public static void selectionSort(int[] arr) {
        int k = 0 ;
        while(k<arr.length) {
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for (int i = k; i < arr.length; i++) {
                if (arr[i] < min) {
                    minIndex = i;
                    min = arr[i];
                }
            }
            swap(arr, k, minIndex);
            k++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,6,2,3,8,9,4,5,7} ;
        System.out.print("array before sorting : " ) ;
        System.out.println(Arrays.toString(arr)) ;
        selectionSort(arr);
        System.out.print("array after sorting : ") ;
        System.out.println(Arrays.toString(arr)) ;

    }

}
