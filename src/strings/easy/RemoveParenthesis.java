package strings.easy;

public class RemoveParenthesis {

    public static String removeOuterParenthesis(String s) { 
        StringBuilder ans = new StringBuilder() ; 

        int depth = 0 ; 
        for(int i =0 ; i<s.length() ; i++) { 
             
            if(s.charAt(i)=='('){
                depth++ ; 
                if(depth!=1) ans.append(s.charAt(i)) ;  
            }else{
                depth-- ; 
                if(depth!=0) ans.append(s.charAt(i)) ; 
            }
            //ans.append(s.charAt(i)) ; 
        }

        return ans.toString() ;  
    }

    public static void main(String[] args) { 
        String s1 = "(()())(())" ; 
        String s2 = "(()())(())(()(()))" ; 
        System.out.println(removeOuterParenthesis(s1)) ; 
        System.out.println(removeOuterParenthesis(s2)) ; 
    }

}
