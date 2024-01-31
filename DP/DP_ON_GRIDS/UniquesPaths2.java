// Tabulation solution
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n -1] == 1) return 0;
         int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return f(m, n, obstacleGrid, dp);
    }

     private int f(int m, int n, int[][] obstacleGrid, int[][] dp) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Base condition: If we are at the top-left cell (0, 0), there's one way to reach it.
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0 && obstacleGrid[i - 1][j] != 1)
                    up = dp[i - 1][j];
                if (j > 0 && obstacleGrid[i][j - 1] != 1)
                    left = dp[i][j - 1];

                // Store the total number of ways to reach the current cell in the DP array
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
        
    }
}

//Space optimization
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n -1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int prev[] = new int[n];
        for (int i = 0; i < m; i++) {
            int temp[] = new int[n];
            for (int j = 0; j < n; j++) {
                // Base condition: If we are at the top-left cell (0, 0), there's one way to reach it.
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0 && obstacleGrid[i][j] != 1)
                    up = prev[j];
                if (j > 0 && obstacleGrid[i][j] != 1)
                    left = temp[j - 1];

                // Store the total number of ways to reach the current cell in the DP array
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n - 1];
    }

}
