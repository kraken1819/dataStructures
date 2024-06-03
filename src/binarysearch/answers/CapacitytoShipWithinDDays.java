package binarysearch.answers;

public class CapacitytoShipWithinDDays {

    public static int shipWithinDays(int[] weights,int days) {
        int low = Integer.MIN_VALUE ;
        int high = 0 ;
        for(int i =0 ; i<weights.length ; i++){
            if(weights[i]>low) low = weights[i] ;

            high += weights[i] ;
        }

        int mid ;
        while (low <= high) {
            mid = low + (high-low)/ 2;

            //days with capacity mid ;
            int load = 0 ;
            int numberDays = 0 ;

            for(int i =0 ; i<weights.length ; i++) {
                load+= weights[i] ;

                if(load>mid) {
                    numberDays++ ;
                    load = weights[i] ;
                }
            }
            if(load!=0) numberDays++ ;

            if(numberDays>days){
                low = mid+1 ;
            }else {
                high = mid - 1;
            }
        }
        return low ;
    }

    public static void main(String[] args) {

        int[] weights = {1,2,3,4,5,6,7,8,9,10} ;
        int days = 5 ;

        System.out.println(shipWithinDays(weights,days));
    }
}
