package strings.easy;

public class RotateString {

    public static boolean rotateString(String s , String goal){
        StringBuilder str = new StringBuilder().append(s) ;
        int count = s.length() ; 
        while(count-->0){
            if(str.toString().equals(goal)) return true ; 

            str.append(str.charAt(0)) ; 
            str.deleteCharAt(0) ; 
        }
        return false ; 

    }
    public static void main(String[] args){ 

        String s =  "abcde" ; 
        String goal = "deab" ; 
        System.out.println(rotateString(s,goal)) ; 
    }

}
