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
