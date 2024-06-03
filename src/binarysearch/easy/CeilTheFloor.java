package binarysearch.easy;

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
    public void printNode(Pair a) {
        System.out.println("[" + a.floor + "," + a.ceil + "]") ;
    }

}

public class CeilTheFloor {

    public static Pair getFloorAndCeil(int[] arr , int n , int x) {
        int a = -1 ;
        int b = Integer.MAX_VALUE ;
        Pair ans = new Pair(-1,-1) ;
        for(int i=0 ;i<arr.length ; i++) {
            if (arr[i] <= x && arr[i] > a) {
                a = arr[i];
            }
            if (arr[i] >= x && arr[i] < b) {
                b = arr[i];
            }
        }
        ans.floor = a;

        if(b!=Integer.MAX_VALUE) ans.ceil = b  ;
        return ans ;


    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 6, 5, 5, 6} ;
        int n = arr.length ;
        int x = 7 ;
        Pair ans = getFloorAndCeil(arr,n,x) ;
        ans.printNode(ans) ;
    }
}
