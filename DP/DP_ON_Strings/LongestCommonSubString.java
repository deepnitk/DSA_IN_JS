class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        
        int maxi = 0;
        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= m; idx2++) {
                if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                    maxi = Math.max(maxi, dp[idx1][idx2]);
                } else {
                    dp[idx1][idx2] = 0;
                }
            }
        }
        return maxi;
    }

}
