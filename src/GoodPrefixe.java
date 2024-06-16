import java.util.Scanner ; 
import java.util.HashSet ; 

public class GoodPrefixe {
    public static void main(String[] args) { 
        Scanner scx = new Scanner(System.in) ; 

        int t = scx.nextInt() ; 
        while(t-->0){
            int n = scx.nextInt() ; 
            int[] nums = new int[n] ; 
            long sum =0 ; 
            HashSet<Integer> setu = new HashSet<>() ; 

            int count = 0 ; 
            
            for(int i=0 ; i<n ; i++){
                nums[i] = scx.nextInt() ; 
                setu.add(nums[i]) ; 
                sum += nums[i] ; 

                if(sum%2==0){
                    if(setu.contains((int)(0.5*sum))) {
                        count++ ; 
                        //System.out.print(i + " ") ; 
                    }
                }
            }
            System.out.println(count) ; 


        }
    }
}
