package binarysearch.easy;
import java.util.Arrays ;

public class FloorCeilBs {

    public static int[] getFloorAndCeil(int[] a , int n , int x ) {
        int low = 0 ;
        int high = n-1 ;
        int mid ;

        while(low<=high) {
            mid = low + (high - low) / 2;
            if (a[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if(high>=0) high = a[high] ;

        if(low<n) {
            low = a[low] ;
        }else {
            low = -1;
        }

        return new int[]{high,low} ;
    }

    public static void main(String[] args) {
        int[] a = {3, 4 ,4, 7,7, 7, 10} ;
        int n = a.length ;
        int x = 7 ;
        System.out.println(Arrays.toString(getFloorAndCeil(a,n,x)) );

    }
}
