package strings.easy ; 


public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs){

        StringBuffer ans = new StringBuffer() ; 
        ans.append(strs[0]) ; 

        for(int i =0 ; i<strs.length; i++){
            if(ans.length()==0) return ans.toString() ; 

            while(!(ans.toString().equals(strs[i].substring(0,Math.min(ans.length(),strs[i].length()))))){
                ans.deleteCharAt(ans.length()-1) ; 
            }

        }

        return ans.toString() ;
    }

    public static void main(String[] args) { 
        String[] strings = {"flower" , "ow" , "flight"} ; 
        System.out.println(longestCommonPrefix(strings)) ; 
    }

}
