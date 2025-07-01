package arrays.medium;

import java.util.Map ;
import java.util.HashMap ;

public class MajorityElement {
    public static int majorityElementMoore(int[] nums) {
        int count = 0 ;
        int ele = 0 ;
        for (int num : nums) {
            if (count == 0) {
                ele = num;
                count = 1;
            } else {
                if (num == ele) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return ele ;
    }
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<>() ;
        for (int num : nums) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }
        int max = Integer.MIN_VALUE ;
        int maxValue = -1 ;
        for(Map.Entry<Integer,Integer> entry : count.entrySet()) {
            if(entry.getValue()>max) {
                max = entry.getValue();
                maxValue = entry.getKey();
            }
        }
        return maxValue ;



    }
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2} ;
        System.out.println(majorityElementMoore(nums)) ;
    }
}
