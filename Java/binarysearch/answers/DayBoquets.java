package binarysearch.answers;

public class DayBoquets {

    public static int minDays(int[] bloomDay , int m , int k ) {
        if(m*k >bloomDay.length) return -1 ;

        int low = Integer.MAX_VALUE ;
        int high = Integer.MIN_VALUE ;
        //find the min value for low and max value for high
        for(int i =0 ; i<bloomDay.length ; i++) {
            if (bloomDay[i] < low) low = bloomDay[i];
            if (bloomDay[i] > high) high = bloomDay[i];
        }
        int mid ;

        while(low <= high) {
            mid = low + (high - low) / 2;
            int nFlowers = 0 ;
            int nBoquets = 0 ;
            for(int i =0 ; i<bloomDay.length ; i++) {
                if(bloomDay[i]-mid <=0){
                    nFlowers++ ;
                    if(nFlowers==k) {
                        nBoquets++ ;
                        nFlowers = 0 ;
                    }
                }else {
                    nFlowers = 0 ;
                }
            }
            if(nBoquets>=m) {
                high = mid-1 ;
            }else {
                low = mid + 1;
            }
        }
        return low ;

    }

    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7} ;
        int m = 2 ;
        int k = 3 ;
        System.out.println(minDays(bloomDay,m,k)) ;
    }
}
