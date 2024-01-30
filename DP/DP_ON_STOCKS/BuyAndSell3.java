//Memoization
class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProfitUtil(0, 1, 2, prices, dp);
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

//Tabulation
class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], 0);
            }
        }
        return maxProfitUtil(prices, dp);
    }

    private int maxProfitUtil(int[] prices, int[][][] dp) {
        int n = prices.length;

        for(int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 1; buy >= 0; buy --) {
                for (int cap = 2; cap > 0; cap --) {
                    int profit = 0;
                    // I can buy today
                    if (buy == 1) {

                        profit = Math.max((-prices[idx] + dp[idx + 1][0][cap]), //will buy
                                            0 + dp[idx + 1][1][cap]); //not buy
                    } else {  // I need to sell today
                        profit = Math.max((prices[idx] + dp[idx + 1][1][cap - 1]), //will sell
                                            0 + dp[idx + 1][0][cap]); //not sell
                    }
                    dp[idx][buy][cap] = profit;
                }
            }
        }
        

        return dp[0][1][2];
    }
}

//Space optimization
class Solution {
    public int maxProfit(int[] prices) {
        int[][] prev = new int[2][3];
        return maxProfitUtil(prices, prev);
    }

    private int maxProfitUtil(int[] prices, int[][] prev) {
        int n = prices.length;

        for(int idx = n - 1; idx >= 0; idx--) {
            int[][] curr = new int[2][3];
            for (int buy = 1; buy >= 0; buy --) {
                for (int cap = 2; cap > 0; cap --) {
                    int profit = 0;
                    // I can buy today
                    if (buy == 1) {

                        profit = Math.max((-prices[idx] + prev[0][cap]), //will buy
                                            0 + prev[1][cap]); //not buy
                    } else {  // I need to sell today
                        profit = Math.max((prices[idx] + prev[1][cap - 1]), //will sell
                                            0 + prev[0][cap]); //not sell
                    }
                   curr[buy][cap] = profit;
                }
            }
            prev = curr;
        }
        

        return prev[1][2];
    }
}
