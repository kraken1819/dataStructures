package binarysearch.answers;
import java.util.Scanner ;
public class NthRoot {
    public static int nthRoot(int n , int m ) {
        int low = 1 ;
        int high = m ;
        int mid ;
        while(low<=high) {
            mid = low + (high - low) / 2;
            int num = 1;
            for (int i = 0; i < n; i++) {
                num *= mid;
                if(num>m) break ;
            }
            //this is nth power of mid ;
            if (num == m) {
                return mid;
            } else if (num < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {

        Scanner scx = new Scanner(System.in) ;
        int n = scx.nextInt() ;
        int m = scx.nextInt() ;
//        int n = 6 ;
//        int m = 4096 ;
        System.out.println(nthRoot(n,m)) ;
    }
}
//