// Recursive solution

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return minPathSumUtil(n - 1, m - 1, grid);
    }

    private int minPathSumUtil(int row, int col, int[][] grid) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (row  < 0 || col < 0) {
            return (int) Math.pow(10, 9);
        }

        int up = grid[row][col] + minPathSumUtil(row - 1, col, grid);
        int left = grid[row][col] + minPathSumUtil(row, col - 1, grid);

         return Math.min(up, left);  
    }
}

//Memoization solution

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return minPathSumUtil(n - 1, m - 1, grid, dp);
    }

    private int minPathSumUtil(int row, int col, int[][] grid, int[][] dp) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (row  < 0 || col < 0) {
            return (int) Math.pow(10, 9);
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int up = grid[row][col] + minPathSumUtil(row - 1, col, grid, dp);
        int left = grid[row][col] + minPathSumUtil(row, col - 1, grid, dp);

         return dp[row][col] = Math.min(up, left);  
    }
}

//Tabulation approach
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return minPathSumUtil(n, m, grid, dp);
    }

    private int minPathSumUtil(int n, int m, int[][] grid, int[][] dp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int  up = grid[i][j];
                    if (i  > 0) 
                        up += dp[i - 1][j];
                    else
                        up += (int) Math.pow(10, 9);
                    int left = grid[i][j];
                    if (j > 0) 
                        left += dp[i][j - 1];
                    else
                        left += (int) Math.pow(10, 9);
                    dp[i][j] = Math.min(up, left); 
                    } 
            }
        }
        return dp[n -1][m - 1];
        
    }
}

//Space optimized approach

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[m];
        Arrays.fill(prev, -1);
        return minPathSumUtil(n, m, grid, prev);
    }

    private int minPathSumUtil(int n, int m, int[][] grid, int[] prev) {
        
        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                   temp[j] = grid[i][j];
                } else {
                    int  up = grid[i][j];
                    if (i  > 0) 
                        up += prev[j];
                    else
                        up += (int) Math.pow(10, 9);
                    int left = grid[i][j];
                    if (j > 0) 
                        left += temp[j - 1];
                    else
                        left += (int) Math.pow(10, 9);

                    temp[j] = Math.min(up, left); 
                    } 
            }
            prev = temp;
        }
        return prev[m - 1];
        
    }
}
