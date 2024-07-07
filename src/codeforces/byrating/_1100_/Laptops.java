package codeforces.byrating._1100_;

import java.util.*;



public class Laptops {
    

    public static void main(String[] args){
        Scanner scx = new Scanner(System.in);
        int n = scx.nextInt();
        pair[] pairArray = new pair[n] ; 
        for(int i =0 ; i<n ; i++){
            pair temp = new pair(scx.nextInt(), scx.nextInt());
            pairArray[i] = temp;
        }
        Arrays.sort(pairArray,new Comparator<pair>(){
            @Override
            public int compare(pair a,pair b){
                return a.first-b.first;
            }
        }); 

        boolean flag = false; 
        int highestsecond = pairArray[0].second;
        for(int i = 1; i<n;i++){
            if(pairArray[i].second<highestsecond){
                flag = true ; 
                break ; 
            }else{
                highestsecond = pairArray[i].second;
            }
        }
        if(flag) System.out.println("Happy Alex");
        else System.out.println("Poor Alex");

        
    }

}
class pair { 
    int first ; 
    int second ; 
    public pair(int first , int second){
        this.first = first ; 
        this.second = second;
    }
}
