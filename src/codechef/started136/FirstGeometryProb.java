package codechef.started136;
import java.util.Scanner ;

public class FirstGeometryProb {

    public static void main(String[] args) {
        Scanner scx= new Scanner(System.in) ;

        int T = scx.nextInt() ;
        while(T-->0){
            String biString = scx.next() ;
            int l = biString.charAt(0)-48;
            int r = biString.charAt(1)-48;
            int u = biString.charAt(2)-48;
            int d = biString.charAt(3)-48;

            System.out.println((l*10+r*10+1)*(u*10+d*10+1)) ;

        }

    }
}
