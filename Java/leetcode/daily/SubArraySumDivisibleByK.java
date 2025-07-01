package leetcode.daily ; 

import java.util.HashMap ;
import java.util.Map;
import java.util.ArrayList ; 

/*
    you can do it using normal prefix sum map approach but it will lead to time complexity 
        when finding for removing the suitable sub array . 
    Appraoch : use a similar method but do it for reminders . which would reduce the search space . 

 */

public class SubArraySumDivisibleByK {


    public static int subArrayDivbyK(int[] nums , int k ) { 

        HashMap<Integer,Integer> mapu = new HashMap<>() ; 
        //ArrayList<Integer> sumu = new ArrayList<>() ; 
        mapu.put(0,1) ; 

        int sum = 0 ; 
        int count = 0 ; 

        for(int i =0 ; i<nums.length ; i++) { 
            sum += nums[i] ;
            //sum += k ; //if the value becomes negative 
            sum %= k ; //making everything in terms of reminder  
            sum += k ; 
            sum %=k ; // if sum becomes negative part . 
    

            if(mapu.containsKey(sum)){
                count += mapu.get(sum) ; 
                mapu.put(sum,mapu.get(sum)+1) ; 
            }else { 
                mapu.put(sum,1) ; 
            }
        }
        return count ; 

    }

    public static void main(String[] args) { 
        int[] nums = {4,5,0,-2,-3,1} ; 

        

        int k = 5 ; 
        System.out.println(subArrayDivbyK(nums,k)) ; 
    }
}
