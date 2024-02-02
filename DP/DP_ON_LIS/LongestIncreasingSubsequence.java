//Recursive 

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return lengthOfLISUtil(0, -1,  nums, n);
    }

    private int lengthOfLISUtil(int idx, int prevIdx, int[] nums, int n) {
        if (idx == n) {
            return 0;
        }
        int notPick = 0 + lengthOfLISUtil(idx + 1, prevIdx, nums, n);
        int pick = 0;
        if (prevIdx == -1 || nums[prevIdx] < nums[idx]) {
            pick = 1 + lengthOfLISUtil(idx + 1, idx, nums, n);
        }

        return Math.max(pick, notPick);
    }
}

//memoization solution

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // n + 1 because previdx starts from -1 and goes to n - 1 and we can't store -1 in dp.
        //so we will do a coordinate shift -1 will be 0, 0 will be 1, 1 will be 2 ..
        // hence n + 1will be the size. And put prevIdx + 1 instead of prevIdx in util function.
        int[][] dp = new int[n][n + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return lengthOfLISUtil(0, -1,  nums, n, dp);
    }

    private int lengthOfLISUtil(int idx, int prevIdx, int[] nums, int n, int[][] dp) {
        if (idx == n) {
            return 0;
        }

        if (dp[idx][prevIdx + 1] != -1) {
            return dp[idx][prevIdx + 1];
        }
        int notPick = 0 + lengthOfLISUtil(idx + 1, prevIdx, nums, n, dp);
        int pick = 0;
        if (prevIdx == -1 || nums[prevIdx] < nums[idx]) {
            pick = 1 + lengthOfLISUtil(idx + 1, idx, nums, n, dp);
        }

        return dp[idx][prevIdx + 1] = Math.max(pick, notPick);
    }
}

//Tabulation solution

class Solution {
    public int lengthOfLIS(int[] nums) {
    
        return lengthOfLISUtil(nums);
    }

    private int lengthOfLISUtil(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];


        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
                int notPick = 0 + dp[idx + 1][prevIdx + 1];
                int pick = 0;
                if (prevIdx == -1 || nums[prevIdx] < nums[idx]) {
                    pick = 1 + dp[idx + 1][idx + 1];
                }

                dp[idx][prevIdx + 1] = Math.max(pick, notPick);
            }
        }
        return dp[0][-1 + 1];
    }
}
