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
