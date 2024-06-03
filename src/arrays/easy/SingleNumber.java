package arrays.easy;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int res = 0 ;
        for(int i =0 ; i<nums.length ; i++) {
            res = res ^ nums[i];
        }
        return res ;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,4,5,4} ;
        int num = singleNumber(arr) ;
        System.out.println(num) ;
    }
}
