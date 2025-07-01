package sorting;
import java.util.Arrays ;
public class BubbleSort {
    public static void swap(int[] arr , int i , int j ) {
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
    public static void bubbleSort(int[] arr) {
        for(int i =0 ; i<arr.length ; i++ ) {
            for(int j=0 ; j<arr.length-1-i ; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,5,3,4,9,8,7,6} ;
        System.out.println(Arrays.toString(nums)) ;
        bubbleSort(nums) ;
        System.out.println(Arrays.toString(nums)) ;

    }
}
