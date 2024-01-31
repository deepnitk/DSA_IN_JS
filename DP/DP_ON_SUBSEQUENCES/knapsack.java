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
