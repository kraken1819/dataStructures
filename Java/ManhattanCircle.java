import java.util.Scanner ; 
public class ManhattanCircle {

    public static void main(String[] args) { 

        Scanner scx = new Scanner(System.in) ; 
        int t = scx.nextInt() ; 

        while(t-->0){
            int m = scx.nextInt() ; 
            int n = scx.nextInt() ; 
            char[][] grid = new char[m][n] ; 

            for(int i=0 ; i<m ; i++) { 
                String line = scx.next() ; 
                for(int j =0 ; j<n ; j++){
                    grid[i][j] = line.charAt(j) ; 
                }
            }

            int[] rowCount = new int[m] ; 
            int[] colCount = new int[n] ; 

            for(int i =0 ; i<m ; i++) { 
                for(int j =0 ; j<n ;j++){
                    if(grid[i][j]=='#'){
                        rowCount[i]++ ; 
                        colCount[j]++ ; 
                    }
                }
            }
            int rowmax = 0 ; 
            int colmax = 0 ; 
            int row =-1; 
            int col =-1; 
            for(int i =0 ; i<m;i++){
                if(rowCount[i]>rowmax){
                    rowmax = rowCount[i] ; 
                    row = i ; 
                }
            }
            for(int i =0 ; i<n;i++){
                if(colCount[i]>colmax){
                    colmax = colCount[i] ; 
                    col = i ; 
                }
            }
            System.out.println((row+1)+ " " + (col+1)) ; 


        }
    }
}
