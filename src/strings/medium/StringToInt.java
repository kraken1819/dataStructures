package strings.medium;

public class StringToInt {

    public static int myAtoi(String s ){
        boolean sign = true ; 
        double result = 0 ; 
        int i =0 ; 
        while(i<s.length() && s.charAt(i)==' '){
            i++ ; 
        }
        if(!(i<s.length())) return 0 ; 
        //now we check for sign ; 
        if(s.charAt(i)=='-'){
            sign = false ; 
            i++ ; 
        }else if (s.charAt(i)=='+'){
            i++ ; 
        }
        //now we parse through the number ; 
        for(;i<s.length() ; i++){
            
            char ch = s.charAt(i) ; 
            if(!(ch>='0' && ch<='9')){
                break ; 
            }else { 
                result*=10 ; 
                result += (ch-48) ; 
            }
        }

        if(!sign) result = -1*result ; 

        if(result>Integer.MAX_VALUE) result = Integer.MAX_VALUE ; 
        if(result<Integer.MIN_VALUE) result = Integer.MIN_VALUE ; 

        return (int)result ; 


    }

    public static void main(String[] args){
        String s = " -042" ; 
        String s1 = "9223372036854775808" ; 
        System.out.println(myAtoi(s1))  ; 
    }

}
