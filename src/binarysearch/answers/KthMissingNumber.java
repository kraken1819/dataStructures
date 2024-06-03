package binarysearch.answers;

public class KthMissingNumber {

    public static int findKthPositive(int[] arr , int k) {
        //if the k is present left side of the array ;

        if(k<=arr[0]-1){
            return k ;
        }
        if(k>arr[arr.length-1]- (arr.length-1) - 1) {
            int n = k - (arr[arr.length-1] - (arr.length-1) -1) ;
            return arr[arr.length-1] + n ;
        }

        int low = 0 ;
        int high = arr.length-1 ;
        int mid ;

        while(low<=high) {
            mid = low + (high-low)/2 ;
            int missing = arr[mid]-mid-1 ;

            if(missing<k){
                low = mid+1 ;
            }else {
                high = mid - 1;
            }
        }
        int n = k - (arr[high]-high-1) ;
        return arr[high] + n ;


    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4} ;
        int k = 2 ;
        System.out.println(findKthPositive(arr,k))  ;
    }
}
