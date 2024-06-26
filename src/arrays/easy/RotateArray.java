package arrays.easy;
import java.util.Arrays ;
public class RotateArray {
    public static void swap(int[] nums , int i , int j) {
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
    public static void reverse(int[] nums , int i , int j ) {
        while(i<j) {
            swap(nums, i, j);
            i++ ;
            j-- ;
        }
    }
    public static void rotate(int[] nums , int k ) {
        reverse(nums,0,nums.length-(k+1)) ;
        reverse(nums,nums.length-k,nums.length-1) ;
        reverse(nums,0,nums.length-1) ;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7} ;
        int k = 3 ;
        rotate(nums,k) ;
        System.out.println(Arrays.toString(nums)) ;

    }

}
