package arrays.Hard;

import java.util.HashMap ;

public class LargestSubarrZeroSum {
    public static int maxLen(int[] nums) {
        HashMap<Integer,Integer> presum = new HashMap<>() ;

        int sum = 0 ;
        int maxlen = Integer.MIN_VALUE ;
        for(int i =0 ; i<nums.length ; i++ ) {
            sum += nums[i];

            if (sum == 0) {
                maxlen = i + 1;
            } else {
                if (presum.containsKey(sum)) {
                    int len = i + 1 - presum.get(sum);
                    if (len > maxlen) maxlen = len;
                }
                presum.putIfAbsent(sum, i + 1);
            }
        }
        return maxlen ;


    }

    public static void main(String[] args) {
        int[] nums = {15,-2,2,-8,1,7,10,23} ;
        System.out.println(maxLen(nums)) ;
    }
}
