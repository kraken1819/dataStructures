package codeforces.byrating._1000_;

import java.util.* ;

public class NewYearTransportation {
    public static void main(String[] args){
        Scanner scx = new Scanner(System.in);
        int n = scx.nextInt() ; 
        int target = scx.nextInt();

        int[] a = new int[n-1] ; 
        for(int i =0 ; i<n-1 ; i++){
            a[i] = scx.nextInt();
        }

        boolean[] checked = new boolean[n] ; 
        boolean flag = false ; 
        
        int start = 0 ; 
        while(start<target){
            if(start == target-1){
                flag = true ; 
                break ; 
            }
            start += a[start];
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");

        

    }
}
