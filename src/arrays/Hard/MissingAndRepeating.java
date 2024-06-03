package arrays.Hard;
import java.util.Arrays ;

public class MissingAndRepeating {

    public static int[] findTwoElement(int[] nums , int n ) {
        int[] ans = new int[2] ;
        //sorting the array
        //using cyclic sort
        for(int i =0 ; i<n ; i++) {
            while(nums[i]!=i+1){
                if(nums[i]==nums[nums[i]-1]) break ;
                int temp = nums[i] ;
                nums[i] = nums[nums[i]-1] ;
                nums[temp-1] = temp ;
            }
        }
        //finding the element
        for(int i =0 ; i<n ; i++) {
            if (nums[i] != i + 1) {
                ans[0] = nums[i];
                ans[1] = i + 1;
            }
        }

        return ans ;

    }

    public static void main(String[] args) {
        int[] nums = {1,1} ;
        int[] ans = findTwoElement(nums,nums.length ) ;
        System.out.println(Arrays.toString(ans)) ;

    }
}
