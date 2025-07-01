
package codeforces.globalround26;
// not full solution 
import java.util.* ; 
public class MagnitudeEasy {

    public static void main(String[] args) { 
        Scanner scx = new Scanner(System.in) ; 

        int T = scx.nextInt() ; 

        while(T-->0){
            int n = scx.nextInt() ; 

            int[] nums = new int[n] ; 
            long fullsum = 0 ; 
            for(int i =0 ; i<n ; i++) { 
                nums[i] = scx.nextInt() ; 
                fullsum += nums[i] ; 
            }
            //int sum 
            long sum = 0 ; 
            long ans = 0 ; 
            for(int i =0 ; i<nums.length ; i++) { 
                ans += nums[i] ; 
                sum += nums[i] ; 
                if(fullsum-sum>0){
                    if(ans<0) ans*=-1 ; 
                }
            }
            if(ans<0) ans*=-1 ; 
            System.out.println(ans) ; 

        }
    }

}
