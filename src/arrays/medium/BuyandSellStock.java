package arrays.medium;

public class BuyandSellStock {
    public static int maxProfit(int[] prices) {



        int max = 0 ;
        int totalProfit = 0 ;
        for(int i =1 ; i<prices.length ; i++) {
            totalProfit += prices[i] - prices[i-1] ;
            if(totalProfit < 0 ) {
                totalProfit = 0 ;
            }
            if(totalProfit>max) {
                max = totalProfit;
            }
        }
        return max ;
    }
    public static void main(String[] args) {
        int[] prices = {7,6} ;
        System.out.println(maxProfit(prices)) ;
    }
}
