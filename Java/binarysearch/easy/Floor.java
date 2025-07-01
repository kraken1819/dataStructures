package binarysearch.easy;

public class Floor {

    public static int findFloor(long[] arr , int n , long x) {
        int low = 0 ;
        int high = n-1 ;
        int mid ;
        while(low<=high) {
            mid = low + ((high - low) >> 1);
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high ;
    }

    public static void main(String[] args) {
        long[] arr = {1,2,8,10,11,12,19} ;
        int n = arr.length ;
        long x = 0 ;
        System.out.println(findFloor(arr,n,x)) ;
    }
}
