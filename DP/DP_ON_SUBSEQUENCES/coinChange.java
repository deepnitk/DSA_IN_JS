//Recursive solution
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = coinChangeUtil(n - 1, amount, coins);
        return (ans == (int)(1e9)) ?  -1 : ans;

    }

    private int coinChangeUtil(int idx, int T, int[] coins) {
        if (idx == 0) {
            if (T % coins[0] == 0) {
                return T / coins[0];
            } else {
                return (int)(1e9);
            }
        }

        int notPick = 0 + coinChangeUtil(idx - 1, T, coins);
        int pick = (int)(1e9);
        if (coins[idx] <= T) {
            pick = 1 + coinChangeUtil(idx, T - coins[idx], coins);
        }

        return Math.min(pick, notPick);
    }
}

// Memoization solution
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = coinChangeUtil(n - 1, amount, coins, dp);
        return (ans == (int)(1e9)) ?  -1 : ans;

    }

    private int coinChangeUtil(int idx, int T, int[] coins, int[][] dp) {
        if (idx == 0) {
            if (T % coins[0] == 0) {
                return T / coins[0];
            } else {
                return (int)(1e9);
            }
        }
        if (dp[idx][T] != -1) {
            return dp[idx][T];
        }
        int notPick = 0 + coinChangeUtil(idx - 1, T, coins, dp);
        int pick = (int)(1e9);
        if (coins[idx] <= T) {
            pick = 1 + coinChangeUtil(idx, T - coins[idx], coins, dp);
        }

        return dp[idx][T] = Math.min(pick, notPick);
    }
}

//Tabulisation

class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = coinChangeUtil(amount, coins);
        return (ans == (int)(1e9)) ?  -1 : ans;

    }

    private int coinChangeUtil(int T, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][T + 1];
        for(int target = 0; target <= T; target++) {
            if (target % coins[0] == 0) {
                dp[0][target] = target / coins[0];
            } else {
                dp[0][target] = (int)(1e9);
            }
        }
        for(int idx = 1; idx < n; idx++) {
            for(int target = 0; target <= T; target++) {
                int notPick = 0 + dp[idx - 1][target];
                int pick = (int)(1e9);
                if (coins[idx] <= target) {
                    pick = 1 + dp[idx][target - coins[idx]];
                }

                dp[idx][target] = Math.min(pick, notPick);
            }
        }
        
        return dp[n - 1][T];
    }
}


