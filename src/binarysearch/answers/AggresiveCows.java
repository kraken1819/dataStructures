package binarysearch.answers;
import java.util.Scanner ;
import java.util.Arrays ;

public class AggresiveCows {

    public static void main(String[] args) {
        Scanner scx = new Scanner(System.in) ;

        int t = scx.nextInt() ;

        while(t-->0){
            int N = scx.nextInt() ;
            int C = scx.nextInt() ;
            int[] stalls = new int[N] ;
            for(int i=0 ; i<N ; i++){
                stalls[i] = scx.nextInt() ;
            }

            Arrays.sort(stalls) ;
            //applying binary search on distance

            int low = 1 ;
            int high = stalls[stalls.length-1] - stalls[0] ;
            int mid ;

            while(low<=high) {
                mid = low + (high - low) / 2;

                //now with this minimum distance mid we need to find
                //whether cows are sufficient in stalls or not .

                int nCows = C-1 ;
                int prevCowPosition = 0 ;

                for(int i=1 ; i<stalls.length ; i++) {
                    if(stalls[i]-stalls[prevCowPosition] >=mid ){
                        prevCowPosition = i;
                        nCows-- ;
                    }
                }

                if(nCows>0){
                    high=mid-1 ;
                }else {
                    low = mid + 1;
                }
            }
            System.out.println(high) ;

        }

    }
}
