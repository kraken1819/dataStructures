package leetcode.daily;

import java.util.TreeMap ; 
import java.util.Arrays ; 
import java.util.Map ; 



public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1 , int[] arr2){
        TreeMap<Integer,Integer> mapu = new TreeMap<>() ; 
        for(int i =0 ; i<arr1.length ; i++){
            if(mapu.containsKey(arr1[i])){
                mapu.put(arr1[i], mapu.get(arr1[i])+1) ;
            }else{
                mapu.put(arr1[i],1) ; 
            }
        }
        //[ {1:0},{2:0},{4:0},{6:1} ] 

        //
        int i =0 ;
        int[] ans = new int[arr1.length] ;  
        for(int ele : arr2){
            int value = mapu.get(ele) ;
            
            while(value-- > 0){
                ans[i++] = ele ;  
            }
            mapu.put(ele,0) ; 
        }
        //now we traverse the map 
        

        //

        for(Map.Entry<Integer,Integer> entry : mapu.entrySet()){
            if(entry.getValue()!=0){
                int value = entry.getValue() ; 
                while(value-->0){
                    ans[i++] = entry.getKey() ;  
                }
                entry.setValue(0) ; 
            }
        }
        return ans ; 

    }
    // (key,value)
    public static void main(String[] args){

        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19} ; 
        int[] arr2 = {2,1,4,3,9,6} ; 
        

        System.out.println(Arrays.toString(relativeSortArray(arr1,arr2))) ; 
        
    }

}
