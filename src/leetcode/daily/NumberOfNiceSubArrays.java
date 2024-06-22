
package leetcode.daily ; 

import java.util.HashMap ; 

public class NumberOfNiceSubArrays {

    public static int numberOfSubarrays(int[] nums , int k ) { 

        int count = 0 ; 

        HashMap<Integer,Integer> mapu = new HashMap<>() ; 
        //subarrays count with odd n ; 

        int nOdds = 0 ; 

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]%2!=0) nOdds++ ; 

            if(nOdds==k){
                count++ ; 
                if(mapu.containsKey(0)){
                    count += mapu.get(0) ; 
                }

            }else if(nOdds>k){
                int extra = nOdds-k ; 
                if(mapu.containsKey(extra)){
                    count+= mapu.get(extra) ; 
                } 
            }

            if( mapu.containsKey(nOdds) ){
                mapu.put(nOdds, mapu.get(nOdds)+1) ; 
            }else { 
                mapu.put(nOdds,1) ; 
            }
        }

        return count ; 


    }


    public static void main(String[] args){

        int[] nums = {1,1,2,1,1} ; 
        int k = 3 ; 
        System.out.println(numberOfSubarrays(nums,k)) ; 
    }

}
