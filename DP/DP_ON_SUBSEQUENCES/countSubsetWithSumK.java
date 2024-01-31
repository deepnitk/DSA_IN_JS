//Recursive approach

class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    return perfectSumUtil(n - 1, sum, arr);
	} 
	
	private int perfectSumUtil(int idx, int k, int[] arr) {
	    if (k == 0) {
	        return 1;
	    } else {
	        if (idx == 0) {
	            if(arr[idx] == k) {
	                return 1;
	            } else {
	                return 0;
	            }
	        }
	        
	    }
	    
	    int notPick = perfectSumUtil(idx - 1, k, arr);
	    
	    int pick = 0;
	    if (k >= arr[idx]) {
	        pick = perfectSumUtil(idx - 1, k - arr[idx], arr);
	    }
	    return pick + notPick;
	}
}

//Memoization

class Solution{

	public int perfectSum(int arr[],int n, int k) 
	{
	    //int n = num.length;
	    int len = arr.length;
        int dp[][] = new int[len][k + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return findWaysUtil(len - 1, k, arr, dp);
	} 
	
	private int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {
	    if (target == 0)
            return 1;

        if (ind == 0)
            return arr[0] == target ? 1 : 0;

        if (dp[ind][target] != -1)
            return dp[ind][target];

        // Calculate the number of ways when the current element is not taken
        int notTaken = findWaysUtil(ind - 1, target, arr, dp);

        // Calculate the number of ways when the current element is taken
        int taken = 0;
        if (arr[ind] <= target)
            taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

        // Store and return the result for the current state
        return dp[ind][target] = notTaken + taken;
	}
}
