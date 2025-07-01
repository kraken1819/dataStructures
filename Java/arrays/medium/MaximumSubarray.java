package arrays.medium;

public class MaximumSubarray {
    public static int maxSubarray(int[] nums){

        int maxSum = Integer.MIN_VALUE ;
        int sum = 0 ;
        for(int i =0 ; i<nums.length ; i++ ) {
            sum += nums[i];

            if(sum>maxSum) {
                maxSum = sum;
            }

            if(sum < 0 ) {
                sum = 0;
            }
        }
        return maxSum ;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-4,-5} ;
        System.out.println(maxSubarray(nums)) ;
    }
}
