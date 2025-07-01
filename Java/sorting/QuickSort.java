package sorting;
import java.util.Arrays ;
public class QuickSort {
    public static void swap(int[] arr , int i , int j ) {
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
    public static int reArrange(int[] nums , int l , int h ) {
        int pivot = nums[h] ;
        int i  = l ;
        for(int j =l ; j< h ; j++) {
            if(nums[j] <= pivot) {
                swap(nums,i,j) ;
                i++ ;
            }
        }
        swap(nums,i,h) ;
        return i ;
    }
    public static void quickSort(int[] nums,int l , int h) {
        if(l >= h) {
            return ;
        }
        int pivot = reArrange(nums , l , h) ;
        quickSort(nums , l , pivot-1  );
        quickSort(nums ,pivot+1 , h) ;

    }
    public static void main(String[] args) {
        int[] numbs = {13,46,24,52,20,9} ;
        System.out.println(Arrays.toString(numbs)) ;
        quickSort(numbs,0,numbs.length-1) ;
        System.out.println(Arrays.toString(numbs)) ;
    }
}
