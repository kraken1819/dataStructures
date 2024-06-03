package binarysearch.easy;

public class PeakElement {

    public static int findPeakElement(int[] nums) {
        int low = 0 ;
        int high = nums.length-1 ;
        int mid ;

        while(low<high) {

            mid = low + (high-low)/2 ;

            if(nums[mid]<nums[mid+1]){//we are in the increasing part of the array
                low = mid+1;
            }else{
                high = mid;
            }

        }
        return low ;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4} ;
        System.out.println(findPeakElement(nums)) ;
    }
}
