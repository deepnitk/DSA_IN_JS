//recursive approach
class Solution {
    public int uniquePaths(int m, int n) {
        return f(m - 1, n - 1);
    }

    private int f(int row, int col) {
        if (row == 0 && col == 0) {
            return 1;
        }
        int top = 0;
        int left = 0;
        if (row - 1 >= 0 )
            top = f(row - 1, col);
        if (col - 1 >= 0)
            left = f(row, col - 1);
        return top + left;
    }
}

//Memoization

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return f(m - 1, n - 1, dp);
    }

    private int f(int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0) {
            return 0;
        } 

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int top = f(row - 1, col, dp);
        int left = f(row, col - 1, dp);
        return dp[row][col] = top + left;
    }
}

//Tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysUtil(m, n, dp);
    }

    private int f(int m, int n, int[][] dp) {

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
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
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
    public int uniquePaths(int m, int n) {
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
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                // Store the total number of ways to reach the current cell in the DP array
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}
