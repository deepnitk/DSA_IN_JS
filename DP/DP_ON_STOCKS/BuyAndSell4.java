//Memoization
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProfitUtil(0, 1, k, prices, dp);
    }

    private int maxProfitUtil(int idx, int buy, int cap, int[] prices, int[][][] dp) {
        int n = prices.length;
        if (idx == n) {
            return  0;
        }
        if( cap == 0) {
            return 0;
        }
        if (dp[idx][buy][cap] != -1) {
            return dp[idx][buy][cap];
        }
        int profit = 0;
        // I can buy today
        if (buy == 1) {

            profit = Math.max((-prices[idx] + maxProfitUtil(idx + 1, 0, cap, prices, dp)), //will buy
                                0 + maxProfitUtil(idx + 1, 1, cap, prices, dp)); //not buy
        } else {  // I need to sell today
            profit = Math.max((prices[idx] + maxProfitUtil(idx + 1, 1, cap - 1, prices, dp)), //will sell
                                0 + maxProfitUtil(idx + 1, 0, cap, prices, dp)); //not sell
        }

        return dp[idx][buy][cap] = profit;
    }
}
