package arrays.medium;
import java.util.ArrayList ;

public class Leaders {

    public static ArrayList<Integer> leaders(int[] arr , int n ) {
        ArrayList<Integer> answer = new ArrayList<>() ;
        int max = Integer.MIN_VALUE ;

        for(int i =arr.length-1 ; i>=0 ; i--) {
            if(arr[i]>max) {
                max = arr[i];
            }
            if(arr[i] == max) {
                answer.add(0,arr[i]) ;
            }
        }
        return answer ;

    }

    public static void main(String[] args) {
        int[] arr = {16,17,4,3,5,2} ;
        int n = arr.length ;
        ArrayList<Integer> ans = leaders(arr,n) ;
        System.out.println(ans) ;
    }
}
