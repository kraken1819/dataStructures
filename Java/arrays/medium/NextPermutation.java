package arrays.medium;
import java.util.Arrays ;

public class NextPermutation {
    public static void swap(int[] nums , int i , int j) {
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }

    public static int[] nextPermutation(int[] nums) {
        for(int i = nums.length-1 ; i>0 ; i--) {
            if (nums[i] > nums[i - 1]) {
                //find the number that is just greater then present number
                int k = nums.length-1 ;
                while(nums[k]<nums[i-1]){
                    k-- ;
                }
                swap(nums ,i-1 , k) ;
                Arrays.sort(nums,i,nums.length) ;
                return nums ;
            }

        }
        Arrays.sort(nums) ;
        return nums ;
    }

    public static void main(String[] args) {
        int[] abc = {2, 1, 3} ;
        System.out.println(Arrays.toString(nextPermutation(abc))) ;
    }
}
