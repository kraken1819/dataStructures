package strings.easy;

public class ReverseWordsString {

    public static String reverseWords(String str) { 

        StringBuilder ans = new StringBuilder() ; 
        StringBuilder temp = new StringBuilder() ; 
        for(int i =0 ; i<str.length() ; i++) { 
            if(str.charAt(i) == ' '){
                if(!temp.isEmpty()){
                    ans.insert(0,temp) ; 
                    ans.insert(0,' ') ; 
                    temp.delete(0,temp.length()) ; 
                } 
            }else { 
                temp.append(str.charAt(i)) ; 
            }
        }
        
        if(!temp.isEmpty()){
            ans.insert(0,temp) ;
            //ans.insert(0,' ') ; 
            //temp.delete(0,temp.length()) ; 
        }
        if(ans.charAt(0)==' '){
            ans.deleteCharAt(0) ; 
        }
        return ans.toString() ;

    }

    public static void main(String[] args) { 

        String str = "the sky is blue" ; 
        System.out.println(str) ; 

        System.out.println(reverseWords(str)) ; 

    }

}
