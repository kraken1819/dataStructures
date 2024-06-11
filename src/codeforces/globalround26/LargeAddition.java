package codeforces.globalround26;

import java.util.Scanner;
import java.util.* ; 

public class LargeAddition {

    public static void main(String[] args) { 
        Scanner scx = new Scanner(System.in) ; 

        int T = scx.nextInt() ; 
        while(T-->0){
            long n = scx.nextLong() ; 
            ArrayList<Integer> digitSums = new ArrayList<>() ; 

            while(n>=10){     
                int digit = (int)(n%10) ; 
                digit+=10 ; 
                digitSums.add(digit) ; 
                n/=10 ;
                n-- ; 
            }
            if(n!=0){
                System.out.println("NO") ; 
            }else { 
                boolean bool = true ; 
                for(int i=0 ; i<digitSums.size() ; i++){
                    if(digitSums.get(i)<10 || digitSums.get(i)>18){
                        bool = false ; 
                        break ; 
                    }
                }
                if(bool) System.out.println("YES") ; 
                else System.out.println("NO") ;
            }

        }
    }

}
