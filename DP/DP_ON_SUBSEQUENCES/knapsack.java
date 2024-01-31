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

//Tabulation approach

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        
        return knapSackUtils(wt, val, W, n);
    }
    
    static int knapSackUtils(int wt[], int val[], int K, int n) {
        int[][] dp = new int[n][K + 1];
        
        // Base Condition
        for (int i = wt[0]; i <= K; i++) {
            dp[0][i] = val[0];
        }
        
        for (int idx = 1; idx < n; idx++) {
            for (int target = 0; target <= K; target++) {
                int notPick = dp[idx - 1][target];
                int pick = 0;
                if(wt[idx] <= target) {
                    pick = val[idx] + dp[idx - 1][target - wt[idx]];
                }
                
                dp[idx][target] = Math.max(pick, notPick);
            }
        }
        return dp[n - 1][K];
        
    }
}

//Space Solution

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        
        return knapSackUtils(wt, val, W, n);
    }
    
    static int knapSackUtils(int wt[], int val[], int K, int n) {
        int[] prev = new int[K + 1];
        // Base Condition
        for (int i = wt[0]; i <= K; i++) {
            prev[i] = val[0];
        }
        
        for (int idx = 1; idx < n; idx++) {
            int[] curr = new int[K + 1];
            for (int target = 0; target <= K; target++) {
                int notPick = prev[target];
                int pick = 0;
                if(wt[idx] <= target) {
                    pick = val[idx] + prev[target - wt[idx]];
                }
                
                curr[target] = Math.max(pick, notPick);
            }
            prev = curr;
        }
        return prev[K];
        
    }
}
