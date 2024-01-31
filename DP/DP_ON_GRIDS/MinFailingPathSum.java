//Recursive solution

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix[0].length;
        int mini = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++) {
            int ans = f(0, j, matrix);
            mini = Math.min(mini, ans);
        }
        return mini;
    }   

    private int f(int i, int j, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (j < 0 || j >= m)
            return (int) Math.pow(10, 9);
        if (i == n - 1)
            return matrix[n - 1][j];

        int left = matrix[i][j] + f(i + 1, j - 1, matrix);
        int top = matrix[i][j] + f(i + 1, j, matrix);
        int right = matrix[i][j] + f(i + 1, j + 1, matrix);

        return Math.min(left, Math.min(top, right));
    }
}

//Memoization solution
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        int mini = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++) {
            int ans = f(0, j, matrix, dp);
            mini = Math.min(mini, ans);
        }
        return mini;
    }   

    private int f(int i, int j, int[][] matrix, int[][] dp) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (j < 0 || j >= m)
            return (int) Math.pow(10, 9);
        if (i == n - 1)
            return matrix[n - 1][j];
            
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = matrix[i][j] + f(i + 1, j - 1, matrix, dp);
        int top = matrix[i][j] + f(i + 1, j, matrix, dp);
        int right = matrix[i][j] + f(i + 1, j + 1, matrix, dp);

        return dp[i][j] = Math.min(left, Math.min(top, right));
    }
}

//Tabulation -- top down approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        for (int j = 0; j < m; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                int left = matrix[i][j];
                if (j - 1 >= 0) {
                    left += dp[i + 1][j - 1];
                } else {
                    left += (int) Math.pow(10, 9);
                }
                int top = matrix[i][j] + dp[i + 1][j];
                int right = matrix[i][j];
                if (j + 1 < m) {
                    right += dp[i + 1][j + 1];
                } else {
                    right +=  (int) Math.pow(10, 9);
                }

                dp[i][j] = Math.min(left, Math.min(top, right));
            }
        }

        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[0][j]);
        }
        return mini;       
    }   

}

//Space optimization
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        Arrays.fill(prev, -1);

        for (int j = 0; j < m; j++) {
            prev[j] = matrix[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            int[] temp = new int[m];
            for (int j = m - 1; j >= 0; j--) {

                int left = matrix[i][j];
                if (j - 1 >= 0) {
                    left += prev[j - 1];
                } else {
                    left += (int) Math.pow(10, 9);
                }

                int top = matrix[i][j] + prev[j];

                int right = matrix[i][j];
                if (j + 1 < m) {
                    right += prev[j + 1];
                } else {
                    right +=  (int) Math.pow(10, 9);
                }

                temp[j] = Math.min(left, Math.min(top, right));
            }
            prev = temp;
        }

        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, prev[j]);
        }
        return mini;       
    }   

}
