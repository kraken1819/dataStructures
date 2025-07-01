package arrays.easy;


public class MissingNumbers {
    public static void swap(int[] arr , int i , int j) {
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
    public static int missingNumber(int[] nums ) {
        //first sorting the given array
        for(int i=0 ; i<nums.length ; i++) {
            while(nums[i] != i && nums[i] != nums.length) {
                swap(nums, i, nums[i]);
            }
        }
        //searching the sorted array with releation with index
        for(int i =0 ; i<nums.length ; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length ;

    }
    public static void main(String[] args) {
        int[] nums = {0,1} ;
        int num = missingNumber(nums) ;
        System.out.println(num) ;

    }
}
