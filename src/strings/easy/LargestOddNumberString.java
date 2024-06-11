package strings.easy;

public class LargestOddNumberString {

    public static String largestOddNumber(String num) { 
        int i; 

        for( i = num.length()-1; i>=0 ; i--){
            if(num.charAt(i)%2!=0){
                break ; 
            }
        }
        String ans = num.substring(0, i+1) ; 
        return ans ; 
    }
    public static void main(String[] args) { 
        String num = "152478" ; 
        System.out.println(largestOddNumber(num)) ; 
    }

}
