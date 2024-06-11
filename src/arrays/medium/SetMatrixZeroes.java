package arrays.medium;
import java.util.Arrays ;
import java.util.HashSet ;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>() ;
        HashSet<Integer> cols = new HashSet<>() ;
        int n = matrix.length ;
        int m = matrix[0].length ;
        for(int i =0 ; i<n ; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Integer[] rowArray = rows.toArray(new Integer[0]) ;
        Integer[] colArray = cols.toArray(new Integer[0]) ;
        for(Integer row : rowArray) {
            for (int i = 0; i < m; i++) {
                matrix[row][i] = 0;
            }
        }
        for(Integer col : colArray) {
            for (int i = 0; i < n; i++) {
                matrix[i][col] = 0;
            }
        }
        return ;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}} ;
        setZeroes(matrix) ;
        for(int[] row :matrix) {
            System.out.println(Arrays.toString(row)) ;
        }
    }
}
