package leetcode.weekly.weekly401;


// still not complete answer 

import java.util.* ; 

public class MaximumTotalReward {

    public static int[] maxTotalReward(int[] rewardValues) { 

        Arrays.sort(rewardValues); 
        int n = rewardValues.length ; 
        int[] dp = new int[n+1] ; 
        boolean[] considered = new boolean[rewardValues.length] ; 

        for(int i =1 ; i<dp.length ; i++) { 
            int prevValue = dp[i-1] ; 
            int ele = rewardValues[i-1] ; //present ele ; 

            if(ele>prevValue){
                prevValue += ele ; 
                dp[i] = prevValue ; 
                considered[i-1] = true ; 

            }else{
                //ele<=prevValue ; 
                int diff = prevValue-ele ; 
                if(diff<ele){
                    //we should consider for doing it 
                    int sum = 0 ; 
                    for(int j=0 ; j<i-1 ; j++) { 
                        if(sum>diff) break ; 

                        if(considered[j]){
                            sum+=rewardValues[j] ; 
                        }
                    }
                    if(sum>ele){
                        //no point in considering present element 
                    }else { 
                        int finalValue = prevValue ; 
                        for(int j=0 ; j<i-1 ; j++) { 
                            
                            if(considered[j]){
                                finalValue-=rewardValues[j]; 
                                considered[j] = false ; 
                            }
                            if(finalValue<ele) break ; 
                        }
                        finalValue+=ele ; 
                        dp[i] = finalValue ; 
                    }
                    
                }else{
                    //there is no point in doing this . 
                }
            }

        }






        return dp ; 
    }

    public static void main(String[] args) { 
        int[] rewardValues = {1,2,3,4,6} ; 
        System.out.println(Arrays.toString(maxTotalReward(rewardValues)));
    }

}
