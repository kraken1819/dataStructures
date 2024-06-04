package binarysearch.answers;
import java.util.ArrayList ;
public class AllocateBooks {



    public static int findPages(ArrayList<Integer> arr , int n , int m ) {

        if(m>n) return -1 ;

        int low = Integer.MIN_VALUE ;
        int high = 0 ;
        for(int i =0 ; i<n ; i++){
            if(arr.get(i)>low) low = arr.get(i) ;

            high+=arr.get(i) ;

        }
        int mid ;
        while(low<=high) {
            mid = low + (high-low)/2 ;

            //we need to find no of parts it make with mid max pages .

            int nparts = 0 ;
            int sum = 0 ;
            for(int i =0 ; i<n ; i++ ){
                sum+=arr.get(i) ;
                if(sum>mid){
                    nparts++ ;
                    sum = arr.get(i) ;
                }
            }
            if(sum!=0) nparts++ ;

            //

            if(nparts<=m){
                high = mid-1 ;
            }else {
                low = mid + 1;
            }
        }
        return low ;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>() ;
        int[] input = {25, 46, 28, 49, 24} ;
        for(int i =0 ; i<input.length ;i++){
            arr.add(input[i]) ;
        }

        int m = 4 ;

        System.out.println(findPages(arr,arr.size(),m)) ;

    }

}
