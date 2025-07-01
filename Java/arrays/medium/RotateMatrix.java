package arrays.medium;
import java.util.Arrays ;
public class RotateMatrix {

    public static void rotate(int[][] nums) {
        /*
            Approach: Transpose the given matrix and reverse each row .
         */
        int n = nums.length ;
        if(n==1) return  ;

        //transpose
        for(int row = 0 ; row<n ; row++) {

            for(int i = row+1 ; i<n ; i++) {
                //swap them elements
                int temp = nums[row][i];
                nums[row][i] = nums[i][row];
                nums[i][row] = temp;
            }
        }
        //reverse each row
        for(int row =0; row<n ; row++) {
            for (int i = 0; i < (n - 1) / 2; i++) {
                int temp = nums[row][i];
                nums[row][i] = nums[row][n - i - 1];
                nums[row][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}} ;
        rotate(nums) ;

        for(int[] row : nums) {
            System.out.println(Arrays.toString(row));
        }

    }
}
