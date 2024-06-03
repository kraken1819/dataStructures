package arrays.easy;

public class LinearSearch {
    public static int linearSearch(int[] arr , int k) {
        for(int i =0 ; i<arr.length ; i++) {
            if (arr[i] == k) {
                return i;
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6} ;
        int ind = linearSearch(arr,3) ;
        System.out.println(ind) ;
    }
}
