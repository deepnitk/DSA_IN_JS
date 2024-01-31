//Recursive solution

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        
        return knapSackUtils(wt, val, n - 1, W);
    }
    
    static int knapSackUtils(int wt[], int val[], int idx, int K) {
        if (idx == 0) {
            if(wt[idx] <= K) {
                return val[idx];
            } else {
                return 0;
            }
        }
        
        int notPick = knapSackUtils(wt, val, idx - 1, K);
        int pick = 0;
        if(wt[idx] <= K) {
            pick = val[idx] + knapSackUtils(wt, val, idx - 1, K - wt[idx]);
        }
        
        return Math.max(pick, notPick);
    }
}

//Memoization approach

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n][W + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return knapSackUtils(wt, val, n - 1, W, dp);
    }
    
    static int knapSackUtils(int wt[], int val[], int idx, int K, int[][] dp) {
        if (idx == 0) {
            if(wt[idx] <= K) {
                return val[idx];
            } else {
                return 0;
            }
        }
        
        if (dp[idx][K] != -1) {
            return dp[idx][K];
        }
        
        int notPick = knapSackUtils(wt, val, idx - 1, K, dp);
        int pick = 0;
        if(wt[idx] <= K) {
            pick = val[idx] + knapSackUtils(wt, val, idx - 1, K - wt[idx], dp);
        }
        
        return dp[idx][K] = Math.max(pick, notPick);
    }
}
