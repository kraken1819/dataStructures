package leetcode.weekly.weekly402;

import java.util.HashMap ;
import java.util.Arrays;

public class CountPairs {

    public static long countPairsTwoSum(int[] nums) {
         
        long count = 0 ; 
        HashMap<Integer,Long> mapu = new HashMap<>() ; 
        for(int i =0 ;i<nums.length ; i++){
            int value = nums[i]%24 ; 
            if(mapu.containsKey(value)){
                mapu.put(value,mapu.get(value)+1) ; 
            }else{
                mapu.put(value , 1L) ; 
            }
        }
        for(int i =0 ; i<=12 ; i++){
            if(!mapu.containsKey(i)) continue ; 

            if(i==12 || i==0){
                long tempCount = mapu.get(i) ; 
                long ncr = (tempCount*(tempCount-1))/(2L) ; 
                count+= ncr ; 
            }else{
                if(mapu.containsKey(24-i)){
                    //System.out.println("[ " + i + "," + (24-i) + "]") ; 

                    long leftCount = mapu.get(i) ; 
                    long rightCount = mapu.get(24-i) ; 
                    count += leftCount*rightCount ; 
                }
            }
        }
        return count ; 

    }
    public static void main(String[] args){
        int[] nums = {12,12,30,24,24} ; 
        System.out.println(countPairsTwoSum(nums)) ; 
    }



}
