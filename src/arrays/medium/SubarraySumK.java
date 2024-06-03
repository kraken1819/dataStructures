package arrays.medium;

import java.util.HashMap;

public class SubarraySumK {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prevSums = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;

            if (sum == k) {
                count++;
            }
            int diff = sum - k;
            if (prevSums.containsKey(diff)) {
                count += prevSums.get(diff);
            }

            if(prevSums.containsKey(sum)) {
                prevSums.put(sum,prevSums.get(sum)+1) ;
            }else {
                prevSums.put(sum, 1);
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums1 = {1, -1, 0};
        int k = 3;
        int k1 = 0;
        System.out.println(subarraySum(nums, k));
        System.out.println(subarraySum(nums1, k1));

    }
}
