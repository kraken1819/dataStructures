import java.util.* ;
public class Test {

    public static boolean isValidSudoku(char[][] board) {

        //check if the digits are in the range 1-9 ;
        // -48 is for converting ascii values to digital value .
        // ascii value for
        //0-48 , 1-49 , 2-50 ...
        for(int i =0 ; i<board.length ; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]!='.'){
                    if (!(board[i][j]-48>0 && board[i][j]-48<10)){
                        return false ;
                    }
                }
            }
        }

        boolean[][] sub = new boolean[3][3] ;
        /*
            Appraoch : We will iterate to each element in the board and update its value in the hash table .
            and finally check if the board is valid or not . this reduces the order of complexity from o(m*n*(m+n)) to
            o(m*n) ;
         */
        int[][] rowHashTable = new int[10][10] ;
        int[][] colHashTable = new int[10][10] ;
        for(int i =0 ; i<9 ; i++) {
            for(int j =0 ; j<9 ; j++) {
                if(board[i][j] == '.') continue ;
                //checking for the sub box elements ;
                if(!sub[i/3][j/3]){
                    int[] hash = new int[10] ;
                    for(int k = 0 ; k<3 ; k++) {
                        for (int l = 0; l < 3; l++) {
                            if(board[(i/3)*3+k][(j/3)*3+l] != '.') {
                                hash[board[(i/3)*3+k][(j/3)*3+l]-48]++ ;
                            }
                        }
                    }
                    for(int val : hash) {
                        if(val>1) {
                            return false ;
                        }
                    }
                    sub[i/3][j/3] = true ;
                }
                //check the row
                //check the column .
                //update the hash table
                rowHashTable[i][board[i][j]-48]++ ;
                colHashTable[board[i][j]-48][j]++ ;
            }
        }
        for(int i =0 ; i<10 ; i++ ) {
            for (int j = 0; j < 10; j++) {
                if(rowHashTable[i][j]>1) return false ;
            }
        }
        for(int i =0 ; i<10 ; i++) {
            for (int j = 0; j < 10; j++) {
                if (colHashTable[i][j] > 1) return false;
            }
        }
        return true ;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(board)) ;
    }

}

/*
[[".",".",".",".","5",".",".","1","."],
[".","4",".","3",".",".",".",".","."],
[".",".",".",".",".","3",".",".","1"],
["8",".",".",".",".",".",".","2","."],
[".",".","2",".","7",".",".",".","."],
[".","1","5",".",".",".",".",".","."],
[".",".",".",".",".","2",".",".","."],
[".","2",".","9",".",".",".",".","."],
[".",".","4",".",".",".",".",".","."]]
 */