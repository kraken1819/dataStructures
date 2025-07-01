package leetcode.weekly.weekly401;

public class BallAfterKSeconds {

    public static int numberOfChild(int n , int k ) { 
        int i =0 ; 
        if(n==1) return i ; 
        boolean increment = true ; 
        while(k-->0){
            if(increment){
                
                i++ ; 
                if(i==n){
                    increment = false ; 
                    i= n-2 ; 
                }
            }
            else {
                i--; 
                if(i==-1){
                    increment = true ; 
                    i = 1 ; 
                }
            }
        }
        return i ; 
    }

    public static void main(String[] args){
        int n = 2 ; 
        int k = 2 ; 
        
        System.out.println(numberOfChild(n,k)) ; 


    }

}
