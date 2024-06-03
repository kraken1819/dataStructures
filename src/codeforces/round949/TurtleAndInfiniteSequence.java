package codeforces.round949;

import java.util.Scanner ;
import java.util.ArrayList ;

public class TurtleAndInfiniteSequence {

    public static String convertToBinary(int n ) {
        int floor = 1;
        int len = 0;
        while (floor < n) {
            floor *= 2;
            len++;
        }
        floor /= 2;
        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            if (floor < n) {
                n -= floor;
                ans.append('1');
            } else {
                ans.append('0');
            }
            floor /= 2;
        }

        return ans.toString();
    }

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
            ArrayList<String> binaryString = new ArrayList<>() ;
            int low = n-m ;
            int high = n+m;
            if(low<0) {
                low = 0;
            }
            for(int i =low ; i<=high ; i++) {
                binaryString.add(convertToBinary(i)) ;
            }
            //now we need to apply | operator for each element ;
            int len = binaryString.get(binaryString.size()-1).length() ;

            //make all the string to same length ;
            for(int i =0 ; i<binaryString.size() ; i++){
                while(binaryString.get(i).length() != len){
                    binaryString.set(i,'0' + binaryString.get(i)) ;
                }
            }
            int[] binaryAnswer = new int[len] ;
            for(int i =0 ; i<len ; i++) {
                for(int j =0 ; j<binaryString.size() ; j++){
                    if(binaryString.get(j).charAt(i)=='1') {
                        binaryAnswer[i] = 1 ;
                        break ;
                    }
                }
            }
            //convert the binary answer to decimal answer .
            int answer = 0 ;
            for(int i = 0 ;  i<binaryAnswer.length ; i++) {
                answer += binaryAnswer[i]*Math.pow(2,binaryAnswer.length-i-1) ;
            }
            System.out.println(answer) ;
        }
    }
}
