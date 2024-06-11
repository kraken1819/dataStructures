package strings.medium;

public class NestingDepth {

    public static int maxDepth(String s) { 
        int max = 0 ; 
        int depth = 0 ; 
        for(int i =0 ; i<s.length() ; i++){
            if(s.charAt(i)=='('){
                depth++ ; 
                if(depth>max) max = depth ; // comparing for max element 
            }else if ( s.charAt(i)==')'){
                depth-- ; 
            }
        }
        return max ; 
    }

    public static void main(String[] args){
        String s = "(1+(2*3)+((8)/4))+1" ; 
        System.out.println(maxDepth(s)) ; 
    }

}
