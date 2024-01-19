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
