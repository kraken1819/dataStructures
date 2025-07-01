package arrays.Hard;
import java.util.Arrays ;
import java.util.Comparator ;
import java.util.List ;
import java.util.ArrayList ;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a ,int[] b) {
                return a[0]-b[0] ;
            }
        });

        List<List<Integer>> ans = new ArrayList<>() ;

        for(int i =0 ; i<intervals.length ; i++) {
            if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) < intervals[i][0]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
                ans.add(temp);
            }else {
                int max = Math.max(intervals[i][1], ans.get(ans.size() - 1).get(1));
                ans.get(ans.size() - 1).set(1, max);
            }
        }
        int[][] matAns = new int[ans.size()][2] ;
        for(int i =0 ; i<ans.size() ; i++) {
            matAns[i][0] = ans.get(i).get(0) ;
            matAns[i][1] = ans.get(i).get(1) ;
        }
        return matAns ;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{4,5},{8,10},{7,18}} ;
        int[][] mergedIntervals = merge(intervals) ;

        for(int[] row:mergedIntervals){
            System.out.println(Arrays.toString(row)) ;
        }
    }
}
