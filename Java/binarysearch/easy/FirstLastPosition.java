package binarysearch.easy;
import java.util.Arrays ;

public class FirstLastPosition {

    public static int[] searchRange(int[] nums , int target) {

        int low =0 ;
        int high = nums.length-1 ;
        int mid ;
        boolean present = false ;
        while(low<=high ) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                present = true;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if(!present) return new int[]{-1,-1} ;
        int[] ans = new int[2] ;
        ans[1] = low-1 ;
        low = 0 ;
        high = nums.length-1 ;
        while(low<=high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        ans[0] = high+1 ;
        return ans ;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10} ;
        int target = 7 ;
        System.out.println(Arrays.toString(searchRange(nums,target)) );
    }
}
