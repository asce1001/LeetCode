class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int low = 0;
        int high = nums.length -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                int n1 = mid;
                while(n1 >= 0 && nums[n1] == target){
                    n1--;
                }
                result[0] = n1 + 1;
                int n2 = mid;
                while(n2 < nums.length && nums[n2] == target){
                    n2++;
                }
                result[1] = n2 - 1;
                return result;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
