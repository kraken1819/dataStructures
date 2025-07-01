package binarysearch.twodimensional;

public class Search2DSorted {

    public static boolean searchSortedMatrix(int[][] matrix, int target) {  
        // this in not binary search  
        //you can traverse the array from first row last element or last row first element .
        
        int m = matrix.length ; 
        int n = matrix[0].length ; 
        int row = m-1 ; 
        int col = 0 ; 

        /*
            Approach : if the element is greater we exclude that column (column++) .. 
                        if the element is lesser we exclude that row (row--) ; 

        */

        while(row>=0 && col<=n-1){
            int ele = matrix[row][col] ; 

            if(ele == target) return true ; 
            else if(ele < target) col++ ; 
            else row-- ; 

        }
        return false ; 


    }

    public static void main(String[] args){
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        }; 
        int target = 5 ; 
        System.out.println(searchSortedMatrix(matrix,target)) ; 
    }

}
