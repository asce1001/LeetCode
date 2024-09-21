class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i  = 0; i < nums.length; i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            max = Math.max(currSum, max);
        }
        return max;
    }
}
