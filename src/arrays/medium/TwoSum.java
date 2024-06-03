package arrays.medium;
import java.util.Arrays ;
import java.util.HashMap ;
public class TwoSum {
    public static int[] twoSumBruteForce(int[] nums , int target) {
        for(int i =0 ; i<nums.length ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1,-1} ;
    }
    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer,Integer> prev = new HashMap<>() ;
        for(int i =0 ; i<nums.length ; i++ ) {
            if (prev.containsKey(target - nums[i])) {
                return new int[]{i, prev.get(target - nums[i])};
            }
            prev.put(nums[i], i);
        }
        return new int[]{-1,-1} ;

    }
    public static int[] twoSumTwoPointer(int[] nums, int target) {
        int[] storeNums = nums.clone() ;
        Arrays.sort(nums) ;
        System.out.println(Arrays.toString(storeNums)) ;
        int i =0 ;
        int j = nums.length-1 ;
        while(i<j){
            int value = nums[i] + nums[j] ;
            if(value == target) {
                int indexi = -1  ;
                int indexj = -1;
                for(int k=0 ; k<nums.length ; k++) {
                    if (nums[i] == storeNums[k]) {
                        indexi = k;
                    } else if (nums[j] == storeNums[k]) {
                        indexj = k;
                    }
                }
                return new int[]{indexi, indexj};
            } else if ( value < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1,-1} ;
    }
    public static void main(String[] args) {
        int[] nums = {2,11,7,15} ;
        int target = 9 ;
        int[] ans = twoSumTwoPointer(nums,target) ;
        System.out.println(Arrays.toString(ans)) ;

    }
}
