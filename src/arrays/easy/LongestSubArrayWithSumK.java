package arrays.easy;
import java.util.HashMap ;
public class LongestSubArrayWithSumK {
    public static int lenOfLongSubarr(int[] A , int N , int K ) {
        HashMap<Integer,Integer> presum = new HashMap<>() ;
        int sum = 0 ;
        int max = 0 ;

        for(int i =0 ; i<N ; i++ ) {
            sum += A[i] ;
            int length = i+1 ;

            if(sum==K) {
                if(length > max) max = length ;
            } else  {
                int diff = sum-K ;
                if(presum.containsKey(diff)) {
                    int nlength = length - presum.get(diff) ;
                    if(nlength>max) max = nlength ;
                }
            }
            presum.putIfAbsent(sum,length) ;
        }
        return max ;

    }
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 3, 5, 5} ;
        int result = lenOfLongSubarr(nums,nums.length ,16) ;
        System.out.println(result) ;

    }
}
