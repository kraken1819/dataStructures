package binarysearch.easy;

public class MinimumInRotateSortedArray {

    public static int findMin(int[] nums) {
        if(nums[0] < nums[nums.length-1]) return nums[0] ;
        int low = 0 ;
        int high = nums.length-1 ;
        int mid ;
        while(low<=high){
            mid = low + (high-low)/2 ;
            if(nums[mid]>=nums[0]){
                low = mid+1 ;
            }else {
                high = mid - 1;
            }
        }
        return nums[low] ;
    }

    public static void main(String[] args){
        int[] nums = {1,3,4,5} ;
        System.out.println(findMin(nums)) ;

    }
}
