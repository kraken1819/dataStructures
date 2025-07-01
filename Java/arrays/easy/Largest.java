package arrays.easy;


public class Largest {
    public static int largestNum(int[] A , int n ) {
        int largest = Integer.MIN_VALUE ;
        for(int i =0 ; i<n ; i++) {
            if (A[i] > largest) {
                largest = A[i];
            }
        }
        return largest ;
    }
    public static void main(String[] args) {
        int[] A = {1,8,7,56,90} ;
        int n = 5 ;
        System.out.println(largestNum(A,n)) ;

    }
}
