package arrays.medium;
import java.util.ArrayList ;

/*
    Approach : see inversepairs for better understandiing .
    this is not full solution to the problem . this only works for array containing only positive numbers .
 */
public class ReversePairs {
    public static int merge(int[] nums , int low , int mid , int high) {
        ArrayList<Integer> mergedArray = new ArrayList<>() ;
        int i = low ;
        int j = mid+1 ;
        int numberOfPairs = 0 ;
        while(i<=mid && j<=high) {

            if(nums[i]<=nums[j]){
                int index = mid+1 ;
                for(int q = i ; q<=mid ; q++){
                    if(nums[q]>2*nums[j]) {
                        index = q ;
                        break ;
                    }
                }
                numberOfPairs += mid-index+1 ;
                mergedArray.add(nums[i++]) ;
            }else {//now these number are greater than the right element we need to find elements that are > twice of them .
                int index = mid+1 ;
                for(int q = i ; q<=mid ; q++){
                    if(nums[q]>2*nums[j]) {
                        index = q ;
                        break ;
                    }
                }
                numberOfPairs += mid-index+1 ;
                mergedArray.add(nums[j++]) ;

            }

        }
        while(i<=mid) {
            mergedArray.add(nums[i++])  ;
        }
        while(j<=high) {
            mergedArray.add(nums[j++]);
        }

        //replace the sub part of array with merged array

        for(i =low ; i<=high ; i++) {
            nums[i] = mergedArray.get(i-low) ;
        }

        return numberOfPairs ;

    }

    public static int mergeSort(int[] nums , int low , int high) {

        if(low==high){
            return 0 ;
        }

        int mid = low + (high-low)/2 ;

        int firstHalf = mergeSort(nums,low,mid) ;
        int secondHalf = mergeSort(nums,mid+1,high) ;

        //System.out.println(firstHalf + " " + secondHalf) ;


        int count = merge(nums,low,mid,high) ;

        //System.out.println("{" +firstHalf + " " + secondHalf+ " " + count + "}") ;

        return firstHalf+secondHalf+count ;

    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1) ;
    }
    public static void main(String[] args) {

        int[] nums = {1,3,2,3,1} ;
        System.out.println(reversePairs(nums)) ;
    }
}
