package binarysearch.easy;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums , int target) {
        int low = 0 ;
        int high = nums.length-1 ;
        int mid ;
        while(low<=high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid ;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high+1 ;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6} ;
        int target = 3 ;
        System.out.println(searchInsert(nums,target)) ;
    }
}
