package codeforces.round166;
import java.util.Scanner ;

public class IncreaseDecreaseCopy {
    public static void main(String[] args) {
        Scanner scx = new Scanner(System.in) ;
        int T = scx.nextInt() ;
        while(T-->0){
            int n = scx.nextInt() ;
            int[] a = new int[n] ;
            int[] b = new int[n+1] ;
            for(int i =0 ; i<n ; i++) {
                a[i] = scx.nextInt();
            }
            for(int i =0 ; i<n+1 ; i++){
                b[i] = scx.nextInt() ;
            }

            int count = 0 ;
            int nearest ;
            int num1 ;
            int num2 ;
            int last = b[n] ;
            int closest = 0 ;
            int closeness = Integer.MAX_VALUE ;
            for(int i =0 ; i<n ; i++) {
                num1 = a[i] ;
                num2 = b[i] ;
                //finding its closest to last element .
                if(num1>=last && last<=num2){
                    closeness = 0 ;
                }else if(num2>=last && last<=num1){
                    closeness = 0 ;
                }

            }

        }
    }

}
