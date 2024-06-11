package strings.easy;

import java.util.HashMap ; 
import java.util.Map ; 

public class ValidAnagram {

    public static boolean isAnagram(String s , String t){

        if(s.length()!=t.length()) return false ; 

        HashMap<Character,Integer> mapu = new HashMap<>() ; 
        for(int i=0 ; i<s.length() ; i++){
            if(mapu.containsKey(s.charAt(i))) mapu.put(s.charAt(i) , mapu.get(s.charAt(i))+1) ;
            mapu.putIfAbsent(s.charAt(i),1) ; 
            
        }
        for(int i =0 ; i<t.length();i++){
            if(mapu.containsKey(t.charAt(i))){
                mapu.put(t.charAt(i),mapu.get(t.charAt(i))-1) ; 
            }else{
                return false ; 
            }
        }

         
        for(Map.Entry<Character,Integer> entry:mapu.entrySet()){
            if(entry.getValue()!=0) {

                return false ;  
            }
        }
        return true ; 
    }

    public static void main(String[] args) { 
        String s = "anagram" ; 
        String t = "nagaram" ; 
        System.out.println(isAnagram(s,t)) ; 
    }

}
