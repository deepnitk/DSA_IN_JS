//Recursive solution 

class Solution{

    public int countPartitions(int n, int d, int arr[]){
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }
        
        //Checking for edge cases
        if(totSum-d<0) return 0;
        if((totSum-d)%2==1) return 0;
        
        
        int s2 = (totSum-d)/2;
        
        return countPartitionsUtil(n - 1, arr, s2);
    }
    
    private int countPartitionsUtil(int ind, int[] nums, int target) {
        if(ind == 0){
            if(target==0 && nums[0]==0)
                return 2;
            if(target==0 || target == nums[0])
                return 1;
            return 0;
        }

        int pick = 0;
        if (target >= nums[ind]) {
            pick = countPartitionsUtil(ind - 1, nums, target - nums[ind]);
        }
        int notPick = countPartitionsUtil(ind - 1, nums, target);
        return pick + notPick;
    }
}

//Memoization solution
class Solution{
    int mod =(int)(Math.pow(10,9)+7);
    public int countPartitions(int n, int d, int arr[]){
        int totSum = 0;
        for(int i=0; i<arr.length;i++){
            totSum += arr[i];
        }
        
        //Checking for edge cases
        if(totSum-d<0) return 0;
        if((totSum-d)%2==1) return 0;
        
        
        int s2 = (totSum-d)/2;
        
        int[][] dp = new int[n][s2 + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return countPartitionsUtil(n - 1, arr, s2, dp);
    }
    
    private int countPartitionsUtil(int ind, int[] nums, int target, int[][] dp) {
        if(ind == 0){
            if(target==0 && nums[0]==0)
                return 2;
            if(target==0 || target == nums[0])
                return 1;
            return 0;
        }
        
        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }
        int pick = 0;
        if (target >= nums[ind]) {
            pick = countPartitionsUtil(ind - 1, nums, target - nums[ind], dp);
        }
        int notPick = countPartitionsUtil(ind - 1, nums, target, dp);
        return dp[ind][target] = (pick + notPick)%mod;
    }
}

//Tabulisation approach

class Solution{
    int mod =(int)(Math.pow(10,9)+7);
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
                
                dp[ind][target] = (pick + notPick)%mod;
            }
        }
        
        
        return dp[n - 1][tar];
    }
}
