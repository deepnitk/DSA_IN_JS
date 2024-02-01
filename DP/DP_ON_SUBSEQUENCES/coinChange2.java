//Recursive solution

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int ans = coinChangeUtil(n - 1, amount, coins);
        return (ans == (int)(1e9)) ?  -1 : ans;
    }

    private int coinChangeUtil(int idx, int T, int[] coins) {
        if (T == 0) {
            return 1;
        }
        if (idx == 0) {
            if (T % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int notPick = coinChangeUtil(idx - 1, T, coins);
        int pick = 0;
        if (coins[idx] <= T) {
            pick = coinChangeUtil(idx, T - coins[idx], coins);
        }

        return pick + notPick;
    }
}

//Memoization approach

class Solution {
    public int change(int T, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][T + 1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return coinChangeUtil(n - 1, T, coins, dp);
    }

    private int coinChangeUtil(int idx, int T, int[] coins, int[][] dp) {
        if (T == 0) {
            return 1;
        }
        if (idx == 0) {
            if (T % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[idx][T] != -1) {
            return dp[idx][T];
        }
        int notPick = coinChangeUtil(idx - 1, T, coins, dp);
        int pick = 0;
        if (coins[idx] <= T) {
            pick = coinChangeUtil(idx, T - coins[idx], coins, dp);
        }

        return dp[idx][T] = pick + notPick;
    }
}
