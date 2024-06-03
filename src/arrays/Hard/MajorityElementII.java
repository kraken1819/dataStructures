package arrays.Hard;
import java.util.List ;
import java.util.ArrayList ;

public class MajorityElementII {

    public static ArrayList<Integer> majorityElementII(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>() ;
        int ele1 = -99 ;
        int ele2 = -99 ;
        int cnt1 = 0 ;
        int cnt2 = 0 ;

        for(int i = 0 ; i<nums.length ; i++ ) {
            if(cnt1==0 && ele2!=nums[i]){
                ele1 = nums[i] ;
                cnt1 = 1 ;
            }
            else if(cnt2==0 && ele1!=nums[i]) {
                ele2 = nums[i];
                cnt2 = 1;
            }else if ( nums[i] == ele1) cnt1++ ;
            else if (nums[i] == ele2) cnt2++ ;
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0 ; cnt2 = 0 ;
        for(int i =0; i<nums.length ; i++) {
            if (nums[i] == ele1) cnt1++;
            else if (nums[i] == ele2) cnt2++;
        }
        if(cnt1>nums.length/3) ans.add(ele1) ;
        if(cnt2>nums.length/3) ans.add(ele2) ;
        return ans ;
    }

    public static void main(String[] args){
        int[] nums = {3,2,3,2} ;
        List<Integer> ans = majorityElementII(nums) ;
        System.out.println(ans) ;
    }
}
