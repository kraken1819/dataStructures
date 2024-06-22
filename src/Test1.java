import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Test1
{
    public static void main(String[] args){
        Scanner scx = new Scanner(System.in) ; 
        
        int T = scx.nextInt() ; 

        while(T-->0){
            int n = scx.nextInt() ; 
            
            int[] nums = new int[n] ; 
            
            for(int i =0 ;i<n ; i++){
                nums[i] = scx.nextInt() ; 
            }

            int ans = nums[n-1] ;
            int max = Integer.MIN_VALUE ; 
            for(int i =0 ; i<n-1 ; i++){
                if(nums[i]>max){
                    max = nums[i]; ;
                }
            }
            ans+=max ; 
            System.out.println(ans) ; 

            
        }
        scx.close() ; 
    }
}