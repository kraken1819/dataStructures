package arrays.easy;
import java.util.* ;

public class MoveZeroes {

    public static void swap(int[] nums , int i , int j ) {
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
    public static void moveZeros(int[] nums) {
        //first find the last index without zeroes
        int k = nums.length-1 ;

        while(nums[k] == 0 ) {
            if(k == 0 ) {
                return;
            }
            k--;
        }
        int i =0 ;
        while(i<k) {
            if (nums[i] == 0) {
                //move all the elements 1 step before ;
                for(int q=i;q<k;q++){
                    nums[q]=nums[q+1] ;
                }
                nums[k]= 0 ;
                while(nums[k]==0){
                    k-- ;
                }
            } else {
                i++;
            }
        }

    }
    public static void main(String[] args) {
        int[] nums = {0,0,1} ;
        moveZeros(nums) ;
        System.out.println(Arrays.toString(nums)) ;
    }
}
