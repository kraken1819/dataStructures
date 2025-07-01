package strings.easy;

import java.util.HashMap ; 

public class IsomorphicString {

    public static boolean isIsomorphic(String s , String t) { 
        HashMap<Character, Character> mapu = new HashMap<>() ; 
        if(s.length()!=t.length()) return false ; //if lengths are not equal .

        for(int i =0 ; i<s.length() ; i++){
            if(mapu.containsKey(s.charAt(i))){
                if(mapu.get(s.charAt(i)) != t.charAt(i)) return false ; 
            }else { 
                mapu.put(s.charAt(i),t.charAt(i)) ; 
            }
        }
        return true ; 
    }


    public static void main(String[] args) { 
        String s = "egg" ; 
        String t = "abd" ; 
        System.out.println(isIsomorphic(s,t)) ; 
    }
}
