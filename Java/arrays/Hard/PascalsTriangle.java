package arrays.Hard;

import java.util.ArrayList ;

public class PascalsTriangle {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        ArrayList<Integer> row = new ArrayList<>();

        row.add(1);
        answer.add(row);
        if (numRows == 1) return answer;
        ArrayList<Integer> row1 = new ArrayList<>(row) ;
        row1.add(1);
        answer.add(row1);
        if (numRows == 2) return answer;
        Integer[] prev = row1.toArray(new Integer[0]);

        for (int i = 3; i <= numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>() ;
            temp.add(1);
            for (int k = 0; k < prev.length - 1; k++) {
                temp.add(prev[k] + prev[k + 1]);
            }
            temp.add(1);
            answer.add(temp);
            prev = temp.toArray(new Integer[0]);

        }
        return answer;
    }


    public static void main(String[] args) {
        int n = 10 ;
        ArrayList<ArrayList<Integer>> arr = generate(n) ;
        System.out.println(arr) ;

    }
}
