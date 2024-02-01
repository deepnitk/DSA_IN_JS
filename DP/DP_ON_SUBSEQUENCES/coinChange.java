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
