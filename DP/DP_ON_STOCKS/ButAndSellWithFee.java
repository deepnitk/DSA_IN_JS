//Memoization solution
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
