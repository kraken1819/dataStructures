import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Test1
{
    public static void main(String[] args){
        Scanner scx = new Scanner(System.in) ; 
        
        int T = scx.nextInt() ; 

        while(T-->0){
            int n = scx.nextInt() ; 

            if(n==3) System.out.println(3) ; 
            else System.out.println(2) ;   
        }
    }
}