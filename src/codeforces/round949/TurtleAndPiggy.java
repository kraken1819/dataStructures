package codeforces.round949;

import java.util.* ;

public class TurtleAndPiggy {

    public static void main(String[] args) {
        Scanner scx = new Scanner(System.in) ;
        int T = scx.nextInt() ;

        while(T-->0){
            int l = scx.nextInt() ;
            int r = scx.nextInt() ;

            int max = 0 ;
            for(int i =r ; i>=l ; i--){
                //System.out.println(i) ;
                int num = i ;
                int div = 2 ;
                int score = 0 ;
                while (num != 1) {
                    while(num!=1 && num%div==0) {
                        score++ ;
                        num/=div ;
                    }
                    div++ ;
                }
                if(score>max) max = score ;
            }
            System.out.println(max) ;

        }

    }
}
