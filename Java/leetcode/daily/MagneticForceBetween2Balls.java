
package leetcode.daily ; 
import java.util.Arrays ; 

public class MagneticForceBetween2Balls {

    public static int maxDistance(int[] positions,int m){
        if(m>positions.length) return -1 ; 

        Arrays.sort(positions) ;

        int low = Integer.MAX_VALUE ; 
        int high = positions[positions.length-1] - positions[0] ; 
        
        for(int i =0 ; i<positions.length-1 ; i++){
            int dist = positions[i+1]-positions[i] ; 
            if(dist<low) low = dist ; 
            
        }

        System.out.println(low + " " + high) ; 
        int mid ; 

        while(low<=high){
            mid = low + ((high-low)/2) ; 

            //now we need to find is it possible to place the balls 
            // with minimum force d ; 
            int ballsPlaced = 1; 
            int prevPosition = positions[0] ; 
            for(int i=1 ; i<positions.length ; i++){
                if(positions[i]-prevPosition >= mid){
                    prevPosition = positions[i] ; 
                    ballsPlaced++ ; 
                }
            }
            //System.out.println(mid + ":" + ballsPlaced) ; 

            if(ballsPlaced>=m){
                low = mid+1 ; 
            }else{
                high = mid-1 ; 
            }
        }
        return high ; 
    }

    public static void main(String[] args){

        int[] positions = {5,4,3,2,1,1000000000} ; 
        int m = 2 ; 
        System.out.println(maxDistance(positions,m)) ; 

    }

}
