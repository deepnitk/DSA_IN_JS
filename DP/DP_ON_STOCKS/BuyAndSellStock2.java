//Memoization
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return maxProfitUtil(0, 1, prices, dp);
    }

    private int maxProfitUtil(int idx, int buy, int[] prices, int[][] dp) {
        int n = prices.length;
        if (idx == n) {
            return  0;
        }
        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }
        int profit = 0;
        // I can buy today
        if (buy == 1) {

            profit = Math.max((-prices[idx] + maxProfitUtil(idx + 1, 0, prices, dp)), //will buy
                                0 + maxProfitUtil(idx + 1, 1, prices, dp)); //not buy
        } else {  // I need to sell today
            profit = Math.max((prices[idx] + maxProfitUtil(idx + 1, 1, prices, dp)), //will sell
                                0 + maxProfitUtil(idx + 1, 0, prices, dp)); //not sell
        }

        return dp[idx][buy] = profit;
    }
}

//Tabulation
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return maxProfitUtil(prices, dp);
    }

    private int maxProfitUtil(int[] prices, int[][] dp) {
        int n = prices.length;
        // if (idx == n) {
        //     return  0;
        // }
        for (int buy = 0; buy <=1; buy++) {
            dp[n][buy] = 0;
        }
        // if (dp[idx][buy] != -1) {
        //     return dp[idx][buy];
        // }
        int profit = 0;

        for(int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 1; buy >= 0; buy--) {
                // I can buy today
                if (buy == 1) {

                    dp[idx][buy] = Math.max((-prices[idx] + dp[idx + 1][0]), //will buy
                                        0 + dp[idx + 1][1]); //not buy
                } else {  // I need to sell today
                     dp[idx][buy] = Math.max((prices[idx] +dp[idx + 1][1]), //will sell
                                        0 + dp[idx + 1][0]); //not sell
                }
            }
        }
        

        return dp[0][1];
    }
}

//Space optimization

class Solution {
    public int maxProfit(int[] prices) {
        int[] prev = new int[2];
        Arrays.fill(prev, -1);
        return maxProfitUtil(prices, prev);
    }

    private int maxProfitUtil(int[] prices, int[] prev) {
        int n = prices.length;
        for (int buy = 0; buy <=1; buy++) {
            prev[buy] = 0;
        }

        int profit = 0;

        for(int idx = n - 1; idx >= 0; idx--) {
            int[] curr = new int[2];
            for (int buy = 1; buy >= 0; buy--) {
                // I can buy today
                if (buy == 1) {

                    curr[buy] = Math.max((-prices[idx] + prev[0]), //will buy
                                        0 + prev[1]); //not buy
                } else {  // I need to sell today
                    curr[buy] = Math.max((prices[idx] +prev[1]), //will sell
                                        0 + prev[0]); //not sell
                }
            }
            prev = curr;
        }
        

        return prev[1];
    }
}
