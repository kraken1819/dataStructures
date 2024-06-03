package sorting;
import java.util.Arrays ;

public class InsertionSort {
    public static void swap(int[] arr ,int i , int j ) {
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
    public static void insertionSort(int[] arr) {

        for(int i = 1 ; i<arr.length ; i++ ) {
            int k = i;
            while (k > 0 && arr[k - 1] > arr[k]) {
                swap(arr, k - 1, k);
                k--;
            }
        }

    }
    public static void main(String[] args) {
        int[] nums = {1,2,5,3,4,9,8,7,6} ;
        System.out.println(Arrays.toString(nums)) ;
        insertionSort(nums) ;
        System.out.println(Arrays.toString(nums)) ;
    }
}
