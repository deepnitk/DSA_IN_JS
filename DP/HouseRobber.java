// Recursive approach
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return f(n - 1, nums);
    }

    private int f(int idx, int[] nums) {
        if (idx < 0) {
            return 0;
        }

        if (idx == 0) {
            return nums[0];
        }
        int pick = nums[idx] + f(idx - 2, nums);
        int notPick = 0 + f(idx - 1, nums);
        return Math.max(pick, notPick);

    }
}
