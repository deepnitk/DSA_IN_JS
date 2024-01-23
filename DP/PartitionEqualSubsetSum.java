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
