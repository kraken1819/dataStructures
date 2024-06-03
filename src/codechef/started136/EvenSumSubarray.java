package codechef.started136;

import java.util.Scanner ;

public class EvenSumSubarray {

    public static void main(String[] args) {
        Scanner scx = new Scanner(System.in) ;
        int T = scx.nextInt() ;
        while(T-->0){
            int n  = scx.nextInt() ;
            int[] nums = new int[n] ;
            for(int i =0 ; i<n ; i++){
                nums[i] = scx.nextInt() ;
            }
            //now we find the smallest part that has odd sum ;
            int oddSumIndex = -1 ;
            int sum = 0 ;
            for(int i =0 ; i<n ; i++)  {
                sum+=nums[i] ;
                if(sum%2!=0){
                    oddSumIndex =i ;
                    break ;
                }
            }
            //now iterate through the array and find the longest subarray.

            sum = 0 ;
            int maxLength = 0 ;

            for(int i = 0 ; i<nums.length ; i++){
                sum+= nums[i] ;
                if(sum%2==0){
                    int len = i+1 ;
                    maxLength = len ;
                }else if(oddSumIndex>=0 &&i>oddSumIndex){
                    //if odd sum possible and offsum is sub part of present sub array .
                    int len = i+1 - (oddSumIndex+1) ;
                    if(len>maxLength) maxLength=len ;
                }
            }
            System.out.println(maxLength) ;



        }
    }
}
