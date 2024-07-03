//package codeforces.byrating._1000_;

import java.util.*;

public class XeniaAndRingRoad {

    public static void main(String[] args){
        Scanner scx = new Scanner(System.in);

        int n = scx.nextInt() ; 
        int m = scx.nextInt();
        int[] tasks = new int[m] ; 
        for(int i=0 ; i<m ; i++){
            tasks[i] = scx.nextInt();
        }
        //Arrays.sort(tasks);
        int houseNumber = 1 ;  
        long time = 0 ; 
        for(int i =0 ; i<tasks.length ; i++){
            int nextHouse = tasks[i] ;
            if(nextHouse>=houseNumber){
                time += nextHouse-houseNumber;
                houseNumber = nextHouse;
            }else{
                time += n-houseNumber;
                time += nextHouse;
                houseNumber = nextHouse;
            }
        }
        System.out.println(time);
        
    }

}
