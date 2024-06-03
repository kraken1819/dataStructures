package arrays.easy;

import java.util.ArrayList ;

public class FindUnion {
    public static void checkAndAdd(ArrayList<Integer> result , int k ) {
        if(result.isEmpty()) {
            result.add(k);
        }else if(result.get(result.size()-1) != k) {
            result.add(k);
        }

    }
    public static ArrayList<Integer> findUnion(int[] arr1 , int[] arr2 , int n , int m ) {
        ArrayList<Integer> result = new ArrayList<>() ;
        int i =0 ;
        int j = 0 ;
        while(i<n && j<m) {
            if(arr1[i] == arr2[j]){
                checkAndAdd(result,arr1[i]) ;
                i++ ;
                j++ ;
            } else if (arr1[i] < arr2[j]) {
                checkAndAdd(result , arr1[i]);
                i++;
            } else {
                checkAndAdd(result , arr2[j]);
                j++;
            }
        }
        while(i<n) {
            checkAndAdd(result, arr1[i++]);
        }
        while(j<m) {
            checkAndAdd(result, arr2[j++]);
        }
        return result ;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3,6,7}  ;
        int[] arr2 = {2,2,4,5,8} ;
        int n , m ;
        n= m =5 ;
        ArrayList<Integer> answer = findUnion(arr1,arr2,n,m) ;
        System.out.println(answer) ;

    }
}
