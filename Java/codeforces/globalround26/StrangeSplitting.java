package codeforces.globalround26;

import java.util.* ; 

public class StrangeSplitting {

    public static void main(String[] args){
        
        Scanner scx = new Scanner(System.in) ; 

        int T  = scx.nextInt() ;
        
        while(T-->0){
            int n = scx.nextInt() ; 
            int[] nums = new int[n] ; 
            for(int i =0 ; i<n;i++){
                nums[i] = scx.nextInt() ; 
            }
            if(nums[0]==nums[n-1]){
                System.out.println("NO"); 
            }else { 
                System.out.println("YES") ; 
                String ans = "RB" ; 
                 
                for(int i = 2 ; i<n ; i++){
                    ans += "R" ;  
                }
                System.out.println(ans) ; 
                
            }
        }
    }

}
