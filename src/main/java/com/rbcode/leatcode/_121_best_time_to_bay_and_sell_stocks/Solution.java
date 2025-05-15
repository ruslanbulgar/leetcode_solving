package com.rbcode.leatcode._121_best_time_to_bay_and_sell_stocks;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int bestPositionBuy = -1;
        int bestPositionSell = -1;

        for (int i=0; i<prices.length;i++) {
            for(int j=i+1; j<prices.length;j++) {
                int testProfit = prices[j] - prices[i];
                if( testProfit > 0 && maxProfit<testProfit) {
                    bestPositionBuy = i;
                    bestPositionSell = j;
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        if(maxProfit>0) {
            System.out.printf("Buy on day %d (price = %d) and sell on day %d (price = %d), profit = %d%n",
                    bestPositionBuy + 1, prices[bestPositionBuy], bestPositionSell + 1, prices[bestPositionSell], maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        new Solution().maxProfit(new int[]{1,2});
    }
}
