package arrays.medium;
import java.util.Arrays ;
public class SortColors {
    public static void swap(int[] nums , int i , int j ) {
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }

    public static void sortColors(int[] nums) {
        int i = 0 ;
        int j = nums.length - 1;
        int mid = 0 ;
        while(mid<=j) {
            if(nums[mid]==0) {
                swap(nums, i, mid);
                i++ ;
                mid++ ;
            }else if(nums[mid]==2){
                swap(nums,j,mid) ;
                j-- ;
                // note that we didn't do mid++ here .
            } else {
                mid++ ;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0,0,2,1,2,1,0,2,1,2,2,1,1,0} ;
        sortColors(nums) ;
        System.out.println(Arrays.toString(nums)) ;
    }
}
