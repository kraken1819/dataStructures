package codeforces.byrating._1100_;

import java.util.*;


public class SerejaAndSuffixes {

    public static void main(String[] args){
        Scanner scx = new Scanner(System.in);

        int n = scx.nextInt();
        int m = scx.nextInt();
        int[] nums = new int[n] ; 
        for(int i=0 ; i<n ; i++){
            nums[i] = scx.nextInt();
        }
        int[] queries = new int[m];
        for(int i=0 ; i<m ; i++){
            queries[i] = scx.nextInt();
        }
        HashMap<Integer,Integer> mapu = new HashMap<>();
        int[] dp = new int[n] ; 
        for(int i= n-1 ; i>=0 ; i--){
            int number = nums[i] ; 
            if(mapu.containsKey(number)){
                int count = mapu.get(number);
                mapu.put(number,count+1);
            }else{
                mapu.put(number,1);
            }
            dp[i] = mapu.size();
        }
        for(int i=0 ;i<m;i++){
            System.out.println(dp[queries[i]-1]);
        }

    }

}
