//Recursive approach

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return longestCommonSubsequenceUtil(text1, n - 1, text2, m - 1);
    }

    private int longestCommonSubsequenceUtil(String s1, int idx1, String s2, int idx2) {
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return 1 + longestCommonSubsequenceUtil(s1, idx1 - 1, s2, idx2 - 1);
        }

        return Math.max((0 + longestCommonSubsequenceUtil(s1, idx1 - 1, s2, idx2)),
                        (0 + longestCommonSubsequenceUtil(s1, idx1, s2, idx2 - 1)));
    }

}

//Memoization approach

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return longestCommonSubsequenceUtil(text1, n - 1, text2, m - 1, dp);
    }

    private int longestCommonSubsequenceUtil(String s1, int idx1, String s2, int idx2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + longestCommonSubsequenceUtil(s1, idx1 - 1, s2, idx2 - 1, dp);
        }

        return dp[idx1][idx2] = Math.max((0 + longestCommonSubsequenceUtil(s1, idx1 - 1, s2, idx2, dp)),
                        (0 + longestCommonSubsequenceUtil(s1, idx1, s2, idx2 - 1, dp)));
    }

}

//Tabulation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceUtil(text1, text2);
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
