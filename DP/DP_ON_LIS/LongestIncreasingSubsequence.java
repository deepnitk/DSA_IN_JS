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

// Space optimiztion
TC: O(N2)
class Solution {
    public int lengthOfLIS(int[] nums) {
    
        return lengthOfLISUtil(nums);
    }

    private int lengthOfLISUtil(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
                int notPick = 0 + next[prevIdx + 1];
                int pick = 0;
                if (prevIdx == -1 || nums[prevIdx] < nums[idx]) {
                    pick = 1 + next[idx + 1];
                }

               curr[prevIdx + 1] = Math.max(pick, notPick);
            }
            next = curr;
        }
        return next[-1 + 1];
    }
}

//tABULATION APPROACH
TC: O(N2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        
        return ans == Integer.MIN_VALUE ? 1 : ans ;
    }
}

//Binary Search
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                len++;
            } else {
                int ind = Collections.binarySearch(temp, nums[i]);
                if (ind < 0) {
                    ind = -ind - 1;
                }

                temp.set(ind, nums[i]);
            }
        }
        return len;
    }


}
