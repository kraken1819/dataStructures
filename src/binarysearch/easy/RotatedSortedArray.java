package binarysearch.easy;

public class RotatedSortedArray {

    public static int Bsearch(int[] nums, int target , int i , int j) {
        int low = i ;
        int high = j ;
        int mid ;
        while(low<=high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1 ;
    }
    public static int search(int[] nums , int target) {
        int low = 0 ;
        int high = nums.length-1 ;
        int mid ;
        while(low<=high) {
            mid = low + (high - low) / 2;
            if (nums[mid] >= nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int peakIndex = high ;
        if(target>nums[peakIndex]) return -1 ;
        if(target<nums[0]) {
            return Bsearch(nums, target, peakIndex + 1, nums.length - 1);
        }else {
            return Bsearch(nums,target,0,peakIndex) ;
        }
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2} ;
        int target = 7 ;
        System.out.println(search(nums,target)) ;
    }
}
