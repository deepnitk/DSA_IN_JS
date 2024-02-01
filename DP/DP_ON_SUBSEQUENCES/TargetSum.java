class Solution {
    public int countPartitions(int n, int d, int arr[]){
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }
        
        //Checking for edge cases
        if(totSum-d<0) return 0;
        if((totSum-d)%2==1) return 0;
        
        
        int s2 = (totSum-d)/2;
        return countPartitionsUtil(arr, s2);
    }
    
    private int countPartitionsUtil(int[] nums, int tar) {
        int n = nums.length;
        int[][] dp = new int[n][tar + 1];
        
        if (nums[0] == 0) {
            dp[0][0] = 2;
        }else {
            dp[0][0] = 1;
        }
        if(nums[0] != 0 && nums[0] <= tar) dp[0][nums[0]] = 1;  // 1 case -pick
        
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= tar; target++) {
                int pick = 0;
                if (target >= nums[ind]) {
                    pick = dp[ind - 1][target - nums[ind]];
                }
                int notPick = dp[ind - 1][target];
                
                dp[ind][target] = (pick + notPick);
            }
        }
        
        
        return dp[n - 1][tar];
    }
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums.length, target, nums);
    }
}
