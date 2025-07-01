
package arrays.easy ;

public class SecondLargest {
    public static int secondLargest(int[] arr , int n ) {
        int max = Integer.MIN_VALUE ;
        int smax = Integer.MIN_VALUE ;
        for(int i =0 ; i<n ; i++) {
            if (arr[i] > max) {
                smax = max;
                max = arr[i];
            } else if (arr[i] > smax && arr[i] < max) {
                smax = arr[i];
            }
        }
        return smax ;
    }
    public static void main(String[] args) {
        int[] A= {1,2,4,6,45,34,47,73,36,44} ;
        int n = 10 ;
        System.out.println(secondLargest(A,n)) ;
    }
}
