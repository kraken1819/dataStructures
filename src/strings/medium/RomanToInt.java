package strings.medium;

import java.util.HashMap ; 

public class RomanToInt {

    public static int romanToInt(String s){

        HashMap<Character,Integer> mapu = new HashMap<>() ; 
        mapu.put('I',1) ; 
        mapu.put('V',5) ; 
        mapu.put('X',10) ; 
        mapu.put('L',50) ; 
        mapu.put('C',100) ; 
        mapu.put('D',500) ; 
        mapu.put('M',1000) ; 

        int result = 0 ; 

        for(int i =0 ; i<s.length()-1 ; i++){
            if(mapu.get(s.charAt(i)) < mapu.get(s.charAt(i+1))){
                result -= mapu.get(s.charAt(i)) ; 
            }else{
                result += mapu.get(s.charAt(i)) ; 
            }
        }
        result+=mapu.get(s.charAt(s.length()-1)) ; 
        return result ; 


    }

    public static void main(String[] args) { 
        String s = "MCMXCIV" ; 
        System.out.println(romanToInt(s)) ; 
    }

}
