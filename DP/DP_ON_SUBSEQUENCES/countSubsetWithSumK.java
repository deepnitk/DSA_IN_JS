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
