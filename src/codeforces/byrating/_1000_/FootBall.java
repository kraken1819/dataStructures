//package codeforces.byrating._1000_;

import java.util.*;

public class FootBall {
    public static void main(String[] args){
        Scanner scx = new Scanner(System.in);
        int n = scx.nextInt();

        int score1 = 0 ; 
        int score2 = 0 ;
        
        String team1 ="";
        String team2 =""; 

        for(int i= 0 ; i<n ; i++){
            if(i==0) {
                team1 = scx.next(); 
                score1++ ; 
            }else{
                String tempTeam=scx.next();
                if(tempTeam.equals(team1)){
                    score1++;
                }else {
                    score2++ ;
                    team2 = tempTeam;
                } 
            }
            if(score1>n/2 || score2>n/2) {  
                break;
            }
            
        } 
        if(score1>score2) System.out.println(team1);
        else System.out.println(team2);
    }

}
