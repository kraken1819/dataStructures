package arrays.Hard;
import java.util.Arrays ;
import java.util.List ;
import java.util.ArrayList ;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums , int target) {
        List<List<Integer>> ans = new ArrayList<>() ;
        Arrays.sort(nums) ;
        for(int i =0 ; i<nums.length-2 ; i++ ) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length-1 ; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = nums.length - 1;
                long sum;
                while (k < l) {
                    sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        while (k < l &&nums[k] == nums[k - 1] ) k++;
                        l--;
                        while (l > k && nums[l] == nums[l + 1] ) l--;
                    } else if (sum > target) {
                        l--;
                        while (nums[l] == nums[l + 1] && l > k) l--;
                    } else {
                        k++;
                        while (nums[k] == nums[k - 1] && k < l) k++;
                    }
                }
            }
        }
        return ans;
    }
    public static List<List<Integer>> fourSum1(int[] nums , int target) {
        int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000} ;
        int target = -294967296 ;
        List<List<Integer>> ans = fourSum(nums,target) ;
        System.out.println(ans) ;
    }
}
