package codechef.started136;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


//ended with Time Limit Exceeded output .
public class SumOfModes {


    public static void main(String[] args) {
        Scanner scx = new Scanner(System.in) ;
        int T = scx.nextInt() ;
        while(T-->0){
            int n = scx.nextInt() ;
            String str = scx.next() ;
            int sum = 0 ;

            

            for(int i =0 ; i<n ; i++) {
                int zs = 0;
                int os = 0;
                for (int j = i; j < n; j++) {
                    if (str.charAt(j) == '0') zs++;
                    else os++;
                    //at every string

                    if (zs == os) sum += 2;
                    else sum++;
                }
            }
            System.out.println(sum) ;
        }
    }
}
