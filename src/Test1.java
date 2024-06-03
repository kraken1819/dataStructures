import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Test1
{
    public static void main(String[] args) {
        Scanner scx = new Scanner(System.in) ;
        int t = scx.nextInt() ;
        while(t-->0){
            int n = scx.nextInt();
            int m = scx.nextInt() ;
            if(m==0){
                System.out.println(n) ;
                continue ;
            }
            else if(n == 0){
                int ans = 0;
                for(int i = 0; i <= m; i++){
                    ans = ans | i;
                }
                System.out.println(ans);
            }
            else{

                int ans = 0;

                int low = n-m ;
                int high = n+m;

                if(low<0) {
                    low = 0;
                }

                for(int i = low;i<=high;i++){
                    ans = ans | i;
                }
                System.out.println(ans);
            }
        }
    }
}