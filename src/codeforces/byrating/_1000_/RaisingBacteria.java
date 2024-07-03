//package codeforces.byrating._1000_;

import java.util.*;

public class RaisingBacteria {

    public static void main(String[] args){
        Scanner scx = new Scanner(System.in);
        int n = scx.nextInt() ;
        
        int count = 0 ; 
        while(n!=0){
            count += n&1;
            n = n>>1 ; 
        }
        System.out.println(count);
    }

}
