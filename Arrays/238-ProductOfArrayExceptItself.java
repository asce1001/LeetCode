class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        int rp = 1;
        result[0] = 1;
        for(int i = 1; i < size; i++){
            rp *= nums[i - 1];
            result[i] = rp;
        }
        rp = 1;
        for(int i = size - 2; i >= 0; i--){
            rp *= nums[i + 1];
            result[i] *= rp;
        }
        return result;
    }
}
