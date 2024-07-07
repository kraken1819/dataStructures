package codeforces.round956_;

import java.util.*;


public class CornerTwist {
    public static void main(String[] args){
        Scanner scx = new Scanner(System.in);
        int T = scx.nextInt();
        while(T-->0){
            int n = scx.nextInt();
            int m = scx.nextInt();
            int[][] beforeGrid = new int[n][m];
            for(int i=0 ; i<n ; i++){
                String line = scx.next();
                for(int j=0 ; j<m ; j++){
                    beforeGrid[i][j] = line.charAt(j);
                }
            }
            int[][] afterGrid = new int[n][m];
            for(int i=0 ; i<n ; i++){
                String line = scx.next();
                for(int j=0 ; j<m ; j++){
                    afterGrid[i][j] = line.charAt(j);
                }
            }
            System.out.println("----------------");
            //difference grid ; 
            int[][] diffGrid = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j =0 ;j<m;j++){
                    diffGrid[i][j] = afterGrid[i][j] - beforeGrid[i][j];
                }
            }
            //find pairs
            boolean[][] checked = new boolean[n][m];

            boolean flag = true ; 
            for(int i =0 ; i<n;i++){
                for(int j=0 ; j<m ; j++){
                    //
                    int first = diffGrid[i][j];
                    for(int p = i+1 ; p<n;p++){
                        if(checked[i][j]) break ; 
                        for(int q= j+1 ; q<m ; q++){
                            if( (!checked[p][q]) && (!checked[i][q-j]) && (!checked[p-i][j])){
                                int second = diffGrid[p][q];
                                int third = diffGrid[i][q-j];
                                int fourth = diffGrid[p-i][j];
                                if(first == second && third == fourth){
                                    checked[i][j] = true ; 
                                    checked[p][q] = true ; 
                                    checked[i][q-j] = true ; 
                                    checked[p-i][j] = true ; 
                                    break ; 
                                }
                            }
                        }
                    }
                    if(!checked[i][j]){
                        flag = false ; 
                        break ; 
                    }

                }   
                if(!flag) break ; 
                
            }
            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }

    }
    
}
