package codeforces.byrating._1100_;

import java.util.*;

public class NegativesAndPositives {

    public static void main(String[] args){
        Scanner scx = new Scanner(System.in);
        int T  = scx.nextInt();

        while(T-->0){
            int n = scx.nextInt();
            int[] nums = new int[n] ; 
            for(int i =0 ; i<n;i++){
                nums[i] = scx.nextInt();
            }
            int negatives = 0 ; 
            long sum = 0 ; 
            int min = Integer.MAX_VALUE;
            for(int i =0 ; i<n ; i++){
                if(nums[i]<=0) negatives++;

                if(Math.abs(nums[i])<min) min = Math.abs(nums[i]);

                sum+=Math.abs(nums[i]);
            }
            
            if((negatives&1) == 0){//indicates this is even
                System.out.println(sum);
            }else{
                System.out.println(sum-2*min);
            }
        }
    }

}
