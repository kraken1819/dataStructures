package arrays.medium;
import java.util.Arrays ;
public class RearrangeArray {
    public static int[] rearrangeArray(int[] nums) {
        int i = 0 ;
        int j = 0 ;
        int[] ans = new int[nums.length] ;
        int k = 0 ;
        while(k<nums.length) {
            while(nums[i]<0) {
                i++;
            }
            while(nums[j]>0){
                j++ ;
            }

            ans[k++] = nums[i++] ;
            ans[k++] =nums[j++] ;
        }
        return ans ;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4} ;
        int[] ans = rearrangeArray(nums) ;
        System.out.println(Arrays.toString(ans)) ;
    }
}
