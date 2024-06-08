package leetcode.biweekly132;

import java.util.Scanner ;


public class ClearDigits {

    public static String clearDigits(String str) {
        int j = 0 ; //pointing to nearest non digit number .
        StringBuilder answer = new StringBuilder()  ;

        for(int i =0 ; i<str.length() ; i++){
            if(str.charAt(i)>=48 && str.charAt(i)<=57){
                //ele is digit
                if(!answer.isEmpty()){
                    answer.deleteCharAt(answer.length()-1) ;
                }


            }else{
                //ele is non-digit
                j = i ;
                answer.append(str.charAt(j)) ;

            }
        }

        return answer.toString() ;
    }

    public static void main(String[] args) {
        Scanner scx = new Scanner(System.in) ;

        String str = scx.next() ;



        System.out.println(clearDigits(str)) ;

    }
}
