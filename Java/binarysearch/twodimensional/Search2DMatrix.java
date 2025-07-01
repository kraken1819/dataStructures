package binarysearch.twodimensional;

public class Search2DMatrix {


    public static boolean searchMatrix(int[][] matrix , int target) {
        

        //first we find in which row it is present
        // this can either be done by finding the floor in first column 
        //or by finding ceil in the last column ; 

        int m = matrix.length ; 
        int n = matrix[0].length ; 

        int low = 0 ; 
        int high = m-1 ; 
        int mid ; 

        while(low<=high){
            mid = low + (high-low)/2 ; 

            if(matrix[mid][0] == target){
                return true ; 
            }else if ( matrix[mid][0] < target){
                low = mid + 1; 
            }else{
                high = mid-1 ; 
            }

        }
        int row = high ; 
        low = 0 ; 
        high = n-1 ; 
        while(low<=high){
            mid = low + (high-low)/2 ; 
            if(matrix[row][mid]==target){
                return true ; 
            }else if(matrix[row][mid]<target){
                low = mid+1 ; 
            }else { 
                high = mid-1 ; 
            }
        }
        //System.out.println(row) ; 
        return false ; 

    }

    public static void main(String[] args){

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 9 ; 
        System.out.println(searchMatrix(matrix,target)) ; 
    }

}
