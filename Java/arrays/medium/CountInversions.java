package arrays.medium;
import java.util.ArrayList ;
import java.util.Arrays ;

public class CountInversions {

    public static long merge(long[] arr , int low , int mid , int high ) {

        ArrayList<Long> mergedArray = new ArrayList<>() ;
        long numberOfInversions = 0 ;

        int i =low ;
        int j = mid+ 1 ;

        while(i<=mid && j<=high) { // none of the arrays are empty
            if(arr[i]<=arr[j]){
                mergedArray.add(arr[i++]) ;
            }else {
                numberOfInversions += mid-i+1 ;
                mergedArray.add(arr[j++]) ;
            }
        }
        while(i<=mid){
            mergedArray.add(arr[i++]) ;
        }
        while(j<=high){
            mergedArray.add(arr[j++]) ;
        }

        for(i = low ; i<=high ; i++) {
            arr[i] = mergedArray.get(i-low);
        }
        return numberOfInversions ;
    }
    public static long mergeSort(long[] arr , int low , int high) {

        //break condition for merge sort
        if(low == high ) {
            return 0 ;
        }

        int mid = low + (high-low)/2 ;
        long a = mergeSort(arr,low,mid) ;
        long b = mergeSort(arr,mid+1,high) ;

        long inversions = merge(arr,low,mid,high) ;

        return a + b + inversions ;


    }

    public static long inversionCount(long[] arr,int N){

        return mergeSort(arr,0,N-1) ;

    }


    public static void main(String[] args) {

        long[] arr = {2,4,1,3,5} ;
        int N = arr.length ;


        System.out.println(inversionCount(arr , N)) ;
        System.out.println(Arrays.toString(arr)) ;
    }
}
