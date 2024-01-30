//Recursive solution
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return maxProfitUtil(0, 1, prices);
    }

    private int maxProfitUtil(int idx, int buy, int[] prices) {
        int n = prices.length;
        if (idx >= n) {
            return  0;
        }
        int profit = 0;
        // I can buy today
        if (buy == 1) {

            profit = Math.max((-prices[idx] + maxProfitUtil(idx + 1, 0, prices)), //will buy
                                0 + maxProfitUtil(idx + 1, 1, prices)); //not buy
        } else {  // I need to sell today
            profit = Math.max((prices[idx] + maxProfitUtil(idx + 2, 1,  prices)), //will sell
                                0 + maxProfitUtil(idx + 1, 0,  prices)); //not sell
        }

        return  profit;
    }
}
