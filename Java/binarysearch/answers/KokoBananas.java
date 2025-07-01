package binarysearch.answers;

public class KokoBananas {

    public static int minEatingSpeed(int[] nums , int h ) {
        int low = 1 ;
        int high = Integer.MIN_VALUE ;
        for(int i =0 ; i<nums.length ; i++) {
            if(nums[i]>high) high = nums[i] ;
        }
        int mid ;
        while(low<=high) {
            mid = low + (high - low) / 2;
            //find time taken by eating speed of mid .
            long t = 0;
            for (int i = 0; i < nums.length; i++) {
                t += nums[i] / mid;
                if (nums[i] % mid != 0) t++;
            }
            System.out.println(mid+ " " +t) ;

            if(t<=h){ // if time taken less than h , we can decrease value of mid.
                high = mid-1 ;
            }else {
                low = mid+1;
            }
        }
        return low ;
    }


    public static void main(String[] args) {
        int[] nums  = { 805306368,805306368,805306368} ;
        int h = 1000000000 ;
        System.out.println(minEatingSpeed(nums,h)) ;
    }
}
