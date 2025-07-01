package arrays.Hard;

public class MaximumProductSubArray {
    public static int maxProduct(int[] nums) {
        int max = nums[0] ;
        int pre = 1 ;
        int suff = 1 ;
        for(int i =0 ; i<nums.length ; i++ ) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= nums[i];
            suff *= nums[nums.length - i - 1];
            if (pre > max) max = pre;
            if (suff > max) max = suff;
        }
        return max ;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,-1} ;
        System.out.println(maxProduct(nums)) ;


    }
}
