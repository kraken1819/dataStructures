
import java.util.* ; 

public class Test3 {

    public static void main(String[] args){
        Scanner scx = new Scanner(System.in) ; 
        int t = scx.nextInt() ; 
        while(t-->0){
            int n = scx.nextInt() ; 
            long k = scx.nextLong() ; 
            int maxPossible = 2*(n-1) ; 
            if(k<=maxPossible && k%2 ==0){
                //possible 
                System.out.println("YES") ; 
                int[] ans = new int[n] ; 
                for(int i =0 ; i<n ; i++){
                    ans[i] = i+1 ; 
                }
                int q = (int)(k/2)  ; 
                int start = n-q-1 ; 
                //System.out.println(start) ; 
                //now we need to shift the array by one ; 
                int temp =ans[n-1]; 
                for(int i=n-1; i>start ; i--){
                    ans[i] = ans[i-1] ; 
                }
                ans[start] = temp ; 
                //found ans ; 
                for(int i =0 ; i<n ; i++){
                    System.out.print(ans[i] + " ") ; 
                }
            }else { 
                System.out.println("NO") ; 
            }
        }
    }
}
