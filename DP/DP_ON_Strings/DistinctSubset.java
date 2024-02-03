//Recursive solution

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        return numDistinctUtil(s, n - 1, t, m - 1);
    }

    private int numDistinctUtil(String s1, int idx1, String s2, int idx2) {
        if (idx2 < 0) {
            return 1;
        }
        if (idx1 < 0) {
            return 0;
        }

        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return numDistinctUtil(s1, idx1 - 1, s2, idx2 - 1) + numDistinctUtil(s1, idx1 - 1, s2, idx2);
        } else {
            return numDistinctUtil(s1, idx1 - 1, s2, idx2);
        }
    }
}

// Memoization

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return numDistinctUtil(s, n - 1, t, m - 1, dp);
    }

    private int numDistinctUtil(String s1, int idx1, String s2, int idx2, int[][] dp) {
        if (idx2 < 0) {
            return 1;
        }
        if (idx1 < 0) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return dp[idx1][idx2] = numDistinctUtil(s1, idx1 - 1, s2, idx2 - 1, dp) + numDistinctUtil(s1, idx1 - 1, s2, idx2, dp);
        } else {
            return dp[idx1][idx2] = numDistinctUtil(s1, idx1 - 1, s2, idx2, dp);
        }
    }
}

//Memoization | cordinate shift

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return numDistinctUtil(s, n, t, m, dp);
    }

    private int numDistinctUtil(String s1, int idx1, String s2, int idx2, int[][] dp) {
        if (idx2 == 0) {
            return 1;
        }
        if (idx1 == 0) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
            return dp[idx1][idx2] = numDistinctUtil(s1, idx1 - 1, s2, idx2 - 1, dp) + numDistinctUtil(s1, idx1 - 1, s2, idx2, dp);
        } else {
            return dp[idx1][idx2] = numDistinctUtil(s1, idx1 - 1, s2, idx2, dp);
        }
    }
}

//Tabulation

class Solution {
    public int numDistinct(String s, String t) {

        return numDistinctUtil(s, t);
    }

    private int numDistinctUtil(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
         for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = 0;
        }

        for (int idx1 = 1; idx1 <= n; idx1++){
            for (int idx2 = 1; idx2 <= m; idx2++) {
                if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + dp[idx1 - 1][idx2];
                } else {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2];
                }
            }
        }
        return dp[n][m];
    }
}
