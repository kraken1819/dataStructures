package leetcode.weekly.weekly401;

import java.util.Arrays ; 

public class NthValueAfterKSeconds {

    public static int valueAfterKSeconds(int n , int k ) { 
        long[] arr = new long[n] ; 
        Arrays.fill(arr,1) ; 
        for(int i =0 ; i<k ; i++) { 
            //for k generation 
            long sum = 0 ; 
            for(int j =0 ; j<arr.length ; j++) {
                sum+= arr[j] ; 
                arr[j] = sum %1000000007L; 
            }
        }
        long num = 1000000007L ; 
        return (int)(arr[n-1]%num) ; 

    }

    public static void main(String[] args){
        int n = 36 ; 
        int k = 39 ;

        System.out.println(valueAfterKSeconds(n,k)) ; 
    }
    

}
