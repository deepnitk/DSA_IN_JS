class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int lps = longestPalindromeSubseq(s);
        return n - lps;
    }
    private int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequenceUtil(s, reversed);
    }

    private int longestCommonSubsequenceUtil(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= m; idx2++) {
                if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                } else {
                     dp[idx1][idx2] = Math.max((0 + dp[idx1 - 1][idx2]),
                                (0 + dp[idx1][idx2 - 1]));
                }

               
            }
        }
        
        return dp[n][m];
    }
}
