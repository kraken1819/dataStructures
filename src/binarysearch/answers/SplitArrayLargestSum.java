package binarysearch.answers;

public class SplitArrayLargestSum {


    public static int splitArray(int[] nums , int k ) {

        if(nums.length < k ) return -1 ;

        int low = Integer.MIN_VALUE ;
        int high = 0 ;
        for(int i=0 ; i<nums.length ; i++) {
            if (nums[i] > low) low = nums[i];
            high += nums[i];
        }

        int mid ;
        while(low<=high){
            mid = low + (high-low)/2 ;

            //we need to find number of parts we can make with this mid

            int nparts = 0 ;
            int sum = 0 ;
            for(int i =0 ; i<nums.length ; i++){
                sum += nums[i] ;
                if(sum>mid){
                    nparts++ ;
                    sum = nums[i] ;
                }
            }
            if(sum>0) nparts++ ;
            //

            if(nparts > k){
                low = mid+1 ;
            }else {
                high = mid -1 ;
            }

        }
        return low ;

    }

    public static void main(String[] args) {

        int[] nums= {7,2,5,10,8} ;
        int k = 2 ;
        System.out.println(splitArray(nums,k)) ;
    }
}
