//Recursive solution
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        return subsetSum(n - 1, nums, sum / 2);
    }

    private boolean subsetSum(int ind, int[] nums, int target) {
        if (target == 0) return true;
        if (ind == 0) return nums[0] == target;

        boolean pick = false;
        if (target > nums[ind]) {
            pick = subsetSum(ind - 1, nums, target - nums[ind]);
        }
        boolean notPick = subsetSum(ind - 1, nums, target);
        return pick || notPick;
    }
}

//Memoization solution

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int k = sum / 2;
        int[][] dp = new int[n][k + 1];

        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return subsetSum(n - 1, nums, k, dp);
    }

    private boolean subsetSum(int ind, int[] nums, int target, int[][] dp) {
        if (target == 0) return true;
        if (ind == 0) return nums[0] == target;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;
            
        boolean pick = false;
        if (target > nums[ind]) {
            pick = subsetSum(ind - 1, nums, target - nums[ind], dp);
        }
        boolean notPick = subsetSum(ind - 1, nums, target, dp);
        dp[ind][target] = notPick || pick ? 1 : 0;
        return notPick || pick;
    }
}
