package arrays.Hard;
import java.util.List ;
import java.util.ArrayList ;
import java.util.Arrays ;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums) ;
        List<List<Integer>> ans = new ArrayList<>() ;

        for(int i =0 ; i<nums.length-2 ; i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue ;
            int j = i+1 ;
            int k = nums.length-1 ;
            int sum ;
            while(j<k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    while (nums[j] == nums[j - 1] && j<nums.length-1) j++;
                    k--;
                    while (nums[k] == nums[k + 1] && k>0) k--;
                } else if (sum > 0) {
                    k--;
                    while (nums[k] == nums[k + 1] && k>0) k--;
                } else {
                    j++;
                    while (nums[j] == nums[j - 1] && j<nums.length-1) j++;
                }
            }
        }
        return ans ;


    }

    public static void main(String[] args) {
        int[] nums = {0,0,0} ;
        List<List<Integer>> ans = threeSum(nums) ;
        System.out.println(ans) ;
    }
}
