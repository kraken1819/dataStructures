package binarysearch.answers;

public class SqRoot {

    public static long floorSqrt(int x ) {
        long low = 1 ;
        long high = x ;
        long mid ;
        while(low<high) {
            mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high ;
    }

    public static void main(String[] args) {
        int x = 5 ;
        System.out.println(floorSqrt(x)) ;
    }
}
