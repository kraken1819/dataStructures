package arrays.easy;

public class CheckSorted {
    public static boolean check(int[] nums) {
        //first we will find whether one pivot is present or not .
        boolean sorted = true ;
        int count = 0 ;
        int index = 0 ;
        for(int i = 1; i<nums.length ; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                index = i ;
            }
        }
        if(count == 0 ) {
            sorted = true;
        }else if(count == 1 ){
            for(int i = index ; i<nums.length ; i++) {
                if (nums[i] > nums[0]) {
                    sorted = false;
                    break;
                }
            }
        }else {
            sorted = false;
        }
        return sorted ;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,6} ;
        System.out.println(check(arr)) ;
    }
}
