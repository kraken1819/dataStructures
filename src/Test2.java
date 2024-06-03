import java.util.Scanner ;
import java.lang.Math;
import java.util.Arrays ;
public class Test2 {

    public static int func(int[] abc,int count) {
        int[] a = {1,2,3,4,5} ;

        for(int i = 0 ; i<a.length ; i++) {
            abc[i] = a[i];
        }
        return 5 ;
    }

    public static void main(String[] args) {

        int[] abc = {1,2,4,5,3} ;
        int count = 10 ;
        count += func(abc,count) ;
        System.out.println(Arrays.toString(abc)) ;
        System.out.println(count) ;

    }
}
