class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            if(nums[low] <= nums[high]) return nums[low];
            int mid = (low + high) / 2;
            if((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] > nums[mid])){
                return nums[mid];
            } if (nums[low] <= nums[mid]){
                low = mid + 1;
            } else high = mid - 1;
        }
        return -1;
    }
}
