//Recursive solution

class Solution {
    public int climbStairs(int n) {
        return f(n);
    }

    private int f (int ind) {
        if (ind <= 1) {
            return 1;
        }
        int oneStep = f(ind - 1);
        int twoStep = f(ind - 2);
        return oneStep + twoStep;
    }
}

//Memoization

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(n, dp);
    }

    private int f (int ind, int[] dp) {
        if (ind <= 1) {
            return 1;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }
        return dp[ind] = f(ind - 1, dp) + f(ind - 2, dp);
    }
}

//Tabulation

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(n, dp);
    }

    private int f (int ind, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= ind; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[ind];
    }
}
