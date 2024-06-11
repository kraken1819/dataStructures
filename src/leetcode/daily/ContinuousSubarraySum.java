package leetcode.daily;

import java.util.HashMap ; 
public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums , int k ) { 

        HashMap<Integer,Integer> mapu = new HashMap<>() ; 
        int sum = 0 ; 
        for(int i =0 ; i<nums.length ; i++) { 
            sum += nums[i] ; 
            sum %= k ; 
            
            if(sum==0){
                return true ; 
            }else{
                if(mapu.containsKey(sum)){
                    int len = i - mapu.get(sum) ; 
                    if(len >=2) {
                        return true ; 
                    }
                }else { 
                    mapu.put(sum,i) ; 
                }
            }
        }
        return false ; 
    }

    public static void main(String[] args){
        int[] nums = {23,2,6,4,7} ; 
        int target = 13 ; 
        System.out.println(checkSubarraySum(nums,target)) ; 
    }

}
