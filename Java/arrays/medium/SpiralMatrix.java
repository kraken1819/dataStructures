package arrays.medium;

import java.util.List ;
import java.util.ArrayList ;


public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>() ;

        int left , right , up , down  ;
        left = 0 ;
        right = matrix[0].length-1 ;
        up = 0 ;
        down = matrix.length-1 ;

        while(left<right && up < down ) {
            //from top left to top right
            for (int i = left; i < right; i++) {
                answer.add(matrix[up][i]);
            }
            //from top right to bottom right
            for (int i = up; i < down; i++) {
                answer.add(matrix[i][right]);
            }
            //from bottom right to bottom left
            for (int i = right; i > left; i--) {
                answer.add(matrix[down][i]);
            }
            //from bottom left to top left
            for (int i = down; i > up; i--) {
                answer.add(matrix[i][left]);
            }
            up++;
            down--;
            right--;
            left++;
        }
        if(up == down && left == right) {
            answer.add(matrix[up][left]);
        }else if(up == down) {
            for (int i = left; i <= right; i++) {
                answer.add(matrix[up][i]);
            }
        }else if(left == right){
            for(int i = up ; i<=down ; i++) {
                answer.add(matrix[i][left]);
            }
        }


        return answer ;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1}} ;
        List<Integer> answer = spiralOrder(matrix) ;
        System.out.println(answer) ;
    }
}
