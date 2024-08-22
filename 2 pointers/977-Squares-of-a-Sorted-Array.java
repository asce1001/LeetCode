class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int [nums.length];
        int low = 0;
        int high = nums.length - 1;
        int p1 = nums.length - 1;
        while(low <= high){
            if(Math.abs(nums[low]) >= Math.abs(nums[high])){
                result[p1] = nums[low] * nums[low];
                low++;  
            } else {
                result[p1] = nums[high] * nums[high];
                high--;
            }
            p1--;
        }
        return result;
    }
}
