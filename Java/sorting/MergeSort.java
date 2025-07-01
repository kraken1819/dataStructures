package sorting;
import java.util.Arrays ;

public class MergeSort {
    public static int[] merge(int[] arr1 , int[] arr2) {
        int i = 0 ;
        int j = 0 ;
        int[] mergedArr = new int[arr1.length + arr2.length] ;
        int k = 0 ;
        // if both the arrays are not empty
        while(i<arr1.length && j<arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArr[k++] = arr1[i++];
            } else {
                mergedArr[k++] = arr2[j++];
            }
        }
        // if arr1 is not empty
        while(i<arr1.length) {
            mergedArr[k++] = arr1[i++];
        }
        //if arr2 is not empty
        while(j<arr2.length) {
            mergedArr[k++] = arr2[j++];
        }
        return mergedArr ;
    }
    public static int[] mergeSort(int[] arr) {

        int start = 0 ;
        int end = arr.length-1 ;
        if(start >= end ) {
            return arr;
        }
        int mid = (start+end)/2 ;
        int[] arr1 = mergeSort(Arrays.copyOfRange(arr,start,mid+1)) ;
        int[] arr2 = mergeSort(Arrays.copyOfRange(arr,mid+1,end+1)) ;
        return merge(arr1,arr2) ;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 4, 9, 8, 7, 6} ;
        System.out.println(Arrays.toString(nums)) ;
        int[] ans = mergeSort(nums) ;
        System.out.println(Arrays.toString(ans)) ;

    }
}
