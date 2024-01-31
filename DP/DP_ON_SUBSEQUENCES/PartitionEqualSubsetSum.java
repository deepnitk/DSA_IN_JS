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

//Tabulation

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
        boolean[][] dp = new boolean[n][k + 1];

        for (boolean[] row: dp) {
            Arrays.fill(row, false);
        }

        return subsetSum(n, nums, k, dp);
    }

    private boolean subsetSum(int n, int[] nums, int k, boolean[][] dp) {
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= k) {
            dp[0][nums[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean pick = false;
                if (target > nums[ind]) {
                    pick = dp[ind - 1][target - nums[ind]];
                }
                boolean notPick = dp[ind - 1][target];
                dp[ind][target] = notPick || pick;
            }
        }

        
        return dp[n - 1][k];
    }
}

//Space optimization

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
        boolean[] prev = new boolean[k + 1];

        Arrays.fill(prev, false);

        return subsetSum(n, nums, k, prev);
    }

    private boolean subsetSum(int n, int[] nums, int k, boolean[] prev) {
        
        prev[0] = true;
        if (nums[0] <= k) {
            prev[nums[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean[] temp = new boolean[k + 1];
            for (int target = 1; target <= k; target++) {
                boolean pick = false;
                if (target > nums[ind]) {
                    pick = prev[target - nums[ind]];
                }
                boolean notPick = prev[target];
                temp[target] = notPick || pick;
            }
            prev = temp;
        }

        
        return prev[k];
    }
}
